package com.bdqn.dao;


import com.bdqn.util.DBUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao {
    private Connection conn;
    @Autowired
    protected DBUtil dbUtil;

    public Connection getConn() {
        return conn;
    }
    @Autowired
    public void setConn(@Qualifier("conn") Connection conn) {
        this.conn = conn;
    }

    //执行非查询语句
    public int ExecuteNonQuery(String sql,Object... args){
        int r=0;
        PreparedStatement pstmt=null;

        try {
            pstmt=conn.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    pstmt.setObject(i+1,args[i]);
                }
            }
            r=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            dbUtil.closeAll(null,pstmt,null);
        }

        return  r;
    }
    //执行查询语句
    public ResultSet ExecuteQuery(String sql, Object... args){
        ResultSet r=null;
        PreparedStatement pstmt=null;

        try {
            pstmt=conn.prepareStatement(sql);
            if (args != null) {
                for (int i = 0; i < args.length; i++) {
                    pstmt.setObject(i+1,args[i]);
                }
            }
            r=pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return  r;
    }
}
