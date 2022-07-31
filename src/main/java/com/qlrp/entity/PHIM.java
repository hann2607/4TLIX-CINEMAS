/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

import java.util.Date;

/**
 *
 * @author duong
 */
public class PHIM {
    private String MA_PHIM;
    private String TEN_PHIM;
    private String TEN_DINH_DANG_PHIM;
    private int THOI_LUONG_CHIEU;
    private String NGON_NGU;
    private String LOAIPHIM;
    private String DIENVIEN;
    private String QUOCGIA;
    private String NHA_SAN_XUAT;
    private String TOM_TAT;
    private String POSTER;
    private String TRAILER;
    private int GIOI_HAN_TUOI;
    private Date NGAY_CONG_CHIEU;
    private String BANNER;
    
    public PHIM() {
    }

    public PHIM(String MA_PHIM, String TEN_PHIM, String TEN_DINH_DANG_PHIM, int THOI_LUONG_CHIEU, String NGON_NGU, String LOAIPHIM, String DIENVIEN, String QUOCGIA,
            String NHA_SAN_XUAT, String TOM_TAT, String POSTER, String TRAILER, int GIOI_HAN_TUOI, Date NGAY_CONG_CHIEU, String BANNER ) {
        this.MA_PHIM = MA_PHIM;
        this.TEN_PHIM = TEN_PHIM;
        this.TEN_DINH_DANG_PHIM = TEN_DINH_DANG_PHIM;
        this.THOI_LUONG_CHIEU = THOI_LUONG_CHIEU;
        this.NGON_NGU = NGON_NGU;
        this.LOAIPHIM = LOAIPHIM;
        this.DIENVIEN = DIENVIEN;
        this.QUOCGIA = QUOCGIA;
        this.NHA_SAN_XUAT = NHA_SAN_XUAT;
        this.POSTER = POSTER;
        this.TRAILER = TRAILER;
        this.GIOI_HAN_TUOI = GIOI_HAN_TUOI;
        this.NGAY_CONG_CHIEU = NGAY_CONG_CHIEU;
        this.BANNER = BANNER;
    }

    public String getMA_PHIM() {
        return MA_PHIM;
    }

    public void setMA_PHIM(String MA_PHIM) {
        this.MA_PHIM = MA_PHIM;
    }

    public String getTEN_PHIM() {
        return TEN_PHIM;
    }

    public void setTEN_PHIM(String TEN_PHIM) {
        this.TEN_PHIM = TEN_PHIM;
    }

    public String getTEN_DINH_DANG_PHIM() {
        return TEN_DINH_DANG_PHIM;
    }

    public void setTEN_DINH_DANG_PHIM(String TEN_DINH_DANG_PHIM) {
        this.TEN_DINH_DANG_PHIM = TEN_DINH_DANG_PHIM;
    }

    public int getTHOI_LUONG_CHIEU() {
        return THOI_LUONG_CHIEU;
    }

    public void setTHOI_LUONG_CHIEU(int THOI_LUONG_CHIEU) {
        this.THOI_LUONG_CHIEU = THOI_LUONG_CHIEU;
    }

    public String getNGON_NGU() {
        return NGON_NGU;
    }

    public void setNGON_NGU(String NGON_NGU) {
        this.NGON_NGU = NGON_NGU;
    }

    public String getLOAIPHIM() {
        return LOAIPHIM;
    }

    public void setLOAIPHIM(String LOAIPHIM) {
        this.LOAIPHIM = LOAIPHIM;
    }

    public String getDIENVIEN() {
        return DIENVIEN;
    }

    public void setDIENVIEN(String DIENVIEN) {
        this.DIENVIEN = DIENVIEN;
    }

    public String getQUOCGIA() {
        return QUOCGIA;
    }

    public void setQUOCGIA(String QUOCGIA) {
        this.QUOCGIA = QUOCGIA;
    }

    public String getNHA_SAN_XUAT() {
        return NHA_SAN_XUAT;
    }

    public void setNHA_SAN_XUAT(String NHA_SAN_XUAT) {
        this.NHA_SAN_XUAT = NHA_SAN_XUAT;
    }

    public String getTOM_TAT() {
        return TOM_TAT;
    }

    public void setTOM_TAT(String TOM_TAT) {
        this.TOM_TAT = TOM_TAT;
    }

    public String getPOSTER() {
        return POSTER;
    }

    public void setPOSTER(String POSTER) {
        this.POSTER = POSTER;
    }

    public String getTRAILER() {
        return TRAILER;
    }

    public void setTRAILER(String TRAILER) {
        this.TRAILER = TRAILER;
    }

    public int getGIOI_HAN_TUOI() {
        return GIOI_HAN_TUOI;
    }

    public void setGIOI_HAN_TUOI(int GIOI_HAN_TUOI) {
        this.GIOI_HAN_TUOI = GIOI_HAN_TUOI;
    }

    public Date getNGAY_CONG_CHIEU() {
        return NGAY_CONG_CHIEU;
    }

    public void setNGAY_CONG_CHIEU(Date NGAY_CONG_CHIEU) {
        this.NGAY_CONG_CHIEU = NGAY_CONG_CHIEU;
    }

    public String getBANNER() {
        return BANNER;
    }

    public void setBANNER(String BANNER) {
        this.BANNER = BANNER;
    }
    
    
}
