package com.bluewalrus.calculationBuilderProject.ui.calculationViewer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import com.bluewalrus.calculationBuilderProject.main.EmptyNode;
import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.ui.TitlePanel;
import com.bluewalrus.calculationBuilderProject.ui.operator.OperatorPanel;

public class CalculationViewerPanel extends JPanel {

    private Node rootNode;
    private CalculationPanel calculationPanel;
    private TitlePanel titlePanel = new TitlePanel();

    public CalculationViewerPanel() {
        initGui();
    }

    private void initGui() {
        rootNode = new EmptyNode();

        calculationPanel = new CalculationPanel(rootNode);

        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .9;
//		gbc.weighty = 1;

        this.add(calculationPanel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
//		gbc.weightx = .9;
//		gbc.weighty = 1;

        this.add(titlePanel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .3;
        gbc.weighty = .7;
        gbc.gridheight = 2;

        this.add(new OperatorPanel(), gbc);
    }

    public CalculationPanel getCalculationPanel() {
        return calculationPanel;
    }

    public Calculation getCalculation() {
        Node rootNode = this.getCalculationPanel().getRootNode();
        Calculation calc = new Calculation(titlePanel.getCalculationName(), "asfd");
        calc.setRootObject(rootNode.getModelObject());

        return calc;

    }

}
