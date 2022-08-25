package com.example.ticon.models;

import android.media.Image;

import java.io.Serializable;
import java.util.List;

public class Emoticon implements Serializable {
    private String artist;
    private String category;
    private String description;
    private String id;
    private String name;
    private double price;
    private int views;
    private boolean wishlist;
    private boolean my_emoticons;
    private List<String> images;
    private int date;

    public String getArtist() {
        return artist;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getViews() {
        return views;
    }

    public boolean isWishlist() {
        return wishlist;
    }

    public boolean isMyEmoticons() { return my_emoticons; }

    public List<String> getImages() {
        return images;
    }

    public int getDate() { return date; }
}
