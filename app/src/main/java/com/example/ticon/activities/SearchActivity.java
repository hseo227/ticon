package com.example.ticon.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private RecyclerView ListRV;

    // Arraylist for storing data
    private ArrayList<ListModel> listModelArrayList;
    private EmoticonAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // here we have created new array list and added data to it.
        listModelArrayList = new ArrayList<>();
        listModelArrayList.add(new ListModel(R.drawable.back_icon, R.drawable.back_icon, R.drawable.back_icon, "Back icon"));
        listModelArrayList.add(new ListModel(R.drawable.close_icon, R.drawable.close_icon, R.drawable.close_icon, "Close icon"));
        listModelArrayList.add(new ListModel(R.drawable.search_icon, R.drawable.search_icon, R.drawable.search_icon, "Search icon"));
        listModelArrayList.add(new ListModel(R.drawable.sort_icon, R.drawable.sort_icon, R.drawable.sort_icon, "Sort icon"));
        listModelArrayList.add(new ListModel(R.drawable.back_icon, R.drawable.back_icon, R.drawable.back_icon, "Back icon"));
        listModelArrayList.add(new ListModel(R.drawable.close_icon, R.drawable.close_icon, R.drawable.close_icon, "Close icon"));
        listModelArrayList.add(new ListModel(R.drawable.search_icon, R.drawable.search_icon, R.drawable.search_icon, "Search icon"));

        RecyclerView recyclerView = findViewById(R.id.listRView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new EmoticonAdapter(this, listModelArrayList);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

//                ListRV = findViewById(R.id.listRView);

//        // we are initializing our adapter class and passing our arraylist to it.
//        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, listModelArrayList);
//
//        // below line is for setting a layout manager for our recycler view.
//        // here we are creating vertical list so we will provide orientation as vertical
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//
//        // in below two lines we are setting layoutmanager and adapter to our recycler view.
//        ListRV.setLayoutManager(linearLayoutManager);
//        ListRV.setAdapter(emoticonAdapter);
//
//        // spacing between each cardview
//        ItemSpacing itemSpacing = new ItemSpacing(16);
//        ListRV.addItemDecoration(itemSpacing);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return true;
            }
        });
        return true;

    }

}


