package com.example.myfirstcalculator.presenter;

import com.example.myfirstcalculator.model.Calculator;
import com.example.myfirstcalculator.model.Operation;
import com.example.myfirstcalculator.view.CalculatorView;


public class CalculatorPresenter {

    private static final int BASE = 10;

    private final Calculator calculator;
    private final CalculatorView view;

    private Double argOne = 0.0;
    private Double argTwo = null;

    private boolean isDotPressed;
    private int divider;

    private Operation previousOperation;

    public CalculatorPresenter(Calculator calculator, CalculatorView view) {
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
        argOne = calculator.doOperation(argOne, argTwo, previousOperation);
        displayResult(argOne);
        previousOperation = null;
        argTwo = null;
    }

    public void onClearPress() {
        argOne = 0.0;
        argTwo = null;
        previousOperation = null;
        isDotPressed = false;
        displayResult(argOne);
    }

/*
    public void onBackspacePress(){
        if (argTwo == null) {

            if (isDotPressed) {
                String s = argOne.toString();
                s = s.substring(0, s.length() - 1);
                argOne = Double.valueOf(s);
                isDotPressed = false;
                try {
                    Integer.valueOf(s);
                } catch (NumberFormatException n){
                    isDotPressed = true;
                }
            } else {
                String s = argOne.toString();
                s = s.substring(0, s.length() - 3);
                if (s.equals("")) {
                    argOne = 0.0;
                } else {
                    argOne = Double.valueOf(s);
                }
            }

            displayResult(argOne);
        } else {

            if (isDotPressed) {
                String[] s = argTwo.toString().split("\\.");
                s[1] = s[1].substring(0, s[1].length() - 1);
                if (s[1].equals("")){
                    isDotPressed = false;
                }
                argTwo = Double.valueOf(Arrays.toString(s));

            } else {
                String s = argTwo.toString();
                String t = s.substring(0, s.length() - 3);
                if (t.equals("")) {
                    argTwo = 0.0;
                } else {
                    argTwo = Double.valueOf(t);
                }
            }

            displayResult(argTwo);
        }
    }
*/

    private void displayResult(double arg) {
        long longValue = (long) arg;

        if (longValue == arg) {
            view.showResult(String.valueOf(longValue));
        } else {
            view.showResult(String.valueOf(arg));
        }
    }
}
