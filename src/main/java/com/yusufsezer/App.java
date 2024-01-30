package com.yusufsezer;

import com.yusufsezer.controller.CalculatorController;
import com.yusufsezer.model.CalculatorModel;
import com.yusufsezer.view.CalculatorView;
import javax.swing.SwingUtilities;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorModel calculatorModel = new CalculatorModel();
            CalculatorView calculatorView = new CalculatorView();
            CalculatorController calculatorController = new CalculatorController(calculatorModel, calculatorView);
            calculatorController.show();
        });
    }
}
