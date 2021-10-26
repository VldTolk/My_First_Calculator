package com.example.myfirstcalculator.presenter;

import androidx.annotation.StyleRes;

import com.example.myfirstcalculator.R;

public enum Theme {

    LIGHT(R.style.Theme_MyFirstCalculator, "light"),
    DARK(R.style.Theme_MyFirstCalculator_Dark, "dark");

    @StyleRes
    private final int theme;

    private final String key;

    Theme(int theme, String key) {
        this.theme = theme;
        this.key = key;
    }

    public int getTheme() {
        return theme;
    }

    public String getKey() {
        return key;
    }
}
