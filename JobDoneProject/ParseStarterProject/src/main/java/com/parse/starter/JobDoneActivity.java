package com.parse.starter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.zxing.Result;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import static com.parse.starter.R.id.settings;



public class JobDoneActivity extends AppCompatActivity implements View.OnClickListener {

    private Button scanBtn, addButton;

    private TextView tvScanFormat, tvScanContent, timeStamp;

    private LinearLayout llSearch;

    MyPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_done);

        scanBtn = (Button) findViewById(R.id.scan_button);

        addButton = (Button) findViewById(R.id.addButton);

        tvScanFormat = (TextView) findViewById(R.id.tvScanFormat);

        tvScanContent = (TextView) findViewById(R.id.tvScanContent);

        timeStamp = (TextView) findViewById(R.id.timestampTextView);

        llSearch = (LinearLayout) findViewById(R.id.llSearch);

        scanBtn.setOnClickListener(this);

        prefs = new MyPreferences(this);

        final String username = prefs.getString("username");


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ParseObject jobdone = new ParseObject("JobDone");

                jobdone.put("jobname", tvScanFormat.getText().toString());
                jobdone.put("jobtimestamp", timeStamp.getText().toString());
                jobdone.put("username", username);




                jobdone.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {

                        if(e!=null){

                            Log.i("SaveInBackground", "Successful!");

                        }else {

                            Log.i("SaveInBackground", "Failed: " + e.toString());

                        }


                    }
                });

            }
        });



    }


    @Override
    public void onClick(View v) {

        llSearch.setVisibility(View.GONE);

        IntentIntegrator integrator = new IntentIntegrator(this);

        integrator.setPrompt("Scan a barcode or QRcode");

        integrator.setOrientationLocked(false);

        //integrator.initiateScan();

//        Use this for more customization

//        IntentIntegrator integrator = new IntentIntegrator(this);

//        integrator.setDesiredBarcodeFormats(IntentIntegrator.ONE_D_CODE_TYPES);

//        integrator.setPrompt("Scan a barcode");

        integrator.setCameraId(0);  // Use a specific camera of the device

        integrator.setBeepEnabled(false);

        integrator.setBarcodeImageEnabled(true);

        integrator.initiateScan();

    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);


        if (result != null) {

            if (result.getContents() == null || !result.getContents().toLowerCase().contains("zadatak")) {

                llSearch.setVisibility(View.GONE);

                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();

            } else {

                llSearch.setVisibility(View.VISIBLE);

                tvScanContent.setText(result.getFormatName());

                tvScanFormat.setText(result.getContents());

                timeStamp.setText(String.valueOf(Calendar.getInstance().getTime()));

            }

        } else {

            super.onActivityResult(requestCode, resultCode, data);

        }

    }
}

