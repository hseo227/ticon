package com.example.ticon.data;

import com.example.ticon.models.Category;
import com.example.ticon.models.Emoticons;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static void getFunnyEmoticonData(CompleteListener<List<Category>> onCompleteListener){
        List<Emoticons> emoticonList = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("funny").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticons emoticons: results.toObjects(Emoticons.class)) {
                    emoticonList.add(emoticons);
                }
            }

            if (emoticonList.size() > 0) {
                onCompleteListener.onComplete(emoticonList);
            }
        });
    }

    public static void getAnimalEmoticonData(CompleteListener<List<Category>> onCompleteListener){
        List<Emoticons> emoticonList = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("animals").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticons emoticons: results.toObjects(Emoticons.class)) {
                    emoticonList.add(emoticons);
                }
            }

            if (emoticonList.size() > 0) {
                onCompleteListener.onComplete(emoticonList);
            }
        });
    }

    public static void getCharacterEmoticonData(CompleteListener<List<Category>> onCompleteListener){
        List<Emoticons> emoticonList = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("characters").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticons emoticons: results.toObjects(Emoticons.class)) {
                    emoticonList.add(emoticons);
                }
            }

            if (emoticonList.size() > 0) {
                onCompleteListener.onComplete(emoticonList);
            }
        });
    }

    public static void incrementViews(String collection, String documentID) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference docRef = db.collection(collection).document(documentID);
        docRef.update("timesViewed", FieldValue.increment(1));
    };

}