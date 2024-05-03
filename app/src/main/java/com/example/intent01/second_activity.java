package com.example.intent01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class second_activity extends AppCompatActivity {
    TextView resultTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        resultTV = findViewById(R.id.resultTV);
        Intent gi = getIntent();
        double result = gi.getDoubleExtra("result", 1);
        resultTV.setText(""+result);
    }


}