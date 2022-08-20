package com.example.ticon.data;

import com.example.ticon.models.Emoticons;

import java.util.List;

public interface CompleteListener<T> {
    void onComplete(List<Emoticons> complete);
}
