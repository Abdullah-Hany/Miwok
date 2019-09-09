package com.example.beido.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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


        numbers.add(new Word("Father", "әpә",R.drawable.family_father, R.raw.family_father));
        numbers.add(new Word("Mother", "әṭa",R.drawable.family_mother, R.raw.family_mother));
        numbers.add(new Word("Son", "angsi",R.drawable.family_son, R.raw.family_son));
        numbers.add(new Word("Daughter", "tune",R.drawable.family_daughter, R.raw.family_daughter));
        numbers.add(new Word("Older brother", "taachi",R.drawable.family_older_brother, R.raw.family_older_brother));
        numbers.add(new Word("Younger brother", "chalitti",R.drawable.family_younger_brother, R.raw.family_younger_brother));
        numbers.add(new Word("Older sister", "teṭe",R.drawable.family_older_sister, R.raw.family_older_sister));
        numbers.add(new Word("Younger sister", "kolliti",R.drawable.family_younger_sister, R.raw.family_younger_sister));
        numbers.add(new Word("Grandmother", "ama",R.drawable.family_grandmother, R.raw.family_grandmother));
        numbers.add(new Word("Grandfather", "paapa",R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter itemsAdapter = new WordAdapter(this, numbers , R.color.category_family);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word item = (Word) listView.getItemAtPosition(i);
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, item.getAudio());
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
