package com.example.languagelearndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyName_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_name_activity);

        ListView familyNames = findViewById(R.id.familyName);
        ArrayList<words> names = new ArrayList<words>();

        names.add(new words("पिता","father", R.drawable.family_father));
        names.add(new words("माता","mother", R.drawable.family_mother));
        names.add(new words("पुत्रः","son", R.drawable.family_son));
        names.add(new words("पुत्री","daughter", R.drawable.family_daughter));
        names.add(new words("ज्येष्ठभ्राता","older brother",R.drawable.family_older_brother));
        names.add(new words("कनिष्ठभ्राता","younger brother", R.drawable.family_younger_brother));
        names.add(new words("ज्येष्ठभगिनी","older sister", R.drawable.family_older_sister));
        names.add(new words("कनिष्ठभगिनी","younger sister", R.drawable.family_younger_sister));
        names.add(new words("पितामही","grandmother", R.drawable.family_grandmother));
        names.add(new words("पितामहः","grandfather", R.drawable.family_grandfather));

        wordsAdapter adapter = new wordsAdapter(this, names, R.color.famNames);
        familyNames.setAdapter(adapter);

    }
}