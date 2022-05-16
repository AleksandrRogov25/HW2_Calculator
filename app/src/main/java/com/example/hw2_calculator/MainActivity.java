package com.example.hw2_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
   private TextView operation;
    Boolean isNull = true;
    String operator;
    String number;
    private String parcelable_tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operation = findViewById(R.id.operation);

    }

    public void onClick(View view) {
        if(isNull)
            operation.setText("");
        isNull = false;

        String button = operation.getText().toString();
        switch (view.getId()){
            case R.id.button1: button = button+"1"; break;
            case R.id.button2: button = button+"2"; break;
            case R.id.button3: button = button+"3"; break;
            case R.id.button4: button = button+"4"; break;
            case R.id.button5: button = button+"5"; break;
            case R.id.button6: button = button+"6"; break;
            case R.id.button7: button = button+"7"; break;
            case R.id.button8: button = button+"8"; break;
            case R.id.button9: button = button+"9"; break;
            case R.id.button0: button = button+"0"; break;
            case R.id.buttondot: button = button+"."; break;


        }
        operation.setText(button);
    }
    public void actions(View view){
        isNull = true;
        number = operation.getText().toString();
        switch (view.getId()){
            case R.id.buttondivide: operator = "/"; break;
            case R.id.buttonmultiply: operator = "*"; break;
            case R.id.buttonsubtract: operator = "-"; break;
            case R.id.buttonadd: operator = "+"; break;
        }

    }
    /* public void onSaveInstanceState(@NonNull Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        SaveTextView saveTextViews = new SaveTextView(operation);
        saveTextViews.setOperation(operation);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        SaveTextView saveTextViews = new SaveTextView(operation);
        saveTextViews = instanceState.getParcelable(parcelable_tag);
        operation.setText(saveTextViews.getOperation().getText());

    } **/

    public void onClickEqual(View view) {
        String nextNumber = operation.getText().toString();
        Double result = 0.0;
        switch (operator){
            case "/": result = Double.parseDouble(number) / Double.parseDouble(nextNumber);
                break;
            case "*": result = Double.parseDouble(number) * Double.parseDouble(nextNumber);
                break;
            case "-": result = Double.parseDouble(number) - Double.parseDouble(nextNumber);
                break;
            case "+": result = Double.parseDouble(number) + Double.parseDouble(nextNumber);
                break;
        }
        operation.setText(result + "");
    }

    public void onClickClear(View view) {
        operation.setText("0");
        isNull = true;

    }

}