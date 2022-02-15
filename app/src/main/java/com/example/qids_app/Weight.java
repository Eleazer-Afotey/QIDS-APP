package com.example.qids_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class Weight extends AppCompatActivity {
    public static final String EXTRA_WEIGHT = "EXTRA_WEIGHT";
    public static final String SCORE = "SCORE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        Intent intentRetrieved = getIntent();

        RadioButton inc = findViewById(R.id.radioButton21);
        RadioButton dec = findViewById(R.id.radioButton22);


        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dec.isChecked()){
                    String classname = intentRetrieved.getStringExtra("CALLER");
                    Log.d("log", classname+"-----------------");
                    if(classname.equals("IncApp")){
                       String val = intentRetrieved.getStringExtra(IncApp.INC_APP_SCORE);
                       String incAppVal = intentRetrieved.getStringExtra(IncApp.INC_APP);

                        Intent intent = new Intent(Weight.this, DecWgt.class);
                        intent.putExtra(EXTRA_WEIGHT,incAppVal);
                        intent.putExtra(SCORE,val);
                        Log.d("log", val+"-----------------");

                        startActivity(intent);

                    }
                    else{
                        String val =intentRetrieved.getStringExtra(DecApp.DEC_APP_SCORE);
                        String decAppVal = intentRetrieved.getStringExtra(DecApp.DEC_APP);

                        Intent intent = new Intent(Weight.this, DecWgt.class);
                        intent.putExtra(EXTRA_WEIGHT,decAppVal);
                        intent.putExtra(SCORE,val);

                        Log.d("log", val+"-----------------");
                        startActivity(intent);
                    }


                }

            }
        });



        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(inc.isChecked()){
                    String classname = intentRetrieved.getStringExtra("CALLER");
                    if(classname.equals("IncApp")){
                        String val = intentRetrieved.getStringExtra(IncApp.INC_APP_SCORE);
                        String incAppVal = intentRetrieved.getStringExtra(IncApp.INC_APP);

                        Intent intent = new Intent(Weight.this, IncWgt.class);
                        intent.putExtra(EXTRA_WEIGHT,incAppVal);
                        intent.putExtra(SCORE,val);
                        startActivity(intent);
                    }
                    else{
                        String val =intentRetrieved.getStringExtra(DecApp.DEC_APP_SCORE);
                        String decAppVal = intentRetrieved.getStringExtra(DecApp.DEC_APP);

                        Intent intent = new Intent(Weight.this, IncWgt.class);
                        intent.putExtra(EXTRA_WEIGHT,decAppVal);
                        intent.putExtra(SCORE,val);
                        startActivity(intent);
                    }



                }
            }
        });

    }
}