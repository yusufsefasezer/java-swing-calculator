package com.yusufsezer.controller;

import com.yusufsezer.contact.ICalculatorStrategy;
import com.yusufsezer.model.CalculatorModel;
import com.yusufsezer.operator.AddOperator;
import com.yusufsezer.operator.DivideOperator;
import com.yusufsezer.operator.MultiplyOperator;
import com.yusufsezer.operator.SubtractOperator;
import com.yusufsezer.view.CalculatorView;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.calculatorModel = model;
        this.calculatorView = view;

        createView();
    }

    private void createView() {
        GridBagConstraints gridBagConstraints = new GridBagConstraints(1, 1, 1, 1, 50D, 10D, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 1, 1);

        gridBagConstraints.gridwidth = 20;
        gridBagConstraints.gridx = 1;
        calculatorView.createDisplayText(gridBagConstraints);

        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        calculatorView.makebutton("7", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        calculatorView.makebutton("8", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        calculatorView.makebutton("9", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        calculatorView.makebutton("/", gridBagConstraints, new OperatorActionListener(new DivideOperator()));

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        calculatorView.makebutton("4", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        calculatorView.makebutton("5", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        calculatorView.makebutton("6", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        calculatorView.makebutton("*", gridBagConstraints, new OperatorActionListener(new MultiplyOperator()));

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        calculatorView.makebutton("1", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 5;
        calculatorView.makebutton("2", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        calculatorView.makebutton("3", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 12;
        calculatorView.makebutton("-", gridBagConstraints, new OperatorActionListener(new SubtractOperator()));

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        calculatorView.makebutton("C", gridBagConstraints, clearActionListener);

        gridBagConstraints.gridx = 5;
        calculatorView.makebutton("0", gridBagConstraints, defaultActionListener);

        gridBagConstraints.gridx = 9;
        calculatorView.makebutton("=", gridBagConstraints, equalActionListener);

        gridBagConstraints.gridx = 12;
        calculatorView.makebutton("+", gridBagConstraints, new OperatorActionListener(new AddOperator()));
    }

    public void showGUI() {
        calculatorView.setVisible(true);
    }

    private final ActionListener defaultActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source instanceof JButton jButton) {
                String digit = jButton.getText();
                String newText = calculatorView.getDisplayText() + digit;
                calculatorView.setDisplayText(newText);
            }
        }
    };

    private final ActionListener clearActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.getNumbers().clear();
            calculatorModel.getOperators().clear();
            calculatorView.setDisplayText("");
        }
    };

    private final ActionListener equalActionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Double input = Double.valueOf(calculatorView.getDisplayText());
            calculatorModel.getNumbers().push(input);
            Number result = calculatorModel.calculate();
            String newText = String.valueOf(result);
            calculatorView.setDisplayText(newText);
        }
    };

    private class OperatorActionListener implements ActionListener {

        private final ICalculatorStrategy calculatorStrategy;

        private OperatorActionListener(ICalculatorStrategy calculatorStrategy) {
            this.calculatorStrategy = calculatorStrategy;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Double input = Double.valueOf(calculatorView.getDisplayText());
            calculatorModel.getNumbers().push(input);
            calculatorModel.getOperators().push(calculatorStrategy);
            String newText = "";
            calculatorView.setDisplayText(newText);
        }
    };

}
