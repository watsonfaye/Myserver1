package com.bdqn.servlet;

import com.bdqn.service.impl.StudentBiz;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginServlet extends HttpServlet {

    public LoginServlet(){
        System.out.println("LoginServlet");
    }

    Map<String,Integer> usermap;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("LoginServlet Init");
        usermap=new HashMap<>();
        this.getServletContext().setAttribute("usermap",usermap);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String pwd = request.getParameter("pwd");

        int r=new StudentBiz().login(uname,pwd);
        if(r>0){
            usermap.put(request.getRemoteAddr(),r);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
