package com.example.moatasemabdallatif.miwok_app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases_Activity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setting up the layout
        setContentView(R.layout.phrases_activity);

        try {
            android.support.v7.app.ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException n){
            Log.d("ActionBar", "null pointetr ,the Action Bar not Found");
        }
        //setting up the GridView
        ListView listView = findViewById(R.id.phrases_listView);
        //creating the ArrayList of Object to be Shown
        ArrayList<Word> words = new ArrayList<>();

        //adding the Objects to the ArrayLisy
        words.add(new Word("Where are you going?", "minto wuksus"));
        words.add(new Word("What is your name?", "tinnә oyaase'nә"));
        words.add(new Word("My name is...", "oyaaset..."));
        words.add(new Word("How are you feeling?", "michәksәs?"));
        words.add(new Word("I'm feeling good.", "kuchi achit"));
        words.add(new Word("Are you coming?", "әәnәs'aa?"));
        words.add(new Word("Yes. I'm coming.", "hәә’ әәnәm"));
        words.add(new Word("I'm coming.", "әәnәm"));
        words.add(new Word("Let's go.", "yoowutis"));
        words.add(new Word("Come here.", "әnni'nem"));

        //Setting Up the Adapter , Adding the ArrayList of Objects to Be shown and setting up the background Color
        WordAdapter phrasesAdapter = new WordAdapter(this , words, R.color.category_phrases);

        //setting up the Adapter to the GridView
        listView.setAdapter(phrasesAdapter);


        }

}
