package com.yusufsezer.operator;

import com.yusufsezer.contact.ICalculatorStrategy;

public class DivideOperator implements ICalculatorStrategy {

    @Override
    public Number execute(Number operand1, Number operand2) {
        if (operand2.doubleValue() != 0) {
            return operand1.doubleValue() / operand2.doubleValue();
        } else {
            return Double.NaN;
        }
    }

}
