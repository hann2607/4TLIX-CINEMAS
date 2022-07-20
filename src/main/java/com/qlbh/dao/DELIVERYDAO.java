package com.qlbh.dao;


import com.qlbh.entity.DELIVERY;
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
public class DELIVERYDAO extends QLBHDAO<DELIVERY, String> {

    String INSERT_SQL = "INSERT INTO DELIVERY ( MAVanChuyen,  NgVanchuyen,  TINHTRANG) VALUES (?, ?, ?)";
    String UPDATE_SQL = "UPDATE DELIVERY SET MAVanChuyen=?, NgVanchuyen=?, TINHTRANG=?, DIACHI=?, GHICHU=? WHERE MAVanChuyen=?";
    String DELETE_SQL = "DELETE FROM DELIVERY WHERE MAVanChuyen=?";
    String SELECT_ALL_SQL = "SELECT * FROM DELIVERY";
    String SELECT_BY_ID_SQL = "SELECT * FROM DELIVERY WHERE MAVanChuyen=?";

    @Override
    public void insert(DELIVERY entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMAVanChuyen(),
                    entity.getNgVanchuyen(),
                    entity.getTINHTRANG());

        } catch (SQLException ex) {
            Logger.getLogger(DELIVERYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DELIVERY entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getMAVanChuyen(),
                    entity.getNgVanchuyen(),
                    entity.getTINHTRANG()
            );
        } catch (SQLException ex) {
            Logger.getLogger(DELIVERYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(DELIVERYDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public DELIVERY selectebyID(String id) {
        List<DELIVERY> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DELIVERY> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<DELIVERY> selectbySql(String sql, Object... args) {
        List<DELIVERY> list = new ArrayList<DELIVERY>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                DELIVERY entity = new DELIVERY();
                entity.setMAVanChuyen(rs.getString("MA_VanChuyen"));
                entity.setNgVanchuyen(rs.getDate("Ng_VanChuyen"));
                entity.setTINHTRANG(rs.getString("TINH_TRANG"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

}
