package com.bluewalrus.calculationBuilderProject.ui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;

import com.bluewalrus.calculationBuilderProject.main.BinaryOperatorNode;
import com.bluewalrus.calculationBuilderProject.main.CalculationNode;
import com.bluewalrus.calculationBuilderProject.main.EmptyNode;
import com.bluewalrus.calculationBuilderProject.main.InputNode;
import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.main.NodeToModelMapper;
import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.Input;
import com.bluewalrus.calculationBuilderProject.model.operators.AdditionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.DivisionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.MultiplicationOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SubtractionOperator;
import com.bluewalrus.calculationBuilderProject.ui.calculationViewer.CalculationPanel;
import com.bluewalrus.calculationBuilderProject.ui.operators.AdditionOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.DivisionOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.MultiplicationOperatorNode;
import com.bluewalrus.calculationBuilderProject.ui.operators.SubtractionOperatorNode;

public class NodeDropProcessor {

    public static void processDrop(Node nodeToDropOnto, DropTargetDropEvent dtde) {

        Transferable transferable = dtde.getTransferable();
        DataFlavor[] flavor = transferable.getTransferDataFlavors();

        Object dropObject = null;
        try {
            dropObject = transferable.getTransferData(flavor[0]);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (nodeToDropOnto.getParent() instanceof Node) {
            Node parent = (Node) nodeToDropOnto.getParent();

            if (nodeToDropOnto instanceof EmptyNode) {

                System.out.println("parent is - " + parent.getClass());

                if (parent instanceof BinaryOperatorNode) {
                    BinaryOperatorNode operator = (BinaryOperatorNode) parent;
                    Node binN = NodeToModelMapper.getNodeForModelObject((CalculationObject) dropObject);

                    operator.replaceFirstNodeWithSecond(nodeToDropOnto, binN);

                }
            } else {
                //nothing for now
            }
        } else {
            System.out.println("replace root node!!!!");
            CalculationPanel calcPanel = (CalculationPanel) nodeToDropOnto.getParent();

            GridBagLayout gbl = (GridBagLayout) calcPanel.getLayout();
            GridBagConstraints gbc = gbl.getConstraints(nodeToDropOnto);

            //now removing the empty node
            calcPanel.remove(nodeToDropOnto);
            Node theNode = getCorrespondingNode(dropObject);

            calcPanel.add(theNode, gbc);
            calcPanel.setRootNode(theNode);

            calcPanel.revalidate();

        }
    }

    private static Node getCorrespondingNode(Object dropObject) {
        if (dropObject instanceof AdditionOperator) {
            return new AdditionOperatorNode();
        }
        if (dropObject instanceof SubtractionOperator) {
            return new SubtractionOperatorNode();
        }
        if (dropObject instanceof MultiplicationOperator) {
            return new MultiplicationOperatorNode();
        }
        if (dropObject instanceof DivisionOperator) {
            return new DivisionOperatorNode();
        }
        if (dropObject instanceof Input) {
            return new InputNode((Input) dropObject);
        }
        if (dropObject instanceof Calculation) {
            return new CalculationNode((Calculation) dropObject);
        }

        System.out.println("no corresponding node");

        return null;
    }
}
