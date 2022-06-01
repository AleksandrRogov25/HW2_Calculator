package com.example.hw2_calculator;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(getAppTheme(R.style.AppThemeLight));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initThemeChooser();
        Button button18 = findViewById(R.id.button_back);
        settingsSetOnClickListener(button18);
    }
    private void initThemeChooser() {
        initRadioButton(findViewById(R.id.radioButtonAppThemeLight), AppThemeLight);
        initRadioButton(findViewById(R.id.radioButtonMyDarkTheme), MyDarkTheme);
        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton) rg.getChildAt(getCodeStyle(AppThemeLight))).setChecked(true);
    }

    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                setAppTheme(codeStyle);
                recreate();
            }
        });
    }


    private void settingsSetOnClickListener(Button buttonback) {
        buttonback.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

