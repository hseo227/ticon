package com.example.ticon.data;

import com.example.ticon.models.Category;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {

    public static void getEmoticonData(CompleteListener<List<Category>> onCompleteListener){
        List<Category> emoticonList = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("funny").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                QuerySnapshot results = task.getResult();
                for (Emoticons emoticons: results.toObjects(Emoticons.class)) {
                    emoticonList.add(coffeeBeans);
                }
            }

            if (emoticonList.size() > 0) {
                onCompleteListener.onComplete(emoticonList);
            }
        });
    }

}
