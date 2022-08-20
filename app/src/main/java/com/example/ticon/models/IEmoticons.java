package com.example.ticon.models;

import java.io.Serializable;
import java.util.List;

public interface IEmoticons extends Serializable {

    public String getItemID();

    public String getName();

    public String getCategory();

    public List<String> getImages();

    public String getDescription();

    public String getArtist();

    public double getPrice();

    public boolean getIsInWishlist();

    public int getViews();

    public void incrementViews();

}
