package com.bluewalrus.calculationBuilderProject.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

class Bracket extends JPanel {

    private Dimension d = new Dimension(40, 40);
    private boolean isLeft = false;

    Font font = new Font("lucina sans demibold", Font.BOLD, 40);

    public Bracket(boolean isLeft) {
        this.setBackground(Color.WHITE);
        this.isLeft = isLeft;
    }

    public void setDimensionAndFont(Dimension d) {
        this.d = d;
        font = new Font("lucina sans demibold", Font.BOLD, (int) d.getHeight());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setBackground(Color.WHITE);
        g2.setPaint(Color.BLACK);
        if (isLeft) {
            g2.setStroke(new BasicStroke(2f));
            g2.drawArc(3, 0, getWidth() * 2, getHeight(), 150, 60);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawArc(3, 0, getWidth() * 2, getHeight(), 90, 180);
        } else {
            g2.setStroke(new BasicStroke(2f));
            g2.translate(-(getWidth()), 0);
            g2.drawArc(0, 0, (getWidth() * 2) - 3, getHeight(), 330, 60);
            g2.setStroke(new BasicStroke(1.5f));
            g2.translate(-1, 0);
            g2.drawArc(0, 0, (getWidth() * 2) - 3, getHeight(), 270, 180);
        }
    }
}
