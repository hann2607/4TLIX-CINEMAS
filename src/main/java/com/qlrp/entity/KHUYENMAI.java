/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

import java.util.Date;

/**
 *
 * @author HAN-PC
 */
public class KHUYENMAI{
    private String MA_KHUYEN_MAI;
    private String MA_NHAN_VIEN;
    private String HINH;
    private String MO_TA;
    private Date NGAY_BAT_DAU;
    private Date NGAY_KET_THUC;
    private String LOAI_KHUYEN_MAI;

    public KHUYENMAI() {
    }

    public KHUYENMAI(String MA_KHUYEN_MAI, String MA_NHAN_VIEN, String HINH, String MO_TA, Date NGAY_BAT_DAU, Date NGAY_KET_THUC, String LOAI_KHUYEN_MAI) {
        this.MA_KHUYEN_MAI = MA_KHUYEN_MAI;
        this.MA_NHAN_VIEN = MA_NHAN_VIEN;
        this.HINH = HINH;
        this.MO_TA = MO_TA;
        this.NGAY_BAT_DAU = NGAY_BAT_DAU;
        this.NGAY_KET_THUC = NGAY_KET_THUC;
        this.LOAI_KHUYEN_MAI = LOAI_KHUYEN_MAI;
    }

    public String getMA_KHUYEN_MAI() {
        return MA_KHUYEN_MAI;
    }

    public void setMA_KHUYEN_MAI(String MA_KHUYEN_MAI) {
        this.MA_KHUYEN_MAI = MA_KHUYEN_MAI;
    }

    public String getMA_NHAN_VIEN() {
        return MA_NHAN_VIEN;
    }

    public void setMA_NHAN_VIEN(String MA_NHAN_VIEN) {
        this.MA_NHAN_VIEN = MA_NHAN_VIEN;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public String getMO_TA() {
        return MO_TA;
    }

    public void setMO_TA(String MO_TA) {
        this.MO_TA = MO_TA;
    }

    public Date getNGAY_BAT_DAU() {
        return NGAY_BAT_DAU;
    }

    public void setNGAY_BAT_DAU(Date NGAY_BAT_DAU) {
        this.NGAY_BAT_DAU = NGAY_BAT_DAU;
    }

    public Date getNGAY_KET_THUC() {
        return NGAY_KET_THUC;
    }

    public void setNGAY_KET_THUC(Date NGAY_KET_THUC) {
        this.NGAY_KET_THUC = NGAY_KET_THUC;
    }

    public String getLOAI_KHUYEN_MAI() {
        return LOAI_KHUYEN_MAI;
    }

    public void setLOAI_KHUYEN_MAI(String LOAI_KHUYEN_MAI) {
        this.LOAI_KHUYEN_MAI = LOAI_KHUYEN_MAI;
    }
    
    
}
