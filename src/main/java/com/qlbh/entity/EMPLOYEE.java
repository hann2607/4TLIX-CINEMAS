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
public class EMPLOYEE {

    private String MANV;
    private String HOTENNV;
    private boolean GIOITINH;
    private String SDT;
    private String DIACHI;
    private boolean VAITRO;
    private String HINH;
    private String STORY;
    private Double LUONG;
    private String MATKHAU;
    private String GMAIL;

    public EMPLOYEE() {

    }

    public EMPLOYEE(String MANV, String HOTENNV, boolean GIOITINH, String SDT, String DIACHI, boolean VAITRO, String HINH, String STORY, Double LUONG, String MATKHAU, String GMAIL) {
        this.MANV = MANV;
        this.HOTENNV = HOTENNV;
        this.GIOITINH = GIOITINH;
        this.SDT = SDT;
        this.DIACHI = DIACHI;
        this.VAITRO = VAITRO;
        this.HINH = HINH;
        this.STORY = STORY;
        this.LUONG = LUONG;
        this.MATKHAU = MATKHAU;
        this.GMAIL = GMAIL;
    }

    public String getGMAIL() {
        return GMAIL;
    }

    public void setGMAIL(String GMAIL) {
        this.GMAIL = GMAIL;
    }

    public String getMANV() {
        return MANV;
    }

    public void setMANV(String MANV) {
        this.MANV = MANV;
    }

    public String getHOTENNV() {
        return HOTENNV;
    }

    public void setHOTENNV(String HOTENNV) {
        this.HOTENNV = HOTENNV;
    }

    public boolean isGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(boolean GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public boolean isVAITRO() {
        return VAITRO;
    }

    public void setVAITRO(boolean VAITRO) {
        this.VAITRO = VAITRO;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public String getSTORY() {
        return STORY;
    }

    public void setSTORY(String STORY) {
        this.STORY = STORY;
    }

    public Double getLUONG() {
        return LUONG;
    }

    public void setLUONG(Double LUONG) {
        this.LUONG = LUONG;
    }

   

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    @Override
    public String toString() {
        //return this.MANV+" ("+this.HOTENNV+")"; //lấy tên để hiển thị trong cbo
        return this.MANV;
    }
}
