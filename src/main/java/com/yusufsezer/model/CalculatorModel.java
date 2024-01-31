package com.yusufsezer.model;

import com.yusufsezer.contact.ICalculatorStrategy;
import java.util.Stack;

public class CalculatorModel {

    private Stack<Number> numbers;
    private Stack<ICalculatorStrategy> operators;

    public CalculatorModel() {
        numbers = new Stack<>();
        operators = new Stack<>();
    }

    public Stack<Number> getNumbers() {
        return numbers;
    }

    public Stack<ICalculatorStrategy> getOperators() {
        return operators;
    }

    public Number calculate() {
        Number result = 0;
        while (!operators.isEmpty()) {
            ICalculatorStrategy operator = operators.pop();
            Number n1 = numbers.pop();
            Number n2 = numbers.pop();
            result = operator.execute(n2, n1);
            numbers.push(result);
        }
        numbers.clear();
        return result;
    }

}
