package com.example.skywlk.lab3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.id.list;

/**
 * Created by skywlk on 27.11.2016..
 */

public class myAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    private Context myContext;

        public myAdapter(Context context){
            this.myContext = context;
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

        LayoutInflater myInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = myInflater.inflate(R.layout.new_layout, viewGroup, false);

        TextView leftText = (TextView) itemView.findViewById(R.id.textLeft);
        TextView centerText = (TextView) itemView.findViewById(R.id.textCenter);
        TextView rightText = (TextView) itemView.findViewById(R.id.textRight);

        Integer currentDataItem = DataStorage.listViewData.get(i);

        leftText.setText(String.valueOf(DataStorage.listViewData.indexOf(currentDataItem)));
        centerText.setText(String.valueOf(currentDataItem));
        rightText.setText(String.valueOf(currentDataItem*currentDataItem));

        return itemView;

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

       int selected = (Integer) adapterView.getAdapter().getItem(i);

        Toast.makeText(myContext, selected, 2000).show();

    }
}
