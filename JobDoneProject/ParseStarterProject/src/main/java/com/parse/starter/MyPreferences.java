package com.parse.starter;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by skywlk on 21.1.2017..
 */

public class MyPreferences {

    String PREFS_NAME ="MyPreferences";
    SharedPreferences sharedPreferencesInstance;

    public MyPreferences(Context context){

        sharedPreferencesInstance = context.getSharedPreferences(PREFS_NAME, 0);

    }

    public void setString(String key, String value){
        sharedPreferencesInstance.edit().putString(key, value).commit();
    }

    public String getString(String key){
        return sharedPreferencesInstance.getString(key, "");
    }

}
