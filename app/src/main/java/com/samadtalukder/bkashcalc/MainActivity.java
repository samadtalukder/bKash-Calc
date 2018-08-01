package com.samadtalukder.bkashcalc;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputAmount;
    private TextView amountTV,bkashFeeTV,finalAmountTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputAmount = findViewById(R.id.enterAmountET);
        amountTV = findViewById(R.id.amount_tk_tv);
        bkashFeeTV = findViewById(R.id.bkash_fee_tv);
        finalAmountTV = findViewById(R.id.final_amount_tv);

        inputAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                bkashFeeCalculation();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void bkashFeeCalculation() {
        double bKashFee = 1.85;
        if (!inputAmount.getText().toString().equals("")){
            double amount = Double.parseDouble(inputAmount.getText().toString());
            double result = (amount/100.0f) * bKashFee;
            double totalAmount = result + amount;
            amountTV.setText(""+totalAmount);
            bkashFeeTV.setText(""+result);
            finalAmountTV.setText(totalAmount+" for "+amount);
        }
        else {
            Toast.makeText(this, "Amount cannot be empty", Toast.LENGTH_SHORT).show();
        }
    }
}
