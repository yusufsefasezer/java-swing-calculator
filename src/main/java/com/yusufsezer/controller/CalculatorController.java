package com.yusufsezer.controller;

import com.yusufsezer.model.CalculatorModel;
import com.yusufsezer.view.CalculatorView;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

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
        view.makebutton("7", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 5;
        view.makebutton("8", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 9;
        view.makebutton("9", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 12;
        view.makebutton("/", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        view.makebutton("4", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 5;
        view.makebutton("5", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 9;
        view.makebutton("6", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 12;
        view.makebutton("*", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        view.makebutton("1", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 5;
        view.makebutton("2", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 9;
        view.makebutton("3", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 12;
        view.makebutton("-", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        view.makebutton("C", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 5;
        view.makebutton("0", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 9;
        view.makebutton("=", gridBagConstraints, new DefaultButtonListener());

        gridBagConstraints.gridx = 12;
        view.makebutton("+", gridBagConstraints, new DefaultButtonListener());

    }

    public void showGUI() {
        calculatorView.setVisible(true);
    }

    private static class DefaultButtonListener implements ActionListener {

        public DefaultButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

}
