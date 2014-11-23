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
import com.bluewalrus.calculationBuilderProject.model.operators.SubtractionOperator;

public class SubtractionOperatorNode extends LeftRightNode {

    private static int fontSize = 25;
    private SubtractionOperator subtractionOperator = new SubtractionOperator();

    public SubtractionOperatorNode() {
        subtractionOperator = new SubtractionOperator();
    }

    public JLabel getOperatorLabel() {
        return new RenderedLabel();
    }

    /**
     * Rendering label
     *
     * @author Olly
     *
     */
    private class RenderedLabel extends JLabel {

        String label = "-";
        Font font = new Font("Serif", Font.PLAIN, SubtractionOperatorNode.fontSize);

        int sWidth = 0;
        int sHeight = 0;

        public RenderedLabel() {
            FontMetrics fm = this.getFontMetrics(font);

            sWidth = fm.stringWidth(label);
            sHeight = fm.getHeight();

            System.out.println("sWidth = " + sWidth + " sHeight = " + sHeight);

            Dimension d = new Dimension(sWidth + 2, sHeight + 2);

            this.setMinimumSize(d);
            this.setSize(d);
            this.setPreferredSize(d);
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setText("-");
        }
    }

    public void setModelObject(CalculationObject calcObj) {
        //set internal
        subtractionOperator = (SubtractionOperator) calcObj;
        subtractionOperator.setFirstOperand(subtractionOperator.getFirstOperand());
        subtractionOperator.setSecondOperand(subtractionOperator.getSecondOperand());

        Node n1 = NodeToModelMapper.getNodeForModelObject(subtractionOperator.getFirstOperand());
        Node n2 = NodeToModelMapper.getNodeForModelObject(subtractionOperator.getSecondOperand());

        this.setFirstOperand(n1);
        this.setSecondOperand(n2);
    }

    public CalculationObject getModelObject() {
        return subtractionOperator;
    }
}
