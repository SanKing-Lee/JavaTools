package Toolkit.View.common;

import javax.swing.*;
import java.awt.*;

import static Toolkit.View.MainFrame.*;

public class CommonPanel extends JPanel {


    int newPanelYPosition = DEFAULT_TABBED_PANEL_X_POSITION;

    @Override
    public Component add(Component comp, int height) {
        comp.setBounds(DEFAULT_TABBED_PANEL_X_POSITION, newPanelYPosition, DEFAULT_TABBED_PANEL_WIDTH, height);
        newPanelYPosition += comp.getHeight();
        return super.add(comp);
    }

    public CommonPanel() {
        super();
        setLayout(null);
        TimeTransPanel ttp = new TimeTransPanel();
        add(ttp, 140);

        TextCodeTransPanel tctp = new TextCodeTransPanel();
        add(tctp, 300);

        RandomAndroidIdPanel raip = new RandomAndroidIdPanel();
        add(raip, 100);
    }
}
