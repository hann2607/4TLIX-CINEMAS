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
public class CUSTOMER {
    private String MAKH;
    private String TENKH;
    private String EMAIL;
    private String DIACHI;
    private String GHICHU;

    public CUSTOMER() {
    }

    public CUSTOMER(String MAKH, String TENKH, String EMAIL, String DIACHI, String GHICHU) {
        this.MAKH = MAKH;
        this.TENKH = TENKH;
        this.EMAIL = EMAIL;
        this.DIACHI = DIACHI;
        this.GHICHU = GHICHU;
    }

    public String getMAKH() {
        return MAKH;
    }

    public void setMAKH(String MAKH) {
        this.MAKH = MAKH;
    }

    public String getTENKH() {
        return TENKH;
    }

    public void setTENKH(String TENKH) {
        this.TENKH = TENKH;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }
    
    @Override
    public String toString() {
        //return this.MAKH+" ("+this.TENKH+")"; //lấy tên để hiển thị trong cbo
        return this.MAKH;
    }
}
