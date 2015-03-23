package com.bluewalrus.calculationBuilderProject.model;

public class NumericalConstant extends CalculationObject {

    private int number; 
    
    public NumericalConstant(String number) {
        
        this.number = new Integer(number);
    }

    public String toXML() {
        return "<TODO numerical constant xml>";
    }

        @Override
    public String toString() {
        return  "" + number;
    }
}
