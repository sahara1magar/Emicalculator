package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public EditText loan,interest,no_of_month;
public TextView tv_result;
public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loan=(EditText)findViewById(R.id.et_loan);
        interest=(EditText)findViewById(R.id.et_rate);
        no_of_month=(EditText)findViewById(R.id.et_number);
        tv_result=(TextView)findViewById(R.id.tv_result);
        btn=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emi();
            }
        });

    }
    private void emi(){
        double loan_amount=Double.parseDouble(loan.getText().toString());
        double rate=Double.parseDouble(interest.getText().toString());
        double month=Double.parseDouble(no_of_month.getText().toString());
        double r= rate/1200;

        double n=Math.pow(r+1,month);
        double result =loan_amount*r*n/(n-1);
        String output = String.format("%.2f",result);
       tv_result.setText("Rs:"+output);

    }
}
