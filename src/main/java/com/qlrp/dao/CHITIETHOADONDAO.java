/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlrp.dao;


import com.qlrp.entity.CHITIETHOADON;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author pc
 */
public class CHITIETHOADONDAO extends QLRPDAO<CHITIETHOADON, String> {
    String SELECT_ALL_SQL = "select cthd.*, slv.MA_VE, slv.SO_LUONG from HOADON hd join CHITIETHOADON cthd on hd.MA_HOA_DON = cthd.MA_HOA_DON\n" +
"															join V_VEDAT_SOLUONGVE slv on slv.MA_VE = hd.MA_VE";
    String SELECT_BY_ID_SQL = "select cthd.*, slv.MA_VE, slv.SO_LUONG from HOADON hd join CHITIETHOADON cthd on hd.MA_HOA_DON = cthd.MA_HOA_DON\n" +
"															join V_VEDAT_SOLUONGVE slv on slv.MA_VE = hd.MA_VE WHERE hd.MA_HOA_DON=?";

    @Override
    public List<CHITIETHOADON> selectAll() {
        return (List<CHITIETHOADON>) this.selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public void insert(CHITIETHOADON entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CHITIETHOADON entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CHITIETHOADON selectebyID(String id) {
         List<CHITIETHOADON> list = (List<CHITIETHOADON>) this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CHITIETHOADON> selectbySql(String sql, Object... args) {
        List<CHITIETHOADON> list = new ArrayList<CHITIETHOADON>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                CHITIETHOADON entity = new CHITIETHOADON();
                entity.setMAHOADONCHITIET(rs.getString("MA_HOA_DON_CHI_TIET"));
                entity.setMAHOADON(rs.getString("MA_HOA_DON"));
                entity.setTENDOAN(rs.getString("TEN_DO_AN"));
                entity.setSOLUONGDOAN(rs.getString("SO_LUONG"));
                entity.setMAVE(rs.getString("MA_VE"));
                entity.setSOLUONGVE(rs.getString("SO_LUONG"));
                entity.setMAKHUYENMAI(rs.getString("MA_KHUYEN_MAI"));
                entity.setTONGTIEN(rs.getString("TONG_TIEN"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}