package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Appetite extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "secure message";
    public String appetiteLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apetite);

        Intent intent = getIntent();

        Button btn = findViewById(R.id.button4);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Appetite.this, AppetiteQ.class);
                RadioButton dec = findViewById(R.id.radioButtonDecreased);
                RadioButton inc = findViewById(R.id.radioButtonIncreased);

                if(dec.isChecked()){
                    intent.putExtra(EXTRA_MESSAGE, "Decreased");
                }

                if(inc.isChecked()){
                    intent.putExtra(EXTRA_MESSAGE, "Increased");
                }



                startActivity(in);
            }
        });

    }
}