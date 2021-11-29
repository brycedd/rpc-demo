package com.dd.simulate.protocol.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Bryce_dd 2021/11/29 22:36
 */
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 3000651579808895860L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpServerHandler().handler(req,resp);
    }
}
