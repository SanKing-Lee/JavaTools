package Toolkit.Model.HttpDatagram;

import Toolkit.Model.Pair;

import java.util.ArrayList;
import java.util.List;

public class RequestHeader {
    private List<Pair> mHeaders;
    private String hostName;

    public RequestHeader(String requestHeader) {
//        System.out.println("requestHeader: " + requestHeader);
        String[] headers = requestHeader.split("\n");
        mHeaders = new ArrayList<>();
        for (String s : headers) {
            String[] header = s.split(":");
            if(header[0].equals("Host")) {
                hostName = header[1];
            }
            Pair headerPair = new Pair(header[0], header[1]);
            mHeaders.add(headerPair);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Pair p:mHeaders) {
            sb.append(sb.toString());
        }

        return "RequestHeader{" +
                "mHeaders=" + sb.toString() +
                '}';
    }

    public String getHostName() {
        return hostName;
    }
}
