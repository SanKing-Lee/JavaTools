package Toolkit.View.net;

import Toolkit.Controller.HttpDatagramParser;
import Toolkit.View.net.config.ConfigFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RequestLinePanel extends JPanel {
    private JLabel lbMethod, lbUrl, lbVersion;
    private JTextField tfMethod, tfUrl, tfVersion;
    private JButton btnCopyUrl, btnGetParaDictFormat, btnCopyGetPara, btnDefForm;
    private JTextArea taGetParam;

    public RequestLinePanel() {
        super();

        lbMethod = new JLabel("\t请求方式: ");
        tfMethod = new JTextField(8);

        lbVersion = new JLabel("\tHttp版本: ");
        tfVersion = new JTextField(9);

        JPanel metVersionPanel = new JPanel();
        metVersionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        metVersionPanel.add(lbMethod);
        metVersionPanel.add(tfMethod);
        metVersionPanel.add(lbVersion);
        metVersionPanel.add(tfVersion);

        lbUrl = new JLabel("\tUrl: ");
        tfUrl = new JTextField(21);
        btnCopyUrl = new JButton("复制");

        JPanel urlPanel = new JPanel();
        urlPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        urlPanel.add(lbUrl);
        urlPanel.add(tfUrl);
        urlPanel.add(btnCopyUrl);

        taGetParam = new JTextArea();
        taGetParam.setLineWrap(true);
        taGetParam.setWrapStyleWord(true);
        JScrollPane spGetParam = new JScrollPane();
        spGetParam.setViewportView(taGetParam);
//        spGetParam.setBorder(new TitledBorder("请求参数"));

        btnDefForm = new JButton("...");
        btnDefForm.addActionListener(e -> {
            ConfigFrame ecf = new ConfigFrame("自定义配置信息");
            ecf.setVisible(true);
        });
        btnGetParaDictFormat = new JButton("格式化");
        btnCopyGetPara = new JButton("复制");

        JPanel getParaBtnPanel = new JPanel();
        getParaBtnPanel.setLayout(new GridLayout(3, 1));
        getParaBtnPanel.add(btnDefForm);
        getParaBtnPanel.add(btnGetParaDictFormat);
        getParaBtnPanel.add(btnCopyGetPara);

        setLayout(new BorderLayout());
        setBorder(new TitledBorder("请求行"));
        add(metVersionPanel, BorderLayout.NORTH);
        add(urlPanel, BorderLayout.SOUTH);
        add(spGetParam, BorderLayout.CENTER);
        add(getParaBtnPanel, BorderLayout.EAST);
    }

    public void updateParseResult() {
        HttpDatagramParser hdp = HttpDatagramParser.getInstance();

        tfMethod.setText(hdp.getMethod().toString());
        tfVersion.setText(hdp.getHttpVersion());
        tfUrl.setText(hdp.getUrl());
        taGetParam.setText(hdp.getFormatPara());
    }
}
