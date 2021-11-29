package com.dd.simulate.provider;

import com.dd.simulate.framework.Protocol;
import com.dd.simulate.framework.ProtocolFactory;
import com.dd.simulate.framework.URL;
import com.dd.simulate.provider.api.DemoService;
import com.dd.simulate.provider.impl.DemoServiceImpl;
import com.dd.simulate.register.RemoteMapRegister;

/**
 * @author Bryce_dd 2021/11/28 23:45
 */
public class Provider {

    public static void main(String[] args) {

        URL url = new URL("localhost", 8080);
        //服务注册
        RemoteMapRegister.register(DemoService.class.getName(), url);

        //管理实现类
        LocalRegister.register(DemoService.class.getName(), DemoServiceImpl.class);

        Protocol protocol = ProtocolFactory.getProtocol();
        protocol.start(url);
    }
}
