package com.bluewalrus.calculationBuilderProject.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.bluewalrus.calculationBuilderProject.main.Node;
import com.bluewalrus.calculationBuilderProject.ui.calculationViewer.CalculationViewerPanel;

public class TopPanel extends JPanel {

    private Node calculationRootNode;

    public TopPanel() {
        initGui();
    }

    private CalculationViewerPanel calculationViewerPanel = new CalculationViewerPanel();

    private XmlViewer xmlViewer = new XmlViewer();

    private void initGui() {
        JTabbedPane tabbedPane = new JTabbedPane();
        this.setLayout(new BorderLayout());
        this.add(tabbedPane);
        tabbedPane.add("Calculation Viewer", calculationViewerPanel);
        tabbedPane.add("Tree Viewer", new JPanel());
        tabbedPane.add("XML", xmlViewer);

    }

    public CalculationViewerPanel getViewerPanel() {
        return calculationViewerPanel;
    }

//	public Node getCalculationRootNode() {
//		return calculationRootNode;
//	}
//
//	public void setCalculationRootNode(Node calculationRootNode) {
//		this.calculationRootNode = calculationRootNode;
//	}
}
