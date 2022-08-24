package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ticon.R;
import com.example.ticon.models.Emoticon;

public class PreviewActivity extends DetailsActivity {

//    public void changeChatEmo1 (View view){
//        ImageView previewEmoticon = (ImageView) findViewById(R.id.displayEmoticon);
//        previewEmoticon.setImageResource(R.drawable.bad_ducks3);
//    }

    Emoticon emoticon;

    ImageView sentImage;
    ImageView emoKeyImage1;
    ImageView emoKeyImage2;
    ImageView emoKeyImage3;
    ImageView emoKeyImage4;
    ImageView emoKeyImage5;
    ImageView emoKeyImage6;

    ImageButton sendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();
        emoticon = (Emoticon) intent.getSerializableExtra("clickedEmoticon");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create objects from layout

        sentImage = findViewById(R.id.displayEmoticon);
        emoKeyImage1 = findViewById(R.id.emoSendImage1);
        emoKeyImage2 = findViewById(R.id.emoSendImage2);
        emoKeyImage3 = findViewById(R.id.emoSendImage3);
        emoKeyImage4 = findViewById(R.id.emoSendImage4);
        emoKeyImage5 = findViewById(R.id.emoSendImage5);
        emoKeyImage6 = findViewById(R.id.emoSendImage6);

        sendButton = findViewById(R.id.sendButton);

        // Set ImageView objects to images from emoticon

        emoKeyImage1.setImageResource(getEmoticonId(0));
        emoKeyImage2.setImageResource(getEmoticonId(1));
        emoKeyImage3.setImageResource(getEmoticonId(2));
        emoKeyImage4.setImageResource(getEmoticonId(3));
        emoKeyImage5.setImageResource(getEmoticonId(4));
        emoKeyImage6.setImageResource(getEmoticonId(5));
    }

}