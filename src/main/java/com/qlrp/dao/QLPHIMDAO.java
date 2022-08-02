/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.dao;

import com.qlrp.entity.PHIM;
import com.qlrp.utils.XJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duong
 */
public class QLPHIMDAO extends QLRPDAO<PHIM, String> {

    String INSERT_SQL = "INSERT INTO PHIM ( MA_PHIM, TEN_PHIM, TEN_DINH_DANG_PHIM, THOI_LUONG_CHIEU, NGON_NGU, LOAIPHIM, DIENVIEN, QUOCGIA, NHA_SAN_XUAT, TOM_TAT, POSTER, TRAILER, GIOI_HAN_TUOI, NGAY_CONG_CHIEU, BANNER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String UPDATE_SQL = "UPDATE PHIM SET LOAI,  MA_PHIM=?,  TEN_PHIM=?, TEN_DINH_DANG_PHIM=?, THOI_LUONG_CHIEU=?, NGON_NGU=?, LOAIPHIM=?, DIENVIEN=?, QUOCGIA=?, NHA_SAN_XUAT=?, TOM_TAT=?, POSTER=?, TRAILER=?, GIOI_HAN_TUOI=?, NGAY_CONG_CHIEU=?, BANNER=? WHERE TEN_DO_AN=?";
    String DELETE_SQL = "DELETE FROM PHIM WHERE MA_PHIM=?";
    String SELECT_ALL_SQL = "SELECT * FROM PHIM";
    String SELECT_BY_ID_SQL = "SELECT * FROM PHIM WHERE MA_PHIM=?";
    String SELECT_BY_TEN_PHIM_SQL = "SELECT * FROM PHIM WHERE TEN_PHIM=?";
    @Override
    public void insert(PHIM entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMA_PHIM(), entity.getTEN_PHIM(), entity.getTEN_DINH_DANG_PHIM(), entity.getTHOI_LUONG_CHIEU(), entity.getNGON_NGU(),
                    entity.getLOAIPHIM(), entity.getDIENVIEN(), entity.getQUOCGIA(), entity.getNHA_SAN_XUAT(), entity.getTOM_TAT(), entity.getPOSTER(), entity.getTRAILER(),
                    entity.getGIOI_HAN_TUOI(), entity.getNGAY_CONG_CHIEU(), entity.getBANNER());
        } catch (SQLException ex) {
            Logger.getLogger(QLPHIMDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(PHIM entity) {
        try {
            XJdbc.update(INSERT_SQL, entity.getMA_PHIM(), entity.getTEN_PHIM(), entity.getTEN_DINH_DANG_PHIM(), entity.getTHOI_LUONG_CHIEU(), entity.getNGON_NGU(),
                    entity.getLOAIPHIM(), entity.getDIENVIEN(), entity.getQUOCGIA(), entity.getNHA_SAN_XUAT(), entity.getTOM_TAT(), entity.getPOSTER(), entity.getTRAILER(),
                    entity.getGIOI_HAN_TUOI(), entity.getNGAY_CONG_CHIEU(), entity.getBANNER());
        } catch (SQLException ex) {
            Logger.getLogger(QLPHIMDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String id) {
        try {
            XJdbc.update(DELETE_SQL, id);
        } catch (SQLException ex) {
            Logger.getLogger(QLPHIMDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PHIM selectebyID(String id) {
        List<PHIM> list = this.selectbySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
    
    public PHIM selectebyTenPhim(String Phim) {
        List<PHIM> list = this.selectbySql(SELECT_BY_TEN_PHIM_SQL, Phim);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<PHIM> selectAll() {
        return selectbySql(SELECT_ALL_SQL);
    }

    @Override
    public List<PHIM> selectbySql(String sql, Object... args) {
        List<PHIM> list = new ArrayList<PHIM>();
        ResultSet rs;
        try {
            rs = XJdbc.query(sql, args);

            while (rs.next()) {
                PHIM entity = new PHIM();
                entity.setMA_PHIM(rs.getString("MA_PHIM"));
                entity.setTEN_PHIM(rs.getString("TEN_PHIM"));
                entity.setTEN_DINH_DANG_PHIM(rs.getString("TEN_DINH_DANG_PHIM"));
                entity.setTHOI_LUONG_CHIEU(rs.getInt("THOI_LUONG_CHIEU"));
                entity.setLOAIPHIM(rs.getString("LOAIPHIM"));
                entity.setDIENVIEN(rs.getString("DIENVIEN"));
                entity.setQUOCGIA(rs.getString("QUOCGIA"));
                entity.setNHA_SAN_XUAT(rs.getString("NHA_SAN_XUAT"));
                entity.setTOM_TAT(rs.getString("TOM_TAT"));
                entity.setPOSTER(rs.getString("POSTER"));
                entity.setTRAILER(rs.getString("TRAILER"));
                entity.setGIOI_HAN_TUOI(rs.getString("GIOI_HAN_TUOI"));
                entity.setNGAY_CONG_CHIEU(rs.getDate("NGAY_CONG_CHIEU"));
                entity.setBANNER(rs.getString("BANNER"));
                entity.setNGON_NGU(rs.getString("NGON_NGU"));

                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

}
