package Toolkit.View.net;

import javax.swing.*;

public class EditConfigFrame extends JFrame {
    private JTextField tfNewFrame;
    public EditConfigFrame() {
        super();
        tfNewFrame = new JTextField();
        tfNewFrame.setText("New Frame");
        add(tfNewFrame);
    }
}
