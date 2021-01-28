package com.example.languagelearndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<words> arr = new ArrayList<words>();
        arr.add(new words("एकम्", "one", R.drawable.number_one));
        arr.add(new words("द्वे ", "two", R.drawable.number_two));
        arr.add(new words("त्रीणि ", "Three", R.drawable.number_three));
        arr.add(new words("चत्वारि ", "four", R.drawable.number_four));
        arr.add(new words("पञ्च", "five", R.drawable.number_five));
        arr.add(new words("षट ", "six", R.drawable.number_six));
        arr.add(new words("सप्त ", "seven", R.drawable.number_seven));
        arr.add(new words("अष्ट ", "eight", R.drawable.number_eight));
        arr.add(new words("नव", "nine", R.drawable.number_nine));
        arr.add(new words("दश", "ten", R.drawable.number_ten));


        wordsAdapter arrayAdapter = new wordsAdapter(this, arr, R.color.numbers);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);
    }
}