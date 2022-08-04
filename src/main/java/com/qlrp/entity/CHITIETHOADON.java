/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlrp.entity;



/**
 *
 * @author pc
 */
public class CHITIETHOADON {
    private String MAHOADONCHITIET;
    private String MAHOADON;
    private String TENDOAN;
    private String SOLUONGDOAN;
    private String MAVE;
    private String SOLUONGVE;
    private String MAKHUYENMAI;
    private String TONGTIEN;

    public CHITIETHOADON() {
    }

    public CHITIETHOADON(String MAHOADONCHITIET, String MAHOADON, String TENDOAN, String SOLUONGDOAN, String MAVE, String SOLUONGVE, String MAKHUYENMAI, String TONGTIEN) {
        this.MAHOADONCHITIET = MAHOADONCHITIET;
        this.MAHOADON = MAHOADON;
        this.TENDOAN = TENDOAN;
        this.SOLUONGDOAN = SOLUONGDOAN;
        this.MAVE = MAVE;
        this.SOLUONGVE = SOLUONGVE;
        this.MAKHUYENMAI = MAKHUYENMAI;
        this.TONGTIEN = TONGTIEN;
    }

    public String getMAHOADONCHITIET() {
        return MAHOADONCHITIET;
    }

    public void setMAHOADONCHITIET(String MAHOADONCHITIET) {
        this.MAHOADONCHITIET = MAHOADONCHITIET;
    }

    public String getMAHOADON() {
        return MAHOADON;
    }

    public void setMAHOADON(String MAHOADON) {
        this.MAHOADON = MAHOADON;
    }

    public String getTENDOAN() {
        return TENDOAN;
    }

    public void setTENDOAN(String TENDOAN) {
        this.TENDOAN = TENDOAN;
    }

    public String getSOLUONGDOAN() {
        return SOLUONGDOAN;
    }

    public void setSOLUONGDOAN(String SOLUONGDOAN) {
        this.SOLUONGDOAN = SOLUONGDOAN;
    }

    public String getMAVE() {
        return MAVE;
    }

    public void setMAVE(String MAVE) {
        this.MAVE = MAVE;
    }

    public String getSOLUONGVE() {
        return SOLUONGVE;
    }

    public void setSOLUONGVE(String SOLUONGVE) {
        this.SOLUONGVE = SOLUONGVE;
    }

    public String getMAKHUYENMAI() {
        return MAKHUYENMAI;
    }

    public void setMAKHUYENMAI(String MAKHUYENMAI) {
        this.MAKHUYENMAI = MAKHUYENMAI;
    }

    public String getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(String TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }  

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
