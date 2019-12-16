package Toolkit.View;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TextCodeTransPanel extends JPanel {

    private JTextArea tfUTF8, tfUnicode, tfString;
    private JScrollPane spUTF8, spUnicode, spString;
    private JButton btnUTF8, btnUnicode, btnString, btnClear;

    public TextCodeTransPanel() {
        super();

//        tfUTF8 = new JTextArea();
//        tfUTF8.setLineWrap(true);
//        tfUTF8.setWrapStyleWord(true);
//        spUTF8 = new JScrollPane();
//        spUTF8.setViewportView(tfUTF8);
//        spUTF8.setBorder(new TitledBorder("UTF-8"));

        tfUnicode = new JTextArea();
        tfUnicode.setLineWrap(true);
        tfUnicode.setWrapStyleWord(true);
        spUnicode = new JScrollPane();
        spUnicode.setViewportView(tfUnicode);
        spUnicode.setBorder(new TitledBorder("Unicode"));

        tfString = new JTextArea();
        tfString.setLineWrap(true);
        tfString.setWrapStyleWord(true);
        spString = new JScrollPane();
        spString.setViewportView(tfString);
        spString.setBorder(new TitledBorder("字符串"));

//        btnUTF8 = new JButton("从UTF8转换");
//        btnUTF8.addActionListener(e -> {
//            String utf8 = tfUTF8.getText();
//        });

        btnUnicode = new JButton("从Unicode转换");
        btnUnicode.addActionListener(e -> {
            String unicode = tfUnicode.getText();
            tfString.setText(unicode2String(unicode));
        });

        btnString = new JButton("从字符串转换");
        btnString.addActionListener(e -> {
            String str = tfString.getText();
            tfUnicode.setText(string2Unicode(str));
        });

        btnClear = new JButton("清空");
        btnClear.addActionListener(e -> {
//            tfUTF8.setText("");
            tfUnicode.setText("");
            tfString.setText("");
        });

        final JPanel choosePanel = new JPanel();
        choosePanel.setLayout(new GridLayout(2, 2));
//        choosePanel.add(btnUTF8);
        choosePanel.add(btnUnicode);
        choosePanel.add(btnString);
        choosePanel.add(btnClear);

        setLayout(new GridLayout(3, 1));
        setBorder(new TitledBorder("文本编码转换"));
//        add(spUTF8);
        add(spUnicode);
        add(spString);
        add(choosePanel);
    }

    public String string2Unicode(String str) {
        StringBuilder unicode = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            unicode.append("\\u");
            unicode.append(Integer.toHexString(c));
        }
        return unicode.toString();
    }

    public String unicode2String(String unicode) {
        StringBuilder string = new StringBuilder();
        String[] hex = unicode.split("\\\\u");

        for(int i = 0; i < hex.length; i++) {
            if(hex[i].equals("")) continue;
            int data = Integer.parseInt(hex[i], 16);
            string.append((char)data);
        }
        return string.toString();
    }
}
