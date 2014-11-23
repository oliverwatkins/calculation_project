package com.bluewalrus.calculationBuilderProject.ui.operators;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JLabel;

import com.bluewalrus.calculationBuilderProject.main.LeftRightNode;
import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.main.NodeToModelMapper;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.AdditionOperator;

public class AdditionOperatorNode extends LeftRightNode {

    private static int fontSize = 25;
    private AdditionOperator additionOperator = new AdditionOperator();

    public JLabel getOperatorLabel() {
        return new RenderedLabel();
    }

    private class RenderedLabel extends JLabel {

        private String labelString = "+";
        private Font font = new Font("Serif", Font.PLAIN, fontSize);

        private int sWidth = 0;
        private int sHeight = 0;

        public RenderedLabel() {
            init();
//			System.out.println("font size is = " + fontSize);
            font = new Font("Serif", Font.PLAIN, AdditionOperatorNode.fontSize);
        }

        private void init() {
            FontMetrics fm = this.getFontMetrics(font);

            sWidth = fm.stringWidth(labelString);
            sHeight = fm.getHeight();

            Dimension d = new Dimension(sWidth, sHeight);

            this.setMinimumSize(d);
            this.setSize(d);
            this.setPreferredSize(d);
            this.setText(labelString);
            this.setHorizontalAlignment(JLabel.CENTER);
        }
    }

    public CalculationObject getModelObject() {
        return additionOperator;
    }

    public void setModelObject(CalculationObject calcObj) {
        //TODO refactor this
        //set internal
        additionOperator = (AdditionOperator) calcObj;
        additionOperator.setFirstOperand(additionOperator.getFirstOperand());
        additionOperator.setSecondOperand(additionOperator.getSecondOperand());

        Node n1 = NodeToModelMapper.getNodeForModelObject(additionOperator.getFirstOperand());
        Node n2 = NodeToModelMapper.getNodeForModelObject(additionOperator.getSecondOperand());

        this.setFirstOperand(n1);
        this.setSecondOperand(n2);
    }
}
