package com.yusufsezer.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class CalculatorModel {

    private String displayText;
    private Number result;
    private Number current;
    private Deque<Number> operand;

    public CalculatorModel() {
        displayText = "";
        result = 0;
        current = 0;
        operand = new ArrayDeque<>();
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public Number getResult() {
        return result;
    }

    public Number getCurrent() {
        return current;
    }

}
