package com.example.beido.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> numbers = new ArrayList<Word>();


        numbers.add(new Word("Red", "weṭeṭṭi" , R.drawable.color_red , R.raw.color_red));
        numbers.add(new Word("Green", "chokokki",R.drawable.color_green, R.raw.color_green));
        numbers.add(new Word("Brown", "ṭakaakki",R.drawable.color_brown, R.raw.color_brown));
        numbers.add(new Word("Gray", "ṭopoppi",R.drawable.color_gray, R.raw.color_gray));
        numbers.add(new Word("Black", "kululli",R.drawable.color_black, R.raw.color_black));
        numbers.add(new Word("White", "kelelli",R.drawable.color_white, R.raw.color_white));
        numbers.add(new Word("Dusty yellow", "ṭopiisә",R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        numbers.add(new Word("Mustard yellow", "chiwiiṭә",R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        WordAdapter itemsAdapter = new WordAdapter(this, numbers , R.color.category_colors);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word item = (Word) listView.getItemAtPosition(i);
                releaseMediaPlayer();
                 mediaPlayer = MediaPlayer.create(ColorsActivity.this, item.getAudio());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(onCompletionListener);

            }


        });
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
}}
