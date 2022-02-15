package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DecWgt extends AppCompatActivity {

    public static final String DEC_WEIGHT_SCORE = "DEC_WEIGHT_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_wgt);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button15);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g8);
                int selected = grp.getCheckedRadioButtonId();
                int score;
                int prevVal, val, max;

                if(selected != -1){

                    RadioButton radioButton = (RadioButton)findViewById(selected);

                    score = Integer.parseInt(intentRetrieved.getStringExtra(Weight.SCORE));
                    prevVal = Integer.parseInt(intentRetrieved.getStringExtra(Weight.EXTRA_WEIGHT));
                    val = Character.getNumericValue(radioButton.getText().toString().charAt(0));

                    max = Math.max(prevVal,val);
                    score += max;

                    String send = score + "";

                    Intent in = new Intent(DecWgt.this, Concentration.class);
                    in.putExtra(DEC_WEIGHT_SCORE, send);
                    in.putExtra("CALLER", "DecWgt");


                    startActivity(in);

                }
            }
        });
    }
}