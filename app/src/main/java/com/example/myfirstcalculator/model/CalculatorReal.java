package com.example.myfirstcalculator.model;

public class CalculatorReal implements Calculator {

    @Override
    public double doOperation(double argOne, double argTwo, Operation operation) {
        switch (operation) {
            case PLUS:
                return argOne + argTwo;
            case MINUS:
                return argOne - argTwo;
            case MULTIPLICATION:
                return argOne * argTwo;
            case DIVISION:
                return argOne / argTwo;
        }
        return 0.0;
    }
}
