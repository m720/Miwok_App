package com.example.moatasemabdallatif.miwok_app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting up the Layout
        setContentView(R.layout.family_activity);

        try {
            android.support.v7.app.ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException n){
            Log.d("ActionBar", "null pointetr ,the Action Bar not Found");
        }

        // ArrayList of Words that contains objects to be shown
        ArrayList<Word> words  = new ArrayList<>();

        //Adding the Objects to the ArrayList
        words.add(new Word("father", "әpә", R.drawable.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));
        WordAdapter familyAdapter = new WordAdapter(this, words, R.color.category_family);

        //setting up the GridView
        ListView listView = findViewById(R.id.family_ListView);

        //Setting Up the Adapter for the GridView
        listView.setAdapter(familyAdapter);
    }

}