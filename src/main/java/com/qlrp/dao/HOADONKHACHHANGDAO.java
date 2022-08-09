/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.HOADON_KH;
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
public class HOADONKHACHHANGDAO extends QLRPDAO<HOADON_KH, String> {

    String INSERT_SQL = "{call SP_insert_HOADON_KH (?, ?, ?, ?, ?, ?)}";
//    String UPDATE_SQL = "UPDATE HOADON SET MA_NHAN_VIEN=?, MA_VE=?,  SDT=?,  NGAY_BAN=?  WHERE MA_HOA_DON=?";
//    String DELETE_SQL = "DELETE FROM HOADON WHERE MA_HOA_DON=?";
    String SELECT_ALL_SQL = "SELECT * FROM HOADON_KH";
    String SELECT_BY_ID_SQL = "SELECT * FROM HOADON_KH WHERE MA_HOA_DON=?";

    @Override
    public void insert(HOADON_KH entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMAHD(), entity.getTENKH(), entity.getSDT(), entity.getEMAIL(), entity.getTHOIGIAN(), entity.getTONGTIEN());
        } catch (SQLException ex) {
            Logger.getLogger(HOADONKHACHHANGDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(HOADON_KH entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HOADON_KH selectebyID(String id) {
        List<HOADON_KH> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HOADON_KH> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<HOADON_KH> selectbySql(String sql, Object... args) {
        List<HOADON_KH> list = new ArrayList<HOADON_KH>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                HOADON_KH entity = new HOADON_KH();
                entity.setMAHD(rs.getString("MA_HOA_DON"));
                entity.setTENKH(rs.getString("TEN_KHACH_HANG"));
                entity.setSDT(rs.getString("SDT"));
                entity.setEMAIL(rs.getString("EMAIL"));
                entity.setTHOIGIAN(rs.getString("THOI_GIAN"));
                entity.setTONGTIEN(rs.getString("TONG_TIEN"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
