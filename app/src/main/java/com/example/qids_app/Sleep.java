package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Sleep extends AppCompatActivity {

    public static final String SLEEP_SCORE = "SLEEP_SCORE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        Intent intentRetrieved = getIntent();
        Button btn = findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup gr1 = findViewById(R.id.g1);
                RadioGroup gr2 = findViewById(R.id.g2);
                RadioGroup gr3 = findViewById(R.id.g3);
                RadioGroup gr4 = findViewById(R.id.g4);

                int g1_selected = gr1.getCheckedRadioButtonId();
                int g2_selected = gr2.getCheckedRadioButtonId();
                int g3_selected = gr3.getCheckedRadioButtonId();
                int g4_selected = gr4.getCheckedRadioButtonId();

                if((g1_selected != -1) && (g2_selected != -1) && (g3_selected != -1) && (g4_selected != -1)){

                    RadioButton radio1 =  (RadioButton)findViewById(g1_selected);
                    RadioButton radio2 =  (RadioButton)findViewById(g2_selected);
                    RadioButton radio3 =  (RadioButton)findViewById(g3_selected);
                    RadioButton radio4 =  (RadioButton)findViewById(g4_selected);

                    int rad1_val = Character.getNumericValue(radio1.getText().toString().charAt(0));
                    int rad2_val = Character.getNumericValue(radio2.getText().toString().charAt(0));
                    int rad3_val = Character.getNumericValue(radio3.getText().toString().charAt(0));
                    int rad4_val = Character.getNumericValue(radio4.getText().toString().charAt(0));

                    int max_val = Math.max(Math.max(rad1_val,rad2_val), Math.max(rad3_val, rad4_val));
                    String send = max_val + "";

                    Intent intent = new Intent(Sleep.this, Sadness.class);
                    intent.putExtra(SLEEP_SCORE, send);
                    startActivity(intent);
                }


            }
        });



    }
}