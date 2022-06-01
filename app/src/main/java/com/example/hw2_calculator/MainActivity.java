package com.example.hw2_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends BaseActivity {
    private TextView operation;
    Boolean isNull = true;
    String operator;
    String number;
    private String tv0tag = "tv0tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.operation);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button button0 = findViewById(R.id.button0);
        Button buttonDot = findViewById(R.id.buttondot);
        Button buttondivide = findViewById(R.id.buttondivide);
        Button buttonmultiply = findViewById(R.id.buttonmultiply);
        Button buttonsubtract = findViewById(R.id.buttonsubtract);
        Button buttonadd = findViewById(R.id.buttonadd);
        Button buttonequal = findViewById(R.id.buttonequal);
        Button buttonclear = findViewById(R.id.buttonclear);
        Button buttonSettings = findViewById(R.id.button_settings);

        settingsSetOnClickListener(buttonSettings);
        buttonSetOnClickListener(button1);
        buttonSetOnClickListener(button2);
        buttonSetOnClickListener(button3);
        buttonSetOnClickListener(button4);
        buttonSetOnClickListener(button5);
        buttonSetOnClickListener(button6);
        buttonSetOnClickListener(button7);
        buttonSetOnClickListener(button8);
        buttonSetOnClickListener(button9);
        buttonSetOnClickListener(button0);
        buttonSetOnClickListener(buttonDot);
        actionsSetOnClickListener(buttondivide);
        actionsSetOnClickListener(buttonmultiply);
        actionsSetOnClickListener(buttonsubtract);
        actionsSetOnClickListener(buttonadd);
        equalSetOnClickListener(buttonequal);
        clearSetOnClickListener(buttonclear);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        String operations = operation.getText().toString();
        instanceState.putString(tv0tag, operations);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        operation.setText(instanceState.getString(tv0tag, "0"));
    }


    private void settingsSetOnClickListener(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
    private void buttonSetOnClickListener(Button button){
    button.setOnClickListener(new View.OnClickListener() {
       @SuppressLint("NonConstantResourceId")
       @Override
       public void onClick(View view) {
           if(isNull)
               operation.setText("");
           isNull = false;
           String button = operation.getText().toString();
           switch (view.getId()) {
               case R.id.button1:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"1"; break;
               case R.id.button2:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"2"; break;
               case R.id.button3:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"3"; break;
               case R.id.button4:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"4"; break;
               case R.id.button5:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"5"; break;
               case R.id.button6:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"6"; break;
               case R.id.button7:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"7"; break;
               case R.id.button8:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"8"; break;
               case R.id.button9:
                   if  (oneZero(button) && button.length() == 1) {
                       button = button.substring(1);
                   }
                   button = button+"9"; break;
               case R.id.button0:
                   if  (oneZero(button) && button.length() == 1){
                       button = "0";
                   } else {
                       button = button + "0"; }
                   break;

               case R.id.buttondot:
                   if   (dotIsPresent(button)) {
                   } else
                   if (oneZero(button)) {
                       button = "0.";
                   } else {
                       button = button + ".";
                       break;
                   }
           }
           operation.setText(button);
       }
   });
    }

    private void actionsSetOnClickListener(Button actions) {
        actions.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onClick(View view) {
                isNull = true;
                number = operation.getText().toString();
                switch (view.getId()) {
                    case R.id.buttondivide:
                        operator = "/";
                        break;
                    case R.id.buttonmultiply:
                        operator = "*";
                        break;
                    case R.id.buttonsubtract:
                        operator = "-";
                        break;
                    case R.id.buttonadd:
                        operator = "+";
                        break;
                }
            }
        });
    }

    private void equalSetOnClickListener(Button equal) {
        equal.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                String nextNumber = operation.getText().toString();
                Double result = 0.0;
                if (nextNumber.equals("0") && operator == "/" || nextNumber.equals("") && operator == "/") {
                    Toast.makeText(MainActivity.this, "На ноль делить нельзя", Toast.LENGTH_SHORT).show();
                } else {
                    switch (operator) {
                        case "/":
                            result = Double.parseDouble(number) / Double.parseDouble(nextNumber);
                            break;
                        case "*":
                            result = Double.parseDouble(number) * Double.parseDouble(nextNumber);
                            break;
                        case "-":
                            result = Double.parseDouble(number) - Double.parseDouble(nextNumber);
                            break;
                        case "+":
                            result = Double.parseDouble(number) + Double.parseDouble(nextNumber);
                            break;
                    }
                    operation.setText(result + "");
                }
            }
        });
    }

    private void clearSetOnClickListener(Button clear) {
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation.setText("0");
                isNull = true;
            }
        });
    }
    public boolean dotIsPresent(String button){
        if (!button.contains(".")){
            return false;
        } else {
            return true;
        }
    }
    private boolean oneZero(String button) {
        if (button.equals("")){
            return true;
        }
        if (button.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }
}