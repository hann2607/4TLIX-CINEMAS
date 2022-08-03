/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.PHONGCHIEU;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAN-PC
 */
public class QLPHONGCHIEUDAO {
    String SELECT_BY_ID_SQL = "SELECT * FROM PHONGCHIEU WHERE MA_PHONG_CHIEU = ?";

    public PHONGCHIEU selectebyID(String id) {
        List<PHONGCHIEU> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<PHONGCHIEU> selectbySql(String sql, Object... args) {
        List<PHONGCHIEU> list = new ArrayList<>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                PHONGCHIEU entity = new PHONGCHIEU();
                entity.setMA_PHONG_CHIEU(rs.getString("MA_PHONG_CHIEU"));
                entity.setSO_LUONG_DAY(rs.getInt("SO_LUONG_DAY"));
                entity.setSO_LUONG_COT(rs.getInt("SO_LUONG_COT"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
