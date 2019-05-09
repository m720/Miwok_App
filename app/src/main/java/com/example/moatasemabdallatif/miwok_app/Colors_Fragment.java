package com.example.moatasemabdallatif.miwok_app;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class Colors_Fragment extends Fragment {
    //this is a custom class for colors Activity

    ListView listView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
        Log.d("Adapter" , "Start with Colors onCreateView");

        View view = inflater.inflate(R.layout.colors_activity , container ,false);
        //Adjusting the ListView
         listView = view.findViewById(R.id.colors_listView);
        Log.d("Adapter" , "Done with Colors onCreateView");
        // ArrayList of Words that contains objects to be shown
        final ArrayList<Word> words  = new ArrayList<>();

        //adding the Objects to the ArrayList
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә" ,R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        //creating the ArrayAdapter ,adding the ArrayList to it and adding the Back ground Color
        WordAdapter colorAdapter = new WordAdapter(getActivity(), words, R.color.category_colors);

        //setting Up the Adapter for the ListView
        listView.setAdapter(colorAdapter);
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

        Log.d("Adapter" , "Start with Colors onCreate");
        super.onCreate(savedInstanceState);



        Log.d("Adapter" , "Done with Colors onCreate");

    }
    public  void releasemedia(MediaPlayer m){
        if(m!=null){
            m.release();
            m=null;
        }

    }
}