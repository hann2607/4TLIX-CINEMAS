/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlrp.dao;


import com.qlrp.entity.HOADON;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class QLHOADONDAO extends QLRPDAO<HOADON, String> {

    String INSERT_SQL = "INSERT INTO HOADON ( MA_HOA_DON,  MA_NHAN_VIEN,  MA_VE, SDT, NGAY_BAN) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE HOADON SET MA_NHAN_VIEN=?, MA_VE=?,  SDT=?,  NGAY_BAN=?  WHERE MA_HOA_DON=?";
    String DELETE_SQL = "DELETE FROM HOADON WHERE MA_HOA_DON=?";
    String SELECT_ALL_SQL = "SELECT * FROM HOADON";
    String SELECT_BY_ID_SQL = "SELECT * FROM HOADON WHERE MA_HOA_DON=?";

    @Override
    public void update(HOADON entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMAHOADON(), entity.getMANHANVIEN(), entity.getMAVE(), entity.getSDT(), entity.getNGAYBAN());
        } catch (SQLException ex) {
            Logger.getLogger(QLHOADONDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLHOADONDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public HOADON selectebyID(String id) {
        List<HOADON> list = (List<HOADON>) this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HOADON> selectAll() {
        return (List<HOADON>) this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<HOADON> selectbySql(String sql, Object... args) {
        List<HOADON> list = new ArrayList<HOADON>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                HOADON entity = new HOADON();
                entity.setMAHOADON(rs.getString("MA_HOA_DON"));
                entity.setMANHANVIEN(rs.getString("MA_NHAN_VIEN"));
                entity.setMAVE(rs.getString("MA_VE"));
                entity.setSDT(rs.getString("SDT"));
                entity.setNGAYBAN(rs.getDate("NGAY_BAN"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void insert(HOADON entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<HOADON> search(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(int mahd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

