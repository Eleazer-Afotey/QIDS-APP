package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Energy extends AppCompatActivity {
    public static final String ENERGY_SCORE = "ENERGY_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy);

        Intent intentRetrieved = getIntent();
        Button btn = findViewById(R.id.button12);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g14);
                int selected = grp.getCheckedRadioButtonId();

                if(selected != -1)
                {
                    RadioButton radioButton =  (RadioButton)findViewById(selected);
                    int val = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Interest.INTEREST_SCORE)) +val;
                    String send = sum_val+"";

                    Intent in = new Intent(Energy.this, SlowedDown.class);
                    in.putExtra(ENERGY_SCORE, send);


                    startActivity(in);

                }


            }
        });
    }
}