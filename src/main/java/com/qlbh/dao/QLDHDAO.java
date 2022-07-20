package com.qlbh.dao;

import com.qlbh.entity.QLDH;
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
public class QLDHDAO extends QLBHDAO<QLDH, String> {

    String INSERT_SQL = "INSERT INTO DONHANG (  MA_DH,  MANV,  MAKH,  DONGIA,  NG_TAO, GHI_CHU) VALUES (?, ?, ?,?, ?, ?)";
    String UPDATE_SQL = "UPDATE DONHANG SET MA_DH=?, MANV=?, MAKH=?, DONGIA=?, NG_TAO=?, GHI_CHU=?  WHERE MA_DH=?";
    String DELETE_SQL = "DELETE FROM DONHANG WHERE MA_DH=?";
    String SELECT_ALL_SQL = "SELECT * FROM DONHANG";
    String SELECT_BY_ID_SQL = "SELECT * FROM DONHANG WHERE MA_DH=?";

    @Override
    public void insert(QLDH entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMADH(), entity.getMANV(), entity.getMAKH(), entity.getDONGIA(), entity.getNgTao(),
                    entity.getGHICHU());
        } catch (SQLException ex) {
            Logger.getLogger(QLDHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void update(QLDH entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMADH(), entity.getMANV(), entity.getMAKH(), entity.getDONGIA(), entity.getNgTao(),
                    entity.getGHICHU(), entity.getMADH());
        } catch (SQLException ex) {
            Logger.getLogger(QLDHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLDHDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public QLDH selectebyID(String id) {
        List<QLDH> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<QLDH> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<QLDH> selectbySql(String sql, Object... args) {
        List<QLDH> list = new ArrayList<QLDH>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                QLDH entity = new QLDH();
                entity.setMADH(rs.getString("MA_DH"));
                entity.setMANV(rs.getString("MANV"));
                entity.setMAKH(rs.getString("MAKH"));
                entity.setDONGIA(rs.getInt("DONGIA"));
                entity.setNgTao(rs.getDate("NG_TAO"));
                entity.setGHICHU(rs.getString("GHI_CHU"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    private List<Object[]> getListOfArray(String sql, String[] cols, Object... args) {
        try {
            List<Object[]> list = new ArrayList<>();
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Object[] vals = new Object[cols.length];
                for (int i = 0; i < cols.length; i++) {
                    vals[i] = rs.getObject(cols[i]);
                }
                list.add(vals);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Object[]> getOrderTableByKeyword(String keyword) {
        String sql = "{CALL sp_OrderTableByKeyword(?)}";
        String[] cols = {"ORDER_ID", "CUSTOMER_ID", "CUSTOMER_NAME",
            "PRODUCT_ID", "PRODUCT_NAME", "DATE_CREATE", "QTY", "PRICE", "NOTE"};
        return this.getListOfArray(sql, cols, "%" + keyword + "%");
    }
}
