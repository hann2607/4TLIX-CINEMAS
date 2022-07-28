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
public class DOAN {
    private String TENDOAN;
    private String LOAI;
    private String KICHCO;
    private String HINH;
    private int SOLUONG;
    private Double DONGIA;
    private String MAKHUYENMAI;

    public DOAN() {
    }

    public DOAN(String TENDOAN, String LOAI, String KICHCO, String HINH, int SOLUONG, Double DONGIA, String MAKHUYENMAI) {
        this.TENDOAN = TENDOAN;
        this.LOAI = LOAI;
        this.KICHCO = KICHCO;
        this.HINH = HINH;
        this.SOLUONG = SOLUONG;
        this.DONGIA = DONGIA;
        this.MAKHUYENMAI = MAKHUYENMAI;
    }

    public String getTENDOAN() {
        return TENDOAN;
    }

    public void setTENDOAN(String TENDOAN) {
        this.TENDOAN = TENDOAN;
    }

    public String getLOAI() {
        return LOAI;
    }

    public void setLOAI(String LOAI) {
        this.LOAI = LOAI;
    }

    public String getKICHCO() {
        return KICHCO;
    }

    public void setKICHCO(String KICHCO) {
        this.KICHCO = KICHCO;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public Double getDONGIA() {
        return DONGIA;
    }

    public void setDONGIA(Double DONGIA) {
        this.DONGIA = DONGIA;
    }

    public String getMAKHUYENMAI() {
        return MAKHUYENMAI;
    }

    public void setMAKHUYENMAI(String MAKHUYENMAI) {
        this.MAKHUYENMAI = MAKHUYENMAI;
    }
}
