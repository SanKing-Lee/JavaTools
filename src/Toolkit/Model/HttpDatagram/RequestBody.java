package Toolkit.Model.HttpDatagram;

import Toolkit.Controller.HttpDatagramParser;

public class RequestBody {
    private String reqBody;
    public RequestBody(String reqBody) {
        this.reqBody = reqBody;
    }

    public String getFormatBody() {
        return HttpDatagramParser.recoverEscape(reqBody).replace("&", "\n");
    }
}
