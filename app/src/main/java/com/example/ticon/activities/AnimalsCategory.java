package com.example.ticon.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;

import java.util.ArrayList;

public class AnimalsCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RecyclerView listRV = findViewById(R.id.listRView);

        // here we have created new array list and added data to it.
        // Arraylist for storing data
        ArrayList<ListModel> listModelArrayList = new ArrayList<>();
        listModelArrayList.add(new ListModel(R.drawable.animal_friends1, R.drawable.animal_friends2, R.drawable.animal_friends3, "Animal Friends"));
        listModelArrayList.add(new ListModel(R.drawable.bad_ducks1, R.drawable.bad_ducks2, R.drawable.bad_ducks3, "Bad ducks"));
        listModelArrayList.add(new ListModel(R.drawable.cluck_chicken1, R.drawable.cluck_chicken2, R.drawable.cluck_chicken3, "Cluck Chicken"));
        listModelArrayList.add(new ListModel(R.drawable.crazy_dog1, R.drawable.crazy_dog2, R.drawable.crazy_dog3, "Crazy dog"));
        listModelArrayList.add(new ListModel(R.drawable.duck_cry, R.drawable.duck_heart, R.drawable.duck_x, "Duck"));
        listModelArrayList.add(new ListModel(R.drawable.stockman_monkey1, R.drawable.stockman_monkey2, R.drawable.stockman_monkey3, "Stockman Monkey"));

        // we are initializing our adapter class and passing our arraylist to it.
        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, listModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        listRV.setLayoutManager(linearLayoutManager);
        listRV.setAdapter(emoticonAdapter);

    }
}
