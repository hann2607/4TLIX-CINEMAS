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
public class HOADON {
    private String MAHOADON;
    private String MANHANVIEN;
    private String MAVE;
    private String SDT;
    private Date NGAYBAN;

    public HOADON() {
    }

    public HOADON(String MAHOADON, String MANHANVIEN, String MAVE, String SDT, Date NGAYBAN) {
        this.MAHOADON = MAHOADON;
        this.MANHANVIEN = MANHANVIEN;
        this.MAVE = MAVE;
        this.SDT = SDT;
        this.NGAYBAN = NGAYBAN;
    }

    public String getMAHOADON() {
        return MAHOADON;
    }

    public void setMAHOADON(String MAHOADON) {
        this.MAHOADON = MAHOADON;
    }

    public String getMANHANVIEN() {
        return MANHANVIEN;
    }

    public void setMANHANVIEN(String MANHANVIEN) {
        this.MANHANVIEN = MANHANVIEN;
    }

    public String getMAVE() {
        return MAVE;
    }

    public void setMAVE(String MAVE) {
        this.MAVE = MAVE;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public Date getNGAYBAN() {
        return NGAYBAN;
    }

    public void setNGAYBAN(Date NGAYBAN) {
        this.NGAYBAN = NGAYBAN;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setEnableButton(String qlhd_ok) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

