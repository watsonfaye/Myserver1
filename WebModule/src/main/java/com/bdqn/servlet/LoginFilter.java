package com.bdqn.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        if(exceptUrlList.contains(request.getServletPath())){
            chain.doFilter(req, resp);
        }else {
            String userIp=request.getRemoteAddr();
            HashMap<String,Integer> usermap= (HashMap<String, Integer>) request.getServletContext().getAttribute("usermap");
            if(null==usermap || !usermap.containsKey(userIp)){ //没有登录
                request.getRequestDispatcher("/login.html").forward(request,response);
            }else {
                chain.doFilter(req, resp);
            }
        }
    }
    private List<String> exceptUrlList;
    public void init(FilterConfig config) throws ServletException {
        String exceptUrls = config.getServletContext().getInitParameter("exceptUrls");
        exceptUrlList= Arrays.asList(exceptUrls.split(","));
    }

}
