package Toolkit.View.net;

import Toolkit.Controller.HttpDatagramParser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RequestHeaderPanel extends JPanel {
    private JTextArea taRequestHeader;
    private JButton btnReqHeadDictFormat, btnCopyReqHead, btnDefForm;

    public RequestHeaderPanel() {
        super();

        taRequestHeader = new JTextArea();
        taRequestHeader.setLineWrap(true);
        taRequestHeader.setWrapStyleWord(true);
        JScrollPane spRequestHeader = new JScrollPane();
        spRequestHeader.setViewportView(taRequestHeader);
//        spRequestHeader.setBorder(new TitledBorder("头部字段"));

        btnDefForm = new JButton("...");
        btnReqHeadDictFormat = new JButton("格式化");
        btnCopyReqHead = new JButton("复制");

        JPanel reqHeadBtnPanel = new JPanel();
        reqHeadBtnPanel.setLayout(new GridLayout(3, 1));
        reqHeadBtnPanel.add(btnDefForm);
        reqHeadBtnPanel.add(btnReqHeadDictFormat);
        reqHeadBtnPanel.add(btnCopyReqHead);

        setBorder(new TitledBorder("请求头"));
        setLayout(new BorderLayout());
        add(spRequestHeader, BorderLayout.CENTER);
        add(reqHeadBtnPanel, BorderLayout.EAST);
    }

    public void updateParseResult() {
        HttpDatagramParser hdp = HttpDatagramParser.getInstance();
        taRequestHeader.setText(hdp.getFormatHeaders());
    }
}
