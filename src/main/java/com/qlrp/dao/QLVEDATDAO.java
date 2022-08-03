/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.VEDAT;
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
public class QLVEDATDAO extends QLRPDAO<VEDAT, String>{
    String INSERT_SQL = "INSERT INTO VEDAT (MA_VE_DAT,  SDT,  SO_LUONG) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE VEDAT SET SDT=?, SO_LUONG=?  WHERE MA_VE_DAT=?";
    String DELETE_SQL = "DELETE FROM VEDAT WHERE MA_VE_DAT=?";
    String SELECT_ALL_SQL = "SELECT * FROM VEDAT";
    String SELECT_BY_ID_SQL = "SELECT * FROM VEDAT WHERE MA_VE_DAT=?";

    @Override
    public void insert(VEDAT entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMA_VE_DAT(), entity.getSDT(), entity.getSO_LUONG());
        } catch (SQLException ex) {
            Logger.getLogger(QLVEDATDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(VEDAT entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getSDT(), entity.getSO_LUONG(), entity.getMA_VE_DAT());
        } catch (SQLException ex) {
            Logger.getLogger(QLVEDATDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLVEDATDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public VEDAT selectebyID(String id) {
        List<VEDAT> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<VEDAT> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<VEDAT> selectbySql(String sql, Object... args) {
        List<VEDAT> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                VEDAT entity = new VEDAT();
                entity.setMA_VE_DAT(rs.getString("MA_VE_DAT"));
                entity.setSDT(rs.getString("SDT"));
                entity.setSO_LUONG(rs.getInt("SO_LUONG"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
