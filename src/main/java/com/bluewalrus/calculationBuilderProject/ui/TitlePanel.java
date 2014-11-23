package com.bluewalrus.calculationBuilderProject.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TitlePanel extends JPanel {

    private JTextField textField = new JTextField();

    public TitlePanel() {
//		textField.setSize(new Dimension(150, this.getHeight()));
//		textField.setMinimumSize(new Dimension(150, this.getHeight()));
//		textField.setMaximumSize(new Dimension(150, this.getHeight()));

        this.setLayout(new GridBagLayout());
//		this.setBorder(BorderFactory.createLineBorder(Color.RED));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(2, 2, 2, 2);

        this.add(new JLabel("name :"), gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = .2;

        this.add(textField, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;

        JLabel label = new JLabel("f(x) = ");
        label.setFont(new Font("Monotype Corsiva", Font.PLAIN, 12));

        this.add(label, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = .5;

        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        this.add(p, gbc);

    }

    public String getCalculationName() {
        return this.textField.getText();
    }

}
