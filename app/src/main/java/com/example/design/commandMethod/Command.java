package com.example.design.commandMethod;

public abstract class Command {
    protected Caculator caculator;
    protected char op;
    protected int num;

    public Command(Caculator caculator, char op, int num) {
        this.caculator = caculator;
        this.op = op;
        this.num = num;
    }

    public abstract void excute();

    public abstract char unExcute(char op);
}
