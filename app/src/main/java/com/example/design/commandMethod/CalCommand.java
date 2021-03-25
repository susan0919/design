package com.example.design.commandMethod;

public class CalCommand extends Command {
    public CalCommand(Caculator caculator, char op, int num) {
        super(caculator, op, num);
    }

    @Override
    public void excute() {
        caculator.Operation(op, num);

    }

    @Override
    public char unExcute(char op) {
        char undo =' ';
        switch (op) {
            case '+':
                undo = '-';
                break;
            case '-':
                undo = '+';
                break;
            case '*':
                undo = '/';
                break;
            case '/':
                undo = '*';
                break;
        }
        return undo;


    }
}
