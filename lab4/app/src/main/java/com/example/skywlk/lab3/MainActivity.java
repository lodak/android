package com.example.skywlk.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView myListView = (ListView) findViewById(R.id.myListView);

        DataStorage.fillData();
        myListView.setAdapter(new myAdapter(getApplicationContext()));


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent myIntent = new Intent(MainActivity.this, newActivity.class);
                Log.i("pozicija", String.valueOf(Integer.valueOf(i)));
                myIntent.putExtra("pozicija", i);
                startActivity(myIntent);

            }
        });




    }
}
