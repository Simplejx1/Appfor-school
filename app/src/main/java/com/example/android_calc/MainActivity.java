package com.example.android_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputA, inputB;
    private TextView resultView;
    private Button btnAdd, btnSub, btnMul, btnDiv, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputA = findViewById(R.id.inputA);
        inputB = findViewById(R.id.inputB);
        resultView = findViewById(R.id.resultView);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnClear = findViewById(R.id.btnClear);

        View.OnClickListener listener = v -> {
            String aText = inputA.getText().toString().trim();
            String bText = inputB.getText().toString().trim();

            if (TextUtils.isEmpty(aText) || TextUtils.isEmpty(bText)) {
                Toast.makeText(this, "Please enter both numbers.", Toast.LENGTH_SHORT).show();
                return;
            }

            double a, b;
            try {
                a = Double.parseDouble(aText);
                b = Double.parseDouble(bText);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number format.", Toast.LENGTH_SHORT).show();
                return;
            }

            double res = 0.0;
            int vid = v.getId();
            if (vid == R.id.btnAdd) {
                res = a + b;
            } else if (vid == R.id.btnSub) {
                res = a - b;
            } else if (vid == R.id.btnMul) {
                res = a * b;
            } else if (vid == R.id.btnDiv) {
                if (b == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero.", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = a / b;
            }

            resultView.setText(String.valueOf(res));
        };

        btnAdd.setOnClickListener(listener);
        btnSub.setOnClickListener(listener);
        btnMul.setOnClickListener(listener);
        btnDiv.setOnClickListener(listener);

        btnClear.setOnClickListener(v -> {
            inputA.setText("");
            inputB.setText("");
            resultView.setText("");
            inputA.requestFocus();
        });
    }
}
