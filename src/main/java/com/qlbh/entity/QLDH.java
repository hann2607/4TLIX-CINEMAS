/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbh.entity;

import java.util.Date;

/**
 *
 * @author pc
 */
public class QLDH {
    private String MADH;
    private String MANV;
    private String MAKH;
    private int DONGIA;
    private Date NgTao;
    private String GHICHU;

    public QLDH() {
    }

    public QLDH(String MADH, String MANV, String MAKH, int DONGIA, Date NgTao, String GHICHU) {
        this.MADH = MADH;
        this.MANV = MANV;
        this.MAKH = MAKH;
        this.DONGIA = DONGIA;
        this.NgTao = NgTao;
        this.GHICHU = GHICHU;
    }

    public String getMADH() {
        return MADH;
    }

    public void setMADH(String MADH) {
        this.MADH = MADH;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public int getDONGIA() {
        return DONGIA;
    }

    public void setDONGIA(int DONGIA) {
        this.DONGIA = DONGIA;
    }

    public Date getNgTao() {
        return NgTao;
    }

    public void setNgTao(Date NgTao) {
        this.NgTao = NgTao;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }
    
    @Override
    public String toString() {
        //lấy tên để hiển thị trong cbo
        return this.MADH;
    }
}
