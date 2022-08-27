package com.example.ticon.activities;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.adapters.EmoticonAdapter;
import com.example.ticon.comparators.SortByDate;
import com.example.ticon.comparators.SortByPopularity;
import com.example.ticon.data.DataProvider;
import com.example.ticon.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * Displays the CATEGORIES, POPULAR, and NEW sections.
     * The top-bar implementations are also here, including the side-bar drawer.
     */


    private class ViewHolder{
        final ImageButton  wishlistBtn;
        final Button changeToSearchFunny;
        final Button changeToSearchCharacter;
        final Button changeToSearchAnimals;
        final SearchView searchView;

        public ViewHolder() {
            wishlistBtn = findViewById(R.id.favorite);
            changeToSearchFunny = findViewById(R.id.button1);
            changeToSearchCharacter = findViewById(R.id.button2);
            changeToSearchAnimals = findViewById(R.id.button3);
            searchView = findViewById(R.id.action_search);
        }
    }


    ViewHolder vh;

    String category = "";
    String listType = "home";

    RecyclerView popularRV;
    RecyclerView newRV;

    private AppBarConfiguration mAppBarConfiguration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.ticon.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vh = new ViewHolder();

        popularRV = findViewById(R.id.popular_recycler_view);
        DataProvider.getAllData(emoticons -> {
            // we are initializing our adapter class and passing our arraylist to it.
            EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, listType);
            getDataSortedPopular(emoticonAdapter, popularRV);
        });

        newRV = findViewById(R.id.new_recycler_view);
        DataProvider.getAllData(emoticons -> {
            // we are initializing our adapter class and passing our arraylist to it.
            EmoticonAdapter emoticonAdapter = new EmoticonAdapter(this, emoticons, listType);
            getDataSortedDate(emoticonAdapter, newRV);
        });

        vh.changeToSearchFunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "funny";
                listType = "three";
                Intent funnyIntent = new Intent(getBaseContext(), ListActivity.class);
                funnyIntent.putExtra("category", category);
                funnyIntent.putExtra("listType", listType);
                startActivity(funnyIntent);
            }
        });

        vh.changeToSearchCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "character";
                listType = "four";
                Intent characterIntent = new Intent(getBaseContext(), ListActivity.class);
                characterIntent.putExtra("category", category);
                characterIntent.putExtra("listType", listType);
                startActivity(characterIntent);
            }
        });

        vh.changeToSearchAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "animals";
                listType = "three";
                Intent animalsIntent = new Intent(getBaseContext(), ListActivity.class);
                animalsIntent.putExtra("category", category);
                animalsIntent.putExtra("listType", listType);
                startActivity(animalsIntent);
            }
        });

        // Side bar drawer set up
        setSupportActionBar(binding.appBarMain.toolbar);
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        NavigationView testNavigationView = findViewById(R.id.nav_view);
        testNavigationView.setNavigationItemSelectedListener(this);
    }


    // Assigning where the side bar drawer features will be navigated to.
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                listType = "home";
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_gallery:
                listType = "sidebar_list";
                Intent wishlistIntent = new Intent(getApplicationContext(), WishlistActivity.class);
                startActivity(wishlistIntent);
                break;

            case R.id.nav_slideshow:
                listType = "sidebar_list";
                Intent myEmoticonIntent = new Intent(getApplicationContext(), MyEmoticonsActivity.class);
                startActivity(myEmoticonIntent);
                break;
        }
        return true;
    }


    // Recylerview set up for POPULAR section
    protected void getDataSortedPopular(EmoticonAdapter emoticonAdapter, RecyclerView rv) {

        // Setting the layout manager for our recycler view.
        Collections.sort(emoticonAdapter.getAllEmoticons(), new SortByPopularity());
        LinearLayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        // Setting of layoutmanager and adapter to the recycler view.
        rv.setLayoutManager(layout);
        rv.setAdapter(emoticonAdapter);
    }


    // Recylerview set up for NEW section
    protected void getDataSortedDate(EmoticonAdapter emoticonAdapter, RecyclerView rv) {

        Collections.sort(emoticonAdapter.getAllEmoticons(), new SortByDate());
        LinearLayoutManager layout = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);

        rv.setLayoutManager(layout);
        rv.setAdapter(emoticonAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        SearchView search = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        // Associate searchable configuration with the SearchView
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        search.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this,
                SearchActivity.class)));
        search.setQueryHint(getResources().getString(R.string.search_hint));

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent newIntent = new Intent(getBaseContext(), SearchActivity.class);
                newIntent.putExtra("query", query);
                startActivity(newIntent);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });

        return true;
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this,
                R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    public void onWishlistPressed() {
        Intent intent = new Intent(this, WishlistActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            return true;
        } else if (item.getItemId() == R.id.favorite) {
            onWishlistPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

}