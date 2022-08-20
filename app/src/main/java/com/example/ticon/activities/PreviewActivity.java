package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.ticon.R;

public class PreviewActivity extends AppCompatActivity {

    public void changeChatEmo1 (View view){
        ImageView previewEmoticon = (ImageView) findViewById(R.id.displayEmoticon);
        previewEmoticon.setImageResource(R.drawable.bad_ducks3);
    }

    public void changeChatEmo2 (View view){
        ImageView previewEmoticon = (ImageView) findViewById(R.id.displayEmoticon);
        previewEmoticon.setImageResource(R.drawable.bad_ducks6);
    }

    public void changeChatEmo3 (View view){
        ImageView previewEmoticon = (ImageView) findViewById(R.id.displayEmoticon);
        previewEmoticon.setImageResource(R.drawable.bad_ducks11);
    }

    public void changeChatEmo4 (View view){
        ImageView previewEmoticon = (ImageView) findViewById(R.id.displayEmoticon);
        previewEmoticon.setImageResource(R.drawable.bad_ducks12);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}