package Toolkit.Model.HttpDatagram;

import Toolkit.Model.HttpMethod;
import Toolkit.Model.Pair;

import java.util.ArrayList;
import java.util.List;

public class RequestLine {

    private HttpMethod method;
    private String uri;
    private String httpVersion;

    private String sGetPara;

    private List<Pair> getParas;

    public RequestLine(String requestLine) {
        String[] lines = requestLine.split(" ");
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
        String getUri = lines[1];
        httpVersion = lines[2];

        getParas = new ArrayList<>();
        String[] saGetPara = getUri.split("\\?");
        if (saGetPara.length > 1) {
            uri = saGetPara[0];
            sGetPara = saGetPara[1];
            String[] saGetParas = sGetPara.split("&");
            for (String para : saGetParas) {
                String[] paraPair = para.split("=");
                String name = paraPair[0];
                String value = paraPair[1];

                Pair getPara = new Pair(name, value);
                getParas.add(getPara);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair p : getParas) {
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

    public List<Pair> getGetParas() {
        return getParas;
    }

    public String getsGetPara() {
        return sGetPara;
    }
}
