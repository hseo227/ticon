package com.example.ticon.models;

import com.example.ticon.data.DataProvider;

import java.util.List;

public class Emoticons implements IEmoticons {

    protected String itemID;
    protected String name;
    protected String category;
    protected List<String> images;
    protected String description;
    protected String artist;
    protected double price;
    protected boolean isInWishlist;
    protected int views;

    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    };

    public List<String> getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }

    public String getArtist() {
        return artist;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsInWishlist() {
        return isInWishlist;
    }

    public int getViews() {
        return views;
    }

    public void incrementViews(){
        String collection = this.getCategory();
        String documentID = this.getItemID();

        DataProvider.incrementViews(collection, documentID);
    }

}
