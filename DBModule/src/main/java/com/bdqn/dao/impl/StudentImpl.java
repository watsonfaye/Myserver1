package com.bdqn.dao.impl;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.StudentDao;
import com.bdqn.entity.City;
import com.bdqn.entity.Student;
import com.bdqn.util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl extends BaseDao implements StudentDao {
    public StudentImpl(Connection conn) {
        super(conn);
    }

    public List<Student> getAll() {
       List<Student> list=null;
        ResultSet rs=null;
        try {
            rs=ExecuteQuery("select * from myschool.student");
            if (rs != null) {
                list=new ArrayList<Student>();
                while (rs.next()){
                    Student s=new Student();
                    s.setStudentNo(rs.getString("StudentNo"));
                    s.setLoginPwd(rs.getString("StudentNo"));
                    s.setStudentName(rs.getString("StudentName"));
                    s.setSex(rs.getString("Sex"));
                    s.setGradeId(rs.getInt("GradeId"));
                    s.setPhone(rs.getString("Phone"));
                    s.setAddress(rs.getString("Address"));
                    s.setBornDate(rs.getDate("BornDate"));
                    s.setEmail(rs.getString("Email"));
                    list.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // DBUtil.closeAll(null,null,rs);
        }
        return list;
    }

    @Override
    public List<City> getCity() {
        List<City> list=null;
        ResultSet rs=null;
        try {
            rs=ExecuteQuery("select * from myschool.city where type=1");
            if (rs != null) {
                list=new ArrayList<City>();
                while (rs.next()){
                   City c=new City();
                   c.setId(rs.getInt("id"));
                   c.setPid(rs.getInt("pid"));
                   c.setCityname(rs.getString("cityname"));
                   c.setType(rs.getInt("type"));

                    list.add(c);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           // DBUtil.closeAll(null,null,rs);
        }
        return list;
    }

    @Override
    public int login(String uname, String pwd) {
        int r=0;
        try {
            r=ExecuteNonQuery("select count(*) from student where studentname=? and studentpwd=?",uname,pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

}
