package com.example.languagelearndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView colors = findViewById(R.id.colors);
        TextView family_names = findViewById(R.id.family_name_id);
        TextView phrases = findViewById(R.id.phrases_id);

        Intent colors_page = new Intent(this, ColorsActivity.class);
        Intent family_name_page = new Intent(this, FamilyName_activity.class);
        Intent Phrases_page = new Intent(this, PhrasesAct.class);

        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(colors_page);
            }
        });

        family_names.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(family_name_page);
            }
        });

        phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Phrases_page);
            }
        });
    }

    public void Numbers(View view)
    {
        Intent intent = new Intent(this, Numbers.class);
        startActivity(intent);
    }
}