package com.bluewalrus.calculationBuilderProject.ui.operator;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bluewalrus.calculationBuilderProject.model.operators.AdditionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.DivisionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.MultiplicationOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.Operator;
import com.bluewalrus.calculationBuilderProject.model.operators.PowerOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SigmaOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.SubtractionOperator;

public class OperatorTableModel extends AbstractTableModel {

    private String[] columnHeaders = new String[]{"Name", "Symbol"};
    private ArrayList operators = new ArrayList();

    public OperatorTableModel() {

        AdditionOperator o1 = new AdditionOperator();
        SubtractionOperator o2 = new SubtractionOperator();
        DivisionOperator o3 = new DivisionOperator();
        MultiplicationOperator o4 = new MultiplicationOperator();
        SigmaOperator o5 = new SigmaOperator();
        PowerOperator o6 = new PowerOperator();

        operators.add(o1);
        operators.add(o2);
        operators.add(o3);
        operators.add(o4);
        operators.add(o5);
        operators.add(o6);

    }

    public int getRowCount() {
        return operators.size();
    }

    public int getColumnCount() {
        return columnHeaders.length;
    }

    public Object getValueAt(int row, int col) {

        Operator operator = (Operator) operators.get(row);

        if (col == 0) {
            return operator.getName();
        } else if (col == 1) {
            return operator.getSymbol();
        }
        return null;
    }

    public Operator getOperatorAt(int i) {
        return (Operator) operators.get(i);
    }

}
