package com.bluewalrus.calculationBuilderProject.model.operators;

import com.bluewalrus.calculationBuilderProject.model.CalculationObject;

public abstract class Operator extends CalculationObject {

    public abstract String getName();

    public abstract String getSymbol();

    public abstract Number calculate();

}
