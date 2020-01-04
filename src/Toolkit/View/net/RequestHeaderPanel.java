package Toolkit.View.net;

import Toolkit.Controller.HttpDatagramParser;
import Toolkit.View.InformationPanel;
import Toolkit.View.net.config.ConfigFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

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
        btnDefForm.addActionListener(e -> {
            ConfigFrame cf = new ConfigFrame("自定义格式", HttpDatagramParser.REQUEST_HEADER);
            cf.setVisible(true);
        });
        btnReqHeadDictFormat = new JButton("格式化");
        btnReqHeadDictFormat.addActionListener(e -> {
            taRequestHeader.setText(HttpDatagramParser.getInstance().getFormatHeaders());
        });
        btnCopyReqHead = new JButton("复制");
        btnCopyReqHead.addActionListener((e)->{
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(taRequestHeader.getText());
            clipboard.setContents(stringSelection, null);
            InformationPanel.getInstance().setInfo("已复制");
        });

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
