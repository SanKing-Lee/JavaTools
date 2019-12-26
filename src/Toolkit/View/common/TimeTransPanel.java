package Toolkit.View.common;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeTransPanel extends JPanel {
    private static String PATTERN_LONG = "\\d*";
    private static DateFormat dateFormat = DateFormat.getDateTimeInstance();

    private JLabel labelMilliseconds, labelSeconds, labelTime;
    private JTextField tfMilliseconds, tfSeconds;
    private JTextArea taTime;
    private JButton btnMilliseconds, btnSeconds;

    public TimeTransPanel() {
        super();
        labelMilliseconds = new JLabel("\t毫秒时间戳(ms)");
        labelSeconds = new JLabel("\tUnix时间戳(s)");
        labelTime = new JLabel("北京时间");

        tfMilliseconds = new JTextField(40);
        tfSeconds = new JTextField(40);

        taTime = new JTextArea();

        btnMilliseconds = new JButton("转换");
        btnMilliseconds.addActionListener(e -> {
            String millisecond = tfMilliseconds.getText();
            if(millisecond.equals("")) {
                taTime.setText("");
                return;
            }
            Pattern pattern = Pattern.compile(PATTERN_LONG);
            Matcher matcher = pattern.matcher(millisecond);
            if(matcher.matches()) {
                taTime.setText(dateFormat.format(Long.parseLong(millisecond)));
//                tfSeconds.setText("");
            }
            else {
                taTime.setText("格式错误");
            }
        });

        btnSeconds = new JButton("转换");
        btnSeconds.addActionListener(e -> {
            String second = tfSeconds.getText();
            if(second.equals("")) {
                taTime.setText("");
                return;
            }
            Pattern pattern = Pattern.compile(PATTERN_LONG);
            Matcher matcher = pattern.matcher(second);
            if(matcher.matches()) {
                taTime.setText(dateFormat.format((Long.parseLong(second))*1000));
//                tfMilliseconds.setText("");
            }
            else {
                taTime.setText("格式错误");
            }
        });

        final JPanel panelTime = new JPanel();
        panelTime.setLayout(new GridLayout(2, 3));

        panelTime.add(labelMilliseconds);
        panelTime.add(tfMilliseconds);
        panelTime.add(btnMilliseconds);

        panelTime.add(labelSeconds);
        panelTime.add(tfSeconds);
        panelTime.add(btnSeconds);

//        taTime.setBounds(12, 98, 376, 60);
        taTime.setBorder(new TitledBorder("北京时间"));
        taTime.setEditable(false);

        setLayout(new GridLayout(2, 1));
        setBorder(new TitledBorder("时间转换"));

        add(panelTime);
        add(taTime);
    }
}
