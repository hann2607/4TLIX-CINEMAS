/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.qlrp.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author HAN-PC
 */
public class setUIJScroll extends BasicScrollBarUI{
    
    
      private final Dimension d = new Dimension();

      @Override
      protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
          
            private static final long serialVersionUID = -3592643796245558676L;

            @Override
              public Dimension getPreferredSize() {
                return d;
              }
            };
      }

      @Override
      protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
          
            private static final long serialVersionUID = 1L;

        @Override
          public Dimension getPreferredSize() {
            return d;
          }
        };
      }

      @Override
      protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
      }

      @Override
      protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar) c;
        if (!sb.isEnabled() || r.width > r.height) {
          return;
        } else if (isDragging) {
          color = Color.DARK_GRAY; // change color
        } else if (isThumbRollover()) {
          color = Color.LIGHT_GRAY; // change color
        } else {
          color = Color.GRAY; // change color
        }
        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.setPaint(Color.WHITE);
        g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.dispose();
      }

      @Override
      protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
      }
    
}
