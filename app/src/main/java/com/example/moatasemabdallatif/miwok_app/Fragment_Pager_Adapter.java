package com.example.moatasemabdallatif.miwok_app;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.lang.reflect.Array;

public class Fragment_Pager_Adapter extends FragmentPagerAdapter {
    String tabTitels []= new String[] {"Numbers" , "Colors" , "Family" ,"Phrases"};

    public Fragment_Pager_Adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if(i==0)return new Numbers_Fragment();
        else if(i==1)return new Colors_Fragment();
        else if(i==2)return new Family_Fragment();
        else return  new Phrases_Fragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitels[position];
    }
}
