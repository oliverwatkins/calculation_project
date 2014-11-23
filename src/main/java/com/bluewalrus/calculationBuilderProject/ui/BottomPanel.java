package com.bluewalrus.calculationBuilderProject.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.bluewalrus.calculationBuilderProject.ui.calculationList.CalculationListPanel;
import com.bluewalrus.calculationBuilderProject.ui.calculationList.CalculationListTableModel;
import com.bluewalrus.calculationBuilderProject.ui.input.InputPanel;

public class BottomPanel extends JPanel {

    private CalculationListPanel calcListPanel = new CalculationListPanel();
    private InputPanel inputPanel = new InputPanel();

    public BottomPanel() {
        initGui();
    }

    private void initGui() {
        JTabbedPane tabbedPane = new JTabbedPane();
        this.setLayout(new BorderLayout());
        this.add(tabbedPane);
        tabbedPane.add("inputs", inputPanel);
        tabbedPane.add("calculations", calcListPanel);

    }

    public CalculationListTableModel getCalculationTableModel() {
        return calcListPanel.getTableModel();

    }

//	public
}
