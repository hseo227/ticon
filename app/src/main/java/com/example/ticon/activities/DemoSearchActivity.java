package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.activities.DetailsActivity;
import com.example.ticon.activities.EmoticonAdapter;
import com.example.ticon.activities.ListModel;
import com.example.ticon.activities.MonkeyActivity;
import com.example.ticon.databinding.ActivityMainBinding;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;
import java.util.List;

public class DemoSearchActivity extends AppCompatActivity {

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
        List<Emoticon> listModelArrayList = new ArrayList<>();
        //listModelArrayList.add(new ListModel(R.drawable.stockman_monkey1, R.drawable.stockman_monkey2, R.drawable.stockman_monkey3, "Stockman Monkey"));

        // we are initializing our adapter class and passing our arraylist to it.
        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, listModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        listRV.setLayoutManager(linearLayoutManager);
        listRV.setAdapter(emoticonAdapter);

        Button changeToMonkey = findViewById(R.id.monkeyButton);
        changeToMonkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityMonkey();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }


    private void changeActivityMonkey() {
        Intent intent = new Intent(this, MonkeyActivity.class);
        startActivity(intent);
    }
}