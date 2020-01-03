package Toolkit.View;

import Toolkit.View.common.CommonPanel;
import Toolkit.View.net.HttpDatagramParserPanel;

import javax.swing.*;

import static Toolkit.View.MainFrame.DEFAULT_HEIGHT;
import static Toolkit.View.MainFrame.DEFAULT_WIDTH;

public class TabbedToolsPanel extends JTabbedPane {
    public TabbedToolsPanel() {
        super();

        CommonPanel commonPanel = new CommonPanel();
        commonPanel.setBounds(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        addTab("常用工具", commonPanel);

        HttpDatagramParserPanel hdpp = new HttpDatagramParserPanel();
        hdpp.setBounds(0, 0, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        addTab("Http数据报解析", hdpp);

        setSelectedIndex(0);
    }
}
