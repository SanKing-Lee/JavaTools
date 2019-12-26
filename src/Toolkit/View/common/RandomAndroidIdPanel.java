package Toolkit.View.common;

import Toolkit.View.InformationPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

public class RandomAndroidIdPanel extends JPanel {
    private JTextField randomId;
    private JLabel randomIdLabel;
    private JButton randomButton, copyButton;

    private String generateRandomId() {
        StringBuilder androidId = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            androidId.append(Integer.toHexString(new Random().nextInt(16)));
        }
        return androidId.toString();
    }

    public RandomAndroidIdPanel() {
        super();
        setBorder(new TitledBorder("随机生成Android ID"));
        setLayout(new GridLayout(2, 2));

        randomIdLabel= new JLabel("\tAndroid ID: ");

        randomId = new JTextField(15);
        randomId.setText(generateRandomId());

        randomButton = new JButton("刷新");
        randomButton.addActionListener((e)->{
            randomId.setText(generateRandomId());
        });

        copyButton = new JButton("复制");
        copyButton.addActionListener((e)->{
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            StringSelection stringSelection = new StringSelection(randomId.getText());
            clipboard.setContents(stringSelection, null);
            InformationPanel.getInstance().setInfo("已复制Android ID");
        });

        add(randomIdLabel);
        add(randomId);
        add(randomButton);
        add(copyButton);
    }
}
