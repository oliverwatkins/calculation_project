package com.bluewalrus.calculationBuilderProject.ui.operators;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.bluewalrus.calculationBuilderProject.main.EmptyNode;
import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.BinaryOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SigmaOperator;
import java.awt.GridBagLayout;
import javax.swing.JComponent;

public class SigmaOperatorNode extends Node {

    private SigmaOperator sigmaOperator = new SigmaOperator();

    private Node topNode = new EmptyNode();
    private Node bottomNode = new EmptyNode();
    private Node rightNode = new EmptyNode();

    private RenderedLabel label;

    public SigmaOperatorNode() {

        label = new RenderedLabel();
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.anchor = GridBagConstraints.SOUTH;
        this.add(getTopPanel(), gbc2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(getOperatorLabel(), gbc);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = 2;
        gbc3.anchor = GridBagConstraints.NORTH;
        this.add(getBottomPanel(), gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 1;
        gbc4.gridy = 0;
        gbc4.gridheight = 3;

        this.add(rightNode, gbc4);
    }

    public JLabel getOperatorLabel() {
        return new RenderedLabel();
    }

    public JComponent getTopPanel() {
        EmptyNode node = new EmptyNode();
        node.setSize(new Dimension(10, 10));
        return node;
    }

    public JPanel getBottomPanel() {
        JLabel label = new JLabel("n = ");
        label.setFont(new Font("Ariel", Font.ITALIC, 12));
        JPanel node = new JPanel();
        node.setBackground(Color.WHITE);
        label.setBackground(Color.WHITE);
        node.add(label);
        EmptyNode en = new EmptyNode();
        en.setSize(new Dimension(10, 10));
        node.add(en);
        return node;
    }

    public void replaceRightNodeWithSecond(Node nodeToBeReplaced, Node nodeToDrop) {
        
//        SigmaOperator binO = (SigmaOperator) this.getModelObject();
                
        
//        if (nodeToBeReplaced == firstOperand) {
//            binO.setFirstOperand(nodeToDrop.getModelObject());
//        } else if (nodeToBeReplaced == secondOperand) {
//            binO.setSecondOperand(nodeToDrop.getModelObject());
//        } else {
//        }

        //storing gbl
        GridBagLayout gbl = (GridBagLayout) this.getLayout();
        GridBagConstraints gbc = gbl.getConstraints(nodeToBeReplaced);

        //now removing the empty node
        this.remove(nodeToBeReplaced);

        this.add(nodeToDrop, gbc);

        this.revalidate();
    }

    private class RenderedLabel extends JLabel {

        public RenderedLabel() {
            Dimension d = new Dimension(40, 40);

            this.setMinimumSize(d);
            this.setSize(d);
            this.setPreferredSize(d);
            this.setFont(new Font("Times New Roman", Font.PLAIN, 40));
            this.setText("\u03a3");
        }
    }

    public CalculationObject getModelObject() {
        return sigmaOperator;
    }

    public void setModelObject(CalculationObject calcObj) {
        sigmaOperator = (SigmaOperator) calcObj;
    }
}
