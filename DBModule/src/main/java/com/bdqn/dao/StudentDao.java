package com.bdqn.dao;

import com.bdqn.entity.City;
import com.bdqn.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAll();
    List<City> getCity();

    int login(String uname, String pwd);
}
