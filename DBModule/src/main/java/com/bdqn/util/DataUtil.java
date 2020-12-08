package com.bdqn.util;

import com.sun.org.apache.xml.internal.security.Init;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataUtil {
    public Properties getMysqlProp() {
        return mysqlProp;
    }
    public void setMysqlProp(Properties mysqlProp) {
        this.mysqlProp = mysqlProp;
    }


    private Properties mysqlProp;

    public void  init(){
        try {
            Class.forName(mysqlProp.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(mysqlProp.getProperty("url"),mysqlProp.getProperty("username"),mysqlProp.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  conn;
    }

    @Override
    public String toString() {
        return "DataUtil{" +
                "mysqlProp=" + mysqlProp +
                '}';
    }
}
