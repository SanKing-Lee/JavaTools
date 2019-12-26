package Toolkit;

import Toolkit.View.MainFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            MainFrame frame = new MainFrame("Tools");
            frame.setVisible(true);
        });
    }
}
