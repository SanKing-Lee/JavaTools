package Toolkit.Controller;

import Toolkit.Model.HttpDatagram.RequestBody;
import Toolkit.Model.HttpDatagram.RequestHeader;
import Toolkit.Model.HttpDatagram.RequestLine;
import Toolkit.Model.HttpMethod;
import Toolkit.Model.Pair;

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

    }

    public static HttpDatagramParser getInstance() {
        if (mInstance == null) {
            mInstance = new HttpDatagramParser();
        }
        return mInstance;
    }

    public void parse(String datagram) {
        int firstRetIndex = datagram.indexOf('\n');
        sReqLine = datagram.substring(0, firstRetIndex);
        String headerAndBody = datagram.substring(firstRetIndex+1);
        String[] splitHeaderBody = headerAndBody.split("\n\n");
        sReqHead = splitHeaderBody[0];
        sReqBody = splitHeaderBody[1];

        requestLine = new RequestLine(sReqLine);

        System.out.println(sReqLine);
        System.out.println(sReqHead);
        System.out.println(sReqBody);
        requestHeader = new RequestHeader(sReqHead);

//        System.out.println(requestLine + "\n" + requestHeader);
    }

    public HttpMethod getMethod() {
        return requestLine.getMethod();
    }

    public String getHttpVersion() {
        return requestLine.getHttpVersion();
    }

    public String getUri() {
        return requestLine.getUri();
    }

    public String getUrl() {
        return requestHeader.getHostName() + requestLine.getUri();
    }

    public List<Pair> getGetParas() {
        return requestLine.getGetParas();
    }

    public String getsGetPara() {
        return requestLine.getsGetPara().replace("&", "\n");
    }

    public String getsReqLine() {
        return sReqLine;
    }

    public String getsReqHead() {
        return sReqHead;
    }

    public String getsReqBody() {
        return sReqBody.replace("&", "\n");
    }
}
