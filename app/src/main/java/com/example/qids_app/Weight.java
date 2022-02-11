package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Weight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        Intent in = getIntent();

        RadioButton inc = findViewById(R.id.radioButton21);
        RadioButton dec = findViewById(R.id.radioButton22);


        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dec.isChecked()){
                    //intent.putExtra(EXTRA_MESSAGE, "Decreased");

                    Intent intent = new Intent(Weight.this, DecWgt.class);
                    startActivity(intent);
                }
            }
        });



        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(inc.isChecked()){
                    //intent.putExtra(EXTRA_MESSAGE, "Increased");
                    Intent intent = new Intent(Weight.this, IncWgt.class);
                    startActivity(intent);

                }
            }
        });

    }
}