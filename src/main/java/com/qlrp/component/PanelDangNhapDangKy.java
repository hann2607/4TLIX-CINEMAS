/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.qlrp.component;

import com.qlrp.dao.QLKHDAO;
import com.qlrp.dao.QLNVDAO;
import com.qlrp.entity.KHACHHANG;
import com.qlrp.entity.NHANVIEN;
import com.qlrp.ui.Login_1;
import com.qlrp.ui.QuenMatKhau;
import com.qlrp.utils.Auth;
import com.qlrp.utils.MsgBox;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import net.miginfocom.swing.MigLayout;

public class PanelDangNhapDangKy extends javax.swing.JLayeredPane {

    //Dang nhap
    String tk;
    String mk;

    //DangKy
    String user;
    String hoten;
    String email;
    String diaChi;
    boolean gt;
    String pass;
    String repass;

    QLNVDAO qlnvdao = new QLNVDAO();
    QLKHDAO qlkhdao = new QLKHDAO();

    public PanelDangNhapDangKy(ActionListener eventLogin) {
        initComponents();
        initDangNhap(eventLogin);
        initDangKy();
        pnl_QuenMK.setVisible(false);
        init();
    }

    private void init() {

    }

    private void initDangKy() {

        pnl_DangKy.setLayout(new MigLayout("wrap", "push[center]push", "push[]35[]20[]20[]20[]20[]20[]20[]20[]35[]push"));
        //Tieu de
        JLabel lb = new JLabel("ĐĂNG KÝ TÀI KHOẢN");
        lb.setFont(new Font("Tahoma", 1, 30));
        lb.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(lb);

        //txt_user
        MyTextField txt_User = new MyTextField();
        txt_User.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/user.png")));
        txt_User.setHint("SDT");
        txt_User.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(txt_User, "w 60%");

        //txt_hoTen
        MyTextField txt_Hoten = new MyTextField();
        txt_Hoten.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/user.png")));
        txt_Hoten.setHint("Họ tên");
        txt_Hoten.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(txt_Hoten, "w 60%");

        //txt_Email
        MyTextField txt_Email = new MyTextField();
        txt_Email.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/email.png")));
        txt_Email.setHint("Email");
        txt_Email.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(txt_Email, "w 60%");

        //txt_hoTen
        MyTextField txt_DiaChi = new MyTextField();
        txt_DiaChi.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/home.png")));
        txt_DiaChi.setHint("Địa chỉ");
        txt_DiaChi.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(txt_DiaChi, "w 60%");

        //Gioi Tinh
        JPanel pnl_gt = new JPanel();
        Border blueBorder = BorderFactory.createLineBorder(Color.BLUE);
        pnl_gt.setLayout(new GridLayout(1, 3));
        pnl_gt.setBorder(BorderFactory.createTitledBorder(blueBorder, "Giới tính", 0, 0));
        pnl_gt.setBackground(Color.WHITE);

        JCheckBoxCustom chk_nam = new JCheckBoxCustom();
        chk_nam.setText("Nam");
        chk_nam.setSelected(true);

        JCheckBoxCustom chk_nu = new JCheckBoxCustom();
        chk_nu.setText("Nữ");

        ButtonGroup group = new ButtonGroup();
        group.add(chk_nam);
        group.add(chk_nu);

        pnl_gt.add(chk_nam);
        pnl_gt.add(chk_nu);

        pnl_DangKy.add(pnl_gt, "w 60%");

        //txt_pass
        MyPasswordField txt_Pass = new MyPasswordField();
        txt_Pass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/pass.png")));
        txt_Pass.setHint("Mật khẩu");
        txt_Pass.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(txt_Pass, "w 60%");

        //txt_repass
        MyPasswordField txt_rePass = new MyPasswordField();
        txt_rePass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/pass.png")));
        txt_rePass.setHint("Xác nhận mật khẩu");
        txt_rePass.setForeground(new Color(0, 0, 0));
        pnl_DangKy.add(txt_rePass, "w 60%");

        //btn_dangKy
        Button btn_dangKy = new Button();
        btn_dangKy.setBackground(new Color(204, 0, 0));
        btn_dangKy.setForeground(new Color(250, 250, 250));
        btn_dangKy.setFont(new Font("Tahoma", 1, 15));
        btn_dangKy.setText("ĐĂNG KÝ");
        pnl_DangKy.add(btn_dangKy, "w 50%, h 7%");
        btn_dangKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                user = txt_User.getText().trim();
                hoten = txt_Hoten.getText().trim();
                email = txt_Email.getText().trim();
                diaChi = txt_DiaChi.getText().trim();
                pass = String.valueOf(txt_Pass.getPassword());
                repass = String.valueOf(txt_rePass.getPassword());
                if (chk_nam.isSelected()) {
                    gt = true;
                } else {
                    gt = false;
                }
                dangKy();
            }
        });

    }

    private void initDangNhap(ActionListener eventLogin) {
        pnl_DangNhap.setLayout(new MigLayout("wrap", "push[center]push", "push[]35[]20[]20[]10[]35[]push"));

        //Tieu de
        JLabel lb = new JLabel("ĐĂNG NHẬP");
        lb.setFont(new Font("Tahoma", 1, 30));
        lb.setForeground(new Color(0, 0, 0));
        pnl_DangNhap.add(lb);

        //txt_dangNhap
        MyTextField txt_taiKhoan = new MyTextField();
        txt_taiKhoan.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/user.png")));
        txt_taiKhoan.setHint("Số điện thoại");
        txt_taiKhoan.setForeground(new Color(0, 0, 0));
        pnl_DangNhap.add(txt_taiKhoan, "w 60%");

        //txt_matKhau
        MyPasswordField txt_Pass = new MyPasswordField();
        txt_Pass.setPrefixIcon(new ImageIcon(getClass().getResource("/com/qlrp/icon/login/pass.png")));
        txt_Pass.setHint("Mật khẩu");
        txt_Pass.setForeground(new Color(0, 0, 0));
        pnl_DangNhap.add(txt_Pass, "w 60%");
        txt_Pass.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    Login_1 login = new Login_1();
                    tk = txt_taiKhoan.getText().trim();
                    mk = String.valueOf(txt_Pass.getPassword());
                    dangNhap();
                    login.closeForm();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        //btn_quenMK
        JButton cmdForget = new JButton("Quên mật khẩu ?");
        cmdForget.setForeground(new Color(100, 100, 100));
        cmdForget.setFont(new Font("Tahoma", 1, 12));
        cmdForget.setContentAreaFilled(false);
        cmdForget.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmdForget.setBorder(null);
        pnl_DangNhap.add(cmdForget, "h 5%");
        cmdForget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QuenMatKhau qmk = new QuenMatKhau();
                qmk.setVisible(true);
            }
        });

        //btn_dangNhap
        Button btn_dangNhap = new Button();
        btn_dangNhap.setBackground(new Color(204, 0, 0));
        btn_dangNhap.setForeground(new Color(250, 250, 250));
        btn_dangNhap.setFont(new Font("Tahoma", 1, 15));
        btn_dangNhap.setText("ĐĂNG NHẬP");
        pnl_DangNhap.add(btn_dangNhap, "w 50%, h 7%");
        btn_dangNhap.addActionListener(eventLogin);
        btn_dangNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tk = txt_taiKhoan.getText().trim();
                mk = String.valueOf(txt_Pass.getPassword());
                dangNhap();
            }
        });
    }

    private void dangNhap() {

        NHANVIEN epl = qlnvdao.selectebyID(tk);
        KHACHHANG cus = qlkhdao.selectebyID(tk);

        if (epl == null) {
            if (cus == null) {
                JOptionPane.showMessageDialog(this, "Sai tên đăng nhập!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            } else if (!mk.equals(cus.getMAT_KHAU())) {
                JOptionPane.showMessageDialog(this, "Sai mật khẩu!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            } else {
                MsgBox.alert(this, "ĐĂNG NHẬP THÀNH CÔNG!");
                Auth.cus = cus;
            }
        } else if (!mk.equals(epl.getMAT_KHAU())) {
            JOptionPane.showMessageDialog(this, "Sai mật khẩu!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
        } else {
            MsgBox.alert(this, "ĐĂNG NHẬP THÀNH CÔNG!");
            Auth.user = epl;
        }
    }

    private void dangKy() {
        int dk = JOptionPane.showConfirmDialog(this, "bạn có muốn đăng ký không?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (dk != JOptionPane.YES_OPTION) {
            return;
        }
        try {
            if (validateForm()) {
                KHACHHANG kh = getform();
                qlkhdao.insert(kh);
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!", "Thông báo!", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Đăng ký thất bại!", "Lỗi!", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private KHACHHANG getform() {
        KHACHHANG kh = new KHACHHANG();
        kh.setSDT(user);
        kh.setHO_TEN(hoten);
        kh.setEMAIL(email);
        kh.setDIA_CHI(diaChi);
        kh.setGIOI_TINH(gt);
        kh.setMAT_KHAU(pass);
        return kh;
    }

    private boolean validateForm() {
        String loi = "";

        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        if (user.equals("")) {
            loi += "SDT không được để trống! \n";
        } else if (!user.matches(reg)) {
            loi += "Số điện thoại không đúng định dạng! \n";
        }

        if (hoten.equals("")) {
            loi += "Họ và tên không được để trống! \n";
        }

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        if (email.equals("")) {
            loi += "Gmail không được để trống! \n";
        } else if (!email.matches(EMAIL_PATTERN)) {
            loi += "Gmail không đúng định dạng! \n";
        }

        if (diaChi.equals("")) {
            loi += "Địa chỉ không được để trống! \n";
        }
        if (pass.equals("")) {
            loi += "Mật khẩu không được để trống! \n";
        } else if (!pass.equalsIgnoreCase(repass)) {
            loi += "Xác nhận mật khẩu không khớp! \n";
        }

        if (!loi.equals("")) {
            JOptionPane.showMessageDialog(this, loi, "Lỗi!", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void showDangKy(boolean show) {
        if (show) {
            pnl_DangKy.setVisible(false);
            pnl_DangNhap.setVisible(true);
        } else {
            pnl_DangKy.setVisible(true);
            pnl_DangNhap.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_DangNhap = new javax.swing.JPanel();
        pnl_DangKy = new javax.swing.JPanel();
        pnl_QuenMK = new javax.swing.JPanel();

        setLayout(new java.awt.CardLayout());

        pnl_DangNhap.setBackground(new java.awt.Color(211, 211, 211));

        javax.swing.GroupLayout pnl_DangNhapLayout = new javax.swing.GroupLayout(pnl_DangNhap);
        pnl_DangNhap.setLayout(pnl_DangNhapLayout);
        pnl_DangNhapLayout.setHorizontalGroup(
            pnl_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnl_DangNhapLayout.setVerticalGroup(
            pnl_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        add(pnl_DangNhap, "card2");

        pnl_DangKy.setBackground(new java.awt.Color(211, 211, 211));

        javax.swing.GroupLayout pnl_DangKyLayout = new javax.swing.GroupLayout(pnl_DangKy);
        pnl_DangKy.setLayout(pnl_DangKyLayout);
        pnl_DangKyLayout.setHorizontalGroup(
            pnl_DangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnl_DangKyLayout.setVerticalGroup(
            pnl_DangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        add(pnl_DangKy, "card2");

        pnl_QuenMK.setBackground(new java.awt.Color(211, 211, 211));

        javax.swing.GroupLayout pnl_QuenMKLayout = new javax.swing.GroupLayout(pnl_QuenMK);
        pnl_QuenMK.setLayout(pnl_QuenMKLayout);
        pnl_QuenMKLayout.setHorizontalGroup(
            pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnl_QuenMKLayout.setVerticalGroup(
            pnl_QuenMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        add(pnl_QuenMK, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnl_DangKy;
    private javax.swing.JPanel pnl_DangNhap;
    private javax.swing.JPanel pnl_QuenMK;
    // End of variables declaration//GEN-END:variables
}
