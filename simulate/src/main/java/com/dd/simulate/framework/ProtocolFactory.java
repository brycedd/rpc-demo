package com.dd.simulate.framework;

import com.dd.simulate.protocol.dubbo.DubboProtocol;
import com.dd.simulate.protocol.http.HttpProtocol;

/**
 * @author Bryce_dd 2021/11/29 23:35
 */
public class ProtocolFactory {

    public static Protocol getProtocol() {
        String name = System.getProperty("protocolName");
        if (name == null || name.equals(""))
            name = "http";

        switch (name) {
            case "http":
                return new HttpProtocol();
            case "dubbo":
                return new DubboProtocol();
            default:
                break;
        }

        return new HttpProtocol();
    }
}
