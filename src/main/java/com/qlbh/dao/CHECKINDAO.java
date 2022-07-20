/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbh.dao;

import com.qlbh.entity.CHECKIN;
import com.qlbh.utils.XJdbc;
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
public class CHECKINDAO extends QLBHDAO<CHECKIN, Object> {

    String INSERT_SQL = "INSERT INTO CHECKIN ( MANV,  GIO_VAO,  GIO_RA,  TINHTRANG, GHI_CHU) VALUES (?, ?, ?, ?, ?)";
    String UPDATE_SQL_IN = "UPDATE CHECKIN SET GIO_VAO=? WHERE MANV=?";
    String UPDATE_SQL_OUT = "UPDATE CHECKIN SET GIO_RA=? WHERE MANV=?";
    String DELETE_SQL = "DELETE FROM CHECKIN WHERE MANV=?";
    String SELECT_ALL_SQL = "SELECT * FROM CHECKIN";
    String SELECT_BY_ID_SQL = "SELECT * FROM CHECKIN WHERE MANV=?";

    @Override
    public void insert(CHECKIN entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void update_IN(CHECKIN entity) {
        try {
            XJdbc.update(UPDATE_SQL_IN, entity.getLUOTVAO(), entity.getMANV());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update_OUT(CHECKIN entity) {
        try {
            XJdbc.update(UPDATE_SQL_OUT, entity.getLUOTRA(), entity.getMANV());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public List<CHECKIN> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<CHECKIN> selectbySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(CHECKIN entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public CHECKIN selectebyID(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
