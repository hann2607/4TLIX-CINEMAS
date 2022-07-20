/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlbh.ui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.qlbh.dao.CHECKINDAO;
import com.qlbh.dao.QLNVDAO;
import com.qlbh.entity.CHECKIN;
import com.qlbh.entity.EMPLOYEE;
import com.qlbh.utils.Auth;
import com.qlbh.utils.MsgBox;
import com.qlbh.utils.XDate;
import com.qlbh.utils.XImage;
import com.qlbh.utils.getInfo;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class CheckIn extends javax.swing.JFrame implements Runnable, ThreadFactory {

    /**
     * Creates new form CheckIn
     */
    private WebcamPanel cam_panel = null;
    private Webcam webcam = null;
    private final Executor executor = Executors.newSingleThreadExecutor(this);
    File f = new File("");
    int numberCheck = 0;

    public CheckIn() {
        initComponents();
        this.setIconImage(XImage.getAppIcon());
        setLocationRelativeTo(null);
        showPanelMenu(pnl_logo_check);
        lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\icon\\CheckIn\\Avatar_checkIn.jpg"));
        lbl_checkIn_logoQR.setIcon(XImage.ResizeImage(lbl_checkIn_logoQR.getWidth(), lbl_checkIn_logoQR.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\icon\\CheckIn\\QR-code_checkIn.jpg"));
        btn_CheckOut.setVisible(false);
        btn_CheckOut.setEnabled(false);
    }

    private void initWebcam() {
        if (numberCheck > 3) {
            JOptionPane.showMessageDialog(this, "You have checked more than allowed!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
            numberCheck = 0;
        }
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0);
        webcam.setViewSize(size);
        cam_panel = new WebcamPanel(webcam);
        cam_panel.setPreferredSize(size);
        //cam_panel.setFPSDisplayed(true);
        pnl_camera.add(cam_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 370));
        executor.execute(this);
    }

    private void showPanelMenu(JPanel pnl) {
        // Ẩn tất cả các form còn lại
        pnl_logo_check.setVisible(false);
        pnl_image.setVisible(false);
        pnl_camera.setVisible(false);
        // show form lên khi click vào menu
        pnl.setVisible(true);
    }

    QLNVDAO qlnvdao = new QLNVDAO();
    CHECKIN ck = new CHECKIN();
    DateTimeFormatter fmDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public void setEnableButton(String addorEdit) {
        if (addorEdit.equalsIgnoreCase("out")) {
            btn_CheckIn.setEnabled(false);
            btn_CheckIn.setVisible(false);
            btn_CheckOut.setVisible(true);
            btn_CheckOut.setEnabled(true);
        }
    }

    private void fillInfo() {
        LocalDateTime now = LocalDateTime.now();
        String id = lbl_ID.getText();
        EMPLOYEE epl = qlnvdao.selectebyID(id);

        if (id.equals(Auth.user.getMANV())) {
            if (epl != null) {
                lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\icon\\Employee\\ImageEmployee\\" + epl.getHINH()));
                lbl_name.setText(epl.getHOTENNV());

                String role = String.valueOf(epl.isVAITRO());
                if (role.equals("true")) {
                    role = "Manager";
                } else {
                    role = "Employee";
                }
                lbl_role.setText(role);

                if (btn_CheckIn.isVisible()) {
                    lbl_timeIN.setText(fmDateTime.format(now));
                } else {
                    CHECKIN chk = getInfo.checkin;
                    lbl_timeIN.setText(XDate.toString(chk.getLUOTVAO(), "dd/MM/yyyy HH:mm:ss"));
                    lbl_timeOUT.setText(fmDateTime.format(now));
                }
            } else {
                JOptionPane.showMessageDialog(this, "No infomation!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please use your employee card!", "Error", JOptionPane.ERROR_MESSAGE);
            clearForm();
        }

    }

    private CHECKIN getForm() {
        CHECKIN chk = new CHECKIN();
        chk.setMANV(lbl_ID.getText());
        if (btn_CheckIn.isEnabled()) {
            chk.setLUOTVAO(XDate.toDate(lbl_timeIN.getText(), "dd/MM/yyyy HH:mm:ss"));
        }
        if (btn_CheckOut.isEnabled()) {
            chk.setLUOTRA(XDate.toDate(lbl_timeOUT.getText(), "dd/MM/yyyy HH:mm:ss"));
        }

        return chk;
    }

    private void conFirm() {
        CHECKINDAO qlcheckindao = new CHECKINDAO();
        if (btn_CheckIn.isEnabled()) {
            CHECKIN chk = getForm();
            qlcheckindao.update_IN(chk);
            MsgBox.alert(this, "Check in Successfully!");
            getInfo.checkin = chk;
            this.dispose();
            // run home
            home h = new home();
            h.setVisible(true);
        }
        if (btn_CheckOut.isEnabled()) {
            CHECKIN chk = getForm();
            qlcheckindao.update_OUT(chk);
            MsgBox.alert(this, "Check out Successfully!");
            System.exit(0);
        }
    }

    private void clearForm() {
        lbl_ID.setText("**********");
        lbl_name.setText("**********");
        lbl_role.setText("**********");
        lbl_timeIN.setText("hh-mm-ss");
        lbl_timeOUT.setText("hh-mm-ss");
        lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\icon\\CheckIn\\Avatar_checkIn.jpg"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_timeOUT = new javax.swing.JLabel();
        lbl_timeIN = new javax.swing.JLabel();
        lbl_role = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_ID = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        btn_Checkin_Reset = new com.k33ptoo.components.KButton();
        btn_CheckIn = new com.k33ptoo.components.KButton();
        btn_CheckOut = new com.k33ptoo.components.KButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pnl_logo_check = new javax.swing.JPanel();
        lbl_checkIn_logoQR = new javax.swing.JLabel();
        pnl_image = new javax.swing.JPanel();
        pnl_camera = new javax.swing.JPanel();
        bt_UseCamera = new com.k33ptoo.components.KButton();
        btn_CANCEL = new com.k33ptoo.components.KButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setPreferredSize(new java.awt.Dimension(1270, 500));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setPreferredSize(new java.awt.Dimension(635, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_img.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(lbl_img, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 190, 220));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("NAME:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ROLE:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TIME - IN:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("TIME - OUT:");

        lbl_timeOUT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_timeOUT.setText("hh-mm-ss");

        lbl_timeIN.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_timeIN.setText("hh-mm-ss");

        lbl_role.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_role.setText("**********");

        lbl_name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_name.setText("**********");

        lbl_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ID.setText("**********");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_timeIN)
                            .addComponent(lbl_ID)
                            .addComponent(lbl_timeOUT)
                            .addComponent(lbl_role)
                            .addComponent(lbl_name))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbl_ID))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_name))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_role))
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbl_timeIN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lbl_timeOUT))
                .addContainerGap())
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 330, 220));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btn_Checkin_Reset.setText("RESET");
        btn_Checkin_Reset.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_Checkin_Reset.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_Checkin_Reset.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_Checkin_Reset.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_Checkin_Reset.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_Checkin_Reset.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_Checkin_Reset.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_Checkin_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Checkin_ResetActionPerformed(evt);
            }
        });
        jPanel7.add(btn_Checkin_Reset);

        btn_CheckIn.setText("CHECK IN");
        btn_CheckIn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_CheckIn.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_CheckIn.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_CheckIn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_CheckIn.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_CheckIn.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_CheckIn.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_CheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CheckInActionPerformed(evt);
            }
        });
        jPanel7.add(btn_CheckIn);

        btn_CheckOut.setText("CHECK OUT");
        btn_CheckOut.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_CheckOut.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_CheckOut.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_CheckOut.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_CheckOut.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_CheckOut.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_CheckOut.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_CheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CheckOutActionPerformed(evt);
            }
        });
        jPanel7.add(btn_CheckOut);

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 480, -1));

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setPreferredSize(new java.awt.Dimension(633, 100));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setPreferredSize(new java.awt.Dimension(440, 440));
        jPanel6.setLayout(new java.awt.CardLayout());

        pnl_logo_check.setLayout(new java.awt.BorderLayout());
        pnl_logo_check.add(lbl_checkIn_logoQR, java.awt.BorderLayout.CENTER);

        jPanel6.add(pnl_logo_check, "card2");

        javax.swing.GroupLayout pnl_imageLayout = new javax.swing.GroupLayout(pnl_image);
        pnl_image.setLayout(pnl_imageLayout);
        pnl_imageLayout.setHorizontalGroup(
            pnl_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );
        pnl_imageLayout.setVerticalGroup(
            pnl_imageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        jPanel6.add(pnl_image, "card4");

        pnl_camera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel6.add(pnl_camera, "card3");

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 390, 370));

        bt_UseCamera.setText("USE CAMERA");
        bt_UseCamera.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        bt_UseCamera.setkEndColor(new java.awt.Color(0, 112, 192));
        bt_UseCamera.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        bt_UseCamera.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        bt_UseCamera.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        bt_UseCamera.setkPressedColor(new java.awt.Color(153, 153, 153));
        bt_UseCamera.setkStartColor(new java.awt.Color(0, 79, 174));
        bt_UseCamera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UseCameraActionPerformed(evt);
            }
        });
        jPanel4.add(bt_UseCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));

        btn_CANCEL.setText("CANCEL");
        btn_CANCEL.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_CANCEL.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_CANCEL.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_CANCEL.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_CANCEL.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_CANCEL.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_CANCEL.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_CANCEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CANCELActionPerformed(evt);
            }
        });
        jPanel4.add(btn_CANCEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, -1));

        jPanel1.add(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckInActionPerformed
        // TODO add your handling code here:\
        conFirm();
    }//GEN-LAST:event_btn_CheckInActionPerformed

    private void btn_Checkin_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Checkin_ResetActionPerformed
        clearForm();
        webcam.close();
        showPanelMenu(pnl_logo_check);
    }//GEN-LAST:event_btn_Checkin_ResetActionPerformed

    private void bt_UseCameraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UseCameraActionPerformed
        clearForm();
        initWebcam();
        webcam.open();
        showPanelMenu(pnl_camera);
        numberCheck++;
    }//GEN-LAST:event_bt_UseCameraActionPerformed

    private void btn_CANCELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CANCELActionPerformed
        if (MsgBox.confirm(this, "Are you sure want to exit ?")) {
            this.dispose();
        }
    }//GEN-LAST:event_btn_CANCELActionPerformed

    private void btn_CheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CheckOutActionPerformed
        // TODO add your handling code here:
        conFirm();
    }//GEN-LAST:event_btn_CheckOutActionPerformed

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
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton bt_UseCamera;
    private com.k33ptoo.components.KButton btn_CANCEL;
    private com.k33ptoo.components.KButton btn_CheckIn;
    private com.k33ptoo.components.KButton btn_CheckOut;
    private com.k33ptoo.components.KButton btn_Checkin_Reset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JLabel lbl_checkIn_logoQR;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_role;
    private javax.swing.JLabel lbl_timeIN;
    private javax.swing.JLabel lbl_timeOUT;
    private javax.swing.JPanel pnl_camera;
    private javax.swing.JPanel pnl_image;
    private javax.swing.JPanel pnl_logo_check;
    // End of variables declaration//GEN-END:variables
    int i = 0;

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (Exception ex) {

            }

            Result rs = null;
            BufferedImage img = null;

            if (webcam.isOpen()) {
                if ((img = webcam.getImage()) == null) {
                    continue;
                }
            }
            LuminanceSource sc = new BufferedImageLuminanceSource(img);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(sc));

            try {
                rs = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException ex) {

            }

            if (rs != null) {
                lbl_ID.setText(rs.getText());
            }
            if (!lbl_ID.getText().equals("**********")) {
                webcam.close();
                showPanelMenu(pnl_logo_check);
                fillInfo();
            }
            if (i == 70) {
                webcam.close();
                showPanelMenu(pnl_logo_check);
                JOptionPane.showMessageDialog(this, "Please check your QR code again !!!", "Error check", ERROR_MESSAGE);
                i = 0;
            }
            i++;
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
