package com.example.languagelearndemo;

public class words {

    private String word;
    private String translation;
//    private String description;
    private final int HAS_NO_IMAGE = -1;
    private int mImage = HAS_NO_IMAGE;

    private int audioId;

    public words(String word, String translation, int imageID ,int audioId) {
        this.word = word;
        this.translation = translation;
        this.audioId = audioId;

    }

    public words(String word, String translation, int imageID)
    {
        this.word = word;
        this.translation = translation;
        this.mImage = imageID;
    //    this.description = description;
    }

    public String getWord()
    {
        return word;
    }

    public String getTranslation()
    {
        return translation;
    }

    public int getImage(){return mImage;}

    public int getAudioId(){return audioId;}

    public boolean hasImage()
    {
        return mImage != HAS_NO_IMAGE;
    }


}
