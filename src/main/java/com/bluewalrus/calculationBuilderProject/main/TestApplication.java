package com.bluewalrus.calculationBuilderProject.main;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TestApplication extends JFrame {

    private ControlPanel controlPanel;

    private EquationBuilderPanel eb = new EquationBuilderPanel();

    public TestApplication() {

        controlPanel = new ControlPanel(this);

        this.getContentPane().setLayout(new BorderLayout());

        this.getContentPane().add(eb);
        this.getContentPane().add(controlPanel, BorderLayout.SOUTH);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TestApplication t = new TestApplication();
        t.setSize(800, 500);
        t.setVisible(true);
    }

    public EquationBuilderPanel getEquationBuilder() {
        return eb;
    }
}
