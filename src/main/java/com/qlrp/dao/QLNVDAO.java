/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

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
public class QLNVDAO extends QLRPDAO<NHANVIEN, String>  {
    String INSERT_SQL = "INSERT INTO NHANVIEN (MA_NHAN_VIEN, HO_TEN, EMAIL, SDT, DIA_CHI, GIOI_TINH, CCCD_CMND, HINH, NGAY_VAO_LAM, TRANG_THAI, TEN_VAI_TRO, MAT_KHAU) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE NHANVIEN SET HO_TEN=?, EMAIL=?, SDT=?, DIA_CHI=?, GIOI_TINH=?, CCCD_CMND=?, HINH=?, NGAY_VAO_LAM=?, TRANG_THAI=?, TEN_VAI_TRO=?, MAT_KHAU=? WHERE MA_NHAN_VIEN=?";
    String DELETE_SQL = "DELETE FROM NHANVIEN WHERE MA_NHAN_VIEN=?";
    String SELECT_ALL_SQL = "SELECT * FROM NHANVIEN";
    String SELECT_BY_ID_SQL = "SELECT * FROM NHANVIEN WHERE MA_NHAN_VIEN LIKE ?";
    String SELECT_By_Role_SQL = "SELECT * FROM NHANVIEN WHERE TEN_VAI_TRO = ?";
    String SELECT_By_GMAIL_SQL = "SELECT * FROM NHANVIEN WHERE EMAIL like ?";
    @Override
    public void insert(NHANVIEN entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMA_NHAN_VIEN(), entity.getHO_TEN(), entity.getEMAIL(), entity.getSDT(), entity.getDIA_CHI(), entity.isGIOI_TINH(), entity.getCCCD_CMND(), 
                                        entity.getHINH(), entity.getNGAY_VAO_LAM(), entity.isTRANG_THAI(), entity.getTEN_VAI_TRO(), entity.getMAT_KHAU());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(NHANVIEN entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getHO_TEN(), entity.getEMAIL(), entity.getSDT(), entity.getDIA_CHI(), entity.isGIOI_TINH(), entity.getCCCD_CMND(), 
                                        entity.getHINH(), entity.getNGAY_VAO_LAM(), entity.isTRANG_THAI(), entity.getTEN_VAI_TRO(), entity.getMAT_KHAU(), entity.getMA_NHAN_VIEN());
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
    public NHANVIEN selectebyID(String id) {
        List<NHANVIEN> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NHANVIEN> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<NHANVIEN> selectbySql(String sql, Object... args) {
        List<NHANVIEN> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                NHANVIEN entity = new NHANVIEN();
                entity.setMA_NHAN_VIEN(rs.getString("MA_NHAN_VIEN"));
                entity.setHO_TEN(rs.getString("HO_TEN"));
                entity.setGIOI_TINH(rs.getBoolean("GIOI_TINH"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDIA_CHI(rs.getString("DIA_CHI"));
                entity.setTEN_VAI_TRO(rs.getString("TEN_VAI_TRO"));
                entity.setHINH(rs.getString("HINH"));
                entity.setTRANG_THAI(rs.getBoolean("TRANG_THAI"));
                entity.setNGAY_VAO_LAM(rs.getDate("NGAY_VAO_LAM"));
                entity.setMAT_KHAU(rs.getString("MAT_KHAU"));
                entity.setEMAIL(rs.getString("EMAIL"));
                entity.setCCCD_CMND(rs.getString("CCCD_CMND"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<NHANVIEN> search(String id) {
        List<NHANVIEN> list = this.selectbySql(SELECT_BY_ID_SQL, "%" + id + "%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public List<NHANVIEN> searchGmail(String gmail) {
        List<NHANVIEN> list = this.selectbySql(SELECT_By_GMAIL_SQL, "%" + gmail + "%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public List<NHANVIEN> listNHANVIEN_Role(int id) {
        List<NHANVIEN> list = this.selectbySql(SELECT_By_Role_SQL,id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
}
