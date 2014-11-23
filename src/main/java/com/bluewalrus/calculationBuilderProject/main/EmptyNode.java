package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.Empty;

public class EmptyNode extends Node implements MouseMotionListener, MouseListener {

    private boolean mouseOver = false;

    public EmptyNode() {
        this.setSize(new Dimension(20, 20));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void setSize(Dimension d) {
        this.setMinimumSize(d);
        this.setPreferredSize(d);
        super.setSize(d);
    }

    public void mouseDragged(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    public void mouseMoved(MouseEvent arg0) {

    }

    public void mouseClicked(MouseEvent arg0) {
        //get node where mouse is over
        Point location = arg0.getPoint();

        Component c = this.getComponentAt(location);

        System.out.println("mouse clicked and c = " + c.getClass());
        if (c instanceof EmptyNode && c.getParent() != null) {
            final ValueEntryPopupMenu menu = new ValueEntryPopupMenu();
            menu.show(this, arg0.getX(), arg0.getY());

            System.out.println("c parent = " + c.getParent());
            Node parent = (Node) c.getParent();
            GridBagLayout gbl = (GridBagLayout) parent.getLayout();

            GridBagConstraints gbc = gbl.getConstraints(c);

            revalidate();
        }
    }

    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
        mouseOver = true;
        repaint();
    }

    public void mouseExited(MouseEvent arg0) {
        mouseOver = false;
        repaint();
    }

    public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.WHITE);
        g2.setColor(Color.WHITE);
        g2.drawRect(0, 0, this.getWidth(), this.getHeight());
        if (mouseOver) {
            g2.setColor(Color.BLUE);
        } else {
            g2.setColor(Color.GRAY);
        }

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0 + 1, 0 + 1, this.getWidth() - 2, this.getHeight() - 2, 40, 40);
//		g2.fillOval(0,0,this.getWidth(),this.getHeight());//, this.getHeight()/2, this.getHeight()/2);
        g2.setColor(Color.WHITE);
        g2.drawString("?", 8, 15);
    }

    private Empty empty = new Empty();

    public CalculationObject getModelObject() {
        return empty;
    }

    public void setModelObject(CalculationObject calcObj) {
        empty = (Empty) calcObj;
    }
}
