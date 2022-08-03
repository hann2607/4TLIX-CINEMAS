/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.KHUYENMAI;
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
public class QLKHUYENMAIDAO extends QLRPDAO<KHUYENMAI, String> {
    String INSERT_SQL = "INSERT INTO KHUYENMAI ( MA_KHUYEN_MAI, MA_NHAN_VIEN, HINH, MO_TA, NGAY_BAT_DAU, NGAY_KET_THUC, LOAI_KHUYEN_MAI) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE KHUYENMAI SET MA_NHAN_VIEN,  HINH=?,  HINH=?,  MO_TA=?, NGAY_BAT_DAU=?, NGAY_KET_THUC=?, LOAI_KHUYEN_MAI=?  WHERE MA_KHUYEN_MAI=?";
    String DELETE_SQL = "DELETE FROM KHUYENMAI WHERE MA_KHUYEN_MAI=?";
    String SELECT_ALL_SQL = "SELECT * FROM KHUYENMAI";
    String SELECT_BY_ID_SQL = "SELECT * FROM KHUYENMAI WHERE MA_KHUYEN_MAI=?";

    @Override
    public void insert(KHUYENMAI entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMA_KHUYEN_MAI(), entity.getMA_NHAN_VIEN(), entity.getHINH(), entity.getMO_TA(), entity.getNGAY_BAT_DAU(), entity.getNGAY_KET_THUC(),
                                    entity.getLOAI_KHUYEN_MAI());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHUYENMAIDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(KHUYENMAI entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMA_NHAN_VIEN(), entity.getHINH(), entity.getMO_TA(), entity.getNGAY_BAT_DAU(), entity.getNGAY_KET_THUC(),
                                    entity.getLOAI_KHUYEN_MAI(), entity.getMA_KHUYEN_MAI());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHUYENMAIDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLKHUYENMAIDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public KHUYENMAI selectebyID(String id) {
        List<KHUYENMAI> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KHUYENMAI> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<KHUYENMAI> selectbySql(String sql, Object... args) {
        List<KHUYENMAI> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                KHUYENMAI entity = new KHUYENMAI();
                entity.setMA_KHUYEN_MAI(rs.getString("MA_KHUYEN_MAI"));
                entity.setMA_NHAN_VIEN(rs.getString("MA_NHAN_VIEN")); 
                entity.setHINH(rs.getString("HINH"));
                entity.setMO_TA(rs.getString("MO_TA")); 
                entity.setNGAY_BAT_DAU(rs.getDate("NGAY_BAT_DAU"));
                entity.setNGAY_KET_THUC(rs.getDate("NGAY_KET_THUC"));            
                entity.setLOAI_KHUYEN_MAI(rs.getString("LOAI_KHUYEN_MAI"));
                
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
