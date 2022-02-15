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

public class Concentration extends AppCompatActivity {
    public static final String CONCENTRATION_SCORE = "CONCENTRATION_SCORE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concentration);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button8);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g10);
                int selected = grp.getCheckedRadioButtonId();

                if(selected != -1){
                    RadioButton radioButton = (RadioButton) findViewById(selected);
                    String classname = intentRetrieved.getStringExtra("CALLER");
                    int score, val, total;

                    if(classname.equals("IncWgt")){

                        score = Integer.parseInt(intentRetrieved.getStringExtra(IncWgt.INC_WEIGHT_SCORE));
                        val = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                        total = score + val;

                        Intent in = new Intent(Concentration.this, Myself.class);
                        in.putExtra(CONCENTRATION_SCORE, total+"");


                        startActivity(in);
                    }

                    else{
                        score = Integer.parseInt(intentRetrieved.getStringExtra(DecWgt.DEC_WEIGHT_SCORE));
                        val = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                        total = score + val;

                        Intent in = new Intent(Concentration.this, Myself.class);
                        in.putExtra(CONCENTRATION_SCORE, total+"");


                        startActivity(in);
                    }


                }


            }
        });
    }
}