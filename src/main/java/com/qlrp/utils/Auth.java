/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.utils;

import com.qlrp.entity.NHANVIEN;
import com.qlrp.entity.KHACHHANG;

/**
 *
 * @author HAN-PC
 */
public class Auth {

    public static NHANVIEN user = null;
    
    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }

    public static boolean isManager() {
        return Auth.isLogin();
    }

    public static KHACHHANG cus = null;

    public static void clearKH() {
        Auth.cus = null;
    }

    public static boolean isLoginKH() {
        return Auth.cus != null;
    }
}
