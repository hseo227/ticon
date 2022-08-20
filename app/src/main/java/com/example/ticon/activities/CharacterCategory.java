package com.example.ticon.activities;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;

import java.util.ArrayList;

public class CharacterCategory extends AppCompatActivity {

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
        listModelArrayList.add(new ListModel(R.drawable.bad_ducks1, R.drawable.bad_ducks2, R.drawable.bad_ducks3, "Bad ducks"));
        listModelArrayList.add(new ListModel(R.drawable.cluck_chicken1, R.drawable.cluck_chicken2, R.drawable.cluck_chicken3, "Cluck Chicken"));
        listModelArrayList.add(new ListModel(R.drawable.colourful_friends1, R.drawable.colourful_friends2, R.drawable.colourful_friends3, "Colourful Friends"));
        listModelArrayList.add(new ListModel(R.drawable.crazy_dog1, R.drawable.crazy_dog2, R.drawable.crazy_dog3, "Crazy dog"));
        listModelArrayList.add(new ListModel(R.drawable.devasted_man1, R.drawable.devasted_man2, R.drawable.devasted_man3, "Devastated man"));
        listModelArrayList.add(new ListModel(R.drawable.duck_cry, R.drawable.duck_heart, R.drawable.duck_x, "Duck"));
        listModelArrayList.add(new ListModel(R.drawable.mr_donothing1, R.drawable.mr_donothing2, R.drawable.mr_donothing3, "Mr Donothing"));
        listModelArrayList.add(new ListModel(R.drawable.princess_moments1, R.drawable.princess_moments2, R.drawable.princess_moments3, "Princess Moments"));
        listModelArrayList.add(new ListModel(R.drawable.shopaholic1, R.drawable.shopaholic2, R.drawable.shopaholic3, "Shopaholic"));
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
