package com.example.design.InterpreterMethod;

public abstract class OperatorExpression extends ArithmeticExpression {
    protected ArithmeticExpression expr1, expr2;

    public OperatorExpression(ArithmeticExpression expr1, ArithmeticExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

}
