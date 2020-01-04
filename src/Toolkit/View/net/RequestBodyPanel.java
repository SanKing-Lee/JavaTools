package Toolkit.View.net;

import Toolkit.Controller.HttpDatagramParser;
import Toolkit.View.InformationPanel;
import Toolkit.View.net.config.ConfigFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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
        btnDefForm.addActionListener(e -> {
            ConfigFrame cf = new ConfigFrame("自定义格式", HttpDatagramParser.REQUEST_BODY);
            cf.setVisible(true);
        });
        btnReqBodyDicForm = new JButton("格式化");
        btnReqBodyDicForm.addActionListener(e -> {
            taRequestBody.setText(HttpDatagramParser.getInstance().getFormatBody());
        });
        btnCopyReqBody = new JButton("复制");
        btnCopyReqBody.addActionListener((e)->{
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(taRequestBody.getText());
            clipboard.setContents(stringSelection, null);
            InformationPanel.getInstance().setInfo("已复制");
        });

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
