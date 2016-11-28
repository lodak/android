package com.example.skywlk.myapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


            // Checks the orientation of the screen
            if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {


                final EditText editCm = (EditText) findViewById(R.id.editCm);

                final EditText editIn = (EditText) findViewById(R.id.editIn);


                double cent;

                if(editCm.getText().toString().length() == 0){
                    cent=0;
                }
                else {
                    cent=Double.valueOf(editCm.getText().toString());
                }
                double inch = cent * 0.393700787;

                editIn.setText(String.valueOf(inch));



                final EditText editG = (EditText) findViewById(R.id.editG);

                final EditText editOz = (EditText) findViewById(R.id.editOz);

                double g;

                if(editG.getText().toString().length()==0){
                    g=0;
                }
                else {
                    g=Double.valueOf(editG.getText().toString());
                }

                double oz = g / 28.34952;

                editOz.setText(String.valueOf(oz));



                final EditText editL = (EditText) findViewById(R.id.editL);

                final EditText editUsgal = (EditText) findViewById(R.id.editUSgal);

                double editl;

                if(editL.getText().length() == 0) {
                    editl=0;
                }
                else {
                    editl = Double.valueOf(editL.getText().toString());
                }

                double editusgal = editl * 0.26417;

                editUsgal.setText(String.valueOf(editusgal));



            } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

                final EditText editIn = (EditText) findViewById(R.id.editIn);
                editIn.setText("Rotate for value");

                final EditText editOz = (EditText) findViewById(R.id.editOz);
                editOz.setText("Rotate for value");

                final EditText editUsgal = (EditText) findViewById(R.id.editUSgal);
                editUsgal.setText("Rotate for value");

            }

    }
}
