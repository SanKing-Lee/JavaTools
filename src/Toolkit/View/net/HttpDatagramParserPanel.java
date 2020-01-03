package Toolkit.View.net;

import Toolkit.Model.DefaultWidthContainer;

public class HttpDatagramParserPanel extends DefaultWidthContainer {
    private DatagramPanel mDp;
    private RequestLinePanel mRlp;
    private RequestHeaderPanel mRhp;
    private RequestBodyPanel mRbp;

    public HttpDatagramParserPanel() {
        super();
        setLayout(null);
        mDp = new DatagramPanel();
        add(mDp, 160);

        mRlp = new RequestLinePanel();
        add(mRlp, 180);

        mRhp = new RequestHeaderPanel();
        add(mRhp, 100);

        mRbp = new RequestBodyPanel();
        add(mRbp, 100);
    }

    public void updateParseResult() {
        mRlp.updateParseResult();
        mRhp.updateParseResult();
        mRbp.updateParseResult();
    }
}
