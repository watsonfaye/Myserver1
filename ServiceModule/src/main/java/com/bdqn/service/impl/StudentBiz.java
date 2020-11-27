package com.bdqn.service.impl;

import com.bdqn.dao.impl.StudentImpl;
import com.bdqn.entity.City;
import com.bdqn.entity.Student;
import com.bdqn.service.StudentService;
import com.bdqn.util.DBUtil;

import java.sql.Connection;
import java.util.List;

public class StudentBiz implements StudentService {
    public List<Student> getAll() {
        List<Student> list=null;
        Connection conn=null;
        try {
            conn= DBUtil.getConn();
            if (conn != null) {
                list=new StudentImpl(conn).getAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,null,null);
        }
        return list;
    }

    public List<City> getCity() {
        List<City> list=null;
        Connection conn=null;
        try {
            conn= DBUtil.getConn();
            if (conn != null) {
                list=new StudentImpl(conn).getCity();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,null,null);
        }
        return list;
    }

    public int login(String uname, String pwd) {
        int r=0;
        Connection conn=null;
        try {
            conn= DBUtil.getConn();
            if (conn != null) {
                r=new StudentImpl(conn).login(uname,pwd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn,null,null);
        }
        return r;
    }
}
