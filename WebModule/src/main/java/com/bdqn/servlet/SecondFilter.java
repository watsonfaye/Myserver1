package com.bdqn.servlet;

import javax.servlet.*;
import java.io.IOException;

public class SecondFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Second 请求前");
       req.setCharacterEncoding("UTF-8");
       resp.setContentType("text/html;charset=UTF-8");
        chain.doFilter(req, resp);
        System.out.println("Second 请求后");

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
