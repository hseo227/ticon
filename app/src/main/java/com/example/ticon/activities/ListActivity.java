package com.example.ticon.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;

import java.util.Collections;

public class ListActivity extends AppCompatActivity {

    private RecyclerView SavedListRV;

    private class ViewHolder{
        TextView views;
        TextView by_new;
        TextView price;
        public ViewHolder() {
            views = findViewById(R.id.text_sort_popularity);
            by_new = findViewById(R.id.text_sort_new);
            price = findViewById(R.id.text_sort_price);
        }
    }

    ViewHolder vh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_list);
        SavedListRV = findViewById(R.id.listRView);

        vh = new ViewHolder();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        String listType = intent.getStringExtra("listType");

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

        // Onclick for Sort by: VIEWS
        vh.views.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                if (category.equals("funny")) {
                    DataProvider.getFunnyData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "three");
                        getDataSortedPopular(emoticonAdapter, "");
                    });
                } else if (category.equals("character")) {
                    DataProvider.getCharacterData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "four");
                        getDataSortedPopular(emoticonAdapter, "grid");
                    });
                } else {
                    DataProvider.getAnimalsData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "three");
                        getDataSortedPopular(emoticonAdapter, "");
                    });
                }
            }
        });

        // Onclick for Sort by: NEW
        vh.by_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (category.equals("funny")) {
                    DataProvider.getFunnyData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "three");
                        getDataSortedDate(emoticonAdapter, "");
                    });
                } else if (category.equals("character")) {
                    DataProvider.getCharacterData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "four");
                        getDataSortedDate(emoticonAdapter, "grid");
                    });
                } else {
                    DataProvider.getAnimalsData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "three");
                        getDataSortedDate(emoticonAdapter, "");
                    });
                }
            }
        });

        // Onclick for Sort by: DATA
        vh.price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (category.equals("funny")) {
                    DataProvider.getFunnyData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "three");
                        getDataSortedPrice(emoticonAdapter, "");
                    });
                } else if (category.equals("character")) {
                    DataProvider.getCharacterData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "four");
                        getDataSortedPrice(emoticonAdapter, "grid");
                    });
                } else {
                    DataProvider.getAnimalsData(emoticons -> {
                        // we are initializing our adapter class and passing our arraylist to it.
                        EmoticonAdapter emoticonAdapter = new EmoticonAdapter(ListActivity.this, emoticons, "three");
                        getDataSortedPrice(emoticonAdapter, "");
                    });
                }
            }
        });
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
        GridLayoutManager grid_layout = new GridLayoutManager(this, 2);
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        SavedListRV.setLayoutManager(grid_layout);
        SavedListRV.setAdapter(emoticonAdapter);
    }

    protected void getDataSortedPopular(EmoticonAdapter emoticonAdapter, String layout_type) {
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as horizontal
        Collections.sort(emoticonAdapter.getAllEmoticons(), new SortByPopularity());
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        if (layout_type.equals("grid")) {
            GridLayoutManager grid_layout = new GridLayoutManager(this, 2);
            SavedListRV.setLayoutManager(grid_layout);
        } else {
            LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            SavedListRV.setLayoutManager(layout);
        }

        SavedListRV.setAdapter(emoticonAdapter);
    }

    protected void getDataSortedDate(EmoticonAdapter emoticonAdapter, String layout_type) {
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as horizontal
        Collections.sort(emoticonAdapter.getAllEmoticons(), new SortByDate());
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        if (layout_type.equals("grid")) {
            GridLayoutManager grid_layout = new GridLayoutManager(this, 2);
            SavedListRV.setLayoutManager(grid_layout);
        } else {
            LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            SavedListRV.setLayoutManager(layout);
        }
        SavedListRV.setAdapter(emoticonAdapter);
    }

    protected void getDataSortedPrice(EmoticonAdapter emoticonAdapter, String layout_type) {
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as horizontal
        Collections.sort(emoticonAdapter.getAllEmoticons(), new SortByPrice());
        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        if (layout_type.equals("grid")) {
            GridLayoutManager grid_layout = new GridLayoutManager(this, 2);
            SavedListRV.setLayoutManager(grid_layout);
        } else {
            LinearLayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            SavedListRV.setLayoutManager(layout);
        }
        SavedListRV.setAdapter(emoticonAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

}
