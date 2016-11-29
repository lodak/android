package com.example.skywlk.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.myListView);

        DataStorage.fillData(20);
        myListView.setAdapter(new myAdapter(getApplicationContext()));

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Integer dataItem = DataStorage.listViewData.get(i);
                Toast.makeText(getApplicationContext(), String.valueOf(dataItem * dataItem * dataItem), 2000).show();
            }
        });

    }
}
