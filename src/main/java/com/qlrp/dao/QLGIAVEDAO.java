/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.GIAVE;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAN-PC
 */
public class QLGIAVEDAO {
    String SELECT_ALL_GIAVE_SQL = "SELECT * FROM GIAVE";
    
    public List<GIAVE> selectAllGiaVe() {
        return this.selectbySqlLoaiGhe(SELECT_ALL_GIAVE_SQL);
    }
    
    public List<GIAVE> selectbySqlLoaiGhe(String sql, Object... args) {
        List<GIAVE> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                GIAVE entity = new GIAVE();
                entity.setMA_GIA_VE(rs.getString("MA_GIA_VE"));
                entity.setDON_GIA(rs.getDouble("DON_GIA"));
                entity.setLOAI_VE(rs.getString("LOAI_VE"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
