/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.entity;

/**
 *
 * @author ACER
 */
public class BANNER {
    private String MAPHIM;
    private String TENPHIM;
    private String BANNER;

    public BANNER() {
    }

    public BANNER(String MAPHIM, String TENPHIM, String BANNER) {
        this.MAPHIM = MAPHIM;
        this.TENPHIM = TENPHIM;
        this.BANNER = BANNER;
    }

    public String getMAPHIM() {
        return MAPHIM;
    }

    public void setMAPHIM(String MAPHIM) {
        this.MAPHIM = MAPHIM;
    }

    public String getTENPHIM() {
        return TENPHIM;
    }

    public void setTENPHIM(String TENPHIM) {
        this.TENPHIM = TENPHIM;
    }

    public String getBANNER() {
        return BANNER;
    }

    public void setBANNER(String BANNER) {
        this.BANNER = BANNER;
    }
    
    
}
