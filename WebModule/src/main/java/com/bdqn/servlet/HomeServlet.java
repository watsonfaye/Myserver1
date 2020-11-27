package com.bdqn.servlet;

import com.alibaba.fastjson.JSON;
import com.bdqn.entity.City;
import com.bdqn.entity.Student;
import com.bdqn.service.impl.StudentBiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opt=request.getParameter("opt");
        String restu="";
        if (opt != null) {
            switch (opt){
                case "all":
                    List<Student> all=new StudentBiz().getAll();
                    restu= JSON.toJSONString(all);
                    break;
                case "city":
                    List<City> cities=new StudentBiz().getCity();
                    restu= JSON.toJSONString(cities);
                    break;

            }
        }
     
        PrintWriter out = response.getWriter();
        out.print(restu);
        out.flush();
        out.close();
    }
}
