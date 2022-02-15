package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SlowedDown extends AppCompatActivity {
    int score;
    boolean selected;
    public static final String SECURE_VALUE = "Total";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slowed_down);

        Intent intentRetrieved = getIntent();

        /*
        Radio buttons
         */



        Button btn = findViewById(R.id.button13);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup group = findViewById(R.id.g15);
                RadioGroup group2 = findViewById(R.id.g16);
                int selected1 = group.getCheckedRadioButtonId();
                int selected2 = group2.getCheckedRadioButtonId();
                if((selected1 != -1) && (selected2 != -1)){
                    RadioButton radioButton1 =  (RadioButton)findViewById(selected1);
                    RadioButton radioButton2 =  (RadioButton)findViewById(selected2);
                    int val = Character.getNumericValue(radioButton1.getText().toString().charAt(0));
                    int val2 = Character.getNumericValue(radioButton2.getText().toString().charAt(0));

                    val = Math.max(val,val2);
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Energy.ENERGY_SCORE)) +val;
                    String send = sum_val+"";

                    Intent in = new Intent(SlowedDown.this, TotalScore.class);
                    in.putExtra(SECURE_VALUE,send);


                    startActivity(in);

                }

            }
        });
    }
}