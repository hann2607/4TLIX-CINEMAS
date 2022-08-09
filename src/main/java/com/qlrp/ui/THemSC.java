/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;


import com.qlrp.dao.QLSUATCHIEUDAO;
import com.qlrp.entity.SUATCHIEU;
import com.qlrp.utils.MsgBox;
import com.qlrp.utils.XImage;
import static com.qlrp.utils.XImage.ResizeImage;
import com.qlrp.utils.getInfo;
import java.awt.Color;
import java.io.File;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.border.MatteBorder;

/**
 *
 * @author duong
 */
public class THemSC extends javax.swing.JFrame {

    /**
     * Creates new form NewMovie
     */
    File f = new File("");
    QLSUATCHIEUDAO qlsuatchieudao = new QLSUATCHIEUDAO();
    List<SUATCHIEU> listSC = qlsuatchieudao.selectAll();

    public THemSC() {
        initComponents();
        init();
    }

    private void init() {
        this.setIconImage(XImage.getAppIcon());
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
      
    }

    public void fillToForm() {
        SUATCHIEU sc = getInfo.sc;
        if (sc != null) {
            txt_maSC.setText(sc.getMA_SUAT_CHIEU());
            txt_MAPC.setText(sc.getMA_PHONG_CHIEU());
            txt_tenddphim1.setText(sc.getTEN_DINH_DANG_PHIM());
            txt_MaPhim.setText(sc.getMA_PHIM());
            cbo_GioBD.setSelectedItem(sc.getGIO_BAT_DAU());
            cbo_GioKT.setSelectedItem(sc.getGIO_KET_THUC());
            dc_ngaychieu1.setDate(sc.getNGAY_CHIEU()); 
        }
    }

    private void clearAll() {
       txt_maSC.setText("");
       txt_MAPC.setText("");
       txt_tenddphim1.setText("");
       txt_MaPhim.setText("");
       cbo_GioBD.setSelectedIndex(0);
       cbo_GioKT.setSelectedIndex(0);
       dc_ngaychieu1.setDate(null);
    }

    public void setForm(SUATCHIEU sc) {
        try {
            txt_maSC.setText(sc.getMA_SUAT_CHIEU());
            txt_MAPC.setText(sc.getMA_PHONG_CHIEU());
            txt_tenddphim1.setText(sc.getTEN_DINH_DANG_PHIM());
            txt_MaPhim.setText(sc.getMA_PHIM());
            cbo_GioBD.setSelectedItem(sc.getGIO_BAT_DAU());
            cbo_GioKT.setSelectedItem(sc.getGIO_KET_THUC());
            dc_ngaychieu1.setDate(sc.getNGAY_CHIEU());
        } catch (Exception e) {
        }
    }
   

    private SUATCHIEU getForm() {
         SUATCHIEU sc = new SUATCHIEU();
        if (validateForm()) {
            sc.setMA_SUAT_CHIEU(txt_maSC.getText());
            sc.setMA_PHONG_CHIEU(txt_MAPC.getText());
            sc.setTEN_DINH_DANG_PHIM(txt_tenddphim1.getText());
            sc.setMA_PHIM(txt_MaPhim.getText());
//            sc.setGIO_BAT_DAU(cbo_GioBD.getSelectedItem());
            sc.setNGAY_CHIEU(dc_ngaychieu1.getDate());
        } else {
            return null;
        }
        return sc;
    }

    

    public void setEnableButton(String addorEdit) {
        if (addorEdit.equalsIgnoreCase("add")) {
            clearAll();
        } else if (addorEdit.equalsIgnoreCase("edit")) {
            btn_Add.setEnabled(false);
            btn_Add.setVisible(false);
            txt_maSC.setEditable(false);
        }
    }

    private void clearform() {
        txt_maSC.setText("");
        txt_MAPC.setText("");
        txt_tenddphim1.setText("");
        txt_MaPhim.setText("");
        cbo_GioBD.setSelectedIndex(0);
        cbo_GioKT.setSelectedIndex(0);
        dc_ngaychieu1.setDate(null);
    }
    
    private boolean validateForm() {
        String Error = "";
        if (txt_maSC.getText().equals("")) {
            Error += "Ma suat chieu không được trống! \n";
        }
        if (txt_MAPC.getText().equals("")) {
            Error += "Mã Phong chieu không được trống! \n";
        }
        if (txt_tenddphim1.getText().equals("")) {
            Error += "Tên định dạng phim không được trống! \n";
        }
        if (txt_MaPhim.getText().equals("")) {
            Error += "Mã phim trống! \n";
        }
         if (cbo_GioBD.getSelectedIndex() == 0) {
            Error += "Gio bat dau không duoc trong! \n";
            cbo_GioBD.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_GioBD.grabFocus();
        }
        if (cbo_GioKT.getSelectedIndex() == 0) {
            Error += "Gio ket thuc không duoc trong! \n";
            cbo_GioKT.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_GioKT.grabFocus();
        }
        if (dc_ngaychieu1.getDate() == null) {
            Error += "Ngày Chieu phim không duoc trong! \n";
            dc_ngaychieu1.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            dc_ngaychieu1.grabFocus();
        }
        if (!Error.equals("")) {
            JOptionPane.showMessageDialog(this, Error, "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;   
}
    

    void insert() {
        SUATCHIEU sc = getForm();
        //    System.out.print("da add");

        try {
            qlsuatchieudao.insert(sc);

            this.clearform();
            MsgBox.alert(this, "Thêm mới thành công!");
        } catch (Exception e) {
            MsgBox.alert(this, "Thêm mới thất bại");
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

        jPanel2 = new javax.swing.JPanel();
        lbl_ten3 = new javax.swing.JLabel();
        lbl_ten6 = new javax.swing.JLabel();
        txt_MaPhim = new javax.swing.JTextField();
        lbl_ten10 = new javax.swing.JLabel();
        txt_maSC = new javax.swing.JTextField();
        lbl_ten8 = new javax.swing.JLabel();
        dc_ngaychieu1 = new newscomponents.RSDateChooserModern();
        lbl_ten9 = new javax.swing.JLabel();
        lbl_ten11 = new javax.swing.JLabel();
        lbl_ten12 = new javax.swing.JLabel();
        btn_Add = new rsbuttongradiente.RSButtonGradiente();
        btn_Restart = new rsbuttongradiente.RSButtonGradiente();
        txt_MAPC = new javax.swing.JTextField();
        txt_tenddphim1 = new javax.swing.JTextField();
        cbo_GioBD = new RSMaterialComponent.RSComboBox();
        cbo_GioKT = new RSMaterialComponent.RSComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ten3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten3.setText("NGÀY CHIẾU");
        jPanel2.add(lbl_ten3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 150, 40));

        lbl_ten6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten6.setText("MÃ PHÒNG CHIẾU");
        jPanel2.add(lbl_ten6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 75, 150, 40));
        jPanel2.add(txt_MaPhim, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 328, 40));

        lbl_ten10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten10.setText("MÃ SUẤT CHIẾU");
        jPanel2.add(lbl_ten10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 22, 150, 51));
        jPanel2.add(txt_maSC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 328, 40));

        lbl_ten8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten8.setText("MÃ PHIM");
        jPanel2.add(lbl_ten8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 40));

        dc_ngaychieu1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.add(dc_ngaychieu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 328, 40));

        lbl_ten9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten9.setText("TÊN ĐỊNH DẠNG PHIM");
        jPanel2.add(lbl_ten9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 170, 40));

        lbl_ten11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten11.setText("GIỜ KẾT THÚC");
        jPanel2.add(lbl_ten11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 170, 40));

        lbl_ten12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten12.setText("GIỜ BẮT ĐẦU");
        jPanel2.add(lbl_ten12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 170, 40));

        btn_Add.setText("THÊM");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 150, 40));

        btn_Restart.setText("LÀM MỚI");
        btn_Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RestartActionPerformed(evt);
            }
        });
        jPanel2.add(btn_Restart, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 160, 40));
        jPanel2.add(txt_MAPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 328, 40));
        jPanel2.add(txt_tenddphim1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 328, 40));

        cbo_GioBD.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giờ Bắt Đầu", "15:00", "20:00", "9:00", "10:00", "10:30", "16:30", "13:45" }));
        cbo_GioBD.setColorFondo(new java.awt.Color(102, 102, 255));
        jPanel2.add(cbo_GioBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 328, 40));

        cbo_GioKT.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giờ kết thúc", "16:45", "11:00", "12:45", "18:45", "22:45", "15:00" }));
        cbo_GioKT.setColorFondo(new java.awt.Color(102, 102, 255));
        jPanel2.add(cbo_GioKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 328, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
         if (btn_Add.isEnabled()) {
            SUATCHIEU sc = getForm();
            if (sc != null) {
                if (qlsuatchieudao.selectebyID(sc.getMA_SUAT_CHIEU()) == null) {
                    qlsuatchieudao.insert(sc);
                    MsgBox.alert(this, "Thêm thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Bộ phim này đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            MsgBox.alert(this, "You can only edit. If you want to add, please choose again!");
        }
    }//GEN-LAST:event_btn_AddActionPerformed

    private void btn_RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RestartActionPerformed
        List<SUATCHIEU> listSC = qlsuatchieudao.selectAll();
        clearform();
    }//GEN-LAST:event_btn_RestartActionPerformed

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new THemSC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttongradiente.RSButtonGradiente btn_Add;
    private rsbuttongradiente.RSButtonGradiente btn_Restart;
    private RSMaterialComponent.RSComboBox cbo_GioBD;
    private RSMaterialComponent.RSComboBox cbo_GioKT;
    private newscomponents.RSDateChooserModern dc_ngaychieu1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_ten10;
    private javax.swing.JLabel lbl_ten11;
    private javax.swing.JLabel lbl_ten12;
    private javax.swing.JLabel lbl_ten3;
    private javax.swing.JLabel lbl_ten6;
    private javax.swing.JLabel lbl_ten8;
    private javax.swing.JLabel lbl_ten9;
    private javax.swing.JTextField txt_MAPC;
    private javax.swing.JTextField txt_MaPhim;
    private javax.swing.JTextField txt_maSC;
    private javax.swing.JTextField txt_tenddphim1;
    // End of variables declaration//GEN-END:variables
}
