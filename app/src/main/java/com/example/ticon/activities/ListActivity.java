package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView SavedListRV;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_list);
        SavedListRV = findViewById(R.id.listRView);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        String listType = intent.getStringExtra("listType");

        if (category.equals("funny")) {
            DataProvider.getFunnyData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "list");
                getData(emoticonAdapter);
            });
        } else if (category.equals("character")) {
            DataProvider.getCharacterData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "list");
                getData(emoticonAdapter);
            });
        } else {
            DataProvider.getAnimalsData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "list");
                getData(emoticonAdapter);
            });
        }

    }

    protected void getData(EmoticonAdapter emoticonAdapter) {
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager layout = new LinearLayoutManager(this);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        SavedListRV.setLayoutManager(layout);
        SavedListRV.setAdapter(emoticonAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
