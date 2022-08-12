package com.example.ticon.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView SavedListRV;

    // Arraylist for storing data
    private ArrayList<SavedModel> savedModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        SavedListRV = findViewById(R.id.SavedListRView);

        // here we have created new array list and added data to it.
        savedModelArrayList = new ArrayList<>();
        savedModelArrayList.add(new SavedModel(R.drawable.back_icon, R.drawable.back_icon, "Back icon", "Back icon"));
        savedModelArrayList.add(new SavedModel(R.drawable.close_icon, R.drawable.close_icon, "Close icon", "Close icon"));
        savedModelArrayList.add(new SavedModel(R.drawable.search_icon, R.drawable.search_icon, "Search icon", "Search icon"));
        savedModelArrayList.add(new SavedModel(R.drawable.sort_icon, R.drawable.sort_icon, "Sort icon","Sort icon"));
        savedModelArrayList.add(new SavedModel(R.drawable.back_icon, R.drawable.back_icon, "Back icon", "Back icon"));
        savedModelArrayList.add(new SavedModel(R.drawable.close_icon, R.drawable.close_icon, "Close icon", "Close icon"));
        savedModelArrayList.add(new SavedModel(R.drawable.search_icon, R.drawable.search_icon, "Search icon", "Search icon"));

        // we are initializing our adapter class and passing our arraylist to it.
        MyEmoticonAdapter myemoticonAdapter = new MyEmoticonAdapter(this, savedModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        SavedListRV.setLayoutManager(linearLayoutManager);
        SavedListRV.setAdapter(myemoticonAdapter);

        ItemSpacing itemSpacing = new ItemSpacing(16);
        SavedListRV.addItemDecoration(itemSpacing);

    }
}
