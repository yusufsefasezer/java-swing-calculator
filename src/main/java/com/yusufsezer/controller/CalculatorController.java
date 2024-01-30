package com.yusufsezer.controller;

import com.yusufsezer.model.CalculatorModel;
import com.yusufsezer.view.CalculatorView;

public class CalculatorController {

    private final CalculatorModel calculatorModel;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.calculatorModel = model;
        this.calculatorView = view;
    }

    public void showGUI() {
        calculatorView.setVisible(true);
    }

}
