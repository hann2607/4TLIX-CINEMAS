/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.HOADON_CT;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class HOADONCHITIETDAO extends QLRPDAO<HOADON_CT, String> {

    String INSERT_SQL = "{call SP_insert_HOADON_CT (?, ?, ?, ?, ?)}";
//    String UPDATE_SQL = "UPDATE HOADON_CT SET SL_KICH_CO=?, TEN_SP=?,  DON_GIA=? WHERE MA_HDCT=?";
//    String DELETE_SQL = "DELETE FROM HOADON_CT WHERE MA_HOA_DON=?";
    String SELECT_ALL_SQL = "SELECT * FROM HOADON_CT";
    String SELECT_BY_ID_SQL = "SELECT * FROM HOADON_CT WHERE MA_HDCT=?";

    @Override
    public void insert(HOADON_CT entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMAHDCT(), entity.getMAHD(), entity.getSL_KICHCO(), entity.getTENSP(),entity.getDONGIA());
        } catch (SQLException ex) {
            Logger.getLogger(HOADONKHACHHANGDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(HOADON_CT entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HOADON_CT selectebyID(String id) {
        List<HOADON_CT> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HOADON_CT> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<HOADON_CT> selectbySql(String sql, Object... args) {
        List<HOADON_CT> list = new ArrayList<HOADON_CT>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                HOADON_CT entity = new HOADON_CT();
                entity.setMAHD(rs.getString("MA_HOA_DON"));
                entity.setSL_KICHCO(rs.getString("SL_KICH_CO"));
                entity.setTENSP(rs.getString("TEN_SP"));
                entity.setDONGIA(rs.getString("DON_GIA"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
