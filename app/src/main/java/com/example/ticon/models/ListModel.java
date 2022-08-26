package com.example.ticon.models;

public class ListModel {
    private int emoticonimg1;
    private int emoticonimg2;
    private int emoticonimg3;
    private String emoticonName;

//    Constructor
    public ListModel(int emoticonimg1, int emoticonimg2, int emoticonimg3, String emoticonName) {
        this.emoticonimg1 = emoticonimg1;
        this.emoticonimg2 = emoticonimg2;
        this.emoticonimg3 = emoticonimg3;
        this.emoticonName = emoticonName;
    }

//    Getter and Setter
    public int getEmoticonimg1() {
        return emoticonimg1;
    }

    public void setEmoticonimg1(int emoticonimg1) {
        this.emoticonimg1 = emoticonimg1;
    }

    public int getEmoticonimg2() {
        return emoticonimg2;
    }

    public void setEmoticonimg2(int emoticonimg2) {
        this.emoticonimg2 = emoticonimg2;
    }

    public int getEmoticonimg3() {
        return emoticonimg3;
    }

    public void setEmoticonimg3(int emoticonimg3) {
        this.emoticonimg3 = emoticonimg3;
    }

    public String getEmoticonName() {
        return emoticonName;
    }

    public void setEmoticonName(String emoticonName) {
        this.emoticonName = emoticonName;
    }
}
