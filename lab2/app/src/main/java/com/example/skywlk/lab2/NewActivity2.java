package com.example.skywlk.lab2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by skywlk on 26.11.2016..
 */

public class NewActivity2 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_layout2);

        Button button1 = (Button) findViewById(R.id.buttonOdgovor);
        final EditText odgovor = (EditText) findViewById(R.id.editText2);


        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent odgIntent = new Intent(NewActivity2.this, NewActivity3.class);
                odgIntent.putExtra("odgovor", odgovor.getText().toString());
                startActivity(odgIntent);
            }
        } );


    }
}
