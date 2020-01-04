package Toolkit.Model.HttpDatagram;

import Toolkit.Controller.HttpDatagramParser;
import Toolkit.Model.ConfigFrame.FormatConfig;
import Toolkit.Model.Pair;

import java.util.ArrayList;
import java.util.List;

public class RequestBody {
    private String reqBody;
    private List<Pair> bodyFieldPairList;
    private static FormatConfig formatConfig;

    public RequestBody(String reqBody) {
        this.reqBody = reqBody;
        String[] bodyFields = reqBody.split("&");
        bodyFieldPairList = new ArrayList<>();
        if (bodyFields.length > 0) {
            for (String s : bodyFields) {
                String[] header = s.split("=");
                if (header.length < 1) {
                    continue;
                }
                String name = HttpDatagramParser.recoverEscape(header[0]);
                String value = HttpDatagramParser.recoverEscape(header[1]);
                Pair headerPair = new Pair(name, value);
                bodyFieldPairList.add(headerPair);
            }
        }
    }


    public String getFormatBody() {
        if (formatConfig != null) {
            StringBuilder sb = new StringBuilder();
            for (Pair p : bodyFieldPairList) {
                String format = formatConfig.getFormat();
                sb.append(format.replace("${name}", p.getName()).replace("${value}", p.getValue()));
                sb.append("\n");
            }
            return sb.toString();
        }
        StringBuilder sb = new StringBuilder();
        for (Pair p : bodyFieldPairList) {
            sb.append(p.getName());
            sb.append(":");
            sb.append("{");
            sb.append(p.getValue());
            sb.append("}");
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void setFormatConfig(FormatConfig formatConfig) {
        RequestBody.formatConfig = formatConfig;
    }
}
