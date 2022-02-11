package com.example.qids_app;

import static android.util.Log.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class AppetiteQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetite_q);

        Intent in = getIntent();

        String value = in.getStringExtra(Appetite.EXTRA_MESSAGE);

        if(value == "Decreased"){
            RadioGroup g = (RadioGroup) findViewById(R.id.group2);

            for (int i = 0; i < g.getChildCount(); i++) {
                g.getChildAt(i).setClickable(false);
            }
        }

        if(value == "Increased"){
            RadioGroup b = (RadioGroup) findViewById(R.id.group1);
            for (int i = 0; i < b.getChildCount(); i++) {
                b.getChildAt(i).setClickable(false);
            }
        }

        Button btn = findViewById(R.id.button5);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AppetiteQ.this, Weight.class);
                startActivity(in);
            }
        });


    }
}