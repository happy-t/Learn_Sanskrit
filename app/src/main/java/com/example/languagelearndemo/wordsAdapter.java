package com.example.languagelearndemo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class wordsAdapter extends ArrayAdapter<words> {


    int color;

    public wordsAdapter(Activity context, ArrayList<words> word, int color) {
        super(context, 0, word);
        this.color = color;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listView = convertView;
//        parent.setBackgroundColor(color);
        if(listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        View container = listView.findViewById(R.id.container);
        int colour = ContextCompat.getColor(getContext(), color);
        container.setBackgroundColor(colour);

        words currentPosition = getItem(position);

        TextView sanskrit = listView.findViewById(R.id.sanskritTranslation);
        sanskrit.setBackgroundColor(colour);
        sanskrit.setText(currentPosition.getTranslation());

        TextView default_translation = listView.findViewById(R.id.defaultTranslation);
        default_translation.setBackgroundColor(colour);
        default_translation.setText(currentPosition.getWord());

        ImageView imageView = listView.findViewById(R.id.displayImage);

        ImageView play =listView.findViewById(R.id.play);

        if (currentPosition.hasImage())
        {
            imageView.setImageResource(currentPosition.getImage());
        }

        else {
            imageView.setVisibility(View.GONE);
            play.setVisibility(View.VISIBLE);
        }
        return listView;
    }
}
