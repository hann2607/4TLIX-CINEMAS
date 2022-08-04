/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;

import com.qlrp.dao.QLPHIMDAO;
import com.qlrp.entity.PHIM;
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
public class NewMovie extends javax.swing.JFrame {

    /**
     * Creates new form NewMovie
     */
    File f = new File("");
    String duongdanBanner = "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\";
    String duongdanPoster = "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\";
    QLPHIMDAO qlphimdao = new QLPHIMDAO();
    List<PHIM> listPHIM = qlphimdao.selectAll();

    public NewMovie() {
        initComponents();
        init();
    }

    private void init() {
//        this.setAlwaysOnTop(true);
        this.setIconImage(XImage.getAppIcon());
        this.setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        setLocation(DEFAULT_CURSOR, 320);
        lbl_poster.setIcon(XImage.ResizeImage(lbl_poster.getWidth(), lbl_poster.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\FR2T-sKVEAAtkXR.jpg"));
        lbl_banner.setIcon(XImage.ResizeImage(lbl_banner.getWidth(), lbl_banner.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\1241136.png"));
//        fillToForm();
    }

    public void fillToForm() {
        PHIM movie = getInfo.movi;
        if (movie != null) {
            txt_maphim.setText(movie.getMA_PHIM());
            txt_ten.setText(movie.getTEN_PHIM());
            cbo_dinhdangphim.setSelectedItem(movie.getTEN_DINH_DANG_PHIM());
            sp_thoiluong.setValue(movie.getTHOI_LUONG_CHIEU());
            cbo_ngonngu.setSelectedItem(movie.getNGON_NGU());
            txt_loai.setText(movie.getLOAIPHIM());
            txt_DienVien.setText(movie.getDIENVIEN());
            cbo_quocgia.setSelectedItem(movie.getQUOCGIA());
            txt_nhasanxuat.setText(movie.getNHA_SAN_XUAT());
            lbl_poster.setText(movie.getPOSTER());
            cbo_gioihantuoi.setSelectedItem(movie.getGIOI_HAN_TUOI());
            dc_ngaycongchieu.setDate(movie.getNGAY_CONG_CHIEU());
            lbl_poster.setIcon(XImage.ResizeImage(lbl_poster.getWidth(), lbl_poster.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\" + movie.getPOSTER()));
            lbl_banner.setIcon(XImage.ResizeImage(lbl_banner.getWidth(), lbl_banner.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\" + movie.getBANNER()));
            txt_tomtat.setText(movie.getTOM_TAT());
        }
    }

    private void clearAll() {
        txt_maphim.setText("");
        txt_ten.setText("");
        cbo_dinhdangphim.setSelectedIndex(0);
        sp_thoiluong.setValue(0);
        cbo_ngonngu.setSelectedIndex(0);
        txt_loai.setText("");
        cbo_quocgia.setSelectedIndex(0);
        txt_nhasanxuat.setText("");
        cbo_gioihantuoi.setSelectedIndex(0);
        dc_ngaycongchieu.setDate(null);
        txt_DienVien.setText("");
        txt_tomtat.setText("");
        try {
            lbl_poster.setIcon(XImage.ResizeImage(lbl_poster.getWidth(), lbl_poster.getHeight(), f.getAbsolutePath() + duongdanPoster + "FR2T-sKVEAAtkXR.jpg"));
            lbl_banner.setIcon(XImage.ResizeImage(lbl_banner.getWidth(), lbl_banner.getHeight(), f.getAbsolutePath() + duongdanBanner + "1241136.png"));
        } catch (Exception e) {
        }
    }

    public void setForm(PHIM movie) {
        try {
            txt_maphim.setText(movie.getMA_PHIM());
            txt_ten.setText(movie.getTEN_PHIM());
            cbo_dinhdangphim.setSelectedItem(movie.getTEN_DINH_DANG_PHIM());
            sp_thoiluong.setValue(movie.getTHOI_LUONG_CHIEU());
            cbo_ngonngu.setSelectedItem(movie.getNGON_NGU());
            txt_loai.setText(movie.getLOAIPHIM());
            txt_DienVien.setText(movie.getDIENVIEN());
            cbo_quocgia.setSelectedItem(movie.getQUOCGIA());
            txt_nhasanxuat.setText(movie.getNHA_SAN_XUAT());
            lbl_poster.setText(movie.getPOSTER());
            cbo_gioihantuoi.setSelectedItem(movie.getGIOI_HAN_TUOI());
            dc_ngaycongchieu.setDate(movie.getNGAY_CONG_CHIEU());
            txt_tomtat.setText(movie.getTOM_TAT());
            lbl_poster.setIcon(XImage.ResizeImage(lbl_poster.getWidth(), lbl_poster.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\" + movie.getPOSTER()));
            lbl_banner.setIcon(XImage.ResizeImage(lbl_banner.getWidth(), lbl_banner.getHeight(), f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\" + movie.getBANNER()));
            duongDanPoster = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\" + movie.getPOSTER();
            duongDanBanner = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\" + movie.getBANNER();
        } catch (Exception e) {
        }
    }
    String duongDanPoster = null;
    String duongDanBanner = null;
    String maphim;

    private PHIM getForm() {
        PHIM movie = new PHIM();
        if (validateForm()) {
            movie.setMA_PHIM(txt_maphim.getText());
            movie.setTEN_PHIM(txt_ten.getText());
            movie.setNGON_NGU(cbo_ngonngu.getSelectedItem().toString());
            movie.setGIOI_HAN_TUOI(cbo_gioihantuoi.getSelectedItem().toString());
            movie.setQUOCGIA(cbo_quocgia.getSelectedItem().toString());
            movie.setTEN_DINH_DANG_PHIM(cbo_dinhdangphim.getSelectedItem().toString());
            movie.setTHOI_LUONG_CHIEU(sp_thoiluong.getValue().hashCode());
            movie.setLOAIPHIM(txt_loai.getText());
            movie.setDIENVIEN(txt_DienVien.getText());
            movie.setNHA_SAN_XUAT(txt_nhasanxuat.getText());
            movie.setNGAY_CONG_CHIEU(dc_ngaycongchieu.getDate());
            movie.setTOM_TAT(txt_tomtat.getText());
            if (txt_maphim.getText().isEmpty()) {
                maphim = null;
            } else {
                maphim = txt_maphim.getText();
            }
            movie.setMA_PHIM(maphim);

            try {
                movie.setPOSTER(duongDanPoster.substring(duongDanPoster.lastIndexOf("\\") + 1, duongDanPoster.length()));
                movie.setBANNER(duongDanBanner.substring(duongDanBanner.lastIndexOf("\\") + 1, duongDanBanner.length()));
            } catch (Exception e) {
                movie.setPOSTER(null);
                movie.setBANNER(null);
            }
        } else {
            return null;
        }
        return movie;
    }

    private boolean validateForm() {
        String Error = "";
        if (txt_ten.getText().equals("")) {
            Error += "Tên phim trống! \n";
            txt_ten.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_ten.grabFocus();
        }
        if (txt_maphim.getText().equals("")) {
            Error += "Mã phim trống! \n";
            txt_maphim.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_maphim.grabFocus();
        }
        if (cbo_dinhdangphim.getSelectedIndex() == 0) {
            Error += "Định dạng phim trống! \n";
            cbo_dinhdangphim.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_dinhdangphim.grabFocus();
        }

        try {
            int thoiluong = sp_thoiluong.getValue().hashCode();
            if (thoiluong < 0) {
                Error += "Thời lượng phải lớn hơn 0! \n";
                sp_thoiluong.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
                sp_thoiluong.grabFocus();
            }
        } catch (Exception e) {
            Error += "Thời lượng phải là số! \n";
            sp_thoiluong.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            sp_thoiluong.grabFocus();
        }

        if (cbo_ngonngu.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn ngôn ngữ! \n";
            cbo_ngonngu.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_ngonngu.grabFocus();
        }
        if (cbo_quocgia.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn quốc gia! \n";
            cbo_quocgia.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_quocgia.grabFocus();
        }
        if (txt_loai.getText()
                .equals("")) {
            Error += "Loại phim trống! \n";
            txt_loai.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_loai.grabFocus();
        }
        if (txt_nhasanxuat.getText()
                .equals("")) {
            Error += "Nhà sản xuất phim trống! \n";
            txt_nhasanxuat.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_nhasanxuat.grabFocus();
        }
        if (cbo_gioihantuoi.getSelectedIndex() == 0) {
            Error += "Vui lòng chọn giới hạn độ tuổi! \n";
            cbo_gioihantuoi.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            cbo_gioihantuoi.grabFocus();
        }
        if (dc_ngaycongchieu.getDate() == null) {
            Error += "Ngày sản xuất phim trống! \n";
            dc_ngaycongchieu.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            dc_ngaycongchieu.grabFocus();
        }
        if (txt_DienVien.getText().equals("")) {
            Error += "Vui lòng nhập tên diễn viên! \n";
            txt_DienVien.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_DienVien.grabFocus();
        }
        if (txt_tomtat.getText().equals("")) {
            Error += "Vui lòng nhập tóm tắt phim! \n";
            txt_tomtat.setBorder(new MatteBorder(0, 0, 2, 0, Color.RED));
            txt_tomtat.grabFocus();
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
            txt_maphim.setEditable(false);
            btn_Edit.setEnabled(true);
            btn_Edit.setVisible(true);
            btn_Delete.setEnabled(true);
            btn_Delete.setVisible(true);
        }
    }

    private void clearform() {

        txt_maphim.setText("");
        txt_ten.setText("");
        cbo_dinhdangphim.setSelectedIndex(0);
        sp_thoiluong.setValue(0);
        cbo_ngonngu.setSelectedIndex(0);
        txt_loai.setText("");
        cbo_quocgia.setSelectedIndex(0);
        txt_nhasanxuat.setText("");
        cbo_gioihantuoi.setSelectedIndex(0);
        dc_ngaycongchieu.setDate(null);
        txt_DienVien.setText("");
        txt_tomtat.setText("");

    }

    void insert() {
        PHIM mov = getForm();
        //    System.out.print("da add");

        try {
            qlphimdao.insert(mov);

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

        jPanel1 = new javax.swing.JPanel();
        lbl_banner = new javax.swing.JLabel();
        lbl_poster = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_ten = new javax.swing.JLabel();
        lbl_ten2 = new javax.swing.JLabel();
        lbl_ten3 = new javax.swing.JLabel();
        lbl_ten4 = new javax.swing.JLabel();
        lbl_ten5 = new javax.swing.JLabel();
        lbl_ten6 = new javax.swing.JLabel();
        lbl_ten7 = new javax.swing.JLabel();
        lbl_ten9 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        txt_loai = new javax.swing.JTextField();
        cbo_quocgia = new RSMaterialComponent.RSComboBox();
        cbo_gioihantuoi = new RSMaterialComponent.RSComboBox();
        txt_nhasanxuat = new javax.swing.JTextField();
        cbo_ngonngu = new RSMaterialComponent.RSComboBox();
        jPanel3 = new javax.swing.JPanel();
        lbl_ten11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_tomtat = new javax.swing.JTextPane();
        lbl_ten12 = new javax.swing.JLabel();
        lbl_ten10 = new javax.swing.JLabel();
        txt_maphim = new javax.swing.JTextField();
        dc_ngaycongchieu = new newscomponents.RSDateChooserModern();
        sp_thoiluong = new javax.swing.JSpinner();
        lbl_ten8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_DienVien = new javax.swing.JTextPane();
        cbo_dinhdangphim = new RSMaterialComponent.RSComboBox();
        jLabel2 = new javax.swing.JLabel();
        btn_Image_Poster = new rsbuttongradiente.RSButtonGradiente();
        btn_Images_Banner = new rsbuttongradiente.RSButtonGradiente();
        btn_Add = new rsbuttongradiente.RSButtonGradiente();
        btn_Edit = new rsbuttongradiente.RSButtonGradiente();
        btn_Clear = new rsbuttongradiente.RSButtonGradiente();
        btn_Delete = new rsbuttongradiente.RSButtonGradiente();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_banner.setBackground(new java.awt.Color(255, 255, 255));
        lbl_banner.setForeground(new java.awt.Color(255, 255, 255));
        lbl_banner.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_poster.setBackground(new java.awt.Color(255, 255, 255));
        lbl_poster.setForeground(new java.awt.Color(255, 255, 255));
        lbl_poster.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_ten.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten.setText("QUỐC GIA");
        jPanel2.add(lbl_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 22, 150, 40));

        lbl_ten2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten2.setText("DIỄN VIÊN");
        jPanel2.add(lbl_ten2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 390, 150, 40));

        lbl_ten3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten3.setText("NGÀY CÔNG CHIẾU");
        jPanel2.add(lbl_ten3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 128, 150, 40));

        lbl_ten4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten4.setText("LOẠI PHIM");
        jPanel2.add(lbl_ten4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 179, 150, 40));

        lbl_ten5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten5.setText("THỜI LƯỢNG");
        jPanel2.add(lbl_ten5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 239, 150, 40));

        lbl_ten6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten6.setText("TÊN PHIM");
        jPanel2.add(lbl_ten6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 75, 150, 40));

        lbl_ten7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten7.setText("GIỚI HẠN TUỔI");
        jPanel2.add(lbl_ten7, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 128, 150, 40));

        lbl_ten9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten9.setText("NHÀ SẢN XUẤT");
        jPanel2.add(lbl_ten9, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 75, 150, 40));
        jPanel2.add(txt_ten, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 77, 328, 40));
        jPanel2.add(txt_loai, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 181, 328, 40));

        cbo_quocgia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Quốc gia sản xuất", "Mỹ", "Hàn", "Vương Quốc Anh", "Việt Nam" }));
        cbo_quocgia.setColorFondo(new java.awt.Color(102, 102, 255));
        jPanel2.add(cbo_quocgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 23, 328, 40));

        cbo_gioihantuoi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giới hạn tuổi", "13", "16", "18" }));
        cbo_gioihantuoi.setColorFondo(new java.awt.Color(102, 102, 255));
        jPanel2.add(cbo_gioihantuoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 132, 328, 40));
        jPanel2.add(txt_nhasanxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 81, 328, 40));

        cbo_ngonngu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ngôn ngữ", "Tiếng Anh", "Tiếng Việt", "Tiếng Nhật Bản" }));
        cbo_ngonngu.setColorFondo(new java.awt.Color(102, 102, 255));
        jPanel2.add(cbo_ngonngu, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 184, 328, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);

        lbl_ten11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten11.setText("TÓM TẮT");

        jScrollPane2.setViewportView(txt_tomtat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_ten11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_ten11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(658, 242, -1, 238));

        lbl_ten12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten12.setText("NGÔN NGỮ");
        jPanel2.add(lbl_ten12, new org.netbeans.lib.awtextra.AbsoluteConstraints(655, 183, 150, 40));

        lbl_ten10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten10.setText("MÃ PHIM");
        jPanel2.add(lbl_ten10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 22, 150, 51));
        jPanel2.add(txt_maphim, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 22, 328, 40));

        dc_ngaycongchieu.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.add(dc_ngaycongchieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 128, 328, 40));

        sp_thoiluong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sp_thoiluong.setPreferredSize(new java.awt.Dimension(7, 20));
        sp_thoiluong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sp_thoiluongKeyReleased(evt);
            }
        });
        jPanel2.add(sp_thoiluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 241, 328, 40));

        lbl_ten8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_ten8.setText("ĐỊNH DẠNG PHIM");
        jPanel2.add(lbl_ten8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 303, 150, 40));

        jScrollPane1.setViewportView(txt_DienVien);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 371, 328, 75));

        cbo_dinhdangphim.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Định dạng phim", "Phim 3D", "Phim 2D", "Phim IMAX" }));
        cbo_dinhdangphim.setColorFondo(new java.awt.Color(102, 102, 255));
        jPanel2.add(cbo_dinhdangphim, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 304, 328, 40));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 2, 1190, 480));

        btn_Image_Poster.setText("CHỌN ẢNH");
        btn_Image_Poster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Image_PosterActionPerformed(evt);
            }
        });

        btn_Images_Banner.setText("CHỌN ẢNH");
        btn_Images_Banner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Images_BannerActionPerformed(evt);
            }
        });

        btn_Add.setText("THÊM");
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });

        btn_Edit.setText("SỬA");
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });

        btn_Clear.setText("LÀM MỚI");
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });

        btn_Delete.setText("XÓA");
        btn_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lbl_poster, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107)
                        .addComponent(lbl_banner, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btn_Image_Poster, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(371, 371, 371)
                        .addComponent(btn_Images_Banner, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_banner, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_poster, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(btn_Add, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Clear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Image_Poster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Images_Banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DeleteActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            if (txt_maphim.getText() != null && !txt_maphim.getText().equals("")) {
                if (qlphimdao.selectebyID(txt_maphim.getText()) != null) {
                    qlphimdao.delete(txt_maphim.getText());
                    MsgBox.alert(this, "Xóa thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Bộ phim không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tên bộ phim không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            MsgBox.alert(this, "You can only Add. If you want to edit, please choose again!");
        }
    }//GEN-LAST:event_btn_DeleteActionPerformed

    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            clearAll();
        } else {
            this.clearAll();
        }
    }//GEN-LAST:event_btn_ClearActionPerformed

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed
        // TODO add your handling code here:
        if (btn_Edit.isEnabled()) {
            PHIM mov = getForm();
            if (mov != null) {
                if (qlphimdao.selectebyID(mov.getMA_PHIM()) != null) {
                    qlphimdao.update(mov);
                    MsgBox.alert(this, "Cập nhật thành công!");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Bộ phim này không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            MsgBox.alert(this, "You can only Add. If you want to edit, please choose again!");
        }
    }//GEN-LAST:event_btn_EditActionPerformed

    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        // TODO add your handling code here:
        if (btn_Add.isEnabled()) {
            PHIM mov = getForm();
            if (mov != null) {
                if (qlphimdao.selectebyID(mov.getMA_PHIM()) == null) {
                    qlphimdao.insert(mov);
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

    private void btn_Images_BannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Images_BannerActionPerformed
        // TODO add your handling code here:
        chooseImageBanner();
    }//GEN-LAST:event_btn_Images_BannerActionPerformed

    private void btn_Image_PosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Image_PosterActionPerformed
        // TODO add your handling code here:
        chooseImagePoster();
    }//GEN-LAST:event_btn_Image_PosterActionPerformed

    private void sp_thoiluongKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sp_thoiluongKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_sp_thoiluongKeyReleased

    private void chooseImagePoster() {
        duongDanPoster = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\";
        try {
            JFileChooser fc = new JFileChooser(f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\POSTER\\");
            fc.setDialogTitle("Open File");
            fc.showOpenDialog(null);

            File fTenAnh = fc.getSelectedFile();
            duongDanPoster = fTenAnh.getAbsolutePath();
            if (duongDanPoster != null) {
                lbl_poster.setIcon(ResizeImage(lbl_poster.getWidth(), lbl_poster.getHeight(), String.valueOf(duongDanPoster)));
                System.out.println(duongDanPoster);
            } else {
                System.out.println("Image not selected!");
            }
        } catch (Exception e) {
            System.out.println("Image not selected!");
            System.out.println(duongDanPoster);
        }
    }

    private void chooseImageBanner() {
        duongDanBanner = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\";
        try {
            JFileChooser fc = new JFileChooser(f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\PHIM\\BANNER\\");
            fc.setDialogTitle("Open File");
            fc.showOpenDialog(null);

            File fTenAnh = fc.getSelectedFile();
            duongDanBanner = fTenAnh.getAbsolutePath();
            if (duongDanBanner != null) {
                lbl_banner.setIcon(ResizeImage(lbl_banner.getWidth(), lbl_banner.getHeight(), String.valueOf(duongDanBanner)));
                System.out.println(duongDanBanner);
            } else {
                System.out.println("Image not selected!");
            }
        } catch (Exception e) {
            System.out.println("Image not selected!");
            System.out.println(duongDanBanner);
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
            java.util.logging.Logger.getLogger(NewMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMovie.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new NewMovie().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttongradiente.RSButtonGradiente btn_Add;
    private rsbuttongradiente.RSButtonGradiente btn_Clear;
    private rsbuttongradiente.RSButtonGradiente btn_Delete;
    private rsbuttongradiente.RSButtonGradiente btn_Edit;
    private rsbuttongradiente.RSButtonGradiente btn_Image_Poster;
    private rsbuttongradiente.RSButtonGradiente btn_Images_Banner;
    private RSMaterialComponent.RSComboBox cbo_dinhdangphim;
    private RSMaterialComponent.RSComboBox cbo_gioihantuoi;
    private RSMaterialComponent.RSComboBox cbo_ngonngu;
    private RSMaterialComponent.RSComboBox cbo_quocgia;
    private newscomponents.RSDateChooserModern dc_ngaycongchieu;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_banner;
    private javax.swing.JLabel lbl_poster;
    private javax.swing.JLabel lbl_ten;
    private javax.swing.JLabel lbl_ten10;
    private javax.swing.JLabel lbl_ten11;
    private javax.swing.JLabel lbl_ten12;
    private javax.swing.JLabel lbl_ten2;
    private javax.swing.JLabel lbl_ten3;
    private javax.swing.JLabel lbl_ten4;
    private javax.swing.JLabel lbl_ten5;
    private javax.swing.JLabel lbl_ten6;
    private javax.swing.JLabel lbl_ten7;
    private javax.swing.JLabel lbl_ten8;
    private javax.swing.JLabel lbl_ten9;
    private javax.swing.JSpinner sp_thoiluong;
    private javax.swing.JTextPane txt_DienVien;
    private javax.swing.JTextField txt_loai;
    private javax.swing.JTextField txt_maphim;
    private javax.swing.JTextField txt_nhasanxuat;
    private javax.swing.JTextField txt_ten;
    private javax.swing.JTextPane txt_tomtat;
    // End of variables declaration//GEN-END:variables
}
