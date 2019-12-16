package Toolkit;

import Toolkit.View.ToolFrame;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            ToolFrame frame = new ToolFrame("Tools");
            frame.setVisible(true);
        });
    }
}
