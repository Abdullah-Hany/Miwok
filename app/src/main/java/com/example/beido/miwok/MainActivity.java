package com.example.beido.miwok;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OpenNumbersList (View view)
    {
        Intent intent = new Intent(this, NumbersActivity.class);
        startActivity(intent); }
    public void OpenFamilyList (View view)
    {
        Intent intent = new Intent(this, FamilyActivity.class);
        startActivity(intent); }
    public void OpenColorsList (View view)
    {
        Intent intent = new Intent(this, ColorsActivity.class);
        startActivity(intent); }
    public void OpenPhrasesList (View view)
    {
        Intent intent = new Intent(this, PhrasesActivity.class);
        startActivity(intent); }
}
