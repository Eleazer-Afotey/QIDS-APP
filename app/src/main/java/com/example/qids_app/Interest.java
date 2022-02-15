package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Interest extends AppCompatActivity {
    public static final String INTEREST_SCORE = "INTEREST_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);

        Intent intentRetrieved = getIntent();
        Button btn = findViewById(R.id.button11);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g13);
                int selected = grp.getCheckedRadioButtonId();
                if(selected != -1) {
                    RadioButton radioButton = (RadioButton) findViewById(selected);
                    int val = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Thoughts.THOUGHTS_SCORE)) +val;
                    String send = sum_val+"";

                    Intent in = new Intent(Interest.this, Energy.class);
                    in.putExtra(INTEREST_SCORE,send);


                    startActivity(in);
                }


            }
        });
    }
}