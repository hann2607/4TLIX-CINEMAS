/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class LOAIGHE {
    private String TEN_GHE;
    private double PHU_THU;
    private String HINH;
    private double GIA;

    public LOAIGHE() {
    }
    
    public LOAIGHE(String TEN_GHE, double PHU_THU, String HINH, double GIA) {
        this.TEN_GHE = TEN_GHE;
        this.PHU_THU = PHU_THU;
        this.HINH = HINH;
        this.GIA = GIA;
    }

    public String getTEN_GHE() {
        return TEN_GHE;
    }

    public void setTEN_GHE(String TEN_GHE) {
        this.TEN_GHE = TEN_GHE;
    }

    public double getPHU_THU() {
        return PHU_THU;
    }

    public void setPHU_THU(double PHU_THU) {
        this.PHU_THU = PHU_THU;
    }

    public String getHINH() {
        return HINH;
    }

    public void setHINH(String HINH) {
        this.HINH = HINH;
    }

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }
    
    
}
