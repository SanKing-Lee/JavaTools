package Toolkit.View;

import javax.swing.*;
import java.awt.*;

public class InformationPanel extends JPanel {
    private static final String DEFAULT_INFO = "...";

    private static final long LAST_SECONDS = 1;

    private static InformationPanel mInstance;

    private JLabel mInfo;

    private InformationPanel() {
        super();
        mInfo = new JLabel();
        mInfo.setText("...");
        setLayout(new GridLayout(1, 1));
        add(mInfo);
    }

    public static InformationPanel getInstance() {
        if (mInstance == null) {
            mInstance = new InformationPanel();
        }
        return mInstance;
    }

    public void setInfo(String infoText) {
        mInfo.setText(infoText);
        Runnable r = () -> {
            try {
                Thread.sleep(LAST_SECONDS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mInfo.setText(DEFAULT_INFO);
        };
        Thread t = new Thread(r);
        t.start();
    }
}
