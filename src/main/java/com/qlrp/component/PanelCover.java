/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.qlrp.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;

public class PanelCover extends javax.swing.JPanel {
    
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    private ActionListener event;
    private MigLayout layout;
    private JLabel title;
    private JLabel moTa;
    private JLabel moTa1;
    private ButtonOutLine btn;
    private boolean isLogin;
    File f = new File("");

    public PanelCover() {
        initComponents();
        setOpaque(false);
        layout = new MigLayout("wrap", "push[center]push", "push[]35[]20[]155[]push");
        setLayout(layout);
        init();
    }

    private void init() {
        String linkIcon = "\\src\\main\\resources\\com\\qlrp\\icon\\login\\";
        title = new JLabel();
        title.setText("");
        title.setIcon(new ImageIcon(f.getAbsolutePath() + linkIcon + "4TLIX_Slogantest85.png"));
        add(title);
        
        //mota
        moTa = new JLabel("Đăng ký tài khoản cá nhân của bạn");
        moTa.setForeground(new Color(245, 245, 245));
        moTa.setFont(new Font("Tahoma", 1, 15));
        add(moTa);
        
        
        btn = new ButtonOutLine();
        btn.setBackground(new Color(255, 255, 255));
        btn.setForeground(new Color(255, 255, 255));
        btn.setText("ĐĂNG KÝ");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                event.actionPerformed(evt);
            }
        });
        add(btn, "w 60%, h 40");
        
        ///mota1
        moTa1 = new JLabel("DESIGN BY 4TL TEAM");
        moTa1.setForeground(new Color(245, 245, 245));
        moTa1.setFont(new Font("Tahoma", 1, 10));
        add(moTa1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        GradientPaint gra = new GradientPaint(0, 0, new Color(220, 20, 60), 0, getHeight(), new Color(22, 21, 26));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(grphcs);
    }

    public void addEvent(ActionListener event) {
        this.event = event;
    }
    
    public void dangKyLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(moTa, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(moTa1, "pad 0 -" + v + "% 0 0");
    }

    public void dangKyRight(double v) {
        v = Double.valueOf(df.format(v));
        login(false);
        layout.setComponentConstraints(title, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(moTa, "pad 0 -" + v + "% 0 0");
        layout.setComponentConstraints(moTa1, "pad 0 -" + v + "% 0 0");
    }

    public void dangNhapLeft(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(moTa, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(moTa1, "pad 0 " + v + "% 0 " + v + "%");
    }

    public void dangNhapRight(double v) {
        v = Double.valueOf(df.format(v));
        login(true);
        layout.setComponentConstraints(title, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(moTa, "pad 0 " + v + "% 0 " + v + "%");
        layout.setComponentConstraints(moTa1, "pad 0 " + v + "% 0 " + v + "%");
    }

    private void login(boolean login) {
        if (this.isLogin != login) {
            if (login) {
                
                moTa.setText("Nhập thông tin chi tiết của bạn");
                moTa1.setText("DESIGN BY 4TL TEAM");
                btn.setText("ĐĂNG NHẬP");
            } else {
                
                moTa.setText("Chất lượng làm nên thương hiệu");
                moTa1.setText("DESIGN BY 4TL TEAM");
                btn.setText("ĐĂNG KÝ");
            }
            this.isLogin = login;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
