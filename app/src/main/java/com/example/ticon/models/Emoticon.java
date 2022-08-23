package com.example.ticon.models;

import android.media.Image;

import java.util.List;

public class Emoticon {
    private String artist;
    private String category;
    private String description;
    private String id;
    private String name;
    private double price;
    private int views;
    private boolean wishlist;
    private List<String> images;

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

    public List<String> getImages() {
        return images;
    }


}
