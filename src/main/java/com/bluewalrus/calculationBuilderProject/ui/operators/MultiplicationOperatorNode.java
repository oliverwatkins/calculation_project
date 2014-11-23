package com.bluewalrus.calculationBuilderProject.ui.operators;

import java.awt.Dimension;

import javax.swing.JLabel;

import com.bluewalrus.calculationBuilderProject.main.LeftRightNode;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.MultiplicationOperator;

public class MultiplicationOperatorNode extends LeftRightNode {

    private MultiplicationOperator multiplicationOperator = new MultiplicationOperator();

    public JLabel getOperatorLabel() {
        return new RenderedLabel();
    }

    private class RenderedLabel extends JLabel {

        public RenderedLabel() {
            Dimension d = new Dimension(15, 15);
            this.setMinimumSize(d);
            this.setSize(d);
            this.setPreferredSize(d);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText("x");
        }
    }

    public CalculationObject getModelObject() {
        return multiplicationOperator;
    }

    public void setModelObject(CalculationObject calcObj) {
        multiplicationOperator = (MultiplicationOperator) calcObj;
    }

}
