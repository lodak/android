/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

  Boolean signupModeActive = true;

  TextView changeSignupModeTexView;

  MyPreferences prefs;

  public void showHomeScreen(){

    Intent intent = new Intent(getApplicationContext(), HomeScreenActivity.class);
    startActivity(intent);
  }



  @Override
  public void onClick(View view){

    Button signupButton= (Button) findViewById(R.id.signupButton);

    if(view.getId() == R.id.changeSignupModeTexView){

      if(signupModeActive){

        signupModeActive=false;
        signupButton.setText("Login");
        changeSignupModeTexView.setText("Or, signup");

      }else {

        signupModeActive=true;
        signupButton.setText("Signup");
        changeSignupModeTexView.setText("Or, login");
      }

    }

  }


  public void signUp(View view){

    final EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
    EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);

    if (usernameEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")){

      Toast.makeText(this, "A username and password are required.", Toast.LENGTH_LONG).show();
    } else {



      if(signupModeActive){

      ParseUser user = new ParseUser();
      user.setUsername(usernameEditText.getText().toString());
      user.setPassword(passwordEditText.getText().toString());



      user.signUpInBackground(new SignUpCallback() {
        @Override
        public void done(ParseException e) {
          if(e== null){

            Log.i("Signup", "Successful");

            showHomeScreen();
            prefs.setString("username", usernameEditText.getText().toString());
          }else {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
          }
        }
      });
    } else {

        ParseUser.logInInBackground(usernameEditText.getText().toString(), passwordEditText.getText().toString(), new LogInCallback() {
          @Override
          public void done(ParseUser user, ParseException e) {
            if(user != null){

              Log.i("Signup", "Successful");

              showHomeScreen();
              prefs.setString("username", usernameEditText.getText().toString());
            }else {

              Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
            }
          }
        });

      }
    }
  }


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    changeSignupModeTexView = (TextView) findViewById(R.id.changeSignupModeTexView);

    changeSignupModeTexView.setOnClickListener(this);

    prefs = new MyPreferences(this);

    
    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}