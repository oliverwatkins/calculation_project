package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;

public abstract class PowerLikeNode extends BinaryOperatorNode {

    public PowerLikeNode() {
        guiInit();
    }

    private void guiInit() {
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 0;
        gbc2.gridy = 1;
        this.add(firstOperand, gbc2);

        secondOperand.setSize(firstOperand.getSize());

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 0;
        this.add(secondOperand, gbc3);

        secondOperand.setSize(new Dimension(10, 10));

        JPanel spaceBuffer = new JPanel();
        spaceBuffer.setSize(secondOperand.getSize());
        spaceBuffer.setPreferredSize(secondOperand.getSize());
        spaceBuffer.setMaximumSize(secondOperand.getSize());

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 2;
        this.add(spaceBuffer, gbc4);

    }

}
