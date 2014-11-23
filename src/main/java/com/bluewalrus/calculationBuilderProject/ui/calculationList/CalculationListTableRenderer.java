package com.bluewalrus.calculationBuilderProject.ui.calculationList;

import java.awt.Component;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.bluewalrus.calculationBuilderProject.ui.Colors;

public class CalculationListTableRenderer extends DefaultTableCellRenderer {

    public CalculationListTableRenderer() {
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (column == 0) {
            setForeground(Colors.CALC_COLOR);
        } else if (column == 1) {
            setForeground(Colors.CALC_COLOR);
        }
        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setIcon(new ImageIcon("/images/Calculation16.gif"));

        return c;
    }
}
