package com.bdqn.service.impl;

import com.bdqn.dao.StudentDao;
import com.bdqn.dao.impl.StudentImpl;
import com.bdqn.entity.City;
import com.bdqn.entity.Student;
import com.bdqn.service.StudentService;
import com.bdqn.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.List;
@Service
public class StudentBiz implements StudentService {
    @Autowired
    private StudentDao studentDao;
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    public List<City> getCity() {
        return studentDao.getCity();
    }

    public int login(String uname, String pwd) {
        return studentDao.login(uname,pwd);
    }
}
