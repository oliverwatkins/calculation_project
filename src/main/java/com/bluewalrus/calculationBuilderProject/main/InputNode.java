package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Color;

import javax.swing.JLabel;

import com.bluewalrus.calculationBuilderProject.ui.Colors;

import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.Empty;
import com.bluewalrus.calculationBuilderProject.model.Input;

public class InputNode extends Node {

    private Input input;

    public InputNode(Input input) {
        this.input = input;
        JLabel label = new JLabel(input.getSymbol());
        label.setForeground(Colors.INPUT_COLOR);
        label.setBackground(Color.WHITE);
        this.setBackground(Color.WHITE);
        this.add(label);
    }

    public CalculationObject getModelObject() {
        return input;
    }

    public void setModelObject(CalculationObject calcObj) {
        input = (Input) calcObj;
    }

}
