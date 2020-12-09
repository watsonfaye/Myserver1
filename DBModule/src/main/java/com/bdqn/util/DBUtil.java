package com.bdqn.util;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;
import java.util.Properties;

//数据库工具类
public class DBUtil {
   private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    //注册驱动
    public void init(){
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //获得连接
    public  Connection getConn(){
        Connection conn=null;
        try {
            conn= DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("username"),properties.getProperty("password"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  conn;
    }
    //关闭连接
    public  void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs){
        try {
            if(rs!=null && !rs.isClosed()){
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(pstmt!=null && !pstmt.isClosed()){
                pstmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
