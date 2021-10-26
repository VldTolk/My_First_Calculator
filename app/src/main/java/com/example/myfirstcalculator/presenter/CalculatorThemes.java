package com.example.myfirstcalculator.presenter;

import android.content.Context;
import android.content.SharedPreferences;

public class CalculatorThemes {

    private static final String ARG_THEME = "ARG_THEME";

    private final SharedPreferences sharedPreferences;

    public CalculatorThemes(Context context) {
        this.sharedPreferences = context.getSharedPreferences("theme", Context.MODE_PRIVATE);
    }

    public Theme getTheme() {
        String key = sharedPreferences.getString(ARG_THEME, Theme.LIGHT.getKey());

        for (Theme theme : Theme.values()) {
            if (theme.getKey().equals(key)) {
                return theme;
            }
        }

        return Theme.LIGHT;
    }

    public void setTheme(Theme theme) {
        sharedPreferences.edit().putString(ARG_THEME, theme.getKey()).apply();
    }

}
