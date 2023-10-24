// MainActivity.java
package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditText;
    private Spinner calculationTypeSpinner;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputEditText);
        calculationTypeSpinner = findViewById(R.id.calculationTypeSpinner);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.calculation_types,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        calculationTypeSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performCalculation();
            }
        });
    }

    private void performCalculation() {
        String inputText = inputEditText.getText().toString().trim();

        if (inputText.isEmpty()) {
            showToast(getString(R.string.toast_empty_input));
            return;
        }

        String selectedCalculation = calculationTypeSpinner.getSelectedItem().toString();
        int result;

        if (selectedCalculation.equals(getString(R.string.calculation_words))) {
            result = WordCounter.countWords(inputText);
        } else {
            result = WordCounter.countCharacters(inputText);
        }

        String resultMessage = getString(R.string.label_count, result);
        resultTextView.setText(resultMessage);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
