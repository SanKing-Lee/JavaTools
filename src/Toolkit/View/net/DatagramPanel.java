package Toolkit.View.net;

import Toolkit.Controller.HttpDatagramParser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class DatagramPanel extends JPanel {
    private JTextArea taRequest;
    private JButton btnRequestPaste, btnParseRequest, btnClear;

    public DatagramPanel() {
        super();

        setBorder(new TitledBorder("数据报"));
        setLayout(new BorderLayout());

        taRequest = new JTextArea();
        taRequest.setWrapStyleWord(true);
        taRequest.setLineWrap(true);

        JScrollPane spRequest = new JScrollPane();
        spRequest.setViewportView(taRequest);
//        spRequest.setBorder(new TitledBorder("报文"));

        btnRequestPaste = new JButton("粘贴");
        btnRequestPaste.addActionListener(e -> {
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            Transferable trans = clipboard.getContents(null);

            if(trans != null) {
                if(trans.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    try {
                        String content = (String) trans.getTransferData(DataFlavor.stringFlavor);
                        taRequest.setText(taRequest.getText() + content);
                    }catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });

        btnParseRequest = new JButton("解析");
        btnParseRequest.addActionListener(e -> {
            String content = taRequest.getText();
            HttpDatagramParser.getInstance().parse(content);
            HttpDatagramParserPanel parent = (HttpDatagramParserPanel)getParent();
            parent.updateParseResult();
        });

        btnClear = new JButton("清空");
        btnClear.addActionListener(e -> {
            taRequest.setText("");
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 3));
        btnPanel.add(btnRequestPaste);
        btnPanel.add(btnClear);
        btnPanel.add(btnParseRequest);

        add(spRequest, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
