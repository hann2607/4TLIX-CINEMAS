/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbh.entity;

/**
 *
 * @author pc
 */
public class RECEIPT {
    private String MADH;
    private String MAKH;
    private String MAVanChuyen;
    private String MASP;
    private int SOLUONG;
    private String GHICHU;

    public RECEIPT() {
    }

    public RECEIPT(String MADH, String MAKH, String MAVanChuyen, String MASP, int SOLUONG, String GHICHU) {
        this.MADH = MADH;
        this.MAKH = MAKH;
        this.MAVanChuyen = MAVanChuyen;
        this.MASP = MASP;
        this.SOLUONG = SOLUONG;
        this.GHICHU = GHICHU;
    }

    public String getMADH() {
        return MADH;
    }

    public void setMADH(String MADH) {
        this.MADH = MADH;
    }
 
    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getMAVanChuyen() {
        return MAVanChuyen;
    }

    public void setMAVanChuyen(String MAVanChuyen) {
        this.MAVanChuyen = MAVanChuyen;
    }

    public String getMASP() {
        return MASP;
    }

    public void setMASP(String MASP) {
        this.MASP = MASP;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }
    
    
}
