package com.parse.starter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreenActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button jobsList = (Button) findViewById(R.id.jobsButton);
        Button jobDoneButton = (Button) findViewById(R.id.jobDoneButton);
        Button statusButton = (Button) findViewById(R.id.statusButton);



        jobDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), JobDoneActivity.class);
                startActivity(intent);
            }
        });



        jobsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JobsListActivity.class);
                startActivity(intent);

            }

        });

        statusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StatusActivity.class);
                startActivity(intent);
            }
        });
    }

}
