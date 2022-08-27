package com.example.ticon.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.adapters.EmoticonAdapter;
import com.example.ticon.comparators.SortByDate;
import com.example.ticon.comparators.SortByPopularity;
import com.example.ticon.comparators.SortByPrice;
import com.example.ticon.data.DataProvider;

import java.util.Collections;

public class ListActivity extends AppCompatActivity {

    /**
     * Displays a list of items in each category, in respect to the selected category.
     * Items are displayed in a card view depending on the indentified list display type.
     * The list is sortable in views, new, price.
     */

    private RecyclerView SavedListRV;
    Button button;
    ViewHolder vh;


    private class ViewHolder{
        final TextView views;
        final TextView by_new;
        final TextView price;
        public ViewHolder() {
            views = findViewById(R.id.text_sort_popularity);
            by_new = findViewById(R.id.text_sort_new);
            price = findViewById(R.id.text_sort_price);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_list);
        SavedListRV = findViewById(R.id.listRView);

        vh = new ViewHolder();

        // Initiate toolbar
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        // Enable back button on toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        String listType = intent.getStringExtra("listType");

        String categoryTitle = "# " + category.toUpperCase();
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

        // Onclick for Sort by: VIEWS
        vh.views.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vh.views.setTypeface(null, Typeface.BOLD_ITALIC);
                vh.by_new.setTypeface(null, Typeface.NORMAL);
                vh.price.setTypeface(null, Typeface.NORMAL);

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
                vh.views.setTypeface(null, Typeface.NORMAL);
                vh.by_new.setTypeface(null, Typeface.BOLD_ITALIC);
                vh.price.setTypeface(null, Typeface.NORMAL);
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
                vh.views.setTypeface(null, Typeface.NORMAL);
                vh.by_new.setTypeface(null, Typeface.NORMAL);
                vh.price.setTypeface(null, Typeface.BOLD_ITALIC);
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
        // Inflate the menu - add items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main_menu, menu);

        // Replace the search icon action to home icon
        menu.findItem(R.id.action_search).setIcon(R.drawable.home_icon);
        menu.findItem(R.id.action_search).setActionView(button);
        return true;
    }


    public void onHomePressed() {
        // Navigate to home
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


    public void onWishlistPressed() {
        // Navigate to wishlist
        Intent intent = new Intent(this, WishlistActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            onHomePressed();
            return true;
        } else if (item.getItemId() == R.id.favorite) {
            onWishlistPressed();
            return true;
        } else {
            finish();
            return true;
        }
    }

}
