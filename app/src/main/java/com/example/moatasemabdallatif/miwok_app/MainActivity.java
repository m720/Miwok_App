package com.example.moatasemabdallatif.miwok_app;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment_Pager_Adapter fp = new Fragment_Pager_Adapter(getSupportFragmentManager());
        ViewPager vp = findViewById(R.id.ViewPager);
        vp.setAdapter(fp);

        Log.d("Adapter1" , "Adapter was set " );
        TabLayout tabs = findViewById(R.id.tabLayout);
        Log.d("Adapter1" , "tabs was set");
        tabs.setupWithViewPager(vp);
        Log.d("Adapter1" , "ViewPager was set");


    }

}
