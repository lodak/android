package com.example.skywlk.lab3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.skywlk.lab3.myAdapter.myContext;

/**
 * Created by skywlk on 29.11.2016..
 */

public class newActivity extends Activity {

    int  pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cat_details);


        Intent i = getIntent();
        pos=i.getExtras().getInt("pozicija");

        final Cat cat = DataStorage.listViewData.get(pos);

        Log.i("dohvacena macka", String.valueOf(cat));

        final TextView desc=(TextView) findViewById(R.id.description);
        final TextView age=(TextView) findViewById(R.id.age);
        final ImageView imageLrg = (ImageView) findViewById(R.id.image);
        final TextView available = (TextView) findViewById(R.id.available);




        imageLrg.setImageResource(cat.getImageId(myContext));

        desc.setText(String.valueOf(cat.getDescription()));
        age.setText(String.valueOf(cat.getAge()));
        available.setText(String.valueOf(cat.getAvailable()));

    }
}
