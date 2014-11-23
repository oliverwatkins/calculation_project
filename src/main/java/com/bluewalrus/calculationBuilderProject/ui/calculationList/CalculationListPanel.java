package com.bluewalrus.calculationBuilderProject.ui.calculationList;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.bluewalrus.calculationBuilderProject.main.CalculationSelectionProcessor;
import com.bluewalrus.calculationBuilderProject.model.Calculation;

public class CalculationListPanel extends JPanel {

    private final CalculationListTableModel model = new CalculationListTableModel();

    public CalculationListPanel() {
        initGui();
    }

    private void initGui() {
        CalculationListTableRenderer renderer = new CalculationListTableRenderer();
        final CalculationListTable oTable = new CalculationListTable(model);
        for (int i = 0; i < oTable.getColumnCount(); i++) {
            oTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
        setLayout(new BorderLayout());
        add(new JScrollPane(oTable));
        oTable.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent arg0) {
                if (arg0.getClickCount() > 1) {
                    System.out.println("double clicking on a calc");
                    int i = oTable.getSelectedRow();

                    Calculation calc = model.getCalculationAt(i);

                    CalculationSelectionProcessor.setCalculation(calc);

                }
            }

            public void mousePressed(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            public void mouseReleased(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    public CalculationListTableModel getTableModel() {
        return model;
    }

}
