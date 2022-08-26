package com.example.ticon.data;

import com.example.ticon.models.Emoticon;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

    public static void getAllData(ITaskListener<List<Emoticon>> taskListener) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        List<Emoticon> emoticons = new ArrayList<>();

        database.collection("animals").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon : results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0) {
                taskListener.onComlete(emoticons);
            }
        });


        database.collection("characters").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon : results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0) {
                taskListener.onComlete(emoticons);
            }
        });

        database.collection("funny").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticon emoticon : results.toObjects(Emoticon.class)) {
                    emoticons.add(emoticon);
                }
            }

            if (emoticons.size() > 0) {
                taskListener.onComlete(emoticons);
            }
        });

    }

//    public static void getEmoticonById(String collection, String documentId) {
//        FirebaseFirestore database = FirebaseFirestore.getInstance();
//        Emoticon emoticon = new Emoticon();
//        DocumentReference docRef = database.collection(collection).document(documentId);
//        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                Emoticon emoticon = documentSnapshot.toObject(Emoticon.class);
//            }
//        });
//    }

    public static void incrementTimesViewed(String collection, String documentID) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference docRef = database.collection(collection).document(documentID);
        docRef.update("timesViewed", FieldValue.increment(1));
    };

    public static void setWishList(String collection, String documentID, boolean isWishList) {
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        DocumentReference docRef = database.collection(collection).document(documentID);
        docRef.update("wishlist", isWishList);
    }

}
