package com.bluewalrus.calculationBuilderProject.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class XmlViewer extends JPanel {

    private JButton testButton = new JButton("test");

    public XmlViewer() {
        this.add(testButton);
        testButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                doPress();
            }
        });
    }

    private void doPress() {
        TopPanel tp = (TopPanel) this.getParent().getParent();

        String s = tp.getViewerPanel().getCalculationPanel().getRootNode().getModelObject().toString();
        System.out.println(s);
    }

}
