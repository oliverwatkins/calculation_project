package com.bluewalrus.calculationBuilderProject.model;

/**
 * Calculation
 * 
 * Hello world
 * 
 * @author oliver
 */

public class Calculation extends CalculationObject {

    private CalculationObject rootObject;
    private String name;
    private String symbol;

    public Calculation(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public CalculationObject getRootObject() {
        return rootObject;
    }

    public void setRootObject(CalculationObject rootNode) {
        this.rootObject = rootNode;
    }

    public String toXML() {
        return "<calculation name = " + this.getName() + ">"
                + "" + rootObject.toXML()
                + "</calculation>";
    }
    
    public String toString() {
        return rootObject.toString();
    }
}
