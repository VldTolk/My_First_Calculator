package com.example.myfirstcalculator.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfirstcalculator.R;
import com.example.myfirstcalculator.presenter.CalculatorThemes;
import com.example.myfirstcalculator.presenter.Theme;

public class SettingsActivity extends AppCompatActivity {

    private static final String ARG_THEME = "ARG_THEME";

    CalculatorThemes storage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = new CalculatorThemes(this);
        Intent launchIntent = getIntent();
        Theme launchTheme = (Theme) launchIntent.getSerializableExtra(ARG_THEME);
        setTheme(storage.getTheme().getTheme());
        setContentView(R.layout.settings_activity);

        View.OnClickListener lightButton = view -> {
            Intent data = new Intent();
            data.putExtra(ARG_THEME, Theme.LIGHT);
            setResult(Activity.RESULT_OK, data);
            finish();
        };
        findViewById(R.id.light_theme_button).setOnClickListener(lightButton);

        View.OnClickListener darkButton = view -> {
            Intent data = new Intent();
            data.putExtra(ARG_THEME, Theme.DARK);
            setResult(Activity.RESULT_OK, data);
            finish();
        };
        findViewById(R.id.dark_theme_button).setOnClickListener(darkButton);

        View.OnClickListener backButton = view -> finish();
        findViewById(R.id.back_button).setOnClickListener(backButton);
    }

}
