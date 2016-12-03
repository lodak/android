package com.example.skywlk.lab3;

import android.content.Context;

/**
 * Created by skywlk on 29.11.2016..
 */

public class Cat {
    private int ID;
    private String name;
    private String description;
    private int age;
    private String owner;
    private boolean available;

    public Cat(int ID, String name, String description, String owner, int age, boolean available){
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.age = age;
        this.available = available;
    }

    public int getAge(){
        return age;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public String getOwner(){
        return owner;
    }

    public boolean getAvailable(){
        return available;
    }

    public int getTmbImageId(Context context){
        return context.getResources().getIdentifier("image_" + ID + "_tmb", "drawable", "com.example.skywlk.lab3");
    }

    public int getImageId(Context context){
        return context.getResources().getIdentifier("image_" + ID, "drawable", "com.example.skywlk.lab3");
    }
}