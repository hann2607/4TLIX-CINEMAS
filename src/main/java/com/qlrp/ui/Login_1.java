/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.qlrp.ui;

import com.qlrp.component.PanelCover;
import com.qlrp.component.PanelDangNhapDangKy;
import com.qlrp.utils.Auth;
import com.qlrp.utils.XImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Login_1 extends javax.swing.JFrame {
    
    private MigLayout layout;
    private PanelCover cover;
    private PanelDangNhapDangKy login;
    private boolean isLogin;
    private final double addSize = 30;
    private final double coverSize = 40;
    private final double loginSize = 60;
    private final DecimalFormat df = new DecimalFormat("##0.###", DecimalFormatSymbols.getInstance(Locale.US));
    
    public Login_1() {
        initComponents();
        init();
    }
    
    private void init() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setIconImage(XImage.getAppIcon());
        this.setCursor(XImage.setCursor());
        this.setLocationRelativeTo(null);
        layout = new MigLayout("fill, insets 0");
        cover = new PanelCover();
        ActionListener eventLogin = (ActionEvent ae) -> {
            if(Auth.cus != null || Auth.user != null) {
                closeForm();
                SplashScreen sp = new SplashScreen();
                sp.setVisible(true);
            }  
        };
        login = new PanelDangNhapDangKy(eventLogin);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double fractionCover;
                double fractionLogin;
                double size = coverSize;
                
                if (fraction <= 0.5f) {
                    size += fraction * addSize;
                } else {
                    size += addSize - fraction * addSize;
                }
                
                if (isLogin) {
                    fractionCover = 1f - fraction;
                    fractionLogin = fraction;
                    if (fraction >= 0.5f) {
                        cover.dangKyRight(fractionCover * 100);
                    } else {
                        cover.dangNhapRight(fractionLogin * 100);
                    }
                } else {
                    fractionCover = fraction;
                    fractionLogin = 1f - fraction;
                    if (fraction <= 0.5f) {
                        cover.dangKyLeft(fraction * 100);
                    } else {
                        cover.dangNhapLeft((1f - fraction) * 100);
                    }
                }
                
                if (fraction >= 0.5f) {
                    login.showDangKy(isLogin);
                }
                
                fractionCover = Double.valueOf(df.format(fractionCover));
                fractionLogin = Double.valueOf(df.format(fractionLogin));
                layout.setComponentConstraints(cover, "width " + size + "%, pos" + fractionCover + "al 0 n 100%");
                layout.setComponentConstraints(login, "width " + loginSize + "%, pos" + fractionLogin + "al 0 n 100%");
                
                bg.revalidate();
            }
            
            @Override
            public void end() {
                isLogin = !isLogin;
            }
            
        };
        Animator animator = new Animator(1000, target);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        animator.setResolution(0);

//        bg.setbg
        bg.setLayout(layout);
        bg.add(cover, "width " + coverSize + "%, pos 0al 0 n 100%");
        bg.add(login, "width " + loginSize + "%, pos 1al 0 n 100%");
        
        cover.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
    }
    
    
    
    public void closeForm() {
//        this.dispose();
//        this.hide();
    this.setVisible(false);
//        this.show(false);
        // or DetailsForm.Hide();
        // or DetailsForm.Dispose();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("4TTLIX CINEMAS");

        bg.setBackground(new java.awt.Color(211, 211, 211));
        bg.setOpaque(true);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane bg;
    // End of variables declaration//GEN-END:variables
}
