package com.example.ticon.models;

import android.media.Image;

import com.example.ticon.data.DataProvider;

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

    public Emoticon() {};

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

    public void updateWishList(boolean isWishList) {
        String collection = this.getCategory();
        String documentID = this.getId();
        this.wishlist = isWishList;
        DataProvider.setWishList(collection, documentID, this.wishlist);
    }

    public int getDate() {
        return date;
    }

    public boolean isMy_emoticons() {
        return my_emoticons;
    }
}
