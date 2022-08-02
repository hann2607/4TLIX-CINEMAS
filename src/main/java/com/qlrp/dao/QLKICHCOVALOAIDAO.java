/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.DOAN;
import com.qlrp.entity.KICHCODA;
import com.qlrp.entity.LOAIDA;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAN-PC
 */
public class QLKICHCOVALOAIDAO {

    String SELECT_ALLLOAI_SQL = "SELECT * FROM LOAIDOAN";
    String SELECT_ALLKICHCO_SQL = "SELECT * FROM KICHCODOAN";

    public List<LOAIDA> selectAllLoai() {
        List<LOAIDA> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(SELECT_ALLLOAI_SQL);
            while (rs.next()) {
                LOAIDA entity = new LOAIDA();
                entity.setTEN_LOAI_DO_AN(rs.getString("TEN_LOAI_DO_AN"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<KICHCODA> selectAllKichCo() {
        List<KICHCODA> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(SELECT_ALLKICHCO_SQL);
            while (rs.next()) {
                KICHCODA entity = new KICHCODA();
                entity.setTEN_KICH_CO_DA(rs.getString("TEN_KICH_CO_DO_AN"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
