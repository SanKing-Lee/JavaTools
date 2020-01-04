package Toolkit.Controller;

import Toolkit.Model.HttpDatagram.RequestBody;
import Toolkit.Model.HttpDatagram.RequestHeader;
import Toolkit.Model.HttpDatagram.RequestLine;
import Toolkit.Model.HttpMethod;
import Toolkit.Model.Pair;
import Toolkit.View.InformationPanel;

import java.util.List;

public class HttpDatagramParser {
    private static HttpDatagramParser mInstance;

    private RequestLine requestLine;
    private RequestHeader requestHeader;
    private RequestBody requestBody;

    private String sReqLine;
    private String sReqHead;
    private String sReqBody;

    private HttpDatagramParser() {
        sReqLine = "";
        sReqHead = "";
        sReqBody = "";
    }

    public static HttpDatagramParser getInstance() {
        if (mInstance == null) {
            mInstance = new HttpDatagramParser();
        }
        return mInstance;
    }

    public static String recoverEscape(String url) {
        if (url == null) {
            return "";
        }
        return url.replace("%2B", "+")
                .replace("%20", " ")
                .replace("%2F", "/")
                .replace("%3F", "?")
                .replace("%25", "%")
                .replace("%23", "#")
                .replace("%26", "&")
                .replace("%3D", "=")
                ;
    }

    public void parse(String datagram) {
        int firstRetIndex = datagram.indexOf('\n');
        sReqLine = datagram.substring(0, firstRetIndex);
        String headerAndBody = datagram.substring(firstRetIndex + 1);
        String[] splitHeaderBody = headerAndBody.split("\n\n");
        sReqHead = splitHeaderBody[0];
        if (splitHeaderBody.length > 1) {
            sReqBody = splitHeaderBody[1];
        }

        requestLine = new RequestLine(sReqLine);
        requestHeader = new RequestHeader(sReqHead);
        requestBody = new RequestBody(sReqBody);

        InformationPanel.getInstance().setInfo("解析完成！");
    }

    public HttpMethod getMethod() {
        return requestLine.getMethod();
    }

    public String getHttpVersion() {
        return requestLine.getHttpVersion();
    }

    public String getUrl() {
        return requestHeader.getHostName() + requestLine.getUri();
    }

    public String getFormatPara() {
        return requestLine.getFormatPara();
    }

    public String getFormatHeaders() {
        return requestHeader.getFormatHeaders();
    }

    public String getFormatBody() {
        return requestBody.getFormatBody();
    }
}
