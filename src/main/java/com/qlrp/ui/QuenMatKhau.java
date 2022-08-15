/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;

import com.qlrp.utils.XImage;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class QuenMatKhau extends javax.swing.JFrame {

    /**
     * Creates new form QuenMatKhau
     */
    public QuenMatKhau() {
        initComponents();
        init();
    }

    private void init() {
        this.setIconImage(XImage.getAppIcon());
        this.setCursor(XImage.setCursor());
        this.setLocationRelativeTo(null);
        showPanelMenu(pnl_QuenMK);
    }

    private void showPanelMenu(JPanel pnl) {
        // Ẩn tất cả các form còn lại
        pnl_QuenMK.setVisible(false);
        pnl_QuenTK.setVisible(false);
        pnl_VerifyMail.setVisible(false);

        // show form lên khi click vào menu
        pnl.setVisible(true);

        jPanel1.revalidate();
        jPanel1.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnl_QuenMK = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_mail = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btn_XNQuenMK = new com.k33ptoo.components.KButton();
        btn_huyQuenMK = new com.k33ptoo.components.KButton();
        btn_QuenTK = new com.k33ptoo.components.KButton();
        jLabel3 = new javax.swing.JLabel();
        pnl_QuenTK = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_mail1 = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btn_XNquenTK = new com.k33ptoo.components.KButton();
        btn_huyQuenTK = new com.k33ptoo.components.KButton();
        btn_QuenMK = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        pnl_VerifyMail = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_mail2 = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btn_XacNhan = new com.k33ptoo.components.KButton();
        btn_huyXN = new com.k33ptoo.components.KButton();
        btn_reSendMail = new com.k33ptoo.components.KButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 20, 60), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUÊN MẬT KHẨU");

        txt_mail.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        txt_mail.setPlaceholder("Email");
        txt_mail.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);

        btn_XNQuenMK.setText("XÁC NHẬN");
        btn_XNQuenMK.setToolTipText("");
        btn_XNQuenMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XNQuenMK.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_XNQuenMK.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_XNQuenMK.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_XNQuenMK.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_XNQuenMK.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_XNQuenMK.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_XNQuenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XNQuenMKActionPerformed(evt);
            }
        });

        btn_huyQuenMK.setText("HỦY BỎ");
        btn_huyQuenMK.setToolTipText("");
        btn_huyQuenMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huyQuenMK.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_huyQuenMK.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenMK.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenMK.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_huyQuenMK.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_huyQuenMK.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyQuenMKActionPerformed(evt);
            }
        });

        btn_QuenTK.setText("QUÊN TÀI KHOẢN");
        btn_QuenTK.setToolTipText("");
        btn_QuenTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QuenTK.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_QuenTK.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_QuenTK.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_QuenTK.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_QuenTK.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_QuenTK.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_QuenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuenTKActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vui lòng nhập Email đã dùng khi đăng ký tài khoản");

        javax.swing.GroupLayout pnl_QuenMKLayout = new javax.swing.GroupLayout(pnl_QuenMK);
        pnl_QuenMK.setLayout(pnl_QuenMKLayout);
        pnl_QuenMKLayout.setHorizontalGroup(
            pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuenMKLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_QuenMKLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1))
                    .addComponent(txt_mail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_QuenMKLayout.createSequentialGroup()
                        .addComponent(btn_huyQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_XNQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_QuenTK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        pnl_QuenMKLayout.setVerticalGroup(
            pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuenMKLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XNQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyQuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_QuenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_QuenMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("QUÊN TÀI KHOẢN");

        txt_mail1.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.EMAIL);
        txt_mail1.setPlaceholder("Email");
        txt_mail1.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);

        btn_XNquenTK.setText("XÁC NHẬN");
        btn_XNquenTK.setToolTipText("");
        btn_XNquenTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XNquenTK.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_XNquenTK.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_XNquenTK.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_XNquenTK.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_XNquenTK.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_XNquenTK.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_XNquenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XNquenTKActionPerformed(evt);
            }
        });

        btn_huyQuenTK.setText("HỦY BỎ");
        btn_huyQuenTK.setToolTipText("");
        btn_huyQuenTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huyQuenTK.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_huyQuenTK.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenTK.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenTK.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_huyQuenTK.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_huyQuenTK.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyQuenTKActionPerformed(evt);
            }
        });

        btn_QuenMK.setText("QUÊN MẬT KHẨU");
        btn_QuenMK.setToolTipText("");
        btn_QuenMK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_QuenMK.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_QuenMK.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_QuenMK.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_QuenMK.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_QuenMK.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_QuenMK.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_QuenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QuenMKActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Vui lòng nhập Email đã dùng khi đăng ký tài khoản");

        javax.swing.GroupLayout pnl_QuenTKLayout = new javax.swing.GroupLayout(pnl_QuenTK);
        pnl_QuenTK.setLayout(pnl_QuenTKLayout);
        pnl_QuenTKLayout.setHorizontalGroup(
            pnl_QuenTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuenTKLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(pnl_QuenTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_QuenTKLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5))
                    .addComponent(txt_mail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_QuenTKLayout.createSequentialGroup()
                        .addComponent(btn_huyQuenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btn_XNquenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_QuenMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_QuenTKLayout.setVerticalGroup(
            pnl_QuenTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuenTKLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(txt_mail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(pnl_QuenTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XNquenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyQuenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_QuenMK, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_QuenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setText("NHẬP MÃ XÁC NHẬN");

        txt_mail2.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VERIFIED_USER);
        txt_mail2.setPlaceholder("Mã xác nhận");
        txt_mail2.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);

        btn_XacNhan.setText("XÁC NHẬN");
        btn_XacNhan.setToolTipText("");
        btn_XacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XacNhan.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_XacNhan.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_XacNhan.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_XacNhan.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_XacNhan.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_XacNhan.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_XacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XacNhanActionPerformed(evt);
            }
        });

        btn_huyXN.setText("HỦY BỎ");
        btn_huyXN.setToolTipText("");
        btn_huyXN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huyXN.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_huyXN.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_huyXN.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_huyXN.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_huyXN.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_huyXN.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_huyXN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyXNActionPerformed(evt);
            }
        });

        btn_reSendMail.setText("GỬI LẠI MÃ XÁC NHẬN");
        btn_reSendMail.setToolTipText("");
        btn_reSendMail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reSendMail.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_reSendMail.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_reSendMail.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_reSendMail.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_reSendMail.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_reSendMail.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_reSendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reSendMailActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Gửi lại mã trong: 60");

        javax.swing.GroupLayout pnl_VerifyMailLayout = new javax.swing.GroupLayout(pnl_VerifyMail);
        pnl_VerifyMail.setLayout(pnl_VerifyMailLayout);
        pnl_VerifyMailLayout.setHorizontalGroup(
            pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel6))
                    .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_mail2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_VerifyMailLayout.createSequentialGroup()
                                    .addComponent(btn_huyXN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                    .addComponent(btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btn_reSendMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_VerifyMailLayout.setVerticalGroup(
            pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txt_mail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyXN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_reSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_VerifyMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btn_XNQuenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XNQuenMKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XNQuenMKActionPerformed

    private void btn_huyQuenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyQuenMKActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_huyQuenMKActionPerformed

    private void btn_QuenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuenTKActionPerformed
        showPanelMenu(pnl_QuenTK);
    }//GEN-LAST:event_btn_QuenTKActionPerformed

    private void btn_XNquenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XNquenTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XNquenTKActionPerformed

    private void btn_huyQuenTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyQuenTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyQuenTKActionPerformed

    private void btn_QuenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QuenMKActionPerformed
        showPanelMenu(pnl_QuenMK);
    }//GEN-LAST:event_btn_QuenMKActionPerformed

    private void btn_XacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XacNhanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XacNhanActionPerformed

    private void btn_huyXNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyXNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyXNActionPerformed

    private void btn_reSendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reSendMailActionPerformed
//        showPanelMenu(pnl_QuenTK);
    }//GEN-LAST:event_btn_reSendMailActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuenMatKhau.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuenMatKhau().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_QuenMK;
    private com.k33ptoo.components.KButton btn_QuenTK;
    private com.k33ptoo.components.KButton btn_XNQuenMK;
    private com.k33ptoo.components.KButton btn_XNquenTK;
    private com.k33ptoo.components.KButton btn_XacNhan;
    private com.k33ptoo.components.KButton btn_huyQuenMK;
    private com.k33ptoo.components.KButton btn_huyQuenTK;
    private com.k33ptoo.components.KButton btn_huyXN;
    private com.k33ptoo.components.KButton btn_reSendMail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnl_QuenMK;
    private javax.swing.JPanel pnl_QuenTK;
    private javax.swing.JPanel pnl_VerifyMail;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_mail;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_mail1;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_mail2;
    // End of variables declaration//GEN-END:variables
}
