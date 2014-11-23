package com.bluewalrus.calculationBuilderProject.ui.operators;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.main.NodeToModelMapper;
import com.bluewalrus.calculationBuilderProject.main.UpDownNode;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.AdditionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.DivisionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SubtractionOperator;

public class DivisionOperatorNode extends UpDownNode {

    private DivisionOperator divisionOperator = new DivisionOperator();

    private RenderedLabel label;

    public DivisionOperatorNode() {
        label = new RenderedLabel();

    }

    public JLabel getOperatorLabel() {
        return new RenderedLabel();
    }

    private class RenderedLabel extends JLabel {

        public RenderedLabel() {
            this.setMinimumSize(new Dimension(30, 5));
            this.setSize(new Dimension(30, 5));
            this.setPreferredSize(new Dimension(30, 5));

        }

        public void paintComponent(Graphics g) {
            g.drawLine(0, 3, this.getWidth(), 3);
        }
    }

    public CalculationObject getModelObject() {
        return divisionOperator;
    }

    public void setModelObject(CalculationObject calcObj) {
        //set internal
        divisionOperator = (DivisionOperator) calcObj;
        divisionOperator.setFirstOperand(divisionOperator.getFirstOperand());
        divisionOperator.setSecondOperand(divisionOperator.getSecondOperand());

        Node n1 = NodeToModelMapper.getNodeForModelObject(divisionOperator.getFirstOperand());
        Node n2 = NodeToModelMapper.getNodeForModelObject(divisionOperator.getSecondOperand());

        this.setFirstOperand(n1);
        this.setSecondOperand(n2);

//		divisionOperator = (DivisionOperator)calcObj;
    }

}
