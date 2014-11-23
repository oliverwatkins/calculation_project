package com.bluewalrus.calculationBuilderProject.model.operators;

import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.Empty;

public abstract class BinaryOperator extends Operator {

    private CalculationObject firstOperand;
    private CalculationObject secondOperand;

    public BinaryOperator() {
        setFirstOperand(new Empty());
        setSecondOperand(new Empty());
    }

    /**
     * @return
     */
    public CalculationObject getFirstOperand() {
        return firstOperand;
    }

    /**
     * @return
     */
    public CalculationObject getSecondOperand() {
        return secondOperand;
    }

    /**
     * @param object
     */
    public void setFirstOperand(CalculationObject object) {
        firstOperand = object;
    }

    /**
     * @param object
     */
    public void setSecondOperand(CalculationObject object) {
        secondOperand = object;
    }

    public String toXML() {
        return "<node type='binary' name='" + this.getName() + "'>\n"
                + "\t<operand1>\n"
                + "\t\t" + this.getFirstOperand().toXML() + "\n"
                + "\t</operand1>" + "\n"
                + "\t<operand2>\n"
                + "\t\t" + this.getSecondOperand().toXML() + "\n"
                + "\t</operand2>\n"
                + "</node>\n";
    }

    public String toString() {
        return "(" + firstOperand.toString() + " " + this.getSymbol() + " " + secondOperand.toString() + ")";
    }

}
