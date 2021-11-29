package com.dd.simulate.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.dd.simulate.framework.Invocation;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newHttpClient;

/**
 * @author Bryce_dd 2021/11/29 23:41
 */
public class HttpClient {

    public String send(String hostname, Integer port, Invocation invocation) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http", null, hostname, port, "/", null, null))
                    .POST(HttpRequest.BodyPublishers.ofString(JSONObject.toJSONString(invocation)))
                    .build();
            var  httpClient = newHttpClient();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
