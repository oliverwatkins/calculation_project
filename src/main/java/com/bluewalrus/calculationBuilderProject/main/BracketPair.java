package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JPanel;

public class BracketPair implements ComponentListener {

    private Bracket leftBracket = new Bracket(true);
    private Bracket rightBracket = new Bracket(false);

    public BracketPair() {

    }

    public JPanel getLeftBracket() {
        return leftBracket;

    }

    public JPanel getRightBracket() {
        return rightBracket;

    }

    public void componentResized(ComponentEvent arg0) {
        leftBracket.setDimensionAndFont(new Dimension(leftBracket.getParent().getWidth(), leftBracket.getParent().getHeight()));
        rightBracket.setDimensionAndFont(new Dimension(leftBracket.getParent().getWidth(), leftBracket.getParent().getHeight()));

        leftBracket.updateUI();
    }

    public void componentMoved(ComponentEvent arg0) {
    }

    public void componentShown(ComponentEvent arg0) {
    }

    public void componentHidden(ComponentEvent arg0) {
    }
}
