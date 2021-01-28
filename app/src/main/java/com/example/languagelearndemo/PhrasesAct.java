package com.example.languagelearndemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PhrasesAct extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    AudioManager maudioManager;

    void releaseMediaPlayer()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();

            mediaPlayer = null;

            maudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS)
                    {

                        releaseMediaPlayer();

                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback
                        mediaPlayer.pause();
                        mediaPlayer.seekTo(0);

                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary

                        mediaPlayer.start();
                    }
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        this.setTitle("Phrases");

        final ArrayList<words> arrayList = new ArrayList<words>();
        ListView listView = findViewById(R.id.Phrases_View);

        maudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


        arrayList.add(new words("To work alone you have the right, and not to the fruits. Do not be impelled by the fruits of work.\n" +
                "Nor have attachment to inaction.","कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।\n" +
                "मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥", 0,R.raw.karmanie));

        arrayList.add(new words("One whose mind remains undisturbed amidst misery, who does not crave for pleasure, " +
                "and who is free from attachment, fear, and anger, is called a sage of steady wisdom.","दु:खेष्वनुद्विग्नमना: सुखेषु विगतस्पृह: |\n" +
                "वीतरागभयक्रोध: स्थितधीर्मुनिरुच्यते ||", 0 , R.raw.dukhesh));

        arrayList.add(new words("I am coming, I am coming, when there is a loss of religion, then I am coming, when the iniquity increases, then I am coming to protect the gentlemen, to destroy the wicked I am coming in to establish religion and I am born in the age of era.","यदा यदा हि धर्मस्य ग्लानिर्भवति भारत:।\n" +
                "अभ्युत्थानमधर्मस्य तदात्मानं सृजाम्यहम्॥", 0 , R.raw.yadayada));

        arrayList.add(new words("when one discards all selfish desires and cravings of the senses that torment the mind, " +
                "and becomes satisfied in the realization of the self, such a person is said to be transcendentally situated.",
                "प्रजहाति यदा कामान्सर्वान्पार्थ मनोगतान् |\n" +
                        "आत्मन्येवात्मना तुष्ट: स्थितप्रज्ञस्तदोच्यते ||",0, R.raw.prajahati));

        arrayList.add(new words("The senses are superior to the gross body, and superior to the senses is the mind.\n" +
                "Beyond the mind is the intellect, and even beyond the intellect is the soul.","इन्द्रियाणि पराण्याहुरिन्द्रियेभ्यः परं मनः।\n" +
                "मनसस्तु परा बुद्धिर्यो बुद्धेः परतस्तु सः॥",0,R.raw.indiyani));

        arrayList.add(new words("Just as the boyhood, youth and old age come to the embodied Soul in this body, in the same manner, is the attaining of another body; the wise man is not deluded at that.","देहिनोऽस्मिन्यथा देहे कौमारं यौवनं जरा।\n" +
                "तथा देहान्तरप्राप्तिर्धीरस्तत्र न मुह्यति॥",0,R.raw.dehino));


        wordsAdapter wordsAdapter = new wordsAdapter(this, arrayList, R.color.phrases);
        listView.setAdapter(wordsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int state = maudioManager.requestAudioFocus(
                        afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC, // There's no AudioAttributes, just the more general constant.
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN
                );

                if (state == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {


                    releaseMediaPlayer();

                    mediaPlayer = MediaPlayer.create(getApplicationContext(), arrayList.get(position).getAudioId());

                    mediaPlayer.start();

                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            //Toast.makeText(getApplicationContext(), "I am done",Toast.LENGTH_SHORT).show();;
                            releaseMediaPlayer();
                        }
                    });
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}