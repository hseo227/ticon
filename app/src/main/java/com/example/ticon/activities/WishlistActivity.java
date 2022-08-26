package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {

    private RecyclerView SavedListRV;
    private Button button;

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

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        Boolean is_wishlist = bundle.getBoolean("is_wishlist");

        DataProvider.getAllData(emoticons -> {
            List<Emoticon> resultEmoticons = getResults(emoticons);
            EmoticonAdapter emoticonAdapter = new EmoticonAdapter(WishlistActivity.this, resultEmoticons, "three");
            getData(emoticonAdapter);
        });

//        // Onclick for Sort by: VIEWS
//        vh.views.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vh.views.setTypeface(null, Typeface.BOLD_ITALIC);
//                vh.by_new.setTypeface(null, Typeface.NORMAL);
//                vh.price.setTypeface(null, Typeface.NORMAL);
//                DataProvider.getAllData(emoticons -> {
//                    // we are initializing our adapter class and passing our arraylist to it.
//                    EmoticonAdapter emoticonAdapter = new EmoticonAdapter(WishlistActivity.this, emoticons, "four");
//                    getDataSortedPopular(emoticonAdapter, "grid");
//                });
//            }
//        });
//
//        // Onclick for Sort by: NEW
//        vh.by_new.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vh.views.setTypeface(null, Typeface.NORMAL);
//                vh.by_new.setTypeface(null, Typeface.BOLD_ITALIC);
//                vh.price.setTypeface(null, Typeface.NORMAL);
//                DataProvider.getCharacterData(emoticons -> {
//                    // we are initializing our adapter class and passing our arraylist to it.
//                    EmoticonAdapter emoticonAdapter = new EmoticonAdapter(WishlistActivity.this, emoticons, "four");
//                    getDataSortedDate(emoticonAdapter, "grid");
//                });
//            }
//        });
//
//        // Onclick for Sort by: DATA
//        vh.price.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vh.views.setTypeface(null, Typeface.NORMAL);
//                vh.by_new.setTypeface(null, Typeface.NORMAL);
//                vh.price.setTypeface(null, Typeface.BOLD_ITALIC);
//                DataProvider.getCharacterData(emoticons -> {
//                    // we are initializing our adapter class and passing our arraylist to it.
//                    EmoticonAdapter emoticonAdapter = new EmoticonAdapter(WishlistActivity.this, emoticons, "four");
//                    getDataSortedPrice(emoticonAdapter, "grid");
//                });
//            }
//        });
    }

    protected List<Emoticon> getResults(List<Emoticon> emoticons) {
        List<Emoticon> searchResults = new ArrayList<Emoticon>();
        for (Emoticon emoticon : emoticons) {
            Boolean emoticon_is_wishlist = emoticon.isWishlist();
            if (emoticon_is_wishlist) {
                searchResults.add(emoticon);
            }
        }
        return searchResults;
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