package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Appetite extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apetite);

        RadioButton dec = findViewById(R.id.radioButtonDecreased);
        RadioButton inc = findViewById(R.id.radioButtonIncreased);

        Intent intent = getIntent();

        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (dec.isChecked()) {
                    //intent.putExtra(EXTRA_MESSAGE, "Decreased");

                    Intent in = new Intent(Appetite.this, DecApp.class);
                    startActivity(in);
                }

            }
        });


        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (inc.isChecked()) {
                    //intent.putExtra(EXTRA_MESSAGE, "Increased");
                    Intent in = new Intent(Appetite.this, IncApp.class);
                    startActivity(in);

                }

            }
        });


    }
}