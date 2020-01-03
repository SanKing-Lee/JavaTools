package Toolkit.View.common;

import Toolkit.Model.DefaultWidthContainer;

public class CommonPanel extends DefaultWidthContainer {

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
