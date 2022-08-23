package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private class ViewHolder{
        ImageButton  wishlistBtn;
        Button changeToSearchFunny;
        Button changeToSearchCharacter;
        Button changeToSearchAnimals;
        SearchView searchView;
        public ViewHolder() {
            wishlistBtn = findViewById(R.id.favorite);
            changeToSearchFunny = findViewById(R.id.button1);
            changeToSearchCharacter = findViewById(R.id.button2);
            changeToSearchAnimals = findViewById(R.id.button3);
            searchView = findViewById(R.id.action_search);
        }
    }
    ViewHolder vh;
    DataProvider dp;

    String category = "";
    String listType = "";

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.ticon.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        vh = new ViewHolder();

//        Button changeToSearchFunny = findViewById(R.id.button1);
        vh.changeToSearchFunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "funny";
                listType = "three";
                Intent funnyIntent = new Intent(getBaseContext(), ListActivity.class);
                funnyIntent.putExtra("category", category);
                startActivity(funnyIntent);
            }
        });

//        Button changeToSearchCharacter = findViewById(R.id.button2);
        vh.changeToSearchCharacter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "character";
                listType = "four";
                Intent characterIntent = new Intent(getBaseContext(), ListActivity.class);
                characterIntent.putExtra("category", category);
                startActivity(characterIntent);
            }
        });

//        Button changeToSearchAnimals = findViewById(R.id.button3);
        vh.changeToSearchAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category = "animals";
                listType = "three";
                Intent animalsIntent = new Intent(getBaseContext(), ListActivity.class);
                animalsIntent.putExtra("category", category);
                startActivity(animalsIntent);
            }
        });


//        ImageButton changeToDetails = findViewById(R.id.detailsButton);
//        changeToDetails.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                changeActivityDetails();
//            }
//        });

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }


//    private void changeActivityDetails() {
//        Intent intent = new Intent(this, DetailsActivity.class);
//        startActivity(intent);
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

}