package SQLiteBrowser.view;

import SQLiteBrowser.controller.Connector;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static int DEFAULT_WIDTH = 900;
    private static int DEFAULT_HEIGHT = 600;

    private Connector connector = new Connector();
    public MainFrame(String title) {
        super(title);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(new BorderLayout());
        setBounds((screenSize.width - DEFAULT_WIDTH)/2, (screenSize.height - DEFAULT_HEIGHT)/2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FileChooserPane fcp = new FileChooserPane();
        add(fcp, BorderLayout.NORTH);

        FileNavigator fn = FileNavigator.getInstance();
        add(fn, BorderLayout.WEST);
    }
}
