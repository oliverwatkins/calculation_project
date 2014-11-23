package com.bluewalrus.calculationBuilderProject.main;

import java.awt.Color;
import java.awt.GridBagConstraints;

/**
 * A left-right node is a node that is like subtraction, addition, but not division.
 * @author oliver
 */
public abstract class LeftRightNode extends BinaryOperatorNode {

    private BracketPair bracketPair = new BracketPair();

    public LeftRightNode() {

        guiInit();
    }

    private void guiInit() {
        this.setBackground(Color.WHITE);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.fill = GridBagConstraints.VERTICAL;
        this.add(bracketPair.getLeftBracket(), gbc1);

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        this.add(firstOperand, gbc2);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        this.add(getOperatorLabel(), gbc);

        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 3;
        gbc3.gridy = 0;
//		gbc3.anchor = GridBagConstraints.SOUTH;
        this.add(secondOperand, gbc3);

        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 4;
        gbc4.gridy = 0;
        gbc4.fill = GridBagConstraints.VERTICAL;
        this.add(bracketPair.getRightBracket(), gbc4);
    }
}
