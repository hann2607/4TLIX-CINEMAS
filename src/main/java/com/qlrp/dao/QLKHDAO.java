/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.KHACHHANG;
import com.qlrp.entity.NHANVIEN;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class QLKHDAO extends QLRPDAO<KHACHHANG, String> {

    String INSERT_SQL = "INSERT INTO KHACHHANG ( SDT, HO_TEN, EMAIL, DIA_CHI, GIOI_TINH, MAT_KHAU) " + "VALUES(?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE KHACHHANG SET HO_TEN=?, EMAIL=?, SDT=?, DIA_CHI=?, GIOI_TINH=?, MAT_KHAU=? WHERE SDT=?";
    String DELETE_SQL = "DELETE FROM KHACHHANG WHERE SDT=?";
    String SELECT_ALL_SQL = "SELECT * FROM KHACHHANG";
    String SELECT_BY_ID_SQL = "SELECT * FROM KHACHHANG WHERE SDT LIKE ?";

    @Override
    public void insert(KHACHHANG entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getHO_TEN(), entity.isGIOI_TINH(), entity.getSDT(), entity.getDIA_CHI(), entity.getEMAIL(), entity.getMAT_KHAU());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KHACHHANG entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getHO_TEN(), entity.isGIOI_TINH(), entity.getSDT(), entity.getDIA_CHI(), entity.getEMAIL(), entity.getMAT_KHAU());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KHACHHANG selectebyID(String id) {
        List<KHACHHANG> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KHACHHANG> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<KHACHHANG> selectbySql(String sql, Object... args) {
        List<KHACHHANG> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                KHACHHANG entity = new KHACHHANG();
                entity.setHO_TEN(rs.getString("HO_TEN"));
                entity.setGIOI_TINH(rs.getBoolean("GIOI_TINH"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDIA_CHI(rs.getString("DIA_CHI"));
                entity.setMAT_KHAU(rs.getString("MAT_KHAU"));
                entity.setEMAIL(rs.getString("EMAIL"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<KHACHHANG> search(String id) {
        List<KHACHHANG> list = this.selectbySql(SELECT_BY_ID_SQL, "%" + id + "%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }




}
