/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class GIOHANG_PHIM {
    private String TEN_SAN_PHAM;
    private String SO_LUONG;
    private double GIA;
    private String NGAY_CHIEU;
    private String GIO_CHIEU;
    private String PHONG_CHIEU;
    private String GHE_NGOI;
    

    public GIOHANG_PHIM() {
    }

    public GIOHANG_PHIM(String TEN_SAN_PHAM, String SO_LUONG, double GIA, String NGAY_CHIEU, String GIO_CHIEU, String PHONG_CHIEU, String GHE_NGOI) {
        this.TEN_SAN_PHAM = TEN_SAN_PHAM;
        this.SO_LUONG = SO_LUONG;
        this.GIA = GIA;
        this.NGAY_CHIEU = NGAY_CHIEU;
        this.GIO_CHIEU = GIO_CHIEU;
        this.PHONG_CHIEU = PHONG_CHIEU;
        this.GHE_NGOI = GHE_NGOI;
    }

    public String getTEN_SAN_PHAM() {
        return TEN_SAN_PHAM;
    }

    public void setTEN_SAN_PHAM(String TEN_SAN_PHAM) {
        this.TEN_SAN_PHAM = TEN_SAN_PHAM;
    }

    public String getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(String SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public String getNGAY_CHIEU() {
        return NGAY_CHIEU;
    }

    public void setNGAY_CHIEU(String NGAY_CHIEU) {
        this.NGAY_CHIEU = NGAY_CHIEU;
    }

    public String getGIO_CHIEU() {
        return GIO_CHIEU;
    }

    public void setGIO_CHIEU(String GIO_CHIEU) {
        this.GIO_CHIEU = GIO_CHIEU;
    }

    public String getPHONG_CHIEU() {
        return PHONG_CHIEU;
    }

    public void setPHONG_CHIEU(String PHONG_CHIEU) {
        this.PHONG_CHIEU = PHONG_CHIEU;
    }

    public String getGHE_NGOI() {
        return GHE_NGOI;
    }

    public void setGHE_NGOI(String GHE_NGOI) {
        this.GHE_NGOI = GHE_NGOI;
    }
    
    
}
