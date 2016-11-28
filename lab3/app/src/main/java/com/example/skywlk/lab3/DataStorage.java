package com.example.skywlk.lab3;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by skywlk on 27.11.2016..
 */

public class DataStorage {

    public static ArrayList<Integer> listViewData = new ArrayList<Integer>();

    static Random rnd = new Random();

    public static void fillData(Integer n){
        for(Integer i=1; i<=n; i++){
            listViewData.add(rnd.nextInt(100));

        }
    }

}
