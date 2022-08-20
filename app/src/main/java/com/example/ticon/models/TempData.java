package com.example.ticon.models;

public class TempData {

    double price;
    String emoticonName, imageFilename, artistName;

    public double getPrice(){
        return price;
    }

    public String getImageFilename(){
        return imageFilename;
    }

    public String getArtistName(){
        return artistName;
    }

    public String getemoticonName(){
        return emoticonName;
    }

    public TempData(double price, String productName, String imageFilename, String brandName){
        this.imageFilename = imageFilename;
        this.price = price;
        this.artistName = artistName;
        this.emoticonName = emoticonName;
    }

}
