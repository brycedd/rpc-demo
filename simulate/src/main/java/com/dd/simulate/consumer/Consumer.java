package com.dd.simulate.consumer;

import com.dd.simulate.framework.ProxyFactory;
import com.dd.simulate.provider.api.DemoService;

/**
 * @author Bryce_dd 2021/11/29 23:53
 */
public class Consumer {
    public static void main(String[] args) {
        DemoService proxy = ProxyFactory.getProxy(DemoService.class);
        String xxx = proxy.demo("xxx");
        System.out.println(xxx);

    }
}
