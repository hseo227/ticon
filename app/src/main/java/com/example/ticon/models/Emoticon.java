package com.example.ticon.models;

import com.example.ticon.data.DataProvider;

import java.io.Serializable;
import java.util.List;

public class Emoticon implements Serializable {

    /**
     * The data model class for Emoticons.
     */

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

    public boolean isMy_emoticons() {
        return my_emoticons;
    }

    public List<String> getImages() {
        return images;
    }

    public int getDate() {
        return date;
    }

    // Updating the is_wishlist boolean in Firestore using DataProvider
    public void updateWishList(boolean isWishList) {
        String collection = this.getCategory();
        String documentID = this.getId();
        this.wishlist = isWishList;
        DataProvider.setWishList(collection, documentID, this.wishlist);
    }

    // Updating the my_emoticons boolean in Firestore using DataProvider
    public void updateMyEmoticons(boolean isMyEmoticons) {
        String collection = this.getCategory();
        String documentID = this.getId();
        this.my_emoticons = isMyEmoticons;
        DataProvider.setMyEmoticons(collection, documentID, this.my_emoticons);
    }

    // Incrementing the view in Firestore using DataProvider
    public void incrementViews() {
        String collection = this.getCategory();
        String documentID = this.getId();
        DataProvider.setIncrementViews(collection, documentID);
    }
}
