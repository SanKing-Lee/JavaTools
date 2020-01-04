package Toolkit.View.net.config;

import Toolkit.Model.ConfigFrame.FormatConfig;

import javax.swing.*;
import java.awt.*;

import static Toolkit.View.MainFrame.NEW_FRAME_OFFSET;

public class EditConfigFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 360;
    private static final int DEFAULT_HEIGHT = 260;

    public EditConfigFrame(String title, FormatConfig fc) {
        super(title);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setLayout(new BorderLayout());
        setBounds((screenSize.width - DEFAULT_WIDTH) / 2 + NEW_FRAME_OFFSET,
                (screenSize.height - DEFAULT_HEIGHT) / 2 + NEW_FRAME_OFFSET,
                DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setResizable(false);

        EditConfigPanel ecp = new EditConfigPanel(fc);
        add(ecp, BorderLayout.CENTER);
    }
}
