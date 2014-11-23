package com.bluewalrus.calculationBuilderProject.ui.input;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bluewalrus.calculationBuilderProject.model.Input;

public class InputTableModel extends AbstractTableModel {

    private String[] columnHeaders = new String[]{"Symbol", "Name"};
    private ArrayList inputs = new ArrayList();

    public InputTableModel() {
        Input o1 = new Input("Earnings before int..", "EBITDA");
        Input o2 = new Input("Net Present Value", "NPV");
        Input o3 = new Input("cdd something", "CDD");
        Input o4 = new Input("something", "FSO");

        inputs.add(o1);
        inputs.add(o2);
        inputs.add(o3);
        inputs.add(o4);
    }

    public int getRowCount() {
        return inputs.size();
    }

    public String getColumnName(int i) {
        return columnHeaders[i];
    }

    public int getColumnCount() {
        return columnHeaders.length;
    }

    public Object getValueAt(int row, int col) {

        Input input = (Input) inputs.get(row);

        if (col == 0) {
            return input.getSymbol();
        } else if (col == 1) {
            return input.getName();
        }
        return null;
    }

    public Input getInputAt(int i) {
        // TODO Auto-generated method stub
        return (Input) inputs.get(i);
    }

}
