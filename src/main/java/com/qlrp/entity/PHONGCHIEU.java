/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class PHONGCHIEU {
    private String MA_PHONG_CHIEU;
    private int SO_LUONG_DAY;
    private int SO_LUONG_COT;

    public PHONGCHIEU() {
    }

    public PHONGCHIEU(String MA_PHONG_CHIEU, int SO_LUONG_DAY, int SO_LUONG_COT) {
        this.MA_PHONG_CHIEU = MA_PHONG_CHIEU;
        this.SO_LUONG_DAY = SO_LUONG_DAY;
        this.SO_LUONG_COT = SO_LUONG_COT;
    }

    public String getMA_PHONG_CHIEU() {
        return MA_PHONG_CHIEU;
    }

    public void setMA_PHONG_CHIEU(String MA_PHONG_CHIEU) {
        this.MA_PHONG_CHIEU = MA_PHONG_CHIEU;
    }

    public int getSO_LUONG_DAY() {
        return SO_LUONG_DAY;
    }

    public void setSO_LUONG_DAY(int SO_LUONG_DAY) {
        this.SO_LUONG_DAY = SO_LUONG_DAY;
    }

    public int getSO_LUONG_COT() {
        return SO_LUONG_COT;
    }

    public void setSO_LUONG_COT(int SO_LUONG_COT) {
        this.SO_LUONG_COT = SO_LUONG_COT;
    }

    
    
    
}
