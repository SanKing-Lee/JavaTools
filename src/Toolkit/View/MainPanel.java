package Toolkit.View;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel() {
        super();

        setLayout(new GridLayout(2, 1));

        TimeTransPanel ttp = new TimeTransPanel();
        ttp.setBounds(12, 12, 376, 140);
        add(ttp);

        TextCodeTransPanel tctp = new TextCodeTransPanel();
        tctp.setBounds(12, 152, 376, 180);
        add(tctp);
    }
}
