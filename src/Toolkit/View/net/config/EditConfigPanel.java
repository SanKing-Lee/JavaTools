package Toolkit.View.net.config;

import Toolkit.Controller.FormatConfigDao;
import Toolkit.Model.ConfigFrame.ConfigTableMode;
import Toolkit.Model.ConfigFrame.FormatConfig;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class EditConfigPanel extends JPanel {

    private JLabel lbName;
    private JTextField tfName;
    private JTextArea taRules;
    private JButton btnCancel, btnSave;

    public EditConfigPanel(FormatConfig fc, JFrame parent) {
        super();
        if(fc == null) {
            fc = new FormatConfig();
        }

        final String oldName = fc.getName();
        final boolean isAdd = fc.getName().equals("");

        lbName = new JLabel("\t配置名称: ");

        tfName = new JTextField(22);
        tfName.setText(fc.getName());

        taRules =new JTextArea();
        taRules.setBorder(new TitledBorder("配置规则"));
        taRules.setText(fc.getFormat());

        btnCancel = new JButton("取消");
        btnCancel.addActionListener(e -> {
            parent.dispose();
        });

        btnSave = new JButton("保存");
        btnSave.addActionListener(e -> {
            FormatConfig newFc = new FormatConfig();
            newFc.setName(tfName.getText());
            newFc.setTime(System.currentTimeMillis());
            newFc.setFormat(taRules.getText());
            FormatConfigDao fcd = FormatConfigDao.getInstance();
            if(isAdd) {
                fcd.addFormatConfig(newFc);
            }
            else {
                fcd.updateFormatConfig(newFc, oldName);
            }
            parent.dispose();
        });

        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        namePanel.add(lbName);
        namePanel.add(tfName);

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnCancel);
        btnPanel.add(btnSave);

        setLayout(new BorderLayout());
        add(namePanel, BorderLayout.NORTH);
        add(taRules, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
}
