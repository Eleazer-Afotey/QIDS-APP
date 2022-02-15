package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TotalScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_score);

        Intent in = getIntent();

        TextView score = findViewById(R.id.textView23);
        TextView value = findViewById(R.id.textView13);

        String total = in.getStringExtra(SlowedDown.SECURE_VALUE);
        value.setText(total);
    }
}