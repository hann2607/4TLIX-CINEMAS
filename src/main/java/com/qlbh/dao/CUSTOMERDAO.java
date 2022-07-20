/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbh.dao;

import com.qlbh.entity.CUSTOMER;
import com.qlbh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class CUSTOMERDAO extends QLBHDAO<CUSTOMER, String> {

    String INSERT_SQL = "INSERT INTO CUSTOMER ( MAKH,  TENKH,  GMAIL,  DIACHI,  GHI_CHU) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE CUSTOMER SET MAKH=?, TENKH=?, GMAIL=?, DIACHI=?, GHI_CHU=? WHERE MAKH=?";
    String DELETE_SQL = "DELETE FROM CUSTOMER WHERE MAKH=?";
    String SELECT_ALL_SQL = "SELECT * FROM CUSTOMER";
    String SELECT_BY_ID_SQL = "SELECT * FROM CUSTOMER WHERE MAKH=?";

    @Override
    public void insert(CUSTOMER entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMAKH(),
                    entity.getTENKH(),
                    entity.getEMAIL(),
                    entity.getDIACHI(), entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(CUSTOMERDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(CUSTOMER entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMAKH(),
                    entity.getTENKH(),
                    entity.getEMAIL(),
                    entity.getDIACHI(), entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(CUSTOMERDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(CUSTOMERDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CUSTOMER selectebyID(String id) {
        List<CUSTOMER> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CUSTOMER> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<CUSTOMER> selectbySql(String sql, Object... args) {

        List<CUSTOMER> list = new ArrayList<CUSTOMER>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                CUSTOMER entity = new CUSTOMER();
                entity.setMAKH(rs.getString("MAKH"));
                entity.setTENKH(rs.getString("TENKH"));
                entity.setEMAIL(rs.getString("GMAIL"));
                entity.setDIACHI(rs.getString("DIACHI"));
                entity.setGHICHU(rs.getString("GHI_CHU"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
