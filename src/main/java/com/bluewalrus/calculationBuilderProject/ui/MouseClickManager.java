package com.bluewalrus.calculationBuilderProject.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import com.bluewalrus.calculationBuilderProject.main.Node;

public class MouseClickManager {

    public static void processClick(MouseEvent e, Node node) {

        ArrayList l = getNodeParentage(node);
        System.out.println("l.size = " + l.size());
//		boolean selectParent = false;
//		boolean nothingSelected = true;
        Node selectedNode = null;
        for (Iterator iter = l.iterator(); iter.hasNext();) {
            Node element = (Node) iter.next();
            if (element.isSelected()) {
                selectedNode = element;
                break;
            }

//			if (selectParent)
//			{
//				element.selectedOn();
//				nothingSelected = false;
//			}
//			else
//			{			
//				if (element.isSelected())
//				{
//					element.selectedOff();
//					selectParent = true;
//				}
//			}
        }
        if (selectedNode == null) {
            node.selectedOn();
        } else {
            selectedNode.selectedOff();
            Component c = selectedNode.getParent();
            if (c instanceof Node) {
                Node n = (Node) c;
                n.selectedOn();
            }

        }
//		if (nothingSelected)
//			node.selectedOn();

//		Node n = getSelectedNode(node); 
//		
//		if (n == null)
//			System.out.println("selected node is null");
//		else
//			System.out.println("n is not null");
//		if (node.isSelected())
//		{
//			node.selectedOff();
//		}
//		else
//		{
//			processEventFurther(e, node);
//
////			selectedOn();			
//		}
    }

    private static void processEventFurther(MouseEvent arg0, Node node) {
        Node n = getSelectedNode(node);

        //a node further up is selected
        if (n != null && n.getParent() instanceof Node) {
//			n.getParent().dispatchEvent(arg0);
        } else {
            node.selectedOn();
        }
    }

    /**
     * When a user clicks on a node, this method will recursively iterate
     * through node ancestors, and find the node which is currently highlighted.
     *
     * @param n
     * @return
     */
    private static Node getSelectedNode(Node n) {
        Container c = n.getParent();
        if (c instanceof Node) {
            Node node = (Node) c;
            if (node.isSelected()) {
                return node;
            }
            return getSelectedNode(node);

        } else {
            return null;
        }
    }

    private static ArrayList getNodeParentage(Node n) {
        ArrayList l = new ArrayList();
        l.add(n);
        Node currentNode = n;

        while (currentNode.getParent() instanceof Node) {
            Node parent = (Node) currentNode.getParent();
            l.add(parent);
            currentNode = parent;

        }
        return l;
    }

}
