package com.example.ticon.comparators;

import com.example.ticon.models.Emoticon;

import java.util.Comparator;

public class SortByPopularity implements Comparator<Emoticon>{

    /**
     * Used to sort a list of emoticons by POPULARITY.
     * From 'most viewed' to 'least viewed'.
     */

    @Override
    public int compare (Emoticon emoticon1, Emoticon emoticon2) {
        return emoticon2.getViews() - emoticon1.getViews();
    }

}
