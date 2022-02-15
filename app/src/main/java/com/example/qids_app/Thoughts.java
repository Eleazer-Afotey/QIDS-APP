package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Thoughts extends AppCompatActivity {

    public static final String THOUGHTS_SCORE = "THOUGHT_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thoughts);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button10);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioGroup grp = findViewById(R.id.g12);
                int selected = grp.getCheckedRadioButtonId();

                if(selected != -1){
                    RadioButton radioButton = (RadioButton) findViewById(selected);

                    int val = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Myself.MYSELF_SCORE)) +val;
                    String send = sum_val +"";


                    Intent in = new Intent(Thoughts.this, Interest.class);
                    in.putExtra(THOUGHTS_SCORE,send);


                    startActivity(in);


                }


            }
        });
    }
}