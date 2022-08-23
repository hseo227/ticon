package com.example.ticon.activities;

import com.example.ticon.models.Emoticon;

import java.util.Comparator;

public class SortByDate implements Comparator<Emoticon> {

    @Override
    public int compare (Emoticon emoticon1, Emoticon emoticon2) {
        return emoticon2.getDate() - emoticon1.getDate();
    }

        @Override
        public Comparator<Emoticon> reversed() {
            return Comparator.super.reversed();
    }

}
