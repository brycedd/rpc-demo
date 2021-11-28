package com.dd.simulate.framework;

/**
 * @author Bryce_dd 2021/11/28 23:46
 */
public class URL {
    private String ip;
    private String port;

    public URL(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
