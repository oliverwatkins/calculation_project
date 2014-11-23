package com.bluewalrus.calculationBuilderProject.ui.operators;

import javax.swing.JLabel;

import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.main.NodeToModelMapper;
import com.bluewalrus.calculationBuilderProject.main.PowerLikeNode;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.PowerOperator;

public class PowerOperatorNode extends PowerLikeNode {

    private PowerOperator powerOperator = new PowerOperator();

    public JLabel getOperatorLabel() {
        return null;
    }

    public CalculationObject getModelObject() {
        return powerOperator;
    }

    public void setModelObject(CalculationObject calcObj) {
        //set internal
        powerOperator = (PowerOperator) calcObj;
        powerOperator.setFirstOperand(powerOperator.getFirstOperand());
        powerOperator.setSecondOperand(powerOperator.getSecondOperand());

        Node n1 = NodeToModelMapper.getNodeForModelObject(powerOperator.getFirstOperand());
        Node n2 = NodeToModelMapper.getNodeForModelObject(powerOperator.getSecondOperand());
        n2.setFontSize(this.getFont().getSize() - 5);
//		n2.setSize();

        this.setFirstOperand(n1);
        this.setSecondOperand(n2);
    }
}
