package SQLiteBrowser.view;

import SQLiteBrowser.controller.Connector;

import javax.swing.*;

public class MainFrame extends JFrame {
    private Connector connector = new Connector();
    public MainFrame(String title) {
        super(title);
    }
}
