package com.example.calculatorhw2_5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    TextView resultTv;
    Integer firstNumber, secondNumber;
    boolean isOperation;
    String operator;
    Button equalBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTv = findViewById(R.id.resultTv);
        equalBtn = findViewById(R.id.equals);
    }

    public void numberClick(View view) {
        if (view instanceof MaterialButton) {
            String text = ((MaterialButton) view).getText().toString();
            if (isOperation) {
                resultTv.setText("");
            }
            resultTv.append(text);
        }
        isOperation = false;
    }

    public void operationClick(View view) {
        if (view.getId() == R.id.clearBtn) {
            resultTv.setText("");
        } else if (view.getId() == R.id.plus) {
            operator = "+";
            firstNumber = Integer.valueOf(resultTv.getText().toString());
        } else if (view.getId() == R.id.minus) {
            operator = "-";
            firstNumber = Integer.valueOf(resultTv.getText().toString());
        } else if (view.getId() == R.id.multiplication) {
            operator = "*";
            firstNumber = Integer.valueOf(resultTv.getText().toString());
        } else if (view.getId() == R.id.divisionBtn) {
            operator = "/";
            firstNumber = Integer.valueOf(resultTv.getText().toString());
        } else if (view.getId() == R.id.equals) {
            secondNumber = Integer.valueOf(resultTv.getText().toString());
            resultTv.setText(calculateOperatin(firstNumber, secondNumber, operator));
        }
        isOperation = true;
    }

    private String calculateOperatin(int firstNumber, int secondNumber, String operator) {
        switch (operator) {
            case "+":
                return String.valueOf(firstNumber + secondNumber);
            case "-":
                return String.valueOf(firstNumber - secondNumber);
            case "*":
                return String.valueOf(firstNumber * secondNumber);
            case "/":
                if (secondNumber != 0) {
                    return String.valueOf(firstNumber / secondNumber);
                } else {
                    return "0";
                }
            default:
                return "";
        }
    }
}