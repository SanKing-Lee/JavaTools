package SQLiteBrowser;

import SQLiteBrowser.view.MainFrame;

import java.awt.*;

public class Main {
    public static void main(String args[]) {
        EventQueue.invokeLater(()->{
            MainFrame mainFrame = new MainFrame("Database Browser");
            mainFrame.setVisible(true);
        });
    }
}
