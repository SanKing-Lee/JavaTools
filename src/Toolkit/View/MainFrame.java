package Toolkit.View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static int DEFAULT_WIDTH = 420;
    public static int DEFAULT_HEIGHT = 630;

    public static int DEFAULT_TABBED_PANEL_X_POSITION = 0;
    public static int DEFAULT_TABBED_PANEL_WIDTH = DEFAULT_WIDTH - 20;

    public static int NEW_FRAME_OFFSET = 20;

    public MainFrame(String title) {
        super(title);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(null);
        setBounds((screenSize.width - DEFAULT_WIDTH) / 2, (screenSize.height - DEFAULT_HEIGHT) / 2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TabbedToolsPanel tp = new TabbedToolsPanel();
        tp.setBounds(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT - 40);
        add(tp);

        InformationPanel ip = InformationPanel.getInstance();
        ip.setBounds(12, tp.getHeight() - 10, DEFAULT_WIDTH, 20);
        add(ip);

        setResizable(false);
    }
}