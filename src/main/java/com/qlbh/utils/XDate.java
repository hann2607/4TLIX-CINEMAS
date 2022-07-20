/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlbh.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HAN-PC
 */
public class XDate {
    static SimpleDateFormat formater = new SimpleDateFormat();
    public static Date toDate(String date, String patern) {
        try {
            formater.applyPattern(patern);
            return formater.parse(date);
        } catch (Exception e) {
            throw  new RuntimeException(e);
        }
    }
    
    public static String toString(Date date, String patern) {
        formater.applyPattern(patern);
        return formater.format(date);
    }
    
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days*24*60*60*1000);
        return date;
    }
}
