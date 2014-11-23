package com.bluewalrus.calculationBuilderProject.model;

public class Empty extends CalculationObject {

    public String toXML() {
        return "<node type='empty'/>";
    }

    public String toString() {
        return "?";
    }

}
