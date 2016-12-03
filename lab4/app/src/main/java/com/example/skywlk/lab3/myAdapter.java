package com.example.skywlk.lab3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.list;

/**
 * Created by skywlk on 27.11.2016..
 */

public class myAdapter extends BaseAdapter  {

    public static Context myContext;

        private LayoutInflater myInflater;

    public myAdapter(Context context){
        myContext = context;
        myInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override
    public int getCount() {
        return DataStorage.listViewData.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //if(view==null)
            view = myInflater.inflate(R.layout.new_layout, viewGroup, false);

        final TextView name = (TextView) view.findViewById(R.id.name);
        final TextView owner = (TextView) view.findViewById(R.id.owner);
        final ImageView imageTmb = (ImageView) view.findViewById(R.id.image_tmb);


        final Cat cat = DataStorage.listViewData.get(i);

        Boolean available = cat.getAvailable();

        if (available == false)
        {
            name.setText(cat.getName());
        }




        owner.setText(cat.getOwner());
        imageTmb.setImageResource(cat.getTmbImageId(myContext));



        return view;


    }


}
