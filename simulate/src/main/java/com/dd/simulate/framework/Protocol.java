package com.dd.simulate.framework;

/**
 * @author Bryce_dd 2021/11/29 23:35
 */
public interface Protocol {

    void start(URL url);
    String send(URL url,Invocation invocation);
}
