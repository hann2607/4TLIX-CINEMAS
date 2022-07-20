/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbh.dao;

import com.qlbh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAN-PC
 */
public class DOANHTHUDAO {
    String SELECT_YEAR_SQL = "select DISTINCT YEAR(NG_TAO) from DONHANG order by YEAR(NG_TAO) DESC";
    
    public List<Object[]>GetSLOrder(Integer year){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_SLOrder (?)}";
                rs = XJdbc.query(sql, year);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MONTH"),
                        rs.getString("QUANTITY"),
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;

    }
    
    public List<Object[]>GetDoanhThu(Integer year){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_DoanhThuTheoNam (?)}";
                rs = XJdbc.query(sql, year);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString("MONTH"),
                        rs.getString("REVENUE"),
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;

    }
    
    public List<Object[]>getYear(){
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = XJdbc.query(SELECT_YEAR_SQL);
                while (rs.next()) {
                    Object[] model = {
                        rs.getString(1),
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return list;

    }
}
