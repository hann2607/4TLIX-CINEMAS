/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.SUATCHIEU;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HAN-PC
 */
public class QLSUATCHIEUDAO extends QLRPDAO<SUATCHIEU, String>{
   String INSERT_SQL = "INSERT INTO SUATCHIEU (MA_SUAT_CHIEU, MA_PHONG_CHIEU, TEN_DINH_DANG_PHIM, MA_PHIM, GIO_BAT_DAU, GIO_KET_THUC, NGAY_CHIEU) " + "VALUES(?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE SUATCHIEU SET MA_PHONG_CHIEU=?, TEN_DINH_DANG_PHIM=?, MA_PHIM=?, GIO_BAT_DAU=?, GIO_KET_THUC=?, NGAY_CHIEU=? WHERE MA_SUAT_CHIEU=?";
    String DELETE_SQL = "DELETE FROM SUATCHIEU WHERE MA_SUAT_CHIEU=?";
    String SELECT_ALL_SQL = "SELECT * FROM SUATCHIEU";
    String SELECT_BY_ID_SQL = "SELECT * FROM SUATCHIEU WHERE MA_SUAT_CHIEU LIKE ?";

    @Override
    public void insert(SUATCHIEU entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMA_SUAT_CHIEU(), entity.getMA_PHONG_CHIEU(), entity.getTEN_DINH_DANG_PHIM(), entity.getMA_PHIM(), 
                                    entity.getGIO_BAT_DAU(), entity.getGIO_KET_THUC(), entity.getNGAY_CHIEU());
        } catch (SQLException ex) {
            Logger.getLogger(QLSUATCHIEUDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(SUATCHIEU entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMA_PHONG_CHIEU(), entity.getTEN_DINH_DANG_PHIM(), entity.getMA_PHIM(), 
                                    entity.getGIO_BAT_DAU(), entity.getGIO_KET_THUC(), entity.getNGAY_CHIEU(), entity.getMA_SUAT_CHIEU());
        } catch (SQLException ex) {
            Logger.getLogger(QLSUATCHIEUDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLSUATCHIEUDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public SUATCHIEU selectebyID(String id) {
        List<SUATCHIEU> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<SUATCHIEU> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<SUATCHIEU> selectbySql(String sql, Object... args) {
        List<SUATCHIEU> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                SUATCHIEU entity = new SUATCHIEU();
                entity.setMA_SUAT_CHIEU(rs.getString("MA_SUAT_CHIEU"));
                entity.setMA_PHONG_CHIEU(rs.getString("MA_PHONG_CHIEU"));
                entity.setTEN_DINH_DANG_PHIM(rs.getString("TEN_DINH_DANG_PHIM"));
                entity.setMA_PHIM(rs.getString("MA_PHIM"));
                entity.setGIO_BAT_DAU(rs.getTime("GIO_BAT_DAU"));
                entity.setGIO_KET_THUC(rs.getTime("GIO_KET_THUC"));
                entity.setNGAY_CHIEU(rs.getDate("NGAY_CHIEU"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
