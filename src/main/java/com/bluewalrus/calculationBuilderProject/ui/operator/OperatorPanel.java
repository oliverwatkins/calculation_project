package com.bluewalrus.calculationBuilderProject.ui.operator;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class OperatorPanel extends JPanel {

    public OperatorPanel() {
        OperatorTableModel model = new OperatorTableModel();
        OperatorTable oTable = new OperatorTable(model);
        setLayout(new BorderLayout());
        add(new JScrollPane(oTable));

    }

}
