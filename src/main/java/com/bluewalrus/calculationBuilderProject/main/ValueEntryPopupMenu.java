package com.bluewalrus.calculationBuilderProject.main;

import com.bluewalrus.calculationBuilderProject.model.Input;
import com.bluewalrus.calculationBuilderProject.model.NumericalConstant;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;

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
    NumberNode numberNode = null; //new NumberNode();
    
    Component componentClicked = null;

    ValueEntryPopupMenu(Component componentClicked) {
        this();
        this.componentClicked = componentClicked;
        
    }
    
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

                    NumericalConstant c = new NumericalConstant(field.getText());
                            
                    numberNode = new NumberNode(c);
                    
                    
                    Object p = (Object) componentClicked.getParent();
                    
                    JComponent parent = (JComponent)p;
                    LayoutManager lm = parent.getLayout();

                    if (lm instanceof GridBagLayout) {
                        
                        GridBagLayout gbl = (GridBagLayout) lm;
                        
                        GridBagConstraints gbc = gbl.getConstraints(componentClicked);
                                            Input i = new Input("balh" , "b");
                        InputNode n = new InputNode(i);

    //                    parent.add(numberNode, gbc);
                        parent.add(numberNode, gbc);
                        System.out.println("parent = " + parent);

                        ValueEntryPopupMenu.this.setVisible(false);
//                        parent.revalidate();

                        parent.remove(componentClicked);

                        parent.getParent().revalidate();
//                        parent.getParent().getParent().revalidate();
                        
                    } else if (lm instanceof FlowLayout) {
                        
                        FlowLayout fl = (FlowLayout) lm;
                        parent.remove(componentClicked);
                        parent.add(numberNode);
                        parent.getParent().revalidate();
                        
                        ValueEntryPopupMenu.this.setVisible(false);
                        
                    }
                    
                    
                    


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
