package com.bluewalrus.calculationBuilderProject.main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import com.bluewalrus.calculationBuilderProject.model.operators.BinaryOperator;

public abstract class BinaryOperatorNode extends Node {

    protected Node firstOperand;
    protected Node secondOperand;

    public BinaryOperatorNode() {
        firstOperand = new EmptyNode();
        secondOperand = new EmptyNode();
    }

    /**
     * @return
     */
    public Node getFirstOperand() {
        return firstOperand;
    }

    /**
     * @return
     */
    public Node getSecondOperand() {
        return secondOperand;
    }

    /**
     * @param object
     */
    public void setFirstOperand(Node object) {
        if (object == null) {
            throw new IllegalArgumentException("Cannot set an operand to null. The least it has to be is an empty");
        }

        replaceGUI(firstOperand, object);

        firstOperand = object;
    }

    /**
     * @param object
     */
    public void setSecondOperand(Node object) {
        if (object == null) {
            throw new IllegalArgumentException("Cannot set an operand to null. The least it has to be is an empty");
        }

        replaceGUI(secondOperand, object);

        secondOperand = object;

    }

    public abstract JLabel getOperatorLabel();

    public void replaceFirstNodeWithSecond(Node nodeToBeReplaced, Node nodeToDrop) {
        BinaryOperator binO = (BinaryOperator) this.getModelObject();

        if (nodeToBeReplaced == firstOperand) {
            binO.setFirstOperand(nodeToDrop.getModelObject());
        } else if (nodeToBeReplaced == secondOperand) {
            binO.setSecondOperand(nodeToDrop.getModelObject());
        } else {
        }

        //storing gbl
        GridBagLayout gbl = (GridBagLayout) this.getLayout();
        GridBagConstraints gbc = gbl.getConstraints(nodeToBeReplaced);

        //now removing the empty node
        this.remove(nodeToBeReplaced);

        this.add(nodeToDrop, gbc);

        this.revalidate();
    }

    public void replaceGUI(Node nodeToBeReplaced, Node nodeToDrop) {
        GridBagLayout gbl = (GridBagLayout) this.getLayout();
        GridBagConstraints gbc = gbl.getConstraints(nodeToBeReplaced);

        //now removing the empty node
        this.remove(nodeToBeReplaced);

        this.add(nodeToDrop, gbc);

        this.revalidate();
    }

}
