package com.example.myfirstcalculator.presenter;

import com.example.myfirstcalculator.model.CalculatorReal;
import com.example.myfirstcalculator.model.Operation;
import com.example.myfirstcalculator.view.CalculatorView;


public class CalculatorPresenter {

    private static final int BASE = 10;

    private final CalculatorReal calculator;
    private final CalculatorView view;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private boolean isDotPressed;
    private int divider;

    private Operation previousOperation;

    public CalculatorPresenter(CalculatorReal calculator, CalculatorView view) {
        this.calculator = calculator;
        this.view = view;
    }

    public void onDigitPress(Integer number) {
        if (argTwo == null) {

            if (isDotPressed) {
                argOne = argOne + number / (double) divider;
                divider *= BASE;
            } else {
                argOne = argOne * BASE + number;
            }

            displayResult(argOne);
        } else {
            if (isDotPressed) {
                argTwo = argTwo + number / (double) divider;
                divider *= BASE;
            } else {
                argTwo = argTwo * BASE + number;
            }
            displayResult(argTwo);
        }
    }

    public void onOperationPress(Operation operation) {
        if (previousOperation != null) {
            double result = calculator.doOperation(argOne, argTwo, previousOperation);

            displayResult(result);

            argOne = result;
        }

        previousOperation = operation;
        argTwo = 0.0;
        isDotPressed = false;
    }

    public void onDotPress() {
        if (!isDotPressed) {
            isDotPressed = true;
            divider = BASE;
        }
    }

    public void onEqualsPress() {
        if (argOne == 0.0) {
            onClearPress();
        } else if (argTwo == null) {
            displayResult(argOne);
        } else {
            argOne = calculator.doOperation(argOne, argTwo, previousOperation);
            displayResult(argOne);
            previousOperation = null;
            argTwo = null;
        }
    }

    public void onClearPress() {
        argOne = 0.0;
        argTwo = null;
        previousOperation = null;
        isDotPressed = false;
        displayResult(argOne);
    }

    private void displayResult(double arg) {
        long longValue = (long) arg;

        if (longValue == arg) {
            view.showResult(String.valueOf(longValue));
        } else {
            view.showResult(String.valueOf(arg));
        }
    }
}
