package com.example.beido.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            //Toast.makeText(PhrasesActivity.this , "hey ",Toast.LENGTH_SHORT).show();

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


        numbers.add(new Word("Where are you going ?", "minto wuksus",R.raw.phrase_where_are_you_going));
        numbers.add(new Word("What is your name ?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        numbers.add(new Word("My name is ...", "oyaaset...",R.raw.phrase_my_name_is));
        numbers.add(new Word("How are you feeling ?", "michәksәs ?",R.raw.phrase_how_are_you_feeling));
        numbers.add(new Word("I am feeling good", "kuchi achit",R.raw.phrase_im_feeling_good));
        numbers.add(new Word("Are you coming ?", "әәnәs'aa ?",R.raw.phrase_are_you_coming));
        numbers.add(new Word("Yes, i am coming", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        numbers.add(new Word("I am coming", "әәnәm",R.raw.phrase_im_coming));
        numbers.add(new Word("Let's go", "yoowutis",R.raw.phrase_lets_go));
        numbers.add(new Word("Come here", "әnni'nem",R.raw.phrase_come_here));


        WordAdapter itemsAdapter = new WordAdapter(this, numbers , R.color.category_phrases);

        final ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Word item = (Word) listView.getItemAtPosition(i);

             releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, item.getAudio());
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
