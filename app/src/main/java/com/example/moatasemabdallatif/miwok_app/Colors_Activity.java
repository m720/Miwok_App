package com.example.moatasemabdallatif.miwok_app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Colors_Activity extends AppCompatActivity {
    //this is a custom class for colors Activity


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting up the Layout
        setContentView(R.layout.colors_activity);

        try {
            android.support.v7.app.ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException n){
            Log.d("ActionBar", "null pointetr ,the Action Bar not Found");
        }
        // ArrayList of Words that contains objects to be shown
        ArrayList<Word> words  = new ArrayList<>();

        //adding the Objects to the ArrayList
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә" ,R.drawable.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow));

        //creating the ArrayAdapter ,adding the ArrayList to it and adding the Back ground Color
        WordAdapter colorAdapter = new WordAdapter(this, words, R.color.category_colors);

        //Adjusting the ListView
        ListView listView = findViewById(R.id.colors_listView);
        //setting Up the Adapter for the ListView
        listView.setAdapter(colorAdapter);

    }
}