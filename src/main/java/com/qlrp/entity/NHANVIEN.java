/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlrp.entity;

import java.util.Date;

/**
 *
 * @author pc
 */
public class NHANVIEN {

    private String MA_NHAN_VIEN;
    private String HO_TEN;
    private boolean GIOI_TINH;
    private String SDT;
    private String DIA_CHI;
    private String TEN_VAI_TRO;
    private String HINH;
    private Date NGAY_VAO_LAM;
    private boolean TRANG_THAI;
    private String MAT_KHAU;
    private String EMAIL;
    private String CCCD_CMND;

    public NHANVIEN() {

    }

    public NHANVIEN(String MA_NHAN_VIEN, String HO_TEN, boolean GIOI_TINH, String SDT, String DIA_CHI, String TEN_VAI_TRO, String HINH, Date NGAY_VAO_LAM, boolean TRANG_THAI, String MAT_KHAU, String EMAIL, String CCCD_CMND) {
        this.MA_NHAN_VIEN = MA_NHAN_VIEN;
        this.HO_TEN = HO_TEN;
        this.GIOI_TINH = GIOI_TINH;
        this.SDT = SDT;
        this.DIA_CHI = DIA_CHI;
        this.TEN_VAI_TRO = TEN_VAI_TRO;
        this.HINH = HINH;
        this.NGAY_VAO_LAM = NGAY_VAO_LAM;
        this.TRANG_THAI = TRANG_THAI;
        this.MAT_KHAU = MAT_KHAU;
        this.EMAIL = EMAIL;
        this.CCCD_CMND = CCCD_CMND;
    }

    public String getMA_NHAN_VIEN() {
        return MA_NHAN_VIEN;
    }

    public void setMA_NHAN_VIEN(String MA_NHAN_VIEN) {
        this.MA_NHAN_VIEN = MA_NHAN_VIEN;
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

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDIA_CHI() {
        return DIA_CHI;
    }

    public void setDIA_CHI(String DIA_CHI) {
        this.DIA_CHI = DIA_CHI;
    }

    public String getTEN_VAI_TRO() {
        return TEN_VAI_TRO;
    }

    public void setTEN_VAI_TRO(String TEN_VAI_TRO) {
        this.TEN_VAI_TRO = TEN_VAI_TRO;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public Date getNGAY_VAO_LAM() {
        return NGAY_VAO_LAM;
    }

    public void setNGAY_VAO_LAM(Date NGAY_VAO_LAM) {
        this.NGAY_VAO_LAM = NGAY_VAO_LAM;
    }

    public boolean isTRANG_THAI() {
        return TRANG_THAI;
    }

    public void setTRANG_THAI(boolean TRANG_THAI) {
        this.TRANG_THAI = TRANG_THAI;
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

    public String getCCCD_CMND() {
        return CCCD_CMND;
    }

    public void setCCCD_CMND(String CCCD_CMND) {
        this.CCCD_CMND = CCCD_CMND;
    }

    



    @Override
    public String toString() {
        //return this.MANV+" ("+this.HOTENNV+")"; //lấy tên để hiển thị trong cbo
        return this.MA_NHAN_VIEN;
    }
}
