package com.example.moatasemabdallatif.miwok_app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers_Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setting up the Layout
        setContentView(R.layout.numbers_activity);

        try {
            android.support.v7.app.ActionBar ab = getSupportActionBar();
            ab.setDisplayHomeAsUpEnabled(true);
        }
        catch (NullPointerException n){
            Log.d("ActionBar", "null pointetr ,the Action Bar not Found");
        }
        //ArrayList of Objects to be Shown
        ArrayList<Word> Words = new ArrayList<>();

        //adding objects to the ArrayList
        Words.add(new Word("One" , "lutti", R.drawable.number_one));
        Words.add(new Word("Two" ,"otiiko", R.drawable.number_two ));
        Words.add(new Word( "Three" ,"tolookosu", R.drawable.number_three));
        Words.add(new Word( "Four" ,"oyyiisa", R.drawable.number_four));
        Words.add(new Word( "Five" ,"massokka", R.drawable.number_five));
        Words.add(new Word("Six" ,"temmokka", R.drawable.number_six));
        Words.add(new Word( "Seven" ,"kenekaku", R.drawable.number_seven));
        Words.add(new Word("Eight" , "kawinta", R.drawable.number_eight));
        Words.add(new Word( "Nine","wo'e", R.drawable.number_nine));
        Words.add(new Word("Ten","na'aacha", R.drawable.number_ten ));

        //setting up the WordAdapter  , Adding the ArrayList to the adapter and setting up the Background Color
        WordAdapter  itemsAdapter = new WordAdapter (this, Words, R.color.category_numbers);

        //setting up the GridView
        ListView listView = findViewById(R.id.numbers_listView);

        //Adjusting the Adapter to the GridView
        listView.setAdapter(itemsAdapter);


    }




}
