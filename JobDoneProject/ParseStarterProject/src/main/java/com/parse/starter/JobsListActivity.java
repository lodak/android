package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

public class JobsListActivity extends AppCompatActivity {

    MyPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jobs_list);


        //prefs = new MyPreferences(this);

        //Toast.makeText(getApplicationContext(), "Ovo je user: " + prefs.getString("username"), Toast.LENGTH_LONG).show();

        final ListView jobsListView = (ListView) findViewById(R.id.jobsListView);

        final ArrayList<String> jobs = new ArrayList<String>();

        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, jobs);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Jobs");

        query.addAscendingOrder("Job_ID");

        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                if(e== null){

                    if(objects.size() > 0){

                        for(ParseObject job: objects){

                            jobs.add(job.getString("JobName"));
                        }

                        jobsListView.setAdapter(arrayAdapter);

                    }

                } else {

                    e.printStackTrace();
                }
            }
        });



    }
}
