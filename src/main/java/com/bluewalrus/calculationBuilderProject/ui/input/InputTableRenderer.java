package com.bluewalrus.calculationBuilderProject.ui.input;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.bluewalrus.calculationBuilderProject.ui.Colors;

public class InputTableRenderer extends DefaultTableCellRenderer {

    public InputTableRenderer() {
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        if (column == 0) {
            setForeground(Colors.INPUT_COLOR);
        } else if (column == 1) {
            setForeground(Colors.INPUT_COLOR);
        }
        JLabel c = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//		c.setIcon(new ImageIcon("/Calculation16.gif"));

        return c;
    }
}
