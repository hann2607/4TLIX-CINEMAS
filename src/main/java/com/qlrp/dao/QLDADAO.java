package com.qlrp.dao;

import com.qlrp.entity.DOAN;
import com.qlrp.utils.XJdbc;
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
public class QLDADAO extends QLRPDAO<DOAN, String> {

    String INSERT_SQL = "INSERT INTO DOANTHUCUONG ( TEN_DO_AN,  LOAI,  KICH_CO,  HINH,  SO_LUONG, DON_GIA, MA_KHUYEN_MAI) VALUES (?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE DOANTHUCUONG SET LOAI,  KICH_CO=?,  HINH=?,  SO_LUONG=?, DON_GIA=?, MA_KHUYEN_MAI=?, TRANG_THAI=?  WHERE TEN_DO_AN=?";
    String DELETE_SQL = "DELETE FROM DOANTHUCUONG WHERE TEN_DO_AN=?";
    String SELECT_ALL_SQL = "SELECT * FROM DOANTHUCUONG";
    String SELECT_BY_ID_SQL = "SELECT * FROM DOANTHUCUONG WHERE TEN_DO_AN=?";

    @Override
    public void insert(DOAN entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getTENDOAN(), entity.getLOAI(), entity.getKICHCO(), entity.getHINH(), entity.getSOLUONG(),
                    entity.getDONGIA(), entity.getMAKHUYENMAI());
        } catch (SQLException ex) {
            Logger.getLogger(QLDADAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(DOAN entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getLOAI(), entity.getKICHCO(), entity.getHINH(), entity.getSOLUONG(),
                    entity.getDONGIA(), entity.getMAKHUYENMAI(), entity.getTENDOAN());
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
    public DOAN selectebyID(String id) {
        List<DOAN> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<DOAN> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<DOAN> selectbySql(String sql, Object... args) {
        List<DOAN> list = new ArrayList<DOAN>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                DOAN entity = new DOAN();
                entity.setTENDOAN(rs.getString("TEN_DO_AN"));
                entity.setLOAI(rs.getString("LOAI"));
                entity.setKICHCO(rs.getString("KICH_CO"));
                entity.setHINH(rs.getString("HINH"));
                entity.setSOLUONG(rs.getInt("SO_LUONG"));
                entity.setDONGIA(rs.getDouble("DON_GIA"));
                entity.setMAKHUYENMAI(rs.getString("MA_KHUYEN_MAI"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
