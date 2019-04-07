package com.example.moatasemabdallatif.miwok_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the text views for the main four categories
        TextView Numbers = findViewById(R.id.numbers);
        TextView Family = findViewById(R.id.family);
        TextView Colors = findViewById(R.id.colors);
        TextView Phrases = findViewById(R.id.phrases);

        //Adding the click listeners
        Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // creating a new Intent that moves to the other Activities
                Intent i = new Intent(MainActivity.this,Numbers_Activity.class);
                startActivity(i);

            }
        });

        Family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Family_Activity.class);
                startActivity(i);

            }
        });

        Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Colors_Activity.class);
                startActivity(i);

            }
        });

        Phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Phrases_Activity.class);
                startActivity(i);

            }
        });



    }

}
