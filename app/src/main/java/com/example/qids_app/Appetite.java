package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Appetite extends AppCompatActivity {
    public static final String APPETITE = "APPETITE";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apetite);

        RadioButton dec = findViewById(R.id.radioButtonDecreased);
        RadioButton inc = findViewById(R.id.radioButtonIncreased);

        Intent intentRetrieved = getIntent();

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (dec.isChecked()) {

                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Sadness.SADNESS_SCORE));
                    String send = sum_val + "";
                    Intent in = new Intent(Appetite.this, DecApp.class);
                    in.putExtra(APPETITE,send);

                    startActivity(in);
                }

            }
        });


        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (inc.isChecked()) {
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Sadness.SADNESS_SCORE));
                    String send = sum_val + "";
                    Intent in = new Intent(Appetite.this, IncApp.class);
                    in.putExtra(APPETITE,send);


                    startActivity(in);

                }

            }
        });


    }
}