/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class GIAVE {
    private String MA_GIA_VE;
    private double DON_GIA;
    private String LOAI_VE;

    public GIAVE() {
    }

    public GIAVE(String MA_GIA_VE, double DON_GIA, String LOAI_VE) {
        this.MA_GIA_VE = MA_GIA_VE;
        this.DON_GIA = DON_GIA;
        this.LOAI_VE = LOAI_VE;
    }

    public String getMA_GIA_VE() {
        return MA_GIA_VE;
    }

    public void setMA_GIA_VE(String MA_GIA_VE) {
        this.MA_GIA_VE = MA_GIA_VE;
    }

    public double getDON_GIA() {
        return DON_GIA;
    }

    public void setDON_GIA(double DON_GIA) {
        this.DON_GIA = DON_GIA;
    }

    public String getLOAI_VE() {
        return LOAI_VE;
    }

    public void setLOAI_VE(String LOAI_VE) {
        this.LOAI_VE = LOAI_VE;
    }

    
    
    
}
