package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        DataProvider.getAllData(emoticons -> {
//            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, emoticons);
//            getData(viewPagerAdapter);
        });

    }

//    protected void getData(ViewPagerAdapter viewPagerAdapter) {
//        // below line is for setting a layout manager for our recycler view.
//        // here we are creating vertical list so we will provide orientation as vertical
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//
//        // in below two lines we are setting layoutmanager and adapter to our recycler view.
//        SavedListRV.setLayoutManager(linearLayoutManager);
//        SavedListRV.setAdapter(viewPagerAdapter);
//    }

//    private void changeActivityPreview() {
//        Intent intent = new Intent(this, PreviewActivity.class);
//        startActivity(intent);
//    }
}