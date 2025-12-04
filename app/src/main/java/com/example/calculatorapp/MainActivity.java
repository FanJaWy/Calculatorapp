package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    TextView txtResult;
    Button btnAdd, btnSub, btnMul, btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        txtResult = findViewById(R.id.txtResult);

        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSub.setOnClickListener(v -> calculate("-"));
        btnMul.setOnClickListener(v -> calculate("*"));
        btnDiv.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String op) {
        String aStr = edtA.getText().toString();
        String bStr = edtB.getText().toString();

        // Check empty input
        if (aStr.isEmpty() || bStr.isEmpty()) {
            txtResult.setText("Please enter both numbers.");
            return;
        }

        double a, b;

        // Check invalid number format
        try {
            a = Double.parseDouble(aStr);
            b = Double.parseDouble(bStr);
        } catch (NumberFormatException e) {
            txtResult.setText("Invalid number input.");
            return;
        }

        double result = 0;

        switch (op) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    txtResult.setText("Cannot divide by zero.");
                    return;
                }
                result = a / b;
                break;
        }

        txtResult.setText("Result: " + result);
    }
}
