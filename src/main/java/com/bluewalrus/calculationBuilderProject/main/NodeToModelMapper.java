package com.bluewalrus.calculationBuilderProject.main;

import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.Empty;
import com.bluewalrus.calculationBuilderProject.model.Input;
import com.bluewalrus.calculationBuilderProject.model.operators.AdditionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.DivisionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.MultiplicationOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.PowerOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SigmaOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SubtractionOperator;
import com.bluewalrus.calculationBuilderProject.ui.operators.AdditionOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.DivisionOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.MultiplicationOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.PowerOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.SigmaOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.SubtractionOperatorNode;

public class NodeToModelMapper {

    public static Node getNodeForModelObject(CalculationObject co) {
        if (co instanceof AdditionOperator) {
            return new AdditionOperatorNode();
        }
        if (co instanceof SubtractionOperator) {
            return new SubtractionOperatorNode();
        }
        if (co instanceof MultiplicationOperator) {
            return new MultiplicationOperatorNode();
        }
        if (co instanceof DivisionOperator) {
            return new DivisionOperatorNode();
        }
        if (co instanceof Input) {
            return new InputNode((Input) co);
        }
        if (co instanceof SigmaOperator) {
            return new SigmaOperatorNode();
        }
        if (co instanceof Calculation) {
            return new CalculationNode((Calculation) co);
        }
        if (co instanceof PowerOperator) {
            return new PowerOperatorNode();
        }
        if (co instanceof Empty) {
            return new EmptyNode();
        } else {
            throw new IllegalArgumentException("no type found");
        }

    }
//	if (dropObject instanceof AdditionOperator)
//	return new AdditionOperatorNode(); 
//if (dropObject instanceof SubtractionOperator)
//	return new SubtractionOperatorNode(); 
//if (dropObject instanceof MultiplicationOperator)
//	return new MultiplicationOperatorNode(); 
//if (dropObject instanceof DivisionOperator)
//	return new DivisionOperatorNode(); 
//if (dropObject instanceof Input)
//	return new InputNode((Input)dropObject);
//if (dropObject instanceof Calculation)
//	return new CalculationNode((Calculation)dropObject);
//if (dropObject instanceof Empty)
//	return new EmptyNode();

}
