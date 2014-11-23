package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.BorderFactory;

import com.bluewalrus.calculationBuilderProject.model.CalculationObject;
import com.bluewalrus.calculationBuilderProject.model.operators.Operator;
import com.bluewalrus.calculationBuilderProject.ui.MouseClickManager;
import com.bluewalrus.calculationBuilderProject.ui.NodeDropProcessor;
import javax.swing.JComponent;

/**
 * Central class for extending
 *
 * Support for drag n drop, mouse click handling, selection
 *
 *
 * @author Olly
 *
 */
public abstract class Node extends JComponent implements MouseListener, Serializable {

    private DragSource dragSource;
    private DropTarget dropTarget;
    private boolean isSelected = false;
//    private int fontSize = 10;

    // list of DataFlavors supported
    public static final DataFlavor[] supportedFlavors = new DataFlavor[]{
        new DataFlavor(Operator.class, "Operator"),};

    public Node() {
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        this.setLayout(new GridBagLayout());
        this.addMouseListener(this);
//		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // setting things up
        final DropTargetListener dropTargetListener = new DropTargetListener() {

            public void dragOver(DropTargetDragEvent dtde) {
                doDragOver(dtde);
            }

            public void drop(DropTargetDropEvent dtde) {
                doDrop(dtde);
            }

            //ignore these				
            public void dropActionChanged(DropTargetDragEvent dtde) {
            }

            public void dragExit(DropTargetEvent dte) {
            }

            public void dragEnter(DropTargetDragEvent dtde) {
            }
        };

        dragSource = DragSource.getDefaultDragSource();
        dropTarget = new DropTarget(this, dropTargetListener);

    }

    public abstract CalculationObject getModelObject();

    public abstract void setModelObject(CalculationObject calcObj);

    // DropTargetListener support
    private void doDragOver(DropTargetDragEvent dtde) {

        if (acceptDrag(dtde)) {
            dtde.acceptDrag(dtde.getDropAction());
        } else {
            dtde.rejectDrag();
        }
    }

    /**
     * acceptDrag. Can only be an empty node at this stage. In the future we may
     * want to be able to drag and drop to replace nodes rather than just drag
     * onto empty nodes.
     *
     * @param dtde
     * @return is acceptable
     */
    private boolean acceptDrag(DropTargetDragEvent dtde) {

        Point location = dtde.getLocation();

        Component c = this.getComponentAt(location);

        if (c instanceof EmptyNode) {
            return true;
        }
        return false;
    }

    /**
     * Perform the drop
     *
     * @param dtde
     */
    private void doDrop(DropTargetDropEvent dtde) {
        dtde.acceptDrop(DnDConstants.ACTION_COPY);

        NodeDropProcessor.processDrop(this, dtde);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void selectedOff() {
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        isSelected = false;
    }

    public void selectedOn() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        isSelected = true;

    }

    public void mouseClicked(MouseEvent e) {
        MouseClickManager.processClick(e, this);
    }

    public void mousePressed(MouseEvent arg0) {
    }

    public void mouseReleased(MouseEvent arg0) {
    }

    public void mouseEntered(MouseEvent arg0) {
    }

    public void mouseExited(MouseEvent arg0) {
    }

    public void setFontSize(int i) {
//		fontSize = i;
    }
}
