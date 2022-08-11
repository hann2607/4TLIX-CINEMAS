/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;

import com.qlrp.dao.HOADONCHITIETDAO;
import com.qlrp.dao.HOADONKHACHHANGDAO;
import com.qlrp.entity.GIOHANG_DOAN;
import com.qlrp.entity.GIOHANG_PHIM;
import com.qlrp.entity.HOADON_CT;
import com.qlrp.entity.HOADON_KH;
import com.qlrp.entity.KHACHHANG;
import com.qlrp.utils.Auth;
import com.qlrp.utils.XImage;
import com.qlrp.utils.getInfo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

/**
 *
 * @author ACER
 */
public final class KH_HoaDon extends javax.swing.JFrame {

    /**
     * Creates new form KH_HoaDon
     */
    DefaultTableModel model;
    HOADONKHACHHANGDAO hdkhdao = new HOADONKHACHHANGDAO();
    HOADONCHITIETDAO hdctdao = new HOADONCHITIETDAO();
    List<HOADON_KH> listHDKH = new ArrayList<>();
    List<HOADON_CT> listHDCT = new ArrayList<>();
    DecimalFormat formatter = new DecimalFormat("###,###,###");

    public KH_HoaDon() {
        initComponents();
        init();
    }

    private void init() {
        this.setIconImage(XImage.getAppIcon());
        this.setCursor(XImage.setCursor());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        fillThongTin_HoaDon();

    }

    private void autoCreateMaHD() {
        String maHD;
        while (true) {
            Random rand = new Random();
            int ranNum = rand.nextInt(100000) + 1;
            maHD = "HD" + ranNum;
            if (hdkhdao.selectebyID(maHD) == null) {
                break;
            }
        }
        lbl_maHD.setText(maHD);
    }

    private void autoCreateMaHDCT() {
        String maHDCT;
        while (true) {
            Random rand = new Random();
            int ranNum = rand.nextInt(100000) + 1;
            maHDCT = "HDCT" + ranNum;
            if (hdkhdao.selectebyID(maHDCT) == null) {
                break;
            }
        }
        lbl_maHDCT.setText(maHDCT);
    }

    public void fillThongTin_HoaDon() {
        // Đổ dữ liệu vào 
        KHACHHANG kh = Auth.cus;
        lbl_tenKH.setText(kh.getHO_TEN());
        lbl_sdt.setText(kh.getSDT());
        lbl_email.setText(kh.getEMAIL());
        autoCreateMaHD();
        autoCreateMaHDCT();
        lbl_thoiGian.setText(java.time.LocalDate.now() + "");
        fillPhimToTable_HoaDon();
    }

    public void fillPhimToTable_HoaDon() {
        // Đổ dữ liệu vào 
        tbl_HoaDon.removeAll();
        model = (DefaultTableModel) tbl_HoaDon.getModel();
        model.setRowCount(0);

        for (GIOHANG_PHIM ph : getInfo.listSP_PHIM) {
            model.addRow(new Object[]{ph.getSO_LUONG() + " vé Phòng: " + ph.getPHONG_CHIEU() + "\r\n"
                + "Ghế: " + ph.getGHE_NGOI(),
                ph.getTEN_SAN_PHAM() + "\r\n"
                + ph.getGIO_CHIEU() + "\r\n"
                + ph.getNGAY_CHIEU(),
                ph.getGIA()});
        }
        tbl_HoaDon.getColumnModel().getColumn(0).setCellRenderer(new WordWrapeCellRender());

        fillDoAnToTable_HoaDon();
    }

    public void fillDoAnToTable_HoaDon() {
        // Đổ dữ liệu vào 
        model = (DefaultTableModel) tbl_HoaDon.getModel();
        for (GIOHANG_DOAN da : getInfo.listSP_DOAN) {
            model.addRow(new Object[]{da.getSO_LUONG() + " size " + da.getKICH_CO(), da.getTEN_SAN_PHAM(), da.getGIA()});
        }
        total();
        getData();
    }

    private class WordWrapeCellRender extends JTextArea implements TableCellRenderer {

        WordWrapeCellRender() {
            setLineWrap(true);
            setWrapStyleWord(true);

        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean bln, boolean isSelected, int row, int column) {
            setText(value.toString());
            setFont(new Font("Segoe UI", Font.BOLD, 17));
            setForeground(new Color(0, 112, 192));
            setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
            setBackground(new Color(0, 0, 0, 0));
            setSelectionColor(new Color(0, 0, 0, 0));
            setOpaque(false);

            return this;
        }
    }

    private void total() {
        int row = tbl_HoaDon.getRowCount();
        double total = 0;

        for (int i = 0; i < row; i++) {
            double val = Double.valueOf(tbl_HoaDon.getValueAt(i, 2).toString());
            total += val;
        }
        lbl_tongtien.setText("Tổng tiền đơn hàng: " + formatter.format(total) + " VNĐ");
    }

    private HOADON_KH getForm() {
        // Lấy dữ liệu ra 
        HOADON_KH kh = new HOADON_KH();
        kh.setTENKH(lbl_tenKH.getText());
        kh.setSDT(lbl_sdt.getText());
        kh.setEMAIL(lbl_email.getText());
        kh.setMAHD(lbl_maHD.getText());
        kh.setMAHDCT(lbl_maHDCT.getText());
        kh.setTHOIGIAN(lbl_thoiGian.getText());
        kh.setTONGTIEN(lbl_tongtien.getText());
        return kh;
    }

    private void getData() {
        // Lấy dữ liệu ra 
        HOADON_CT ct = new HOADON_CT();
        HOADON_KH kh = getForm();
        model = (DefaultTableModel) tbl_HoaDon.getModel();
        ct.setMAHDCT(kh.getMAHDCT());
        ct.setMAHD(kh.getMAHD());
        for (int i = 0; i < model.getRowCount(); i++) {
            ct.setSL_KICHCO(model.getValueAt(i, 0) + "");
            ct.setTENSP(model.getValueAt(i, 1) + "");
            ct.setDONGIA(model.getValueAt(i, 2) + "");
            listHDCT.add(ct);
            hdctdao.insert(ct);
        }

    }

    private void insertData() {
        HOADON_KH kh = getForm();

        if (kh != null) {
            if (hdkhdao.selectebyID(kh.getMAHD()) == null) {
                hdkhdao.insert(kh);
                getData();
                // send mail
                sendMail();
//                MsgBox.alert(this, "Xác nhận thành công. Sử dụng mã QR được gửi qua email khi đến check in tại rạp!");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Xác nhận thất bại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    int index = 0;
    String duongDanImage = null;
    File f = new File("");

    private String createQRcode() {
        HOADON_KH kh = getForm();
        try {
            //chuyen noi dung thanh QR_Code
            ByteArrayOutputStream out = QRCode.from(kh.getMAHDCT()).to(ImageType.PNG).stream();

            // tao duong dan luu anh
            String file_name = kh.getMAHDCT();
            duongDanImage = f.getAbsolutePath() + "\\src\\main\\resources\\com\\qlrp\\image\\QRcode\\";

            //xuat file anh
            FileOutputStream fout = new FileOutputStream(new File(duongDanImage + (file_name + ".PNG")));
            fout.write(out.toByteArray());
            fout.flush();

            return duongDanImage + (file_name + ".PNG");

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void sendMail() {
        HOADON_KH kh = getForm();
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

            String from = "4tlixcompany@gmail.com";
            String to = lbl_email.getText();

            String subject = ("Successful booking information ( " + kh.getTHOIGIAN() + ",Order ID: " + kh.getMAHD() + ")");

            String body
                    = "4TLIX CINEMAS TRÂN TRỌNG THÔNG BÁO  \n"
                    + "Thông tin hóa đơn: " + kh.getMAHDCT() + "\n"
                    + listHDCT.get(index).getSL_KICHCO() + "\n" //                  
                    + listHDCT.get(index).getTENSP() + "\n"
                    + kh.getTONGTIEN()
                    + "Vui lòng đưa mã QR này cho nhân viên khi đến check in tại rạp.";

            Message msg = new MimeMessage(ss);

            MimeBodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(body, "text/html; charset=utf-8");

            msg.setFrom(new InternetAddress(from));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            msg.setSubject(subject);

            Multipart multipart = new MimeMultipart();
            BodyPart messageBodyPart1 = new MimeBodyPart();

            messageBodyPart1.setContent(body, "text/plain; charset=UTF-8");
            multipart.addBodyPart(messageBodyPart1);

            // Gui File dinh kem
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
            DataSource source1 = new FileDataSource(createQRcode());
            messageBodyPart2.setDataHandler(new DataHandler(source1));
            messageBodyPart2.setFileName(createQRcode());
            multipart.addBodyPart(messageBodyPart2);

            msg.setContent(multipart);

            Transport.send(msg);
            JOptionPane.showMessageDialog(null, "Hóa đơn đã được gửi về email của bạn" + "\n"
                    + "Sử dụng mã QR được gửi qua email khi đến check in tại rạp", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (MessagingException e) {
            e.printStackTrace();

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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HoaDon = new rojerusan.RSTableMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_tenKH = new javax.swing.JLabel();
        lbl_sdt = new javax.swing.JLabel();
        lbl_maHD = new javax.swing.JLabel();
        lbl_thoiGian = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btn_huyBo = new com.k33ptoo.components.KButton();
        btn_xacNhan = new com.k33ptoo.components.KButton();
        lbl_maHDCT = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HÓA ĐƠN");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "HÓA ĐƠN", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24))); // NOI18N

        tbl_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1 PHONG 1 - A1,A2,A3,A4", "MINIONS", "45,000"},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "SL", "TÊN", "GIÁ"
            }
        ));
        tbl_HoaDon.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_HoaDon.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tbl_HoaDon.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tbl_HoaDon.setColorSelBackgound(new java.awt.Color(255, 255, 153));
        tbl_HoaDon.setColorSelForeground(new java.awt.Color(0, 0, 0));
        tbl_HoaDon.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tbl_HoaDon.setFuenteHead(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl_HoaDon.setRowHeight(60);
        tbl_HoaDon.setSelectionBackground(new java.awt.Color(255, 255, 102));
        jScrollPane2.setViewportView(tbl_HoaDon);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("TÊN KHÁCH HÀNG:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("SDT:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("MÃ HÓA ĐƠN:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("THỜI GIAN:");

        lbl_tenKH.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_tenKH.setText("4TLIX");

        lbl_sdt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_sdt.setText("0123");

        lbl_maHD.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_maHD.setText("HD001");

        lbl_thoiGian.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_thoiGian.setText("08/08/2022");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("EMAIL:");

        lbl_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_email.setText("0123");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_sdt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_tenKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_maHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_thoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_email, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_thoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 590, 520));

        lbl_tongtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_tongtien.setText("000.000");
        jPanel1.add(lbl_tongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 580, 580, -1));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 712, 560, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("4TLIX - CINEMAS");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 720, -1, -1));

        btn_huyBo.setText("HỦY BỎ");
        btn_huyBo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_huyBo.setkEndColor(new java.awt.Color(255, 51, 51));
        btn_huyBo.setkHoverEndColor(new java.awt.Color(255, 0, 0));
        btn_huyBo.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_huyBo.setkHoverStartColor(new java.awt.Color(207, 0, 0));
        btn_huyBo.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_huyBo.setkStartColor(new java.awt.Color(255, 0, 0));
        btn_huyBo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyBoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_huyBo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 650, 170, 50));

        btn_xacNhan.setText("XÁC NHẬN");
        btn_xacNhan.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_xacNhan.setkEndColor(new java.awt.Color(0, 204, 0));
        btn_xacNhan.setkHoverEndColor(new java.awt.Color(0, 153, 0));
        btn_xacNhan.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_xacNhan.setkHoverStartColor(new java.awt.Color(0, 153, 0));
        btn_xacNhan.setkPressedColor(new java.awt.Color(153, 153, 153));
        btn_xacNhan.setkStartColor(new java.awt.Color(0, 204, 0));
        btn_xacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacNhanActionPerformed(evt);
            }
        });
        jPanel1.add(btn_xacNhan, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 650, 170, 50));

        lbl_maHDCT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_maHDCT.setText("HD001");
        jPanel1.add(lbl_maHDCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 110, 24));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("MÃ HDCT:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 275, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_huyBoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyBoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_huyBoActionPerformed

    private void btn_xacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacNhanActionPerformed
        insertData();
    }//GEN-LAST:event_btn_xacNhanActionPerformed

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
            java.util.logging.Logger.getLogger(KH_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KH_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KH_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KH_HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KH_HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KButton btn_huyBo;
    private com.k33ptoo.components.KButton btn_xacNhan;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_maHD;
    private javax.swing.JLabel lbl_maHDCT;
    private javax.swing.JLabel lbl_sdt;
    private javax.swing.JLabel lbl_tenKH;
    private javax.swing.JLabel lbl_thoiGian;
    private javax.swing.JLabel lbl_tongtien;
    private rojerusan.RSTableMetro tbl_HoaDon;
    // End of variables declaration//GEN-END:variables
}
