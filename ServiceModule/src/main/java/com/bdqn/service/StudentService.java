package com.bdqn.service;

import com.bdqn.entity.City;
import com.bdqn.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    List<City> getCity();
    int login(String uname,String pwd);
}
