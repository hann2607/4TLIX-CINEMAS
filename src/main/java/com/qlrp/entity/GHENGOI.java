/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author HAN-PC
 */
public class GHENGOI {
    private String MA_GHE;
    private String TEN_GHE;
    private String MA_PHONG_CHIEU;
    private boolean DA_CHON;

    public GHENGOI() {
    }

    public GHENGOI(String MA_GHE, String TEN_GHE, String MA_PHONG_CHIEU, boolean DA_CHON) {
        this.MA_GHE = MA_GHE;
        this.TEN_GHE = TEN_GHE;
        this.MA_PHONG_CHIEU = MA_PHONG_CHIEU;
        this.DA_CHON = DA_CHON;
    }

    public String getMA_GHE() {
        return MA_GHE;
    }

    public void setMA_GHE(String MA_GHE) {
        this.MA_GHE = MA_GHE;
    }

    public String getTEN_GHE() {
        return TEN_GHE;
    }

    public void setTEN_GHE(String TEN_GHE) {
        this.TEN_GHE = TEN_GHE;
    }

    public String getMA_PHONG_CHIEU() {
        return MA_PHONG_CHIEU;
    }

    public void setMA_PHONG_CHIEU(String MA_PHONG_CHIEU) {
        this.MA_PHONG_CHIEU = MA_PHONG_CHIEU;
    }

    public boolean isDA_CHON() {
        return DA_CHON;
    }

    public void setDA_CHON(boolean DA_CHON) {
        this.DA_CHON = DA_CHON;
    }
    
    
}
