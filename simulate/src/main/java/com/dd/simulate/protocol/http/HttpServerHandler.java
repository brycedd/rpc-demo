package com.dd.simulate.protocol.http;

import com.alibaba.fastjson.JSONObject;
import com.dd.simulate.framework.Invocation;
import com.dd.simulate.provider.LocalRegister;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Bryce_dd 2021/11/29 22:41
 */
public class HttpServerHandler {
    public void handler(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Invocation invocation = JSONObject.parseObject(req.getInputStream(), Invocation.class);

            var interfaceName = invocation.getInterfaceName();
            // 获取实现类
            var serviceImpl = LocalRegister.get(interfaceName);

            Method method = serviceImpl.getMethod(invocation.getMethodName(), invocation.getParamType());
            String result = (String)method.invoke(serviceImpl.newInstance(), invocation.getParams());

            System.out.println("tomcat:" + result);
            IOUtils.write(result,resp.getOutputStream());

        } catch (IOException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
