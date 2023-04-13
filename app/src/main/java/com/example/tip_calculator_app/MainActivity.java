package com.example.tip_calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText et_bill;
    private TextView tv_tip,tv_tip_output,tv_total_output;
    private Button b_calculate,b_tip_minus,b_tip_plus;

    private int tipPercent = 0;
    private int peopleCount = 1;
    private double billInit = 100.00;
    private double tipOutput = 0;
    private double totalOutput = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_bill = findViewById(R.id.et_bill);
        tv_tip = findViewById(R.id.tv_tip);

        tv_tip_output = findViewById(R.id.tv_tip_output);
        tv_total_output = findViewById(R.id.tv_total_output);
        b_calculate = findViewById(R.id.b_calculate);
        b_tip_minus = findViewById(R.id.b_tip_minus);
        b_tip_plus = findViewById(R.id.b_tip_plus);


        b_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String billString = et_bill.getText().toString();
                if(!billString.equals("")){
                    //Initial bill with out tip
                    billInit = Double.valueOf(billString);
                    billInit = billInit*100;
                    billInit = Math.round(billInit);
                    billInit = billInit / 100;

                    et_bill.setText(String.format(Locale.getDefault(),"%.2f",billInit));

                    //calculate The Tip
                    tipOutput = (billInit * tipPercent)/100;
                    tipOutput = tipOutput*100;
                    tipOutput = Math.round(tipOutput);
                    tipOutput = tipOutput / 100;

                    // total calculation
                    tv_tip_output.setText(String.format(Locale.getDefault(),"%.2f",tipOutput));

                    totalOutput = billInit + tipOutput;
                    tv_total_output.setText(String.format(Locale.getDefault(),"%.2f",totalOutput));


                }
            }
        });
        b_tip_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tipPercent > 0){
                    tipPercent--;
                    tv_tip.setText(tipPercent + "%");
                }
            }
        });
        b_tip_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipPercent++;
                tv_tip.setText(tipPercent + "%");
            }
        });
    }
}