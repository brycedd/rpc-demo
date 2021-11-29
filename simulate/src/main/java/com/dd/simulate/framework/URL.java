package com.dd.simulate.framework;

/**
 * @author Bryce_dd 2021/11/28 23:46
 */
public class URL {
    private String ip;
    private int port;

    public URL(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
