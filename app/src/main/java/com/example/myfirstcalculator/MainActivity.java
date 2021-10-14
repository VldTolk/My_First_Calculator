package com.example.myfirstcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.myfirstcalculator.model.CalculatorReal;
import com.example.myfirstcalculator.model.Operation;
import com.example.myfirstcalculator.presenter.CalculatorPresenter;
import com.example.myfirstcalculator.view.CalculatorView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    CalculatorPresenter presenter = new CalculatorPresenter(new CalculatorReal(), this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.output);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.key_0, 0);
        digits.put(R.id.key_1, 1);
        digits.put(R.id.key_2, 2);
        digits.put(R.id.key_3, 3);
        digits.put(R.id.key_4, 4);
        digits.put(R.id.key_5, 5);
        digits.put(R.id.key_6, 6);
        digits.put(R.id.key_7, 7);
        digits.put(R.id.key_8, 8);
        digits.put(R.id.key_9, 9);

        View.OnClickListener digitsClick = view -> presenter.onDigitPress(digits.get(view.getId()));

        findViewById(R.id.key_0).setOnClickListener(digitsClick);
        findViewById(R.id.key_1).setOnClickListener(digitsClick);
        findViewById(R.id.key_2).setOnClickListener(digitsClick);
        findViewById(R.id.key_3).setOnClickListener(digitsClick);
        findViewById(R.id.key_4).setOnClickListener(digitsClick);
        findViewById(R.id.key_5).setOnClickListener(digitsClick);
        findViewById(R.id.key_6).setOnClickListener(digitsClick);
        findViewById(R.id.key_7).setOnClickListener(digitsClick);
        findViewById(R.id.key_8).setOnClickListener(digitsClick);
        findViewById(R.id.key_9).setOnClickListener(digitsClick);

        Map<Integer, Operation> operations = new HashMap<>();
        operations.put(R.id.key_multiplication, Operation.MULTIPLICATION);
        operations.put(R.id.key_division, Operation.DIVISION);
        operations.put(R.id.key_minus, Operation.MINUS);
        operations.put(R.id.key_plus, Operation.PLUS);

        View.OnClickListener operationsClick = view -> presenter.onOperationPress(operations.get(view.getId()));

        findViewById(R.id.key_multiplication).setOnClickListener(operationsClick);
        findViewById(R.id.key_division).setOnClickListener(operationsClick);
        findViewById(R.id.key_minus).setOnClickListener(operationsClick);
        findViewById(R.id.key_plus).setOnClickListener(operationsClick);

        View.OnClickListener dotClick = view -> presenter.onDotPress();
        findViewById(R.id.key_dot).setOnClickListener(dotClick);

        View.OnClickListener equalsClick = view -> presenter.onEqualsPress();
        findViewById(R.id.key_equals).setOnClickListener(equalsClick);

        View.OnClickListener clearClick = view -> presenter.onClearPress();
        findViewById(R.id.key_C).setOnClickListener(clearClick);

/*        View.OnClickListener backspaceClick = view -> presenter.onBackspacePress();
        findViewById(R.id.key_backspace).setOnClickListener(backspaceClick);*/
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }
}