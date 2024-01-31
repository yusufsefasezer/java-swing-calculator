package com.yusufsezer.operator;

import com.yusufsezer.contact.ICalculatorStrategy;

public class AddOperator implements ICalculatorStrategy {

    @Override
    public Number execute(Number operand1, Number operand2) {
        return operand1.doubleValue() + operand2.doubleValue();
    }

}
