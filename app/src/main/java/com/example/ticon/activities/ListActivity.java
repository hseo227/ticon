package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView SavedListRV;
    LinearLayoutManager linearLayoutManager;
    Button button;

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

        String categoryTitle = "#" + category.toUpperCase();
        getSupportActionBar().setTitle(categoryTitle);

        if (category.equals("funny")) {
            DataProvider.getFunnyData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "three");
                getData(emoticonAdapter);
            });
        } else if (category.equals("character")) {
            DataProvider.getCharacterData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "four");
                getData2(emoticonAdapter);
            });
        } else {
            DataProvider.getAnimalsData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, "three");
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

    protected void getData2(EmoticonAdapter emoticonAdapter) {
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        GridLayoutManager Glayout = new GridLayoutManager(this, 2);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        SavedListRV.setLayoutManager(Glayout);
        SavedListRV.setAdapter(emoticonAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        menu.findItem(R.id.action_search).setIcon(R.drawable.home_icon);
        menu.findItem(R.id.action_search).setActionView(button);
        return true;
    }

    public void onHomePressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            onHomePressed();
            return true;
        } else if (item.getItemId() == R.id.favorite) {
            return true;
        } else {
            finish();
            return true;
        }
    }


}
