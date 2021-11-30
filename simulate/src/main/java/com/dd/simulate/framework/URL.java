package com.dd.simulate.framework;

import java.io.Serializable;

/**
 * @author Bryce_dd 2021/11/28 23:46
 */
public class URL implements Serializable {
    private static final long serialVersionUID = -674272385738844295L;
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
