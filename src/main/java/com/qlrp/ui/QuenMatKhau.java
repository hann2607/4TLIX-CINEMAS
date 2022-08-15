/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;

import com.k33ptoo.components.KButton;
import com.qlrp.utils.MsgBox;
import com.qlrp.utils.XImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author ACER
 */
public class QuenMatKhau extends javax.swing.JFrame {

    Timer timer;
    int sec = 60;
    String maXN;

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

    public void showPanelMenu(JPanel pnl) {
        // Ẩn tất cả các form còn lại
        pnl_QuenMK.setVisible(false);
        pnl_QuenTK.setVisible(false);
        pnl_VerifyMail.setVisible(false);
        pnl_DoiMK.setVisible(false);

        // show form lên khi click vào menu
        pnl.setVisible(true);
    }

    private boolean validateFormDoiMK() {
        String loi = "";

        if (txt_maXN.getText().equals("")) {
            loi += "Vui lòng nhập mã xác nhận! \n";
        } else if (!txt_maXN.getText().equalsIgnoreCase(maXN)) {
            loi += "Mã xác nhận không chính xác! \n";
        }

        if (txt_MKmoi.equals("")) {
            loi += "Vui lòng nhập mật khẩu! \n";
        } else if (!txt_MKmoi.getText().equalsIgnoreCase(txt_xacNhanMKmoi.getText())) {
            loi += "Xác nhận mật khẩu không khớp! \n";
        }

        if (!loi.equals("")) {
            JOptionPane.showMessageDialog(this, loi, "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validateFormQuenMKvaTK() {
        String loi = "";

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (txt_mail.getText().equals("")) {
            loi += "Vui lòng nhập Email! \n";
        } else if (!txt_mail.getText().matches(EMAIL_PATTERN)) {
            loi += "Email không đúng định dạng! \n";
        }

        if (!loi.equals("")) {
            JOptionPane.showMessageDialog(this, loi, "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public String verifyCode() {
        String vrCode;
        while (true) {
            Random rand = new Random();
            int ranNum = rand.nextInt(100000) + 1;
            if (ranNum > 10000) {
                vrCode = ranNum + "";
                maXN = vrCode;
                break;
            }
        }
        return vrCode;
    }

    public void sendVerifyMail(String toEmail, String code) {
        try {
            // Thiet lap ket noi
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            p.put("mail.smtp.port", 587);

            // Tai khoan login gmail
            String accoutName = "4tlixcompany@gmail.com";
            String accoutPass = "ssqbkkkbdcokwtcr";

            Session ss = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                @Override
                protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(accoutName, accoutPass);
                }
            });

            Message message = new MimeMessage(ss);
            message.setFrom(new InternetAddress(accoutName));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Verify Code");
            String body = code + " là mã xác nhận cho yêu cầu của bạn";
            message.setContent(body, "text/plain; charset=UTF-8");
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "Đã gửi mã xác nhận!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
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
        jLabel8 = new javax.swing.JLabel();
        lbl_diaChiEmail = new javax.swing.JLabel();
        pnl_DoiMK = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_xacNhanMKmoi = new RSMaterialComponent.RSTextFieldMaterialIcon();
        btn_XNquenTK1 = new com.k33ptoo.components.KButton();
        btn_huyQuenTK1 = new com.k33ptoo.components.KButton();
        btn_reSendMXN = new com.k33ptoo.components.KButton();
        txt_MKmoi = new RSMaterialComponent.RSTextFieldMaterialIcon();
        lbl_timer = new javax.swing.JLabel();
        txt_maXN = new RSMaterialComponent.RSTextFieldMaterialIcon();
        jLabel10 = new javax.swing.JLabel();
        lbl_diaChiEmailDoiMK = new javax.swing.JLabel();

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
        txt_mail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mailKeyPressed(evt);
            }
        });

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
                .addGap(130, 130, 130)
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
                .addContainerGap(120, Short.MAX_VALUE))
        );
        pnl_QuenMKLayout.setVerticalGroup(
            pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuenMKLayout.createSequentialGroup()
                .addGap(40, 40, 40)
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
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_QuenMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 350));

        pnl_QuenTK.setPreferredSize(new java.awt.Dimension(560, 350));

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
                .addGap(130, 130, 130)
                .addGroup(pnl_QuenTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_QuenTKLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel5))
                    .addComponent(txt_mail1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_QuenTKLayout.createSequentialGroup()
                        .addComponent(btn_huyQuenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_XNquenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_QuenMK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                .addContainerGap(120, Short.MAX_VALUE))
        );
        pnl_QuenTKLayout.setVerticalGroup(
            pnl_QuenTKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_QuenTKLayout.createSequentialGroup()
                .addGap(40, 40, 40)
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

        jPanel1.add(pnl_QuenTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, -1));

        pnl_VerifyMail.setPreferredSize(new java.awt.Dimension(560, 350));

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Vui lòng nhập mã xác nhận được gửi qua email:");

        lbl_diaChiEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_diaChiEmail.setText("asd@email.com");

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
                        .addGap(130, 130, 130)
                        .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4)
                            .addComponent(txt_mail2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                                .addComponent(btn_huyXN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                .addComponent(btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_reSendMail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_diaChiEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnl_VerifyMailLayout.setVerticalGroup(
            pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_VerifyMailLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lbl_diaChiEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_mail2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(pnl_VerifyMailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_XacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huyXN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_reSendMail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(pnl_VerifyMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 560, 350));

        pnl_DoiMK.setPreferredSize(new java.awt.Dimension(560, 350));
        pnl_DoiMK.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("ĐỔI MẬT KHẨU");
        pnl_DoiMK.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 11, -1, -1));

        txt_xacNhanMKmoi.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        txt_xacNhanMKmoi.setPlaceholder("Nhập lại mật khẩu mới");
        txt_xacNhanMKmoi.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        pnl_DoiMK.add(txt_xacNhanMKmoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 184, 310, 35));

        btn_XNquenTK1.setText("XÁC NHẬN");
        btn_XNquenTK1.setToolTipText("");
        btn_XNquenTK1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_XNquenTK1.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_XNquenTK1.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_XNquenTK1.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_XNquenTK1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_XNquenTK1.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_XNquenTK1.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_XNquenTK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XNquenTK1ActionPerformed(evt);
            }
        });
        pnl_DoiMK.add(btn_XNquenTK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 140, 40));

        btn_huyQuenTK1.setText("QUAY LẠI");
        btn_huyQuenTK1.setToolTipText("");
        btn_huyQuenTK1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huyQuenTK1.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_huyQuenTK1.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenTK1.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenTK1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_huyQuenTK1.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_huyQuenTK1.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_huyQuenTK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyQuenTK1ActionPerformed(evt);
            }
        });
        pnl_DoiMK.add(btn_huyQuenTK1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 140, 40));

        btn_reSendMXN.setText("GỬI LẠI MÃ XÁC NHẬN");
        btn_reSendMXN.setToolTipText("");
        btn_reSendMXN.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_reSendMXN.setkEndColor(new java.awt.Color(22, 21, 26));
        btn_reSendMXN.setkHoverColor(new java.awt.Color(220, 20, 60));
        btn_reSendMXN.setkHoverEndColor(new java.awt.Color(220, 20, 60));
        btn_reSendMXN.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_reSendMXN.setkHoverStartColor(new java.awt.Color(22, 21, 26));
        btn_reSendMXN.setkStartColor(new java.awt.Color(220, 20, 60));
        btn_reSendMXN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reSendMXNActionPerformed(evt);
            }
        });
        pnl_DoiMK.add(btn_reSendMXN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 288, 310, 40));

        txt_MKmoi.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.LOCK);
        txt_MKmoi.setPlaceholder("Nhập mật khẩu mới");
        txt_MKmoi.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        pnl_DoiMK.add(txt_MKmoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 131, 310, 35));

        lbl_timer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_timer.setText("Gửi lại mã trong: 60");
        pnl_DoiMK.add(lbl_timer, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 334, -1, -1));

        txt_maXN.setIcons(rojeru_san.efectos.ValoresEnum.ICONS.VERIFIED_USER);
        txt_maXN.setPlaceholder("Mã xác nhận");
        txt_maXN.setPositionIcon(rojeru_san.efectos.ValoresEnum.POSITIONICON.RIGHT);
        pnl_DoiMK.add(txt_maXN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 78, 310, 35));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Vui lòng nhập mã xác nhận được gửi đến email:");
        pnl_DoiMK.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 300, -1));

        lbl_diaChiEmailDoiMK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbl_diaChiEmailDoiMK.setText("asd@email.com");
        pnl_DoiMK.add(lbl_diaChiEmailDoiMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 220, -1));

        jPanel1.add(pnl_DoiMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void checkTimer(KButton btn) {
        btn_reSendMXN.setEnabled(false);
        lbl_timer.setVisible(false);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_timer.setVisible(true);
                sec--;
                lbl_timer.setText("Gửi lại mã trong: " + sec);
                if (sec == 0) {
                    timer.stop();
                    sec = 60;
                    lbl_timer.setVisible(false);
                    btn.setEnabled(true);
                }
            }
        });
        timer.start();
    }

    private void btn_XNQuenMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XNQuenMKActionPerformed
        if (validateFormQuenMKvaTK()) {
            showPanelMenu(pnl_DoiMK);
            lbl_diaChiEmailDoiMK.setText(txt_mail.getText());
            sendVerifyMail(txt_mail.getText(), verifyCode());
            checkTimer(btn_reSendMXN);
        }
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

    private void btn_XNquenTK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XNquenTK1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_XNquenTK1ActionPerformed

    private void btn_huyQuenTK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyQuenTK1ActionPerformed
        // TODO add your handling code here:
        showPanelMenu(pnl_QuenMK);
    }//GEN-LAST:event_btn_huyQuenTK1ActionPerformed

    private void btn_reSendMXNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reSendMXNActionPerformed
        // TODO add your handling code here:
        if (btn_reSendMXN.isEnabled()) {
            sendVerifyMail(lbl_diaChiEmailDoiMK.getText(), verifyCode());
            checkTimer(btn_reSendMXN);

        } else {
            JOptionPane.showMessageDialog(this, "Chưa thể gửi lại mã lúc này!");
        }
    }//GEN-LAST:event_btn_reSendMXNActionPerformed

    private void txt_mailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mailKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            showPanelMenu(pnl_DoiMK);
            lbl_diaChiEmailDoiMK.setText(txt_mail.getText());
            sendVerifyMail(txt_mail.getText(), verifyCode());
        }
    }//GEN-LAST:event_txt_mailKeyPressed

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
    private com.k33ptoo.components.KButton btn_XNquenTK1;
    private com.k33ptoo.components.KButton btn_XacNhan;
    private com.k33ptoo.components.KButton btn_huyQuenMK;
    private com.k33ptoo.components.KButton btn_huyQuenTK;
    private com.k33ptoo.components.KButton btn_huyQuenTK1;
    private com.k33ptoo.components.KButton btn_huyXN;
    private com.k33ptoo.components.KButton btn_reSendMXN;
    private com.k33ptoo.components.KButton btn_reSendMail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_diaChiEmail;
    private javax.swing.JLabel lbl_diaChiEmailDoiMK;
    private javax.swing.JLabel lbl_timer;
    private javax.swing.JPanel pnl_DoiMK;
    private javax.swing.JPanel pnl_QuenMK;
    private javax.swing.JPanel pnl_QuenTK;
    private javax.swing.JPanel pnl_VerifyMail;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_MKmoi;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_maXN;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_mail;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_mail1;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_mail2;
    private RSMaterialComponent.RSTextFieldMaterialIcon txt_xacNhanMKmoi;
    // End of variables declaration//GEN-END:variables
}
