package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ticon.R;

public class PreviewActivity extends AppCompatActivity {

//    public void changeChatEmo1 (View view){
//        ImageView previewEmoticon = (ImageView) findViewById(R.id.displayEmoticon);
//        previewEmoticon.setImageResource(R.drawable.bad_ducks3);
//    }

    ImageView sentImage;
    ImageView emoKeyImage1;
    ImageView emoKeyImage2;
    ImageView emoKeyImage3;
    ImageView emoKeyImage4;
    ImageView emoKeyImage5;
    ImageView emoKeyImage6;

    Button sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}