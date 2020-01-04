package Toolkit.View.net;

import Toolkit.Controller.HttpDatagramParser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class RequestBodyPanel extends JPanel {
    private JTextArea taRequestBody;
    private JButton btnReqBodyDicForm, btnCopyReqBody, btnDefForm;

    public RequestBodyPanel() {
        super();
        taRequestBody = new JTextArea();
        taRequestBody.setWrapStyleWord(true);
        taRequestBody.setLineWrap(true);
        JScrollPane spRequestBody = new JScrollPane();
        spRequestBody.setViewportView(taRequestBody);
//        spRequestBody.setBorder(new TitledBorder("内容字段"));

        btnDefForm = new JButton("...");
        btnReqBodyDicForm = new JButton("格式化");
        btnCopyReqBody = new JButton("复制");

        JPanel reqBodyBtnPanel = new JPanel();
        reqBodyBtnPanel.setLayout(new GridLayout(3, 1));
        reqBodyBtnPanel.add(btnDefForm);
        reqBodyBtnPanel.add(btnReqBodyDicForm);
        reqBodyBtnPanel.add(btnCopyReqBody);

        setBorder(new TitledBorder("请求体"));
        setLayout(new BorderLayout());
        add(spRequestBody, BorderLayout.CENTER);
        add(reqBodyBtnPanel, BorderLayout.EAST);
    }

    public void updateParseResult() {
        HttpDatagramParser hdp = HttpDatagramParser.getInstance();
        taRequestBody.setText(hdp.getFormatBody());
    }
}
