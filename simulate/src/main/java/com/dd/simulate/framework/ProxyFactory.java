package com.dd.simulate.framework;

import com.dd.simulate.register.RemoteMapRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author Bryce_dd 2021/11/29 23:53
 */
public class ProxyFactory<T> {

    @SuppressWarnings("unchecked")
    public static <T> T getProxy(final Class<T> interfaceClass) {
        return (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //todo 容错处理


                Invocation invocation = new Invocation(interfaceClass.getName(), method.getName(), args, method.getParameterTypes());
                List<URL> list = RemoteMapRegister.get(interfaceClass.getName());
                URL random = LoadBalance.random(list);

                Protocol protocol = ProtocolFactory.getProtocol();
                return protocol.send(random, invocation);
            }
        });
    }


}
