package com.bluewalrus.calculationBuilderProject.model;

public class Input extends CalculationObject {

    private String name;
    private String symbol;

    public Input(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String toXML() {
        // TODO Auto-generated method stub
        return "<input>" + name + "</input>";
    }

    public String toString() {
        return name;
    }
}
