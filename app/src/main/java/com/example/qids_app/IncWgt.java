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

public class IncWgt extends AppCompatActivity {
    public static final String INC_WEIGHT_SCORE = "INC_WEIGHT_SCORE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_q);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button7);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup grp = findViewById(R.id.g9);
                int selected = grp.getCheckedRadioButtonId();
                int score;
                int prevVal;
                int val,max;

                if(selected != -1){

                    RadioButton radioButton = (RadioButton)findViewById(selected);
                    Log.d("log", intentRetrieved.getStringExtra("SCORE")+"-----------------");

                    score = Integer.parseInt(intentRetrieved.getStringExtra("SCORE"));
                    prevVal = Integer.parseInt(intentRetrieved.getStringExtra("EXTRA_WEIGHT"));
                    val = Character.getNumericValue(radioButton.getText().toString().charAt(0));

                    max = Math.max(prevVal,val);
                    score += max;
                    String send = score + "";

                    Intent in = new Intent(IncWgt.this, Concentration.class);
                    in.putExtra(INC_WEIGHT_SCORE, send);
                    in.putExtra("CALLER", "IncWgt");
                    startActivity(in);

                }


            }
        });
    }
}