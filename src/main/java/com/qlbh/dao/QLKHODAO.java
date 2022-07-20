package com.qlbh.dao;

import com.qlbh.entity.INVENTORY;
import com.qlbh.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Acer
 */
public class QLKHODAO extends QLBHDAO<INVENTORY, String> {

    String INSERT_SQL = "INSERT INTO WAREHOUSE ( MA_SP,  TENSP,  SOLUONG,  DONGIA,  HINH, GHI_CHU) VALUES (?, ?, ?,?, ?, ?)";
    String UPDATE_SQL = "UPDATE WAREHOUSE SET TENSP=?, SOLUONG=?, DONGIA=?, HINH=?, GHI_CHU=?  WHERE MA_SP=?";
    String DELETE_SQL = "DELETE FROM WAREHOUSE WHERE MA_SP=?";
    String SELECT_ALL_SQL = "SELECT * FROM WAREHOUSE";
    String SELECT_BY_ID_SQL = "SELECT * FROM WAREHOUSE WHERE MA_SP=?";

    @Override
    public void insert(INVENTORY entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMASP(), entity.getTENSP(), entity.getSOLUONG(), entity.getDONGIA(), entity.getHINH(),
                    entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(INVENTORY entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getTENSP(), entity.getSOLUONG(), entity.getDONGIA(), entity.getHINH(),
                    entity.getGHICHU(), entity.getMASP());
        } catch (SQLException ex) {
            Logger.getLogger(QLKHODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLKHODAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public INVENTORY selectebyID(String id) {
        List<INVENTORY> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<INVENTORY> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<INVENTORY> selectbySql(String sql, Object... args) {
        List<INVENTORY> list = new ArrayList<INVENTORY>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                INVENTORY entity = new INVENTORY();
                entity.setMASP(rs.getString("MA_SP"));
                entity.setTENSP(rs.getString("TENSP"));
                entity.setSOLUONG(rs.getInt("SOLUONG"));
                entity.setDONGIA(rs.getDouble("DONGIA"));
                entity.setHINH(rs.getString("HINH"));
                entity.setGHICHU(rs.getString("GHI_CHU"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
