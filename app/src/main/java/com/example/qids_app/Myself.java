package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Myself extends AppCompatActivity {

    public static final String MYSELF_SCORE = "MYSELF_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button9);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g11);
                int selected = grp.getCheckedRadioButtonId();

                if(selected != -1){
                    RadioButton radioButton = (RadioButton) findViewById(selected);

                    int val = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Concentration.CONCENTRATION_SCORE) )+ val;
                    String send = sum_val +"";


                    Intent in = new Intent(Myself.this, Thoughts.class);
                    in.putExtra(MYSELF_SCORE,send);


                    startActivity(in);


                }


            }
        });
    }
}