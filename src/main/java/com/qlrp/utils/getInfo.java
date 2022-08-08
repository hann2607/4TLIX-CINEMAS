/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.utils;

import com.qlrp.entity.CHITIETHOADON;
import com.qlrp.entity.DOAN;
import com.qlrp.entity.GIOHANG_DOAN;
import com.qlrp.entity.GIOHANG_PHIM;
import com.qlrp.entity.HOADON;
import com.qlrp.entity.KHACHHANG;
import com.qlrp.entity.NHANVIEN;
import com.qlrp.entity.PHIM;
import com.qlrp.entity.SUATCHIEU;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAN-PC
 */
public class getInfo {

    public static NHANVIEN nv = null;
    public static DOAN da = null;
    public static KHACHHANG cus;
    public static PHIM movi = null;
    public static HOADON hd = null;
    public static CHITIETHOADON ct = null;
    public static SUATCHIEU sc = null;
    public static List<GIOHANG_PHIM> listSP_PHIM = new ArrayList<>();
    public static List<GIOHANG_DOAN> listSP_DOAN = new ArrayList<>();
}
