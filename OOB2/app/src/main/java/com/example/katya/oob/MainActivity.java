package com.example.katya.oob;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;
    EditText etNum3;
    Button rbMan;
    Button rbWoman;
    TextView tvResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        etNum3 = (EditText) findViewById(R.id.etNum3);

        rbMan = (Button) findViewById(R.id.rbMan);
        rbWoman = (Button) findViewById(R.id.rbWoman);

        tvResult = (TextView) findViewById(R.id.tvResult);

        rbMan.setOnClickListener(this);
        rbWoman.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        float num1 = 0;
        float num2 = 0;
        float num3 = 0;
        float result = 0;

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());
        num3 = Float.parseFloat(etNum3.getText().toString());

        switch (view.getId()) {
            case R.id.rbMan:
                result = (float) (66 + (13.8 * num2) + (5 * num1) - (6.8 * num3));
                break;

            case R.id.rbWoman:

                result = (float) ((10 * num2) + (6.25 * num1) - (5 * num3) - 161);
                break;
            default:
                break;
        }
        tvResult.setText(result + " ккал/сутки");
    }

}