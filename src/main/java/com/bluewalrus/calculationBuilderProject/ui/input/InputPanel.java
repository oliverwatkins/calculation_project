package com.bluewalrus.calculationBuilderProject.ui.input;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InputPanel extends JPanel {

    public InputPanel() {
        initGui();
    }

    private void initGui() {
        InputTableModel model = new InputTableModel();
        InputTable oTable = new InputTable(model);
        InputTableRenderer renderer = new InputTableRenderer();
        for (int i = 0; i < oTable.getColumnCount(); i++) {
            oTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }

        setLayout(new BorderLayout());
        add(new JScrollPane(oTable));
    }

}
