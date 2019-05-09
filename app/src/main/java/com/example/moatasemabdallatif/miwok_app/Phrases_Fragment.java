package com.example.moatasemabdallatif.miwok_app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases_Fragment extends Fragment {

   ListView listView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("Adapter" , "Start with Phrases onCreateView");

        View view = inflater.inflate(R.layout.phrases_activity , container , false);
        //setting up the GridView
     listView =(ListView) view.findViewById(R.id.phrases_listView);
        Log.d("Adapter" , "Done with Phrases onCreateView");




        //creating the ArrayList of Object to be Shown
        final ArrayList<Word> words = new ArrayList<>();

        //adding the Objects to the ArrayLisy
        words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("I'm feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
        words.add(new Word("Yes. I'm coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.", "әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let's go.", "yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.", "әnni'nem",R.raw.phrase_come_here));

        //Setting Up the Adapter , Adding the ArrayList of Objects to Be shown and setting up the background Color
        WordAdapter phrasesAdapter = new WordAdapter(getActivity(),  words, R.color.category_phrases);

        //setting up the Adapter to the GridView
        listView.setAdapter(phrasesAdapter);
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
        Log.d("Adapter" , "Start with Phrases onCreate");

        super.onCreate(savedInstanceState);


        Log.d("Adapter" , "Done with phrases onCreateView");


        }
    public  void releasemedia(MediaPlayer m){
        if(m!=null){
            m.release();
            m=null;
        }

    }

}
