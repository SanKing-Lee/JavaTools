package Toolkit.Model.HttpDatagram;

import Toolkit.Controller.HttpDatagramParser;
import Toolkit.Model.HttpMethod;
import Toolkit.Model.Pair;

import java.util.ArrayList;
import java.util.List;

public class RequestLine {

    private HttpMethod method;
    private String uri;
    private String httpVersion;
    private List<Pair> paraPairList;

    public RequestLine(String requestLine) {
        String[] lines = requestLine.split(" ");
        // method
        switch (lines[0]) {
            case "get":
            case "Get":
            case "GET":
                method = HttpMethod.GET;
                break;
            case "post":
            case "Post":
            case "POST":
                method = HttpMethod.POST;
                break;
        }
        // uri
        String sUri = lines[1];
        // version
        httpVersion = lines[2];

        // para
        paraPairList = new ArrayList<>();
        String[] spPara = sUri.split("\\?");
        uri = spPara[0];
        if (spPara.length > 1) {
            String sPara = spPara[1];
            String[] saGetParas = sPara.split("&");
            for (String para : saGetParas) {
                String[] paraPair = para.split("=");
                if (paraPair.length > 1) {
                    String name = HttpDatagramParser.recoverEscape(paraPair[0]);
                    String value = HttpDatagramParser.recoverEscape(paraPair[1]);
                    Pair getPara = new Pair(name, value);
                    paraPairList.add(getPara);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair p : paraPairList) {
            sb.append(p.toString());
        }

        return "RequestLine{" +
                "method=" + method +
                ", url='" + uri + '\'' +
                ", httpVersion='" + httpVersion + '\'' +
                ", getParas=" + sb.toString() +
                '}';
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public String getHttpVersion() {
        return httpVersion;
    }

    public String getFormatPara() {
        StringBuilder sb = new StringBuilder();
        for (Pair p : paraPairList) {
            sb.append(p.getName());
            sb.append("=");
            sb.append("{");
            sb.append(p.getValue());
            sb.append("}");
            sb.append("\n");
        }
        return sb.toString();
    }
}
