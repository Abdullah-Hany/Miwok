package com.example.beido.miwok;


public class Word {


    private String english , miwok ;
    private int imageid , audio;


    public Word (String eng , String Miwok , int audiofile)
    {
        english =eng ;
        miwok = Miwok;
        audio = audiofile;
    }
    public Word (String eng , String Miwok , int image , int audiofile)
    {
        english =eng ;
        miwok = Miwok;
        imageid= image;
        audio = audiofile;
    }
    public String getEnglish() {
        return english;
    }
    public String getMiwok() {
        return miwok;
    }
    public int getImageid() {return imageid;}
    public int getAudio() {return audio;}
}
