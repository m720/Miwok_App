package com.example.moatasemabdallatif.miwok_app;

public class Word {

    private String Miwok ;  //the Miwok word
    private String English; //the English Word
    private int mImageID= noImage;  // setting the Default value to -1 so if there is no image provided the it stays -1
    private static int noImage= -1;
    private int audioID ;



    //default constructor
    public Word(){}

    //parameterized constructors
    public Word( String english , String miwok) {
        Miwok = miwok;
        English = english;
    }
    public Word( String english , String miwok,int audio) {
        Miwok = miwok;
        English = english;
        audioID= audio;
    }
    public Word( String english , String miwok, int id ,int audio) {
        Miwok = miwok;
        English = english;
        mImageID = id;
        audioID = audio;
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

    public int getAudioID() {return audioID;    }

    public void setAudioID(int audioID) {this.audioID = audioID; }

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
