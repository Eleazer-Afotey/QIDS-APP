package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DecApp extends AppCompatActivity {
    public static final String DEC_APP = "DEC_APP";
    public static final String DEC_APP_SCORE = "DEC_APP_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dec_app);

        Intent intentRetrieved = getIntent();

        Button btn = findViewById(R.id.button14);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup grp = findViewById(R.id.g6);
                int selected = grp.getCheckedRadioButtonId();

                if(selected != -1){
                    RadioButton radioButton = (RadioButton)findViewById(selected);
                    int dec = Character.getNumericValue(radioButton.getText().toString().charAt(0));
                    String decApp = dec + "";
                    int sum_val = Integer.parseInt(intentRetrieved.getStringExtra(Appetite.APPETITE));
                    String send = sum_val +"";

                    Intent in = new Intent(DecApp.this, Weight.class);
                    in.putExtra(DEC_APP_SCORE, send);
                    in.putExtra(DEC_APP, decApp);
                    in.putExtra("CALLER", "DecApp");


                    startActivity(in);
                }

            }
        });
    }
}