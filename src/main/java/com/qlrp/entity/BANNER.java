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
    private String TRAILER;

    public BANNER() {
    }

    public BANNER(String MAPHIM, String TENPHIM, String TRAILER) {
        this.MAPHIM = MAPHIM;
        this.TENPHIM = TENPHIM;
        this.TRAILER = TRAILER;
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

    public String getTRAILER() {
        return TRAILER;
    }

    public void setTRAILER(String TRAILER) {
        this.TRAILER = TRAILER;
    }
    
    
}
