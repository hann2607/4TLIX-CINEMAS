/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class GIOHANG_DOAN {
    private String TEN_SAN_PHAM;
    private int SO_LUONG;
    private double GIA;
    private String KICH_CO;
    
    public GIOHANG_DOAN() {
    }

    public GIOHANG_DOAN(String TEN_SAN_PHAM, int SO_LUONG, double GIA, String KICH_CO) {
        this.TEN_SAN_PHAM = TEN_SAN_PHAM;
        this.SO_LUONG = SO_LUONG;
        this.GIA = GIA;
        this.KICH_CO = KICH_CO;
    }

    public String getTEN_SAN_PHAM() {
        return TEN_SAN_PHAM;
    }

    public void setTEN_SAN_PHAM(String TEN_SAN_PHAM) {
        this.TEN_SAN_PHAM = TEN_SAN_PHAM;
    }

    public int getSO_LUONG() {
        return SO_LUONG;
    }

    public void setSO_LUONG(int SO_LUONG) {
        this.SO_LUONG = SO_LUONG;
    }

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public String getKICH_CO() {
        return KICH_CO;
    }

    public void setKICH_CO(String KICH_CO) {
        this.KICH_CO = KICH_CO;
    }

    
    
    
}
