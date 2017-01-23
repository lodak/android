package com.parse.starter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.google.android.gms.analytics.internal.zzy.t;

public class StatusActivity extends AppCompatActivity {

    private BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        barChart = (BarChart) findViewById(R.id.barGraph);


        final ArrayList<String> joblist = new ArrayList<>();
        final ArrayList<String> users = new ArrayList<>();

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        ArrayList<String> theUsers = new ArrayList<>();

        ParseQuery<ParseUser> query = ParseUser.getQuery();

        query.addAscendingOrder("username");

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {

                        for (ParseUser user : objects) {

                            users.add(user.getUsername());

                        }
                    }

                } else {

                    e.printStackTrace();

                }
            }
        });

        ParseQuery<ParseObject> query1 = ParseQuery.getQuery("JobDone");
        query1.addAscendingOrder("username");
        query1.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {

                    if (objects.size() > 0) {

                        for (ParseObject object : objects) {

                            joblist.add(object.getString("username"));

                        }

                    }

                } else {

                    e.printStackTrace();

                }
            }
        });


        for(int k=0; k<users.size(); k++){

            theUsers.add(users.get(k).toString());

        }

        for(int i=0; i<users.size(); i++){
            float x = 0;

            for (int j=0; j<joblist.size(); j++){

                if(users.get(i).toString() == joblist.get(j).toString()){
                    x++;
                }

            }

            barEntries.add(new BarEntry(x, i));
        }

        BarDataSet barDataSet = new BarDataSet(barEntries, "values");

        BarData barData = new BarData(theUsers, barDataSet);

        barChart.setDescription("Jobs done per user.");

        barChart.setData(barData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.invalidate();

    }
}