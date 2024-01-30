package com.yusufsezer.controller;

import com.yusufsezer.model.CalculatorModel;
import com.yusufsezer.view.CalculatorView;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    private final ActionListener defaultActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source instanceof JButton jButton) {
                String digit = jButton.getText();
                String newText = calculatorModel.getDisplayText() + digit;
                calculatorModel.setDisplayText(newText);
                calculatorView.setDisplayText(calculatorModel.getDisplayText());
            }
        }
    };

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.calculatorModel = model;
        this.calculatorView = view;

        GridBagConstraints gridBagConstraints = new GridBagConstraints(1, 1, 1, 1, 50D, 10D, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 1, 1);

        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridx = 1;
        view.createDisplayText(gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        view.makebutton("7", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        view.makebutton("8", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        view.makebutton("9", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        view.makebutton("/", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        view.makebutton("4", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        view.makebutton("5", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        view.makebutton("6", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        view.makebutton("*", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        view.makebutton("1", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        view.makebutton("2", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        view.makebutton("3", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        view.makebutton("-", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        view.makebutton("C", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        view.makebutton("0", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        view.makebutton("=", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        view.makebutton("+", gridBagConstraints, defaultActionListener);
    }

    public void showGUI() {
        calculatorView.setVisible(true);
    }

}
