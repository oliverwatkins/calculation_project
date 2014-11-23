package com.bluewalrus.calculationBuilderProject.ui.calculationViewer;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.bluewalrus.calculationBuilderProject.main.BinaryOperatorNode;
import com.bluewalrus.calculationBuilderProject.main.CalculationSelectionProcessor;
import com.bluewalrus.calculationBuilderProject.main.Node;

public class CalculationPanel extends JPanel {

    private Node rootNode;

    public CalculationPanel(Node rootNode) {
        this.rootNode = rootNode;

        CalculationSelectionProcessor.setCalculationPanel(this);

        this.setBackground(Color.WHITE);

        this.setLayout(new GridBagLayout());

        this.setCalculationRootNode(rootNode);

    }

    public void setCalculationRootNode(Node rootNode) {
        this.rootNode = rootNode;

        System.out.println("setting node ");
//		System.out.println(" " + rootNode.get);
        System.out.println("setting node ");

        //remove all components
        this.removeAll();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        System.out.println("root node class = " + rootNode.getClass());
        if (rootNode instanceof BinaryOperatorNode) {
            BinaryOperatorNode bon = (BinaryOperatorNode) rootNode;

            System.out.println("first operand class = " + bon.getFirstOperand().getClass());

            System.out.println("component cocunt");
            bon.revalidate();
            for (int i = 0; i < bon.getComponentCount(); i++) {
                System.out.println("class : " + bon.getComponent(i).getClass());

            }

        }
        add(rootNode, gbc);
        revalidate();
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

}
