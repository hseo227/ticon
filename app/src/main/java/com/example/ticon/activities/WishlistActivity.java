package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.ticon.R;
import com.example.ticon.adapters.EmoticonAdapter;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;
import java.util.List;

public class WishlistActivity extends AppCompatActivity {

    /**
     * Displays the list of WISHLIST in the Wishlist page.
     * It is the list of all the emoticons that have been "hearted".
     */

    private RecyclerView SavedListRV;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishlist_list);
        SavedListRV = findViewById(R.id.listRView);

        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DataProvider.getAllData(emoticons -> {
            List<Emoticon> resultEmoticons = getResults(emoticons);
            EmoticonAdapter emoticonAdapter = new EmoticonAdapter(WishlistActivity.this,
                    resultEmoticons, "sidebar_list");
            getData(emoticonAdapter);
        });
    }


    // This method goes through a list of emoticons and only grabs the ones in Wishlist.
    protected List<Emoticon> getResults(List<Emoticon> emoticons) {
        List<Emoticon> wishlist_results = new ArrayList<Emoticon>();
        for (Emoticon emoticon : emoticons) {
            boolean emoticon_is_wishlist = emoticon.isWishlist();
            if (emoticon_is_wishlist) {
                wishlist_results.add(emoticon);
            }
        }
        return wishlist_results;
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
            onHomePressed();
            return true;
        }
    }

}