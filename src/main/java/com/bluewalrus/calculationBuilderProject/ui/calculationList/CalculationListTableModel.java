package com.bluewalrus.calculationBuilderProject.ui.calculationList;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.bluewalrus.calculationBuilderProject.model.Calculation;
import com.bluewalrus.calculationBuilderProject.model.Empty;
import com.bluewalrus.calculationBuilderProject.model.Input;
import com.bluewalrus.calculationBuilderProject.model.operators.AdditionOperator;
import com.bluewalrus.calculationBuilderProject.model.operators.DivisionOperator;

public class CalculationListTableModel extends AbstractTableModel {

    private String[] columnHeaders = new String[]{"Name", "Symbol"};
    private ArrayList calculations = new ArrayList();

    public CalculationListTableModel() {
        Calculation o1 = new Calculation("Earnings before int..", "EBITDA");
        o1.setRootObject(new Empty());
        Calculation o2 = new Calculation("Net Present Value", "NPV");
        o2.setRootObject(new Empty());
        Calculation o3 = new Calculation("cdd something", "CDD");
        o3.setRootObject(new Empty());
        Calculation o4 = new Calculation("something", "FSO");
        o4.setRootObject(new Empty());
        Calculation o5 = new Calculation("Missy J's calculation", "MJC");
        o5.setRootObject(new Empty());
        Calculation o6 = new Calculation("test a plus b", "TAB");
        o6.setRootObject(new Empty());

        AdditionOperator ao = new AdditionOperator();
        AdditionOperator ao2 = new AdditionOperator();
        ao.setFirstOperand(new Input("blah1", "b1"));
        ao.setSecondOperand(ao2);
        ao2.setFirstOperand(new DivisionOperator());
        ao2.setSecondOperand(new Input("MC", "MC"));

        System.out.println("ao to string = " + ao.toString());

        o6.setRootObject(ao);

        calculations.add(o1);
        calculations.add(o2);
        calculations.add(o3);
        calculations.add(o4);
        calculations.add(o5);
        calculations.add(o6);
    }

    public int getRowCount() {
        return calculations.size();
    }

    public int getColumnCount() {
        return columnHeaders.length;
    }

    public String getColumnName(int i) {
        return columnHeaders[i];

    }

    public Object getValueAt(int row, int col) {

        Calculation calculation = (Calculation) calculations.get(row);

        if (col == 0) {
            return calculation.getSymbol();
        } else if (col == 1) {
            return calculation.getName();
        }
        return null;
    }

    public Calculation getCalculationAt(int i) {
        return (Calculation) calculations.get(i);
    }

    public void addCalculation(Calculation calculation) {
        calculations.add(calculation);
        fireTableDataChanged();
    }

    public ArrayList getAllCalculations() {
        return calculations;
    }

}
