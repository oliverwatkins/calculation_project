package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Color;
import java.awt.GridBagConstraints;

public abstract class UpDownNode extends BinaryOperatorNode {

    private BracketPair bracketPair = new BracketPair();

    public UpDownNode() {
        initGui();
    }

    private void initGui() {

//		this.setSize(new Dimension(70,25));
        this.setBackground(Color.WHITE);
        this.addComponentListener(bracketPair);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        this.add(firstOperand, gbc2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.add(getOperatorLabel(), gbc);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 1;
        gbc3.gridy = 2;
        this.add(secondOperand, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = 0;
        gbc4.gridheight = 3;
        gbc4.fill = GridBagConstraints.VERTICAL;

        this.add(bracketPair.getLeftBracket(), gbc4);

        GridBagConstraints gbc5 = new GridBagConstraints();
        gbc5.gridx = 2;
        gbc5.gridy = 0;
        gbc5.gridheight = 3;
        gbc5.fill = GridBagConstraints.VERTICAL;
        this.add(bracketPair.getRightBracket(), gbc5);

    }

}
