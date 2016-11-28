package com.example.skywlk.lab2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.valueOf;

/**
 * Created by skywlk on 26.11.2016..
 */

public class NewActivity3 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout3);

        String provjera = "12";

        TextView da = (TextView) findViewById(R.id.textTocan);
        TextView ne = (TextView) findViewById(R.id.textKrivi);


        Bundle extras = getIntent().getExtras();
        if(extras != null){
            String value=extras.getString("odgovor").toString();
            if(provjera == value) {
                da.setVisibility(View.VISIBLE);
                ne.setVisibility(View.INVISIBLE);
            }
            else {
                da.setVisibility(View.INVISIBLE);
                ne.setVisibility(View.VISIBLE);
            }

        }
    }
}
