package com.example.skywlk.lab2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("proba", "Aplikacija pokrenuta");
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button3);
        Button button3 = (Button) findViewById(R.id.button4);
        final EditText toastText = (EditText) findViewById(R.id.toastText);

        Button button4 = (Button) findViewById(R.id.button5);
        Button button5 = (Button) findViewById(R.id.button6);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.i("poruka1", "Ovo je prva poruka!");
            }
        });


        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Log.i("poruka2", "Ovo je poruka 2!");
            }
        });


        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                //String.valueOf(toastText.getText().toString())
                //
                Toast.makeText(getApplicationContext(), toastText.getText().toString(), 2000).show();
            }


        });


        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, NewActivity1.class);
                startActivity(myIntent);
            }
        });


        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, NewActivity2.class);
                startActivity(myIntent);
            }
        });

    }

    @Override
        public void onDestroy(){
        Log.i("DestroyLog", "Aplikacija je ubijena!");
        super.onDestroy();
    }

}
