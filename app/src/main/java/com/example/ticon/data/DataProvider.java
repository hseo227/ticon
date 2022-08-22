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
                    System.out.println("NAME: " + emoticon.getName());
                }
            }

            if (emoticons.size() > 0 ) {
                taskListener.onComlete(emoticons);
            }
        });


    }
}
