package com.bdqn.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//过滤器　Ｆiｌｔｅｒ
public class HelloFilter implements Filter {
    public void destroy() {
        System.out.println("HelloFilter 销毁");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
       /* System.out.println("HelloFilter 请求前");
        HttpServletRequest request= (HttpServletRequest) req;
        System.out.println(request.getServletPath());
        if(request.getServletPath().equals("/index1.html")){
            chain.doFilter(req, resp);
        }
        //chain.doFilter(req,resp);//跳转到请求的页面
        System.out.println("HelloFilter 请求后");*/
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("HelloFilter 初始化");
    }

}
