package com.bluewalrus.calculationBuilderProject.main;

import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.BinaryOperator;
import com.bluewalrus.calculationBuilderProject.ui.calculationViewer.CalculationPanel;
import com.bluewalrus.calculationBuilderProject.ui.operators.SigmaOperatorNode;

public class CalculationSelectionProcessor {

    private static CalculationPanel calcPanel;

    public static void setCalculationPanel(CalculationPanel cPanel) {
        calcPanel = cPanel;
    }

    public static void setCalculation(Calculation calc) {
        CalculationObject rootCalcObject = calc.getRootObject();

        System.out.println("*****ASSEMBLING******");
        System.out.println("Before assemble - toString = \n" + calc.toString());

        Node nd = assemble(rootCalcObject);

        System.out.println("After assemble - toString = \n" + calc.toString());

        System.out.println("toString = " + calc.toString());

        calcPanel.setCalculationRootNode(nd);

    }

    public static Node assemble(CalculationObject calcObj) {
//		System.out.print("assembling ...");

        /////TODO need to recursively assemble
        //model is ok, but node is not
        Node n = getCorrespondingNode(calcObj);

        if (n instanceof BinaryOperatorNode) {

            //cast then set model object
            BinaryOperatorNode binNode = (BinaryOperatorNode) n;
            binNode.setModelObject(calcObj);
            BinaryOperator bo = (BinaryOperator) calcObj;

            //get operand nodes
            Node n1 = assemble(bo.getFirstOperand());
            Node n2 = assemble(bo.getSecondOperand());

            binNode.setFirstOperand(n1);
            binNode.setSecondOperand(n2);

            return binNode;
        } else if (n instanceof InputNode) {
            InputNode inNode = (InputNode) n;
            inNode.setModelObject(calcObj);

            return inNode;

        } else if (n instanceof CalculationNode) {

        } else if (n instanceof SigmaOperatorNode) {

        } else if (n instanceof EmptyNode) {
            EmptyNode eNode = (EmptyNode) n;
            eNode.setModelObject(calcObj);
        }

        return n;

    }

    private static Node getCorrespondingNode(Object dropObject) {

        return NodeToModelMapper.getNodeForModelObject((CalculationObject) dropObject);
//		if (dropObject instanceof AdditionOperator)
//			return new AdditionOperatorNode(); 
//		if (dropObject instanceof SubtractionOperator)
//			return new SubtractionOperatorNode(); 
//		if (dropObject instanceof MultiplicationOperator)
//			return new MultiplicationOperatorNode(); 
//		if (dropObject instanceof DivisionOperator)
//			return new DivisionOperatorNode(); 
//		if (dropObject instanceof Input)
//			return new InputNode((Input)dropObject);
//		if (dropObject instanceof Calculation)
//			return new CalculationNode((Calculation)dropObject);
//		if (dropObject instanceof Empty)
//			return new EmptyNode();
//
//		System.out.println("no corresponding node");
//		
//		return null;
    }

}
