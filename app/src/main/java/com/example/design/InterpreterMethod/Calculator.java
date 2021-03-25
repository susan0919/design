package com.example.design.InterpreterMethod;

import java.util.Stack;

public class Calculator {
    private Stack<ArithmeticExpression> mExpStack = new Stack<ArithmeticExpression>();

    public Calculator(String expression) {
        ArithmeticExpression expression1, expression2;
        String[] elements = expression.split(" ");

        for (int i = 0; i < elements.length; i++) {
            switch (elements[i].charAt(0)) {
                case '+':
                    expression1 = mExpStack.pop();
                    expression2 = new NumExpression(Integer.valueOf(elements[++i]));
                    mExpStack.push(new AdditionExpression(expression1, expression2));
                    break;
                default:
                    mExpStack.push(new NumExpression(Integer.valueOf(expression)));
                    break;
            }
        }

    }

    public int Calculate() {
        return mExpStack.pop().interpret();
    }

}
