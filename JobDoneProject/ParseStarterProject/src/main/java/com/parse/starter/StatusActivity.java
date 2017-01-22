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

        final ArrayList<String> usernames = new ArrayList<String>();

        final ArrayList<String> joblist = new ArrayList<String>();


        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, joblist);
        final ListView jobsListView = (ListView) findViewById(R.id.jobsListView);


        final List<BarEntry> entries = new ArrayList<>();
        List<BarEntry> yaxis = new ArrayList<>();

        ParseQuery<ParseUser> query = ParseUser.getQuery();

        query.addAscendingOrder("username");

        query.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (e == null) {
                    if (objects.size() > 0) {

                        for (ParseUser user : objects) {

                            usernames.add(user.getUsername());

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
                            //Log.i("user", )

                        }

                        jobsListView.setAdapter(arrayAdapter);

                    }

                } else {

                    e.printStackTrace();

                }
            }
        });

        List<Float> yValues = new ArrayList<Float>();

        for(int i=0; i<usernames.size(); i++){

            float count = 0;

            for (int j=0; j<joblist.size(); j++){

                if(usernames.get(i) == joblist.get(j)){

                    count++;

                }

            }

            yValues.add(count);

            for(int k=0; k<yValues.size(); k++){

                Toast.makeText(getApplicationContext(), "user count: " + yValues.get(k).toString(), Toast.LENGTH_LONG).show();
            }

        }



    }

    private void drawBarChart(float yValues[], String [] xValues){
        //barChart.setDescription("Jobs done per user");
        ArrayList<BarEntry> yData = new ArrayList<>();
        for(int i=0; i < yValues.length; i++){

            yData.add(new BarEntry(yValues[i], i));

        }

        ArrayList<String> xData = new ArrayList<>();
        for(int i=0; i<xValues.length; i++){

            xData.add(xValues[i]);
        }

        BarDataSet barDataSet = new BarDataSet(yData, "Jobs done per user");
        barDataSet.setColor(ColorTemplate.COLOR_NONE);

       // BarData barData = new BarData(xData, barDataSet)



    }


}


   /* private void setChartData(LinkedHashMap<String, Integer> jobsDonePerUser){

        ArrayList<String> xVals = new ArrayList<>();

        for(LinkedHashMap.Entry<String, Integer> entry : jobsDonePerUser.entrySet()){

            xVals.add(entry.getKey());

        }

        ArrayList<Entry> vals1 = new ArrayList<>();
        int i=0;

        for (Map.Entry<String, Integer> entry : jobsDonePerUser.entrySet()){

            vals1.add(new Entry(Float.valueOf(entry.getValue()), i));

            i++;

        }

        //dataset for barChart
        BarDataSet barDataSet = new BarDataSet(vals1, "users");


    }
*/


/*
    LinkedHashMap<String, Integer> count = new LinkedHashMap<>();
       for (String t : joblist) {

        Integer i = count.get(t);

        Toast.makeText(getApplicationContext(), "t: " + count.get(t), Toast.LENGTH_LONG).show();

        if (i == null) {
        i = 0;
        Log.i("Score: ", String.valueOf(i + 1));
        }
        count.put(t, i + 1);

        }
*/