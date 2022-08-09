/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author HAN-PC
 */
public class SUATCHIEU {
    private String MA_SUAT_CHIEU;
    private String MA_PHONG_CHIEU;
    private String TEN_DINH_DANG_PHIM;
    private String MA_PHIM;
    private Time GIO_BAT_DAU;
    private Time GIO_KET_THUC;
    private Date NGAY_CHIEU;

    public SUATCHIEU() {
    }

    public SUATCHIEU(String MA_SUAT_CHIEU, String MA_PHONG_CHIEU, String TEN_DINH_DANG_PHIM, String MA_PHIM, Time GIO_BAT_DAU, Time GIO_KET_THUC, Date NGAY_CHIEU) {
        this.MA_SUAT_CHIEU = MA_SUAT_CHIEU;
        this.MA_PHONG_CHIEU = MA_PHONG_CHIEU;
        this.TEN_DINH_DANG_PHIM = TEN_DINH_DANG_PHIM;
        this.MA_PHIM = MA_PHIM;
        this.GIO_BAT_DAU = GIO_BAT_DAU;
        this.GIO_KET_THUC = GIO_KET_THUC;
        this.NGAY_CHIEU = NGAY_CHIEU;
    }

    public String getMA_SUAT_CHIEU() {
        return MA_SUAT_CHIEU;
    }

    public void setMA_SUAT_CHIEU(String MA_SUAT_CHIEU) {
        this.MA_SUAT_CHIEU = MA_SUAT_CHIEU;
    }

    public String getMA_PHONG_CHIEU() {
        return MA_PHONG_CHIEU;
    }

    public void setMA_PHONG_CHIEU(String MA_PHONG_CHIEU) {
        this.MA_PHONG_CHIEU = MA_PHONG_CHIEU;
    }

    public String getTEN_DINH_DANG_PHIM() {
        return TEN_DINH_DANG_PHIM;
    }

    public void setTEN_DINH_DANG_PHIM(String TEN_DINH_DANG_PHIM) {
        this.TEN_DINH_DANG_PHIM = TEN_DINH_DANG_PHIM;
    }

    public String getMA_PHIM() {
        return MA_PHIM;
    }

    public void setMA_PHIM(String MA_PHIM) {
        this.MA_PHIM = MA_PHIM;
    }

    public Time getGIO_BAT_DAU() {
        return GIO_BAT_DAU;
    }

    public void setGIO_BAT_DAU(Time GIO_BAT_DAU) {
        this.GIO_BAT_DAU = GIO_BAT_DAU;
    }

    public Time getGIO_KET_THUC() {
        return GIO_KET_THUC;
    }

    public void setGIO_KET_THUC(Time GIO_KET_THUC) {
        this.GIO_KET_THUC = GIO_KET_THUC;
    }

    public Date getNGAY_CHIEU() {
        return NGAY_CHIEU;
    }

    public void setNGAY_CHIEU(Date NGAY_CHIEU) {
        this.NGAY_CHIEU = NGAY_CHIEU;
    }

    public void getNGAY_CHIEU(Date date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
