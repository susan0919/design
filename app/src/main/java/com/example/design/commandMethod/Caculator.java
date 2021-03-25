package com.example.design.commandMethod;

import android.util.Log;

public class Caculator {

    private int total;

    public Caculator() {
        this.total = 0;
    }

    public void Operation(char op, int num) {
        switch (op) {
            case '+':
                total = total + num;
                break;
            case '-':
                total = total - num;
                break;
            case '*':
                total = total * num;
                break;
            case '/':
                total = total / num;
                break;
        }
        Log.d("Command", op + " " + num + " = " + total);
    }
}
