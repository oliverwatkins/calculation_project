package com.bluewalrus.calculationBuilderProject.ui.operator;

import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import com.bluewalrus.calculationBuilderProject.model.operators.Operator;

public class OperatorTable extends JTable implements DragGestureListener, DragSourceListener {

    public OperatorTable(TableModel model) {
        super(model);
        this.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        DragSource dragSource = DragSource.getDefaultDragSource();
        dragSource.createDefaultDragGestureRecognizer(
                this, DnDConstants.ACTION_COPY, this);
    }

    public void dragGestureRecognized(DragGestureEvent dge) {
        OperatorTableModel model = (OperatorTableModel) getModel();
        Point location = dge.getDragOrigin();
        int i = this.getSelectedRow();
        Operator operator = model.getOperatorAt(i);
        if (operator != null) {
            Transferable transferable = new SimpleTransferable(operator);
            dge.startDrag(null, transferable, this);
        }
    }

    public void dragEnter(DragSourceDragEvent dsde) {
        /**
         * @todo Implement this java.awt.dnd.DragSourceListener method
         */
    }

    public void dragOver(DragSourceDragEvent dsde) {
        /**
         * @todo Implement this java.awt.dnd.DragSourceListener method
         */
    }

    public void dropActionChanged(DragSourceDragEvent dsde) {
        /**
         * @todo Implement this java.awt.dnd.DragSourceListener method
         */
    }

    public void dragExit(DragSourceEvent dse) {
        /**
         * @todo Implement this java.awt.dnd.DragSourceListener method
         */
    }

    public void dragDropEnd(DragSourceDropEvent dsde) {
        /**
         * @todo Implement this java.awt.dnd.DragSourceListener method
         */
    }

}
