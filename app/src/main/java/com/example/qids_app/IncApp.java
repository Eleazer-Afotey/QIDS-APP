package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class IncApp extends AppCompatActivity {
    public static final String INC_APP = "INC_APP";
    public static final String INC_APP_SCORE = "INC_APP_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inc_app);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g7);
                int selected = grp.getCheckedRadioButtonId();

                if(selected != -1){
                    RadioButton radioButton = (RadioButton)findViewById(selected);
                    int inc = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                    String incApp = inc + "";
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Appetite.APPETITE));
                    String send = sum_val +"";

                    Intent in = new Intent(IncApp.this, Weight.class);
                    in.putExtra(INC_APP_SCORE, send);
                    in.putExtra(INC_APP, incApp);
                    in.putExtra("CALLER", "IncApp");


                    startActivity(in);
                }


            }
        });


    }
}