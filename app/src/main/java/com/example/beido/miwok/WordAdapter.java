package com.example.beido.miwok;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Beido on 3/4/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int color , audio;
    public WordAdapter(@NonNull Context context, int resource, @NonNull List<Word> objects) {
        super(context, 0, objects );


    }

    public WordAdapter(Activity context, ArrayList<Word> numbers , int colorid)
    {
        super(context, 0, numbers);
        color = colorid;
    }
    public WordAdapter(Activity context, ArrayList<Word> numbers , int colorid , int audiofile)
    {
        super(context, 0, numbers);
        color = colorid;
        audio = audiofile;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word currentWord = getItem(position);
        View listView = convertView;
        if (listView == null)
        {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item ,parent,false);
        }
        TextView englishText = (TextView) listView.findViewById(R.id.default_text_view);
        englishText.setText(currentWord.getEnglish());
        TextView miwokText = (TextView) listView.findViewById(R.id.miwok_text_view);
        miwokText.setText(currentWord.getMiwok());
        ImageView image = (ImageView) listView.findViewById(R.id.image_view);

        if (currentWord.getImageid() != 0)
        {
            image.setImageResource(currentWord.getImageid());
        }
        else
        {
            image.setVisibility(listView.GONE);
        }
        //handling the color view
        View main_view = listView.findViewById(R.id.main_view);
        int newcolor = ContextCompat.getColor(getContext(), color);
        main_view.setBackgroundColor(newcolor);



        return listView;
    }
}
