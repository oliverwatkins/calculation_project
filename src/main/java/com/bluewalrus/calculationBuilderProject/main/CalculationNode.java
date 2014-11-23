package com.bluewalrus.calculationBuilderProject.main;

import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Arbitrary input node. Used in drag and dropping from calculatinos table.
 * @author oliver
 */

public class CalculationNode extends Node {

    private Calculation calculation;

    public CalculationNode(Calculation calc) {
        this.calculation = calc;
        JLabel label = new JLabel(calc.getSymbol());
        label.setForeground(Color.BLUE);
        label.setBackground(Color.WHITE);
        label.setIcon(new ImageIcon("images/Calculation16.gif"));
        this.setBackground(Color.WHITE);
        this.add(label);
    }

    public CalculationObject getModelObject() {
        return calculation;
    }

    public void setModelObject(CalculationObject calcObj) {
        calculation = (Calculation) calcObj;
    }

}
