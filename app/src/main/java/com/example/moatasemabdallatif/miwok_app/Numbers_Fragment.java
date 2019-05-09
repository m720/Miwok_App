package com.example.moatasemabdallatif.miwok_app;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class Numbers_Fragment extends Fragment {

    ListView listView ;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        Log.d("Adapter" , "Start with Numbers onCreateView");

            View view = inflater.inflate(R.layout.numbers_activity, container, false);
            listView = new ListView(getActivity());
            listView = view.findViewById(R.id.numbers_listView);

        Log.d("Adapter" , "Done with Numbers onCreateVliew");

        //ArrayList of Objects to be Shown
        final ArrayList<Word> Words = new ArrayList<>();

        //adding objects to the ArrayList
        Words.add(new Word("One" , "lutti", R.drawable.number_one, R.raw.number_one ));
        Words.add(new Word("Two" ,"otiiko", R.drawable.number_two ,R.raw.number_two));
        Words.add(new Word( "Three" ,"tolookosu", R.drawable.number_three,R.raw.number_three));
        Words.add(new Word( "Four" ,"oyyiisa", R.drawable.number_four, R.raw.number_four ));
        Words.add(new Word( "Five" ,"massokka", R.drawable.number_five, R.raw.number_five));
        Words.add(new Word("Six" ,"temmokka", R.drawable.number_six, R.raw.number_six ));
        Words.add(new Word( "Seven" ,"kenekaku", R.drawable.number_seven, R.raw.number_seven));
        Words.add(new Word("Eight" , "kawinta", R.drawable.number_eight, R.raw.number_eight ));
        Words.add(new Word( "Nine","wo'e", R.drawable.number_nine,R.raw.number_nine));
        Words.add(new Word("Ten","na'aacha", R.drawable.number_ten , R.raw.number_ten));

        //setting up the WordAdapter  , Adding the ArrayList to the adapter and setting up the Background Color
        WordAdapter  itemsAdapter = new WordAdapter (getActivity(), Words, R.color.category_numbers);



        //Adjusting the Adapter to the GridView
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = Words.get(position);
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



        return  view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Adapter" , "Start with Numbers onCreate");


        super.onCreate(savedInstanceState);


        Log.d("Adapter" , "Done with Numbers onCreate");
    }

    public  void releasemedia(MediaPlayer m){
        if(m!=null){
            m.release();
            m=null;
        }

    }


}
