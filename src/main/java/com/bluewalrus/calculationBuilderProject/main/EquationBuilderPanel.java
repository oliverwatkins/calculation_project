package com.bluewalrus.calculationBuilderProject.main;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.ui.BottomPanel;
import com.bluewalrus.calculationBuilderProject.ui.TopPanel;

public class EquationBuilderPanel extends JPanel {

    private TopPanel topPanel = new TopPanel();
    private BottomPanel bottomPanel = new BottomPanel();

    public EquationBuilderPanel() {
        initGui();
    }

    private void initGui() {
        this.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .9;
        gbc.weighty = 1;

        this.add(topPanel, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .2;
        gbc.weighty = 1;

        this.add(bottomPanel, gbc);

    }

    public Calculation getCalculation() {
        return this.topPanel.getViewerPanel().getCalculation();
    }

    public void addCalculationToTable(Calculation calculation) {
        bottomPanel.getCalculationTableModel().addCalculation(calculation);

    }

    public ArrayList getAllCalculations() {
        return bottomPanel.getCalculationTableModel().getAllCalculations();
    }

}
