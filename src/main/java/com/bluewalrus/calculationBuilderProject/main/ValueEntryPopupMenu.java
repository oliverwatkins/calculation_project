package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPopupMenu;
import javax.swing.JTextField;

/**
 * Manages the entry of numerical values into an empty node
 *
 * @author Olly
 *
 */
public class ValueEntryPopupMenu extends JPopupMenu {

    private JTextField field = new JTextField();

    public ValueEntryPopupMenu() {
        field.setPreferredSize(new Dimension(50, field.getPreferredSize().height));
        field.setMaximumSize(new Dimension(50, field.getPreferredSize().height));
        field.setMinimumSize(new Dimension(50, field.getPreferredSize().height));

        add(field);
        field.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent arg0) {
                System.out.println("key typed");

                if (arg0.getKeyChar() == KeyEvent.VK_ENTER) {
                    System.out.println("enter pressed");

//					ValueEntryPopupMenu.this.firePopupMenuCanceled();
//					ValueEntryPopupMenu.this.
                }
            }

            public void keyPressed(KeyEvent arg0) {
                // TODO Auto-generated method stub
            }

            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void show(Component c, int i, int j) {
        super.show(c, i, j);
        field.grabFocus();
    }
}
