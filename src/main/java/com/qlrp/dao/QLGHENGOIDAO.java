/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.GHENGOI;
import com.qlrp.entity.LOAIGHE;
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
public class QLGHENGOIDAO{
    String SELECT_THEOPHONGCHIEU_SQL = "SELECT * FROM GHENGOI WHERE MA_PHONG_CHIEU = ?";
    String SELECT_ALL_LOAIGHE_SQL = "SELECT * FROM LOAIGHE";
    String UPDATE_TRANG_THAI_GHE = "UPDATE GHENGOI SET DA_CHON = ? WHERE MA_GHE = ? AND MA_PHONG_CHIEU = ?";
    String SELECT_GHE_NGOI_SQL = "SELECT * FROM GHENGOI WHERE MA_PHONG_CHIEU = ? AND MA_GHE = ?";

    public void update(GHENGOI entity, String MA_PHONG_CHIEU) {
        try {
            XJdbc.update(UPDATE_TRANG_THAI_GHE, entity.isDA_CHON(), entity.getMA_GHE(), MA_PHONG_CHIEU);
        } catch (SQLException ex) {
            Logger.getLogger(QLGHENGOIDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateGheToFormKHHome(String MA_GHE, String MA_PHONG_CHIEU, boolean DA_CHON) {
        try {
            XJdbc.update(UPDATE_TRANG_THAI_GHE, DA_CHON, MA_GHE, MA_PHONG_CHIEU);
        } catch (SQLException ex) {
            Logger.getLogger(QLGHENGOIDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<GHENGOI> SELECT_THEOPHONGCHIEU_SQL(String MA_PHONG_CHIEU) {
        return this.selectbySql(SELECT_THEOPHONGCHIEU_SQL, MA_PHONG_CHIEU);
    }

    public List<GHENGOI> selectbySql(String sql, Object... args) {
        List<GHENGOI> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                GHENGOI entity = new GHENGOI();
                entity.setMA_GHE(rs.getString("MA_GHE"));
                entity.setTEN_GHE(rs.getString("TEN_GHE"));
                entity.setMA_PHONG_CHIEU(rs.getString("MA_PHONG_CHIEU"));
                entity.setDA_CHON(rs.getBoolean("DA_CHON"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public List<LOAIGHE> selectAllLoaiGhe() {
        return this.selectbySqlLoaiGhe(SELECT_ALL_LOAIGHE_SQL);
    }
    
    public List<LOAIGHE> selectbySqlLoaiGhe(String sql, Object... args) {
        List<LOAIGHE> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                LOAIGHE entity = new LOAIGHE();
                entity.setTEN_GHE(rs.getString("TEN_GHE"));
                entity.setPHU_THU(rs.getDouble("PHU_THU"));
                entity.setHINH(rs.getString("HINH"));
                entity.setGIA(rs.getDouble("GIA"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public GHENGOI selecteGhe_Ngoi(String MA_PHONG_CHIEU, String MA_GHE) {
        List<GHENGOI> list = this.selectbySql(SELECT_GHE_NGOI_SQL, MA_PHONG_CHIEU, MA_GHE);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
