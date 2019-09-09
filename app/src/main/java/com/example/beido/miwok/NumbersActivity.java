package com.example.beido.miwok;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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


        ArrayList<Word> numbers= new ArrayList<Word>();


        numbers.add(new Word ("One" , "lutti",R.drawable.number_one , R.raw.number_one));
        numbers.add(new Word ("Two","otiiko",R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word ("Three" , "tolookosu",R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word ("Four" , "oyyisa",R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word ("Five","massokka",R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word ("Six","temmokka",R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word ("Seven","kenekaku",R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word ("Eight","kawinta",R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word ("Nine","wo'e",R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word ("Ten","na'aacha",R.drawable.number_ten, R.raw.number_ten));


        WordAdapter itemsAdapter = new WordAdapter(this,numbers , R.color.category_numbers);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word item = (Word) listView.getItemAtPosition(i);

                releaseMediaPlayer();

                 mediaPlayer = MediaPlayer.create(NumbersActivity.this, item.getAudio());
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
    }
}
