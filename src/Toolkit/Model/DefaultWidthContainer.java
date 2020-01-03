package Toolkit.Model;

import javax.swing.*;
import java.awt.*;

import static Toolkit.View.MainFrame.DEFAULT_TABBED_PANEL_WIDTH;
import static Toolkit.View.MainFrame.DEFAULT_TABBED_PANEL_X_POSITION;

public class DefaultWidthContainer extends JPanel {

    int newPanelYPosition = DEFAULT_TABBED_PANEL_X_POSITION;

    @Override
    public Component add(Component comp, int height) {
        comp.setBounds(DEFAULT_TABBED_PANEL_X_POSITION, newPanelYPosition, DEFAULT_TABBED_PANEL_WIDTH, height);
        newPanelYPosition += comp.getHeight();
        return super.add(comp);
    }

}
