/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlbh.ui;

import com.qlbh.dao.QLKHODAO;
import com.qlbh.entity.INVENTORY;
import com.qlbh.utils.MsgBox;
import com.qlbh.utils.XImage;
import static com.qlbh.utils.XImage.ResizeImage;
import com.qlbh.utils.getInfo;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public final class NewItems_Inventory extends javax.swing.JFrame {

    /**
     * Creates new form NewOrder
     */
    File f = new File("");
    String duongdanBanner = "\\src\\main\\resources\\com\\qlbh\\Image\\Inventory\\";
    QLKHODAO qlkhodao = new QLKHODAO();
    List<INVENTORY> listSP = qlkhodao.selectAll();
//    home hm = new home();

    public NewItems_Inventory() {
        initComponents();
        init();
    }

    public void fillToForm() {
        INVENTORY inv = getInfo.inventory;
        if (inv != null) {
            txt_ID.setText(inv.getMASP());
            txt_Name.setText(inv.getTENSP());
            sp_QTY.setValue(inv.getSOLUONG());
            txt_Price.setText(inv.getDONGIA() + "");
            txt_Note.setText(inv.getGHICHU());
            lbl_img.setIcon((XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\Image\\Inventory\\" + inv.getHINH())));
        }
    }

    private void init() {
        this.setAlwaysOnTop(true);
        this.setIconImage(XImage.getAppIcon());
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation(DEFAULT_CURSOR, 320);
        lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\Image\\Inventory\\product.jpg"));
        fillToForm();
    }

    private void clearAll() {
        txt_ID.setText("");
        txt_Name.setText("");
        sp_QTY.setValue(0);
        txt_Price.setText("");
        txt_Note.setText("");
        try {
            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + "product.jpg"));
        } catch (Exception e) {
        }
    }

    private void clearEdit() {
        txt_ID.setText("");
        txt_Name.setText("");
        sp_QTY.setValue(0);
        txt_Price.setText("");
        txt_Note.setText("");
        try {

            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + "product.jpg"));
        } catch (Exception e) {
        }
    }

    public void setForm(INVENTORY inv) {
        try {
            txt_ID.setText(inv.getMASP());
            txt_Name.setText(inv.getTENSP());
            sp_QTY.setValue(inv.getSOLUONG());
            txt_Price.setText(inv.getDONGIA() + "");
            txt_Note.setText(inv.getGHICHU());
            lbl_img.setIcon(XImage.ResizeImage(lbl_img.getWidth(), lbl_img.getHeight(), f.getAbsolutePath() + duongdanBanner + inv.getHINH()));
        } catch (Exception e) {
        }
    }
    String duongDanImage = null;

    private INVENTORY getForm() {
        INVENTORY inv = new INVENTORY();
        if (validateForm()) {
            inv.setMASP(txt_ID.getText());
            inv.setTENSP(txt_Name.getText());
            inv.setSOLUONG(sp_QTY.getValue().hashCode());
            inv.setDONGIA(Double.valueOf(txt_Price.getText()));
            inv.setGHICHU(txt_Note.getText());

            try {
                inv.setHINH(duongDanImage.substring(duongDanImage.lastIndexOf("\\") + 1, duongDanImage.length()));
            } catch (Exception e) {
                inv.setHINH(null);
            }
        } else {
            return null;
        }
        return inv;
    }
    double price = 0;

    private boolean validateForm() {
        String Error = "";
        if (txt_ID.getText().equals("")) {
            Error += "Product ID not null! \n";
        }
        if (txt_Name.getText().equals("")) {
            Error += "Product Name not null! \n";
        }
        int qty = sp_QTY.getValue().hashCode();
        if (qty <= 0) {
            Error += "The QTY is not equal to 0 ! \n";
        }

        if (txt_Price.getText().equals("")) {
            Error += "Price not null! \n";
        } else {
            try {
                price = Double.parseDouble(txt_Price.getText());
                if (price < 0) {
                    Error += "Price must be greater than 0! \n";
                }
            } catch (Exception e) {
                Error += "Price must be number! \n";
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
            txt_ID.setEditable(true);
            btn_Edit.setEnabled(false);
            btn_Edit.setVisible(false);
            btn_Delete.setEnabled(false);
            btn_Delete.setVisible(false);
            btn_Add.setEnabled(true);
            btn_Add.setVisible(true);
            btn_Clear.setVisible(true);
            btn_Clear.setEnabled(true);
            btn_New.setVisible(false);
            btn_New.setEnabled(false);
            clearEdit();
        } else if (addorEdit.equalsIgnoreCase("edit")) {
            txt_ID.setEditable(false);
            btn_Add.setEnabled(false);
            btn_Add.setVisible(false);
            btn_Clear.setVisible(false);
            btn_Clear.setEnabled(false);
            btn_Edit.setEnabled(true);
            btn_Edit.setVisible(true);
            btn_Delete.setEnabled(true);
            btn_Delete.setVisible(true);
            btn_New.setVisible(true);
            btn_New.setEnabled(true);
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
        txt_ID = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Note = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_img = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_Price = new javax.swing.JTextField();
        sp_QTY = new javax.swing.JSpinner();
        btn_Items_chooseFile = new com.k33ptoo.components.KButton();
        jPanel8 = new javax.swing.JPanel();
        btn_New = new com.k33ptoo.components.KButton();
        btn_Add = new com.k33ptoo.components.KButton();
        btn_Edit = new com.k33ptoo.components.KButton();
        btn_Delete = new com.k33ptoo.components.KButton();
        btn_Clear = new com.k33ptoo.components.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ITEMS");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("PRODUCT ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("PRODUCT NAME");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("QUANTITY");

        txt_Note.setColumns(20);
        txt_Note.setRows(5);
        jScrollPane1.setViewportView(txt_Note);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("ITEMS");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        lbl_img.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_img, java.awt.BorderLayout.CENTER);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("PRICE");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("NOTE");

        sp_QTY.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sp_QTY.setPreferredSize(new java.awt.Dimension(7, 20));

        btn_Items_chooseFile.setText("CHOOSE FILE");
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

        btn_New.setText("NEW");
        btn_New.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_New.setkEndColor(new java.awt.Color(0, 112, 192));
        btn_New.setkHoverEndColor(new java.awt.Color(0, 30, 153));
        btn_New.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_New.setkHoverStartColor(new java.awt.Color(0, 30, 153));
        btn_New.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_New.setkStartColor(new java.awt.Color(0, 79, 174));
        btn_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewActionPerformed(evt);
            }
        });
        jPanel8.add(btn_New);

        btn_Add.setText("ADD");
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

        btn_Edit.setText("EDIT");
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

        btn_Delete.setText("DELETE");
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

        btn_Clear.setText("CLEAR");
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
                    .addComponent(jLabel5)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_ID, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_Price, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sp_QTY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_Name, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addGap(0, 53, Short.MAX_VALUE)
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
                            .addComponent(txt_ID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sp_QTY, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Items_chooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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
            INVENTORY inv = getForm();
            if (inv != null) {
                if (qlkhodao.selectebyID(inv.getMASP()) == null) {
                    qlkhodao.insert(inv);
                    MsgBox.alert(this, "Insert Successfully!");
//                    hm.fillToTable_Kho(listSP);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Product already exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            MsgBox.alert(this, "You can only edit. If you want to add, please choose again!");
        }
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            INVENTORY inv = getForm();
            if (inv != null) {
                if (qlkhodao.selectebyID(inv.getMASP()) != null) {
                    qlkhodao.update(inv);
                    MsgBox.alert(this, "Update Successfully!");
//                    hm.fillToTable_Kho(listSP);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Product doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            MsgBox.alert(this, "You can only Add. If you want to edit, please choose again!");
        }
    }//GEN-LAST:event_btn_EditActionPerformed

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            if (txt_ID.getText() != null && !txt_ID.getText().equals("")) {
                if (qlkhodao.selectebyID(txt_ID.getText()) != null) {
                    qlkhodao.delete(txt_ID.getText());
                    MsgBox.alert(this, "Delete Successfully!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Product doesn't exist!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Employee ID cannot be blank!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            MsgBox.alert(this, "You can only Add. If you want to edit, please choose again!");
        }

    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        if (btn_Edit.isEnabled()) {
            clearEdit();
        } else {
            this.clearAll();
        }
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_Items_chooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Items_chooseFileActionPerformed
        // TODO add your handling code here:
        chooseImage();

    }//GEN-LAST:event_btn_Items_chooseFileActionPerformed

    private void btn_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewActionPerformed
        setEnableButton("add");
    }//GEN-LAST:event_btn_NewActionPerformed

    private void chooseImage() {
        duongDanImage = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\Image\\Inventory\\";
        try {
            JFileChooser fc = new JFileChooser(f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlbh\\Image\\Inventory\\");
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
            java.util.logging.Logger.getLogger(NewItems_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewItems_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewItems_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewItems_Inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewItems_Inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_Add;
    private com.k33ptoo.components.KButton btn_Clear;
    private com.k33ptoo.components.KButton btn_Delete;
    private com.k33ptoo.components.KButton btn_Edit;
    private com.k33ptoo.components.KButton btn_Items_chooseFile;
    private com.k33ptoo.components.KButton btn_New;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_img;
    private javax.swing.JSpinner sp_QTY;
    private javax.swing.JTextField txt_ID;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextArea txt_Note;
    private javax.swing.JTextField txt_Price;
    // End of variables declaration//GEN-END:variables
}
