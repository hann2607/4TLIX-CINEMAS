/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.BANNER;
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
public class QLBANNERDAO extends QLRPDAO<BANNER, String> {

    String INSERT_SQL = "INSERT INTO BANNER (MP,  TEN_PHIM,  TRAILER) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE BANNER SET TEN_PHIM=?, TRAILER=?  WHERE MP=?";
    String DELETE_SQL = "DELETE FROM BANNER WHERE MP=?";
    String SELECT_ALL_SQL = "SELECT * FROM BANNER";
    String SELECT_BY_ID_SQL = "SELECT * FROM BANNER WHERE MP=?";

    @Override
    public void insert(BANNER entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMAPHIM(), entity.getTENPHIM(), entity.getBANNER());
        } catch (SQLException ex) {
            Logger.getLogger(QLDADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(BANNER entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTENPHIM(), entity.getBANNER(), entity.getMAPHIM());
        } catch (SQLException ex) {
            Logger.getLogger(QLDADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLDADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BANNER selectebyID(String id) {
        List<BANNER> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<BANNER> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<BANNER> selectbySql(String sql, Object... args) {
        List<BANNER> list = new ArrayList<BANNER>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                BANNER entity = new BANNER();
                entity.setMAPHIM(rs.getString("MP"));
                entity.setTENPHIM(rs.getString("TEN_PHIM"));
                entity.setBANNER(rs.getString("BANNER"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
