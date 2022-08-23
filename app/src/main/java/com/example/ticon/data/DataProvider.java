package com.example.ticon.data;

import android.content.Context;

import com.example.ticon.models.Emoticon;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    public static void getAnimalsData(ITaskListener<List<Emoticon>> taskListener){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        List<Emoticon> emoticons = new ArrayList<>();

        database.collection("animals").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon: results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });
    }

    public static void getCharacterData(ITaskListener<List<Emoticon>> taskListener){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        List<Emoticon> emoticons = new ArrayList<>();

        database.collection("characters").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon: results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });
    }

    public static void getFunnyData(ITaskListener<List<Emoticon>> taskListener){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        List<Emoticon> emoticons = new ArrayList<>();

        database.collection("funny").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon: results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });
    }

    public static void getAllData(ITaskListener<List<Emoticon>> taskListener){
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        List<Emoticon> emoticons = new ArrayList<>();

        database.collection("animals").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon: results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });

        database.collection("characters").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon: results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });

        database.collection("funny").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon: results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });
    }
}
