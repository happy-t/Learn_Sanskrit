package com.example.languagelearndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        ArrayList<words> colors = new ArrayList<words>();
        colors.add(new words("लोहितः","red" , R.drawable.color_red));
        colors.add(new words("हरितः","green",R.drawable.color_green));
        colors.add(new words("श्यावः","brown", R.drawable.color_brown));
        colors.add(new words("धूसरः","grey" , R.drawable.color_gray));
        colors.add(new words("श्यामः","black", R.drawable.color_black));
        colors.add(new words("शुक्लः","white", R.drawable.color_white));
        colors.add(new words("पीतः","yellow", R.drawable.color_mustard_yellow));
//        colors.add(new words("नीलः","blue"));

        wordsAdapter colorsAdapter = new wordsAdapter(this, colors, R.color.colors);
        ListView listView = findViewById(R.id.colorView);
        listView.setAdapter(colorsAdapter);

    }
}