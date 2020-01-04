package Toolkit.View.net.config;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ImportConfigPanel extends JPanel {
    private JTextField tfConfigPath;
    private JButton btnImport, btnNavigate;

    public ImportConfigPanel() {
        super();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(new TitledBorder("从文件导入配置信息"));

        tfConfigPath = new JTextField(12);
        btnNavigate = new JButton("...");
        btnImport = new JButton("导入");

        add(tfConfigPath);
        add(btnNavigate);
        add(btnImport);
    }


}
