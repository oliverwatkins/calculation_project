package com.bluewalrus.calculationBuilderProject.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.bluewalrus.calculationBuilderProject.model.Calculation;

public class ControlPanel extends JPanel {

    private JButton saveCalculationButton = new JButton("Save Calculation");
    private JButton saveAllButton = new JButton("Save All");

    private TestApplication mainApp = null;

    public ControlPanel(TestApplication mainApp) {
        this.mainApp = mainApp;

        this.add(saveCalculationButton);
        saveCalculationButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                processClick();
            }
        });
        this.add(saveAllButton);
        saveAllButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {

                saveCalcs();
            }

        });

    }

    private void processClick() {
        EquationBuilderPanel ebp = mainApp.getEquationBuilder();
        Calculation calc = ebp.getCalculation();
        mainApp.getEquationBuilder().addCalculationToTable(calc);

    }

    private void saveCalcs() {
        EquationBuilderPanel ebp = mainApp.getEquationBuilder();
        ArrayList al = mainApp.getEquationBuilder().getAllCalculations();

    }

}
