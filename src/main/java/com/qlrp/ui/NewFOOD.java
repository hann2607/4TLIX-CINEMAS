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
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
    QLHOME hm = new QLHOME();

    public NewFOOD() {
        initComponents();
        init();
    }

    public void fillToForm() {
        DOAN datu = getInfo.da;
        if (datu != null) {
            txt_tenDA.setText(datu.getTENDOAN());
            cbo_loaiDA.setSelectedItem(datu.getLOAI());
            cbo_kichcoDA.setSelectedItem(datu.getKICHCO());
            sp_soluongDA.setValue(datu.getSOLUONG());
            txt_donGiaDA.setText(datu.getDONGIA() + "");
            txt_maKMDA.setText(datu.getMAKHUYENMAI());
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
        txt_tenDA.setText("");
        cbo_loaiDA.setSelectedIndex(0);
        cbo_kichcoDA.setSelectedIndex(0);
        sp_soluongDA.setValue(0);
        txt_donGiaDA.setText("");
        txt_maKMDA.setText("");
        try {
            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + "PopcornCombo.png"));
        } catch (Exception e) {
        }
    }

    public void setForm(DOAN doan) {
        try {
            txt_tenDA.setText(doan.getTENDOAN());
            cbo_loaiDA.setSelectedItem(doan.getLOAI());
            cbo_kichcoDA.setSelectedItem(doan.getKICHCO());
            sp_soluongDA.setValue(doan.getSOLUONG());
            txt_donGiaDA.setText(doan.getDONGIA() + "");
            txt_maKMDA.setText(doan.getMAKHUYENMAI());
            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + doan.getHINH()));
        } catch (Exception e) {
        }
    }
    String duongDanImage = null;

    private DOAN getForm() {
        DOAN doan = new DOAN();
        if (validateForm()) {
            doan.setTENDOAN(txt_tenDA.getText());
            doan.setLOAI(cbo_loaiDA.getSelectedItem().toString());
            doan.setKICHCO(cbo_loaiDA.getSelectedItem().toString());
            doan.setSOLUONG(sp_soluongDA.getValue().hashCode());
            doan.setDONGIA(Double.valueOf(txt_donGiaDA.getText()));
            doan.setMAKHUYENMAI(txt_maKMDA.getText());

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
        if (txt_tenDA.getText().equals("")) {
            Error += "Tên đồ ăn trống! \n";
        }
        if (cbo_loaiDA.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn loại! \n";
        }
        if (cbo_kichcoDA.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn kích cỡ! \n";
        }
        int qty = sp_soluongDA.getValue().hashCode();
        if (qty
                <= 0) {
            Error += "Số lượng không được nhỏ hơn 0 ! \n";
        }

        if (txt_donGiaDA.getText()
                .equals("")) {
            Error += "Đơn giá trống! \n";
        } else {
            try {
                price = Double.parseDouble(txt_donGiaDA.getText());
                if (price < 0) {
                    Error += "Đơn giá phải lớn hơn 0! \n";
                }
            } catch (Exception e) {
                Error += "Đơn giá phải là số! \n";
            }
        }

        if (!Error.equals(
                "")) {
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
            txt_tenDA.setEditable(false);
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
        jLabel1 = new javax.swing.JLabel();
        txt_tenDA = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_maKMDA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_donGiaDA = new javax.swing.JTextField();
        sp_soluongDA = new javax.swing.JSpinner();
        btn_Items_chooseFile = new com.k33ptoo.components.KButton();
        jPanel8 = new javax.swing.JPanel();
        btn_Add = new com.k33ptoo.components.KButton();
        btn_Edit = new com.k33ptoo.components.KButton();
        btn_Delete = new com.k33ptoo.components.KButton();
        btn_Clear = new com.k33ptoo.components.KButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbo_kichcoDA = new javax.swing.JComboBox<>();
        cbo_loaiDA = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ITEMS");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("TÊN ĐỒ ĂN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("SÓ LƯỢNG");

        txt_maKMDA.setColumns(20);
        txt_maKMDA.setRows(5);
        jScrollPane1.setViewportView(txt_maKMDA);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("LOẠI ĐỒ ĂN");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_img, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("ĐƠN GIÁ");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("MÃ KHUYẾN MÃI");

        sp_soluongDA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sp_soluongDA.setPreferredSize(new java.awt.Dimension(7, 20));

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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("LOẠI");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("KÍCH CỠ");

        cbo_kichcoDA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHỌN KÍCH CỠ", "S", "M", "L" }));
        cbo_kichcoDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_kichcoDAActionPerformed(evt);
            }
        });

        cbo_loaiDA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CHỌN LOẠI", "SIÊU CAY", "PHÔ MAI", "CAY X2" }));
        cbo_loaiDA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_loaiDAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_donGiaDA, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_soluongDA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                    .addComponent(txt_tenDA)
                    .addComponent(cbo_kichcoDA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_loaiDA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 49, Short.MAX_VALUE)
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenDA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_loaiDA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_kichcoDA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sp_soluongDA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_donGiaDA, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Items_chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
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
                    hm.fillToTable_DA(listDA);
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
                    hm.fillToTable_DA(listDA);
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
            if (txt_tenDA.getText() != null && !txt_tenDA.getText().equals("")) {
                if (qldadao.selectebyID(txt_tenDA.getText()) != null) {
                    qldadao.delete(txt_tenDA.getText());
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

    private void cbo_kichcoDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_kichcoDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_kichcoDAActionPerformed

    private void cbo_loaiDAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_loaiDAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_loaiDAActionPerformed

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
    private javax.swing.JComboBox<String> cbo_kichcoDA;
    private javax.swing.JComboBox<String> cbo_loaiDA;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JSpinner sp_soluongDA;
    private javax.swing.JTextField txt_donGiaDA;
    private javax.swing.JTextArea txt_maKMDA;
    private javax.swing.JTextField txt_tenDA;
    // End of variables declaration//GEN-END:variables
}
