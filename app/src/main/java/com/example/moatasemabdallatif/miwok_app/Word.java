package com.example.moatasemabdallatif.miwok_app;

public class Word {

    private String Miwok ;  //the Miwok word
    private String English; //the English Word
    private int mImageID= noImage;  // setting the Default value to -1 so if there is no image provided the it stays -1
    private static int noImage= -1;

    //default constructor
    public Word(){}

    //parameterized constructors
    public Word( String english , String miwok) {
        Miwok = miwok;
        English = english;
    }
    public Word( String english , String miwok, int id) {
        Miwok = miwok;
        English = english;
        mImageID = id;
    }

    //getters & setters
    public String getMiwok() {
        return Miwok;
    }

    public void setMiwok(String miwok) {
        Miwok = miwok;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public int getmImageID() {
        return mImageID;
    }

    public void setmImageID(int mImageID) {
        this.mImageID = mImageID;
    }

    public boolean hasImage(){
        return mImageID!=noImage;
    }
}
