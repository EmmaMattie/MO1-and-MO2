package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText textN1, textN2;
    private TextView textANS;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize components
        textN1 = findViewById(R.id.editTextN1);
        textN2 = findViewById(R.id.editTextN2);
        textANS = findViewById(R.id.editTextNumAns);

        btnAdd = findViewById(R.id.b_Add);
        btnSubtract = findViewById(R.id.b_Subtract);
        btnMultiply = findViewById(R.id.b_Multiply);
        btnDivide = findViewById(R.id.b_Divide);

        // Action when "Add" button is pressed
        btnAdd.setOnClickListener(v -> calculate('+'));

        // Action when "Subtract" button is pressed
        btnSubtract.setOnClickListener(v -> calculate('-'));

        // Action when "Multiply" button is pressed
        btnMultiply.setOnClickListener(v -> calculate('*'));

        // Action when "Divide" button is pressed
        btnDivide.setOnClickListener(v -> calculate('/'));
    }

    private void calculate(char operator) {
        Double d1, d2, answer = 0.0;

        try {
            d1 = Double.parseDouble(textN1.getText().toString());
            d2 = Double.parseDouble(textN2.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Invalid input. Please enter valid numbers.", Toast.LENGTH_SHORT).show();
            Log.w("M01_Calculator", "Invalid input entered");
            return;
        }

        switch (operator) {
            case '+':
                answer = d1 + d2;
                break;
            case '-':
                answer = d1 - d2;
                break;
            case '*':
                answer = d1 * d2;
                break;
            case '/':
                if (d2 != 0) {
                    answer = d1 / d2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    Log.w("M01_Calculator", "Attempted division by zero");
                    return;
                }
                break;
        }

        // Set the Answer into the answer field
        textANS.setText(String.valueOf(answer));

        // Log the operation
        Log.w("M01_Calculator", operator + " Selected with => " + d1 + " " + operator + " " + d2 + " = " + answer);
    }
}


