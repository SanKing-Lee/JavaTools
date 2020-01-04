package Toolkit.Model.HttpDatagram;

import Toolkit.Controller.HttpDatagramParser;
import Toolkit.Model.ConfigFrame.FormatConfig;
import Toolkit.Model.Pair;

import java.util.ArrayList;
import java.util.List;

public class RequestHeader {
    private List<Pair> headerPairList;
    private String hostName;
    private static FormatConfig formatConfig;

    public RequestHeader(String requestHeader) {
        String[] headers = requestHeader.split("\n");
        headerPairList = new ArrayList<>();
        if (headers.length > 0) {
            for (String s : headers) {
                String[] header = s.split(":");
                if (header.length < 1) {
                    continue;
                }
                String name = HttpDatagramParser.recoverEscape(header[0]);
                String value = HttpDatagramParser.recoverEscape(header[1]);
                if (name.equals("Host")) {
                    hostName = value;
                }
                Pair headerPair = new Pair(name, value);
                headerPairList.add(headerPair);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pair p : headerPairList) {
            sb.append(sb.toString());
        }

        return "RequestHeader{" +
                "mHeaders=" + sb.toString() +
                '}';
    }

    public String getHostName() {
        return hostName;
    }

    public String getFormatHeaders() {
        if (formatConfig != null) {
            StringBuilder sb = new StringBuilder();
            for (Pair p : headerPairList) {
                String format = formatConfig.getFormat();
                sb.append(format.replace("${name}", p.getName()).replace("${value}", p.getValue()));
                sb.append("\n");
            }
            return sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : headerPairList) {
            sb.append(p.getName());
            sb.append(":");
            sb.append("{");
            sb.append(p.getValue());
            sb.append("}");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void setFormatConfig(FormatConfig fc) {
        formatConfig = fc;
    }
}
