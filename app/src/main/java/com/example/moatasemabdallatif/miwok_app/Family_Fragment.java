package com.example.moatasemabdallatif.miwok_app;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_Fragment extends Fragment {
    //setting up the GridView
    ListView listView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Adapter" , "Start with Family onCreateView");


        View view = inflater.inflate(R.layout.family_activity ,container , false);
        listView = view.findViewById(R.id.family_ListView);
        Log.d("Adapter" , "Done with Family onCreateView");

        // ArrayList of Words that contains objects to be shown
        final ArrayList<Word> words  = new ArrayList<>();

        //Adding the Objects to the ArrayList
        words.add(new Word("father", "әpә", R.drawable.family_father, R.raw.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother,  R.raw.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather,R.raw.family_grandfather));
        WordAdapter familyAdapter = new WordAdapter(getActivity(), words, R.color.category_family);


        //Setting Up the Adapter for the GridView
        listView.setAdapter(familyAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(), word.getAudioID());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releasemedia(mp);
                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Adapter" , "Start with Family onCreate");

        super.onCreate(savedInstanceState);



        Log.d("Adapter" , "Done with Family onCreateView");
    }
    public  void releasemedia(MediaPlayer m){
        if(m!=null){
            m.release();
            m=null;
        }

    }

}