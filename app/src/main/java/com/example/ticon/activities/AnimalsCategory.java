package com.example.ticon.activities;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;

import java.util.ArrayList;

public class AnimalsCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_list);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView listRV = findViewById(R.id.listRView);

        // here we have created new array list and added data to it.
        // Arraylist for storing data
        ArrayList<ListModel> listModelArrayList = new ArrayList<>();
        listModelArrayList.add(new ListModel(R.drawable.animal_friends1, R.drawable.animal_friends2, R.drawable.animal_friends3, "Animal Friends"));
        listModelArrayList.add(new ListModel(R.drawable.baby_penguin1, R.drawable.baby_penguin2, R.drawable.baby_penguin3, "Baby Penguin"));
        listModelArrayList.add(new ListModel(R.drawable.hello_hamster1, R.drawable.hello_hamster2, R.drawable.hello_hamster3, "Hello Hamster"));
        listModelArrayList.add(new ListModel(R.drawable.love_kitty1, R.drawable.love_kitty2, R.drawable.love_kitty3, "Love Kitty"));
        listModelArrayList.add(new ListModel(R.drawable.purple_hippo1, R.drawable.purple_hippo2, R.drawable.purple_hippo3, "Purple Hippo"));
        listModelArrayList.add(new ListModel(R.drawable.money_pig1, R.drawable.money_pig2, R.drawable.money_pig3, "Money Pig"));
        listModelArrayList.add(new ListModel(R.drawable.bad_ducks1, R.drawable.bad_ducks2, R.drawable.bad_ducks3, "Bad ducks"));
        listModelArrayList.add(new ListModel(R.drawable.cluck_chicken1, R.drawable.cluck_chicken2, R.drawable.cluck_chicken3, "Cluck Chicken"));
        listModelArrayList.add(new ListModel(R.drawable.crazy_dog1, R.drawable.crazy_dog2, R.drawable.crazy_dog3, "Crazy dog"));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
