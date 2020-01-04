package Toolkit.View.net.config;

import Toolkit.Model.ConfigFrame.ConfigTableMode;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ConfigFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 460;
    private static final int DEFAULT_HEIGHT = 260;

    public ConfigFrame(String title) {
        super(title);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(new BorderLayout());
        setBounds((screenSize.width - DEFAULT_WIDTH) / 2, (screenSize.height - DEFAULT_HEIGHT) / 2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setResizable(false);

        ImportConfigPanel icp = new ImportConfigPanel();
//        add(icp, BorderLayout.NORTH);

        SelectConfigPanel scp = new SelectConfigPanel();
//        add(scp, BorderLayout.CENTER);

        JSplitPane mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, icp, scp);
        add(mainPane, BorderLayout.CENTER);
    }
}
