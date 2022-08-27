package com.example.ticon.comparators;

import com.example.ticon.models.Emoticon;

import java.util.Comparator;

public class SortByDate implements Comparator<Emoticon> {

    /**
     * Used to sort a list of emoticons by DATE.
     * From 'newest' to 'oldest'.
     */

    @Override
    public int compare (Emoticon emoticon1, Emoticon emoticon2) {
        return emoticon2.getDate() - emoticon1.getDate();
    }

}
