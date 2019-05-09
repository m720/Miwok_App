package com.example.moatasemabdallatif.miwok_app;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter {

    private int cat; // int variable to contain the Color
    //parametrized Constructor
    public WordAdapter(@NonNull Context context, ArrayList <Word> resource, int category) {
        super(context, 0,resource);
        cat = category;
    }



    @NonNull
    @Override //Overriding the getView Method to edit the view of the elements
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemsList = convertView; //creating a view Variable
        if(itemsList== null){ // if there is no view then create one (Inflation)

            // creating new View assigning it's parent
            itemsList=LayoutInflater.from(getContext()).inflate(R.layout.words_item, parent, false);
        }
        //creating a Word Object that contains the current Object
        Word currentNumber =(Word) getItem(position);

        //creating a TextView that Holds the English Word and Assigning it's Value
        TextView EnglishWord = itemsList.findViewById(R.id.English_word);
        EnglishWord.setText(currentNumber.getEnglish());

        //creating a TextView that Holds the Miwok Word and Assigning it's Value
        TextView MiwokWord = itemsList.findViewById(R.id.Miok_word);
        MiwokWord.setText(currentNumber.getMiwok());

        //Creating an ImageView that Holds the Image if there is an Image provided
        ImageView image = itemsList.findViewById(R.id.imageView);
        if(currentNumber.hasImage()) {
            //setting up the image
            image.setImageResource(currentNumber.getmImageID());
        }
        else{
            //not Visible , doesn't take any space
            image.setVisibility(View.GONE);
        }

        //Setting the Words Layout (Contains Only Words)
        LinearLayout words_Layout = itemsList.findViewById(R.id.words_layout);
        //getting the Color
        int color = ContextCompat.getColor( getContext(), cat);
        //setting up the Background Color
        words_Layout.setBackgroundColor(color);

        return itemsList;
    }
}
