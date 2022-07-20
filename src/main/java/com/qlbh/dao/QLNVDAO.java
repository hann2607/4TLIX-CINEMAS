package com.qlbh.dao;

import com.qlbh.entity.EMPLOYEE;
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
public class QLNVDAO extends QLBHDAO<EMPLOYEE, String> {

    String INSERT_SQL = "INSERT INTO EMPLOYEE (MANV, HOTENNV, GIOITINH, SDT, DIACHI, VAITRO, HINH, STORY, GMAIL, LUONG, MATKHAU) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE EMPLOYEE SET HOTENNV=?, GIOITINH=?, SDT=?, DIACHI=?, VAITRO=?, HINH=?, STORY=?, GMAIL=?, LUONG=?, MATKHAU=? WHERE MANV=?";
    String DELETE_SQL = "DELETE FROM EMPLOYEE WHERE MANV=?";
    String SELECT_ALL_SQL = "SELECT * FROM EMPLOYEE";
    String SELECT_BY_ID_SQL = "SELECT * FROM EMPLOYEE WHERE MANV LIKE ?";
    String SELECT_By_Role_SQL = "SELECT * FROM EMPLOYEE WHERE VAITRO = ?";
    @Override
    public void insert(EMPLOYEE entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMANV(), entity.getHOTENNV(), entity.isGIOITINH(), entity.getSDT(), entity.getDIACHI(), entity.isVAITRO(),
                    entity.getHINH(), entity.getSTORY(), entity.getGMAIL(), entity.getLUONG(), entity.getMATKHAU());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(EMPLOYEE entity) {
        try {
            XJdbc.update(UPDATE_SQL, entity.getHOTENNV(), entity.isGIOITINH(), entity.getSDT(), entity.getDIACHI(), entity.isVAITRO(),
                    entity.getHINH(), entity.getSTORY(), entity.getGMAIL(), entity.getLUONG(), entity.getMATKHAU(), entity.getMANV());
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLNVDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public EMPLOYEE selectebyID(String id) {
        List<EMPLOYEE> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<EMPLOYEE> selectAll() {
        return this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<EMPLOYEE> selectbySql(String sql, Object... args) {
        List<EMPLOYEE> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                EMPLOYEE entity = new EMPLOYEE();
                entity.setMANV(rs.getString("MANV"));
                entity.setHOTENNV(rs.getString("HOTENNV"));
                entity.setGIOITINH(rs.getBoolean("GIOITINH"));
                entity.setSDT(rs.getString("SDT"));
                entity.setDIACHI(rs.getString("DIACHI"));
                entity.setVAITRO(rs.getBoolean("VAITRO"));
                entity.setHINH(rs.getString("HINH"));
                entity.setSTORY(rs.getString("STORY"));
                entity.setLUONG(rs.getDouble("LUONG"));
                entity.setMATKHAU(rs.getString("MATKHAU"));
                entity.setGMAIL(rs.getString("GMAIL"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public List<EMPLOYEE> search(String id) {
        List<EMPLOYEE> list = this.selectbySql(SELECT_BY_ID_SQL, "%" + id + "%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public List<EMPLOYEE> listEmployee_Role(int id) {
        List<EMPLOYEE> list = this.selectbySql(SELECT_By_Role_SQL,id);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
}
