package View;

import javax.swing.*;
import java.awt.*;

public class ToolFrame extends JFrame {

    private static int DEFAULT_WIDTH = 400;
    private static int DEFAULT_HEIGHT = 600;

    public ToolFrame(String title) {
        super(title);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(null);
        setBounds((screenSize.width - DEFAULT_WIDTH)/2, (screenSize.height - DEFAULT_HEIGHT)/2, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TimeTransPanel ttp = new TimeTransPanel();
        ttp.setBounds(12, 12, 376, 140);
        add(ttp);

    }
}