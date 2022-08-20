package com.example.ticon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ticon.R;
import com.example.ticon.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.example.ticon.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Button changeToSearchFunny = findViewById(R.id.button1);
        changeToSearchFunny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityFunny();
            }
        });

        Button changeToSearchAnimals = findViewById(R.id.button3);
        changeToSearchAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityAnimals();
            }
        });

        Button changeToSearchCute = findViewById(R.id.button2);
        changeToSearchCute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityCute();
            }
        });

        ImageButton changeToDetails = findViewById(R.id.detailsButton);
        changeToDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivityDetails();
            }
        });

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

    private void changeActivityFunny() {
        Intent intent = new Intent(this, FunnyCategory.class);
        startActivity(intent);
    }
    private void changeActivityAnimals() {
        Intent intent = new Intent(this, AnimalsCategory.class);
        startActivity(intent);
    }
    private void changeActivityCute() {
        Intent intent = new Intent(this, CuteCategory.class);
        startActivity(intent);
    }

    private void changeActivityDetails() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

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