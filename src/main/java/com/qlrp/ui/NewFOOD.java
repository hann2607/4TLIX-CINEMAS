/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;

import com.qlrp.dao.QLDADAO;
import com.qlrp.entity.DOAN;
import com.qlrp.utils.MsgBox;
import com.qlrp.utils.XImage;
import static com.qlrp.utils.XImage.ResizeImage;
import com.qlrp.utils.getInfo;
import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

/**
 *
 * @author ACER
 */
public final class NewFOOD extends javax.swing.JFrame {

    /**
     * Creates new form NewOrder
     */
    File f = new File("");
    String duongdanBanner = "\\src\\main\\resources\\com\\qlrp\\image\\doan\\";
    QLDADAO qldadao = new QLDADAO();
    List<DOAN> listDA = qldadao.selectAll();

    public NewFOOD() {
        initComponents();
        init();
    }

    public void fillToForm() {
        DOAN datu = getInfo.da;
        if (datu != null) {
            txt_ten.setText(datu.getTENDOAN());
            cbo_loai.setSelectedItem(datu.getLOAI());
            cbo_kichco.setSelectedItem(datu.getKICHCO());
            sp_soluong.setValue(datu.getSOLUONG());
            txt_donGia.setText(datu.getDONGIA() + "");
            txt_maKM.setText(datu.getMAKHUYENMAI());
            lbl_img.setIcon((XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\DOAN\\" + datu.getHINH())));
        }
    }

    private void init() {
        this.setAlwaysOnTop(true);
        this.setIconImage(XImage.getAppIcon());
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocation(DEFAULT_CURSOR, 320);
        lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\DOAN\\PopcornCombo.png"));
//        fillToForm();
    }
    
    private void clearAll() {
        txt_ten.setText("");
        cbo_loai.setSelectedIndex(0);
        cbo_kichco.setSelectedIndex(0);
        sp_soluong.setValue(0);
        txt_donGia.setText("");
        txt_maKM.setText("");
        try {
            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + "PopcornCombo.png"));
        } catch (Exception e) {
        }
    }

    public void setForm(DOAN doan) {
        try {
            txt_ten.setText(doan.getTENDOAN());
            cbo_loai.setSelectedItem(doan.getLOAI());
            cbo_kichco.setSelectedItem(doan.getKICHCO());
            sp_soluong.setValue(doan.getSOLUONG());
            txt_donGia.setText(doan.getDONGIA() + "");
            txt_maKM.setText(doan.getMAKHUYENMAI());
            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + doan.getHINH()));
        } catch (Exception e) {
        }
    }
    String duongDanImage = null;
    String maKM;

    private DOAN getForm() {
        DOAN doan = new DOAN();
        if (validateForm()) {
            doan.setTENDOAN(txt_ten.getText());
            doan.setLOAI(cbo_loai.getSelectedItem().toString());
            System.out.println(cbo_loai.getSelectedItem().toString());
            doan.setKICHCO(cbo_kichco.getSelectedItem().toString());
            doan.setSOLUONG(sp_soluong.getValue().hashCode());
            doan.setDONGIA(Double.valueOf(txt_donGia.getText()));
            if (txt_maKM.getText().isEmpty()) {
                maKM = null;
            } else {
                maKM = txt_maKM.getText();
            }
            doan.setMAKHUYENMAI(maKM);

            try {
                doan.setHINH(duongDanImage.substring(duongDanImage.lastIndexOf("\\") + 1, duongDanImage.length()));
            } catch (Exception e) {
                doan.setHINH(null);
            }
        } else {
            return null;
        }
        return doan;
    }
    double price = 0;

    private boolean validateForm() {
        String Error = "";
        if (txt_ten.getText().equals("")) {
            Error += "Tên đồ ăn trống! \n";
            txt_ten.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_ten.grabFocus();
        }
        if (cbo_loai.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn loại! \n";
            cbo_loai.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_loai.grabFocus();
        }
        if (cbo_kichco.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn kích cỡ! \n";
            cbo_kichco.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_kichco.grabFocus();
        }
        int qty = sp_soluong.getValue().hashCode();
        if (qty
                <= 0) {
            Error += "Số lượng không được nhỏ hơn 0 ! \n";
            sp_soluong.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            sp_soluong.grabFocus();
        }

        if (txt_donGia.getText()
                .equals("")) {
            Error += "Đơn giá trống! \n";
            txt_donGia.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_donGia.grabFocus();
        } else {
            try {
                price = Double.parseDouble(txt_donGia.getText());
                if (price < 0) {
                    Error += "Đơn giá phải lớn hơn 0! \n";
                    txt_donGia.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
                    txt_donGia.grabFocus();
                }
            } catch (Exception e) {
                Error += "Đơn giá phải là số! \n";
                txt_donGia.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
                txt_donGia.grabFocus();
            }
        }

        if (!Error.equals("")) {
            JOptionPane.showMessageDialog(this, Error, "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public void setEnableButton(String addorEdit) {
        if (addorEdit.equalsIgnoreCase("add")) {
            btn_Edit.setEnabled(false);
            btn_Edit.setVisible(false);
            btn_Delete.setEnabled(false);
            btn_Delete.setVisible(false);
            clearAll();
        } else if (addorEdit.equalsIgnoreCase("edit")) {
            btn_Add.setEnabled(false);
            btn_Add.setVisible(false);
            txt_ten.setEditable(false);
            btn_Edit.setEnabled(true);
            btn_Edit.setVisible(true);
            btn_Delete.setEnabled(true);
            btn_Delete.setVisible(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        lbl_ten = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        lbl_soluong = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        lbl_dongia = new javax.swing.JLabel();
        lbl_maKH = new javax.swing.JLabel();
        txt_donGia = new javax.swing.JTextField();
        sp_soluong = new javax.swing.JSpinner();
        btn_Items_chooseFile = new com.k33ptoo.components.KButton();
        jPanel8 = new javax.swing.JPanel();
        btn_Add = new com.k33ptoo.components.KButton();
        btn_Edit = new com.k33ptoo.components.KButton();
        btn_Delete = new com.k33ptoo.components.KButton();
        btn_Clear = new com.k33ptoo.components.KButton();
        lbl_loai = new javax.swing.JLabel();
        lbl_kichco = new javax.swing.JLabel();
        cbo_kichco = new javax.swing.JComboBox<>();
        cbo_loai = new javax.swing.JComboBox<>();
        txt_maKM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ITEMS");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lbl_ten.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten.setText("TÊN ĐỒ ĂN");

        txt_ten.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_ten.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tenKeyReleased(evt);
            }
        });

        lbl_soluong.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_soluong.setText("SÓ LƯỢNG");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("LOẠI ĐỒ ĂN");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_img, java.awt.BorderLayout.CENTER);

        lbl_dongia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_dongia.setText("ĐƠN GIÁ");

        lbl_maKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_maKH.setText("MÃ KHUYẾN MÃI");

        txt_donGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txt_donGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_donGiaKeyReleased(evt);
            }
        });

        sp_soluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sp_soluong.setPreferredSize(new java.awt.Dimension(7, 20));
        sp_soluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sp_soluongKeyReleased(evt);
            }
        });

        btn_Items_chooseFile.setText("CHỌN ẢNH");
        btn_Items_chooseFile.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_Items_chooseFile.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_Items_chooseFile.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_Items_chooseFile.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_Items_chooseFile.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_Items_chooseFile.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_Items_chooseFile.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_Items_chooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Items_chooseFileActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

        btn_Add.setText("THÊM");
        btn_Add.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_Add.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_Add.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_Add.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_Add.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_Add.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_Add.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel8.add(btn_Add);

        btn_Edit.setText("SỬA");
        btn_Edit.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_Edit.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_Edit.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_Edit.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_Edit.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_Edit.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_Edit.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });
        jPanel8.add(btn_Edit);

        btn_Delete.setText("XÓA");
        btn_Delete.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_Delete.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_Delete.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_Delete.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_Delete.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_Delete.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_Delete.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });
        jPanel8.add(btn_Delete);

        btn_Clear.setText("MỚI");
        btn_Clear.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_Clear.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_Clear.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_Clear.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_Clear.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_Clear.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_Clear.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });
        jPanel8.add(btn_Clear);

        lbl_loai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_loai.setText("LOẠI");

        lbl_kichco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_kichco.setText("KÍCH CỠ");

        cbo_kichco.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHỌN KÍCH CỠ", "S", "M", "L" }));
        cbo_kichco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kichcoActionPerformed(evt);
            }
        });
        cbo_kichco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbo_kichcoKeyReleased(evt);
            }
        });

        cbo_loai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHỌN LOẠI", "Đồ ăn", "Đồ uống" }));
        cbo_loai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_loaiActionPerformed(evt);
            }
        });
        cbo_loai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbo_loaiKeyReleased(evt);
            }
        });

        txt_maKM.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ten)
                            .addComponent(lbl_soluong)
                            .addComponent(lbl_dongia)
                            .addComponent(lbl_kichco)
                            .addComponent(lbl_loai))
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_maKH)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_soluong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ten)
                    .addComponent(cbo_kichco, 0, 249, Short.MAX_VALUE)
                    .addComponent(cbo_loai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_maKM))
                .addGap(0, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Items_chooseFile, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(lbl_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(cbo_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_kichco, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_kichco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maKM, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Items_chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
//        // TODO add your handling code here:
        if (btn_Add.isEnabled()) {
            DOAN da = getForm();
            if (da != null) {
                if (qldadao.selectebyID(da.getTENDOAN()) == null) {
                    qldadao.insert(da);
                    MsgBox.alert(this, "Thêm thành công!");
//                    qlhome.fillToTable_DA(listDA);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Món ăn đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            MsgBox.alert(this, "You can only edit. If you want to add, please choose again!");
        }
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            DOAN da = getForm();
            if (da != null) {
                if (qldadao.selectebyID(da.getTENDOAN()) != null) {
                    qldadao.update(da);
                    MsgBox.alert(this, "Cập nhật thành công!");
//                    QLHOME hm = new QLHOME();
//                    qlhome.fillToTable_DA(listDA);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Món ăn không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            MsgBox.alert(this, "You can only Add. If you want to edit, please choose again!");
        }
    }//GEN-LAST:event_btn_EditActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            if (txt_ten.getText() != null && !txt_ten.getText().equals("")) {
                if (qldadao.selectebyID(txt_ten.getText()) != null) {
                    qldadao.delete(txt_ten.getText());
                    MsgBox.alert(this, "Xóa thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Món ăn không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tên món ăn không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            MsgBox.alert(this, "You can only Add. If you want to edit, please choose again!");
        }

    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        if (btn_Edit.isEnabled()) {
            clearAll();
        } else {
            this.clearAll();
        }
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_Items_chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Items_chooseFileActionPerformed
        // TODO add your handling code here:
        chooseImage();

    }//GEN-LAST:event_btn_Items_chooseFileActionPerformed

    private void cbo_kichcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kichcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_kichcoActionPerformed

    private void cbo_loaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_loaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_loaiActionPerformed

    private void txt_tenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tenKeyReleased
        // TODO add your handling code here:
        txt_ten.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

    }//GEN-LAST:event_txt_tenKeyReleased

    private void cbo_loaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_loaiKeyReleased
        // TODO add your handling code here:
        cbo_loai.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

    }//GEN-LAST:event_cbo_loaiKeyReleased

    private void cbo_kichcoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbo_kichcoKeyReleased
        // TODO add your handling code here:
        cbo_kichco.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

    }//GEN-LAST:event_cbo_kichcoKeyReleased

    private void sp_soluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sp_soluongKeyReleased
        // TODO add your handling code here:
        sp_soluong.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

    }//GEN-LAST:event_sp_soluongKeyReleased

    private void txt_donGiaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_donGiaKeyReleased
        // TODO add your handling code here:
        txt_donGia.setBorder(new MatteBorder(0, 0, 1, 0, Color.BLACK));

    }//GEN-LAST:event_txt_donGiaKeyReleased

    private void chooseImage() {
        duongDanImage = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\DOAN\\";
        try {
            JFileChooser fc = new JFileChooser(f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\DOAN\\");
            fc.setDialogTitle("Open File");
            fc.showOpenDialog(null);

            File fTenAnh = fc.getSelectedFile();
            duongDanImage = fTenAnh.getAbsolutePath();
            if (duongDanImage != null) {
                lbl_img.setIcon(ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), String.valueOf(duongDanImage)));
                System.out.println(duongDanImage);
            } else {
                System.out.println("Image not selected!");
            }
        } catch (Exception e) {
            System.out.println("Image not selected!");
            System.out.println(duongDanImage);
        }
    }

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
            java.util.logging.Logger.getLogger(NewFOOD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewFOOD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewFOOD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewFOOD.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewFOOD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_Add;
    private com.k33ptoo.components.KButton btn_Clear;
    private com.k33ptoo.components.KButton btn_Delete;
    private com.k33ptoo.components.KButton btn_Edit;
    private com.k33ptoo.components.KButton btn_Items_chooseFile;
    private javax.swing.JComboBox<String> cbo_kichco;
    private javax.swing.JComboBox<String> cbo_loai;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lbl_dongia;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JLabel lbl_kichco;
    private javax.swing.JLabel lbl_loai;
    private javax.swing.JLabel lbl_maKH;
    private javax.swing.JLabel lbl_soluong;
    private javax.swing.JLabel lbl_ten;
    private javax.swing.JSpinner sp_soluong;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_maKM;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
