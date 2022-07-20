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
public class CHECKIN extends EMPLOYEE{
    private Date LUOTRA;
    private Date LUOTVAO;
    private String TINHTRANG;
    private String GHICHU;

    public CHECKIN() {
    }

    public CHECKIN(Date LUOTRA, Date LUOTVAO, String TINHTRANG, String GHICHU) {
        this.LUOTRA = LUOTRA;
        this.LUOTVAO = LUOTVAO;
        this.TINHTRANG = TINHTRANG;
        this.GHICHU = GHICHU;
    }

    public CHECKIN(Date LUOTRA, Date LUOTVAO, String TINHTRANG, String GHICHU, String MANV, String HOTENNV, boolean GIOITINH, String SDT, String DIACHI, boolean VAITRO, String HINH, String STORY, Double LUONG, String MATKHAU, String GMAIL) {
        super(MANV, HOTENNV, GIOITINH, SDT, DIACHI, VAITRO, HINH, STORY, LUONG, MATKHAU, GMAIL);
        this.LUOTRA = LUOTRA;
        this.LUOTVAO = LUOTVAO;
        this.TINHTRANG = TINHTRANG;
        this.GHICHU = GHICHU;
    }

   

    public Date getLUOTRA() {
        return LUOTRA;
    }

    public void setLUOTRA(Date LUOTRA) {
        this.LUOTRA = LUOTRA;
    }

    public Date getLUOTVAO() {
        return LUOTVAO;
    }

    public void setLUOTVAO(Date LUOTVAO) {
        this.LUOTVAO = LUOTVAO;
    }

    public String getTINHTRANG() {
        return TINHTRANG;
    }

    public void setTINHTRANG(String TINHTRANG) {
        this.TINHTRANG = TINHTRANG;
    }

    public String getGHICHU() {
        return GHICHU;
    }

    public void setGHICHU(String GHICHU) {
        this.GHICHU = GHICHU;
    }
    
    
}
