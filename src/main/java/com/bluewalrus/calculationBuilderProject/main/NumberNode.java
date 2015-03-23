/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bluewalrus.calculationBuilderProject.main;

import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.NumericalConstant;
import com.bluewalrus.calculationBuilderProject.ui.Colors;
import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author oliver
 */
public class NumberNode extends Node{

    private NumericalConstant numericalConstant;

    public NumberNode(NumericalConstant numericalConstant) {
        this.numericalConstant = numericalConstant;
        JLabel label = new JLabel("" + numericalConstant);
        label.setForeground(Colors.INPUT_COLOR);
        label.setBackground(Color.WHITE);
        this.setBackground(Color.WHITE);
        this.add(label);
    }

    public CalculationObject getModelObject() {
        return numericalConstant;
    }

    public void setModelObject(CalculationObject calcObj) {
        numericalConstant = (NumericalConstant) calcObj;
    }

}
