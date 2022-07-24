/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HAN-PC
 */
public class XJdbc {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String dburl = "database-4tl.cxhu9lb6n3tu.ap-southeast-1.rds.amazonaws.com,1433";
    static String user = "admin";
    static String pass = "123";
    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException{
        try {
            Connection conn = DriverManager.getConnection(dburl, user, pass);
            PreparedStatement stmt;
            if(sql.trim().startsWith("{")){
                stmt = conn.prepareCall(sql); // PROC
            } else {
                stmt = conn.prepareStatement(sql); // SQL 
            }
            for(int i=0; i<args.length; i++) {
                stmt.setObject(i+1, args[i]);
            }
            return stmt;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static int update(String sql, Object...args) throws SQLException {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ResultSet query(String sql, Object...args) throws SQLException {
        PreparedStatement stmt = XJdbc.getStmt(sql, args);
        return stmt.executeQuery();
    }
    
    public static Object value(String sql, Object...args) {
        try {
            ResultSet rs = XJdbc.query(sql, args);
            if(rs.next()) {
                return rs.getObject(1);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
