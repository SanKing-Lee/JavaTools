package Toolkit.View.net.config;

import Toolkit.Controller.FormatConfigDao;
import Toolkit.Model.ConfigFrame.ConfigTableMode;
import Toolkit.Model.ConfigFrame.FormatConfig;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class SelectConfigPanel extends JPanel {
    private JButton btnAdd, btnEdit, btnDel, btnOk;

    public SelectConfigPanel() {
        super();

        ConfigTableMode configTableMode = new ConfigTableMode();
        JTable configTable = new JTable(configTableMode);
        configTable.setShowGrid(true);
        ListSelectionModel configTableSelection = configTable.getSelectionModel();
        configTableSelection.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        configTableSelection.addListSelectionListener(e -> {
            btnEdit.setEnabled(true);
            btnDel.setEnabled(true);
        });

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.setBorder(new TitledBorder("已有的配置信息"));
        tablePanel.add(configTable, BorderLayout.CENTER);

        btnAdd = new JButton("添加");
        btnAdd.addActionListener(e -> {
            EditConfigFrame ecf = new EditConfigFrame("添加配置信息", null);
            ecf.setVisible(true);
        });
        btnEdit = new JButton("编辑");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(e -> {
            EditConfigFrame ecf = new EditConfigFrame("编辑配置信息",
                    FormatConfigDao.getInstance().findFormatConfig(
                            (String) configTableMode.getValueAt(
                                    configTable.getSelectedRow(), 0)
                    )
            );
            ecf.setVisible(true);
        });

        btnDel = new JButton("删除");
        btnDel.setEnabled(false);
        btnDel.addActionListener(e -> {
            FormatConfigDao.getInstance().deleteFormatConfig((String) configTableMode.getValueAt(
                    configTable.getSelectedRow(), 0));
            configTable.updateUI();
        });

        btnOk = new JButton("确认");

        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.Y_AXIS));
        btnPanel.add(btnAdd);
        btnPanel.add(btnEdit);
        btnPanel.add(btnDel);
        btnPanel.add(btnOk);

        setLayout(new BorderLayout());
        add(tablePanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.EAST);
    }
}
