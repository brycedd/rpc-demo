package com.dd.simulate.protocol.http;

import com.dd.simulate.framework.Invocation;
import com.dd.simulate.framework.Protocol;
import com.dd.simulate.framework.URL;


/**
 * @author Bryce_dd 2021/11/29 23:39
 */
public class HttpProtocol implements Protocol {
    @Override
    public void start(URL url) {
        HttpServer httpServer = new HttpServer();
        httpServer.start(url.getIp(), url.getPort());

    }

    @Override
    public String send(URL url, Invocation invocation) {
        HttpClient httpClient = new HttpClient();
        return httpClient.send(url.getIp(), url.getPort(), invocation);
    }
}
