package com.example.design.InterpreterMethod;

public class AdditionExpression extends OperatorExpression {
    public AdditionExpression(ArithmeticExpression expr1, ArithmeticExpression expr2) {
        super(expr1, expr2);
    }

    @Override
    public int interpret() {
        return expr1.interpret() + expr2.interpret();
    }
}
