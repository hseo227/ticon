package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        RecyclerView listRV = findViewById(R.id.listRView);

        // here we have created new array list and added data to it.
        // Arraylist for storing data
        List<Emoticon> listModelArrayList = new ArrayList<>();
//        listModelArrayList.add(new ListModel(R.drawable.ic_back, R.drawable.ic_back, R.drawable.ic_back, "Back icon"));
//        listModelArrayList.add(new ListModel(R.drawable.close_icon, R.drawable.close_icon, R.drawable.close_icon, "Close icon"));
//        listModelArrayList.add(new ListModel(R.drawable.search_icon, R.drawable.search_icon, R.drawable.search_icon, "Search icon"));
//        listModelArrayList.add(new ListModel(R.drawable.sort_icon, R.drawable.sort_icon, R.drawable.sort_icon, "Sort icon"));
//        listModelArrayList.add(new ListModel(R.drawable.ic_back, R.drawable.ic_back, R.drawable.ic_back, "Back icon"));
//        listModelArrayList.add(new ListModel(R.drawable.close_icon, R.drawable.close_icon, R.drawable.close_icon, "Close icon"));
//        listModelArrayList.add(new ListModel(R.drawable.search_icon, R.drawable.search_icon, R.drawable.search_icon, "Search icon"));

        // we are initializing our adapter class and passing our arraylist to it.
        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, listModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        listRV.setLayoutManager(linearLayoutManager);
        listRV.setAdapter(emoticonAdapter);

        ItemSpacing itemSpacing = new ItemSpacing(16);
        listRV.addItemDecoration(itemSpacing);

        Button changeToDuck = findViewById(R.id.duckButton);
        changeToDuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { changeActivityDuck();
            }
        });

        Button changeToMonkey = findViewById(R.id.monkeyButton);
        changeToMonkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityMonkey();
            }
        });


    }

    private void changeActivityDuck() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
    private void changeActivityMonkey() {
        Intent intent = new Intent(this, MonkeyActivity.class);
        startActivity(intent);
    }
}


