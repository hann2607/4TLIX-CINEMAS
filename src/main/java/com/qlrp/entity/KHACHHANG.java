/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author duong
 */
public class KHACHHANG {

    private String SDT;
    private String HO_TEN;
    private boolean GIOI_TINH;
    private String DIA_CHI;
    private String MAT_KHAU;
    private String EMAIL;

    public KHACHHANG() {

    }

    public KHACHHANG(String SDT, String HO_TEN, boolean GIOI_TINH, String DIA_CHI, String MAT_KHAU, String EMAIL) {
        this.HO_TEN = HO_TEN;
        this.GIOI_TINH = GIOI_TINH;
        this.SDT = SDT;
        this.DIA_CHI = DIA_CHI;
        this.MAT_KHAU = MAT_KHAU;
        this.EMAIL = EMAIL;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHO_TEN() {
        return HO_TEN;
    }

    public void setHO_TEN(String HO_TEN) {
        this.HO_TEN = HO_TEN;
    }

    public boolean isGIOI_TINH() {
        return GIOI_TINH;
    }

    public void setGIOI_TINH(boolean GIOI_TINH) {
        this.GIOI_TINH = GIOI_TINH;
    }

    public String getDIA_CHI() {
        return DIA_CHI;
    }

    public void setDIA_CHI(String DIA_CHI) {
        this.DIA_CHI = DIA_CHI;
    }

    public String getMAT_KHAU() {
        return MAT_KHAU;
    }

    public void setMAT_KHAU(String MAT_KHAU) {
        this.MAT_KHAU = MAT_KHAU;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    
    
}
