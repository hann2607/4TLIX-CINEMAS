/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class VEDAT {
    private String MA_VE_DAT;
    private String SDT;
    private int SO_LUONG;

    public VEDAT() {
    }

    public VEDAT(String MA_VE_DAT, String SDT, int SO_LUONG) {
        this.MA_VE_DAT = MA_VE_DAT;
        this.SDT = SDT;
        this.SO_LUONG = SO_LUONG;
    }

    public String getMA_VE_DAT() {
        return MA_VE_DAT;
    }

    public void setMA_VE_DAT(String MA_VE_DAT) {
        this.MA_VE_DAT = MA_VE_DAT;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(int SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }
    
    
}
