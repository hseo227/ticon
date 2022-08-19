package com.example.ticon.activities;

public class SavedModel {
    private int emoticonimg;
    private int heartimg;
    private String emoticonName;
    private String author;

    public SavedModel(int emoticonimg, int heartimg, String emoticonName, String author) {
        this.emoticonimg = emoticonimg;
        this.heartimg = heartimg;
        this.emoticonName = emoticonName;
        this.author = author;
    }

    //    Getter and Setter
    public int getEmoticonimg() {
        return emoticonimg;
    }

    public void setEmoticonimg(int emoticonimg) {
        this.emoticonimg = emoticonimg;
    }

    public int getHeartimg() {
        return heartimg;
    }

    public void setHeartimg(int heartimg) {
        this.heartimg = heartimg;
    }

    public String getEmoticonName() {
        return emoticonName;
    }

    public void setEmoticonName(String emoticonName) {
        this.emoticonName = emoticonName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
