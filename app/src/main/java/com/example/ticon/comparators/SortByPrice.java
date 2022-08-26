package com.example.ticon.comparators;

import com.example.ticon.models.Emoticon;

import java.util.Comparator;

public class SortByPrice implements Comparator<Emoticon>{

    @Override
    public int compare (Emoticon emoticon1, Emoticon emoticon2) {
        if (emoticon1.getPrice() < emoticon2.getPrice()) {
            return 1;
        } else if (emoticon1.getPrice() > emoticon2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }

}
