package com.example.ticon.activities;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.ticon.R;
import com.example.ticon.models.Emoticon;

public class PreviewActivity extends DetailsActivity implements View.OnClickListener {

    /**
     * This activity provides the Preview window UI of this application.
     * It uses the activity_preview.xml to set the layout of the screen.
     * It allows the users to try emoticons in a preview test chat room.
     */

    Emoticon emoticon;

    ImageView sentImage;
    ImageView previewImage;
    ImageButton emoKeyButton1;
    ImageButton emoKeyButton2;
    ImageButton emoKeyButton3;
    ImageButton emoKeyButton4;
    ImageButton emoKeyButton5;
    ImageButton emoKeyButton6;
    ImageButton sendButton;
    ImageButton exitTransparentButton;

    RelativeLayout chatBubble;
    LinearLayout transparentLayout;

    int imageIndicator = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);

        Toolbar myToolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(myToolbar);

        Intent intent = getIntent();
        emoticon = (Emoticon) intent.getSerializableExtra("clickedEmoticon");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Create objects from layout
        sentImage = findViewById(R.id.displayEmoticon);
        previewImage = findViewById(R.id.transparentEmoticon);
        emoKeyButton1 = findViewById(R.id.emoButton1);
        emoKeyButton2 = findViewById(R.id.emoButton2);
        emoKeyButton3 = findViewById(R.id.emoButton3);
        emoKeyButton4 = findViewById(R.id.emoButton4);
        emoKeyButton5 = findViewById(R.id.emoButton5);
        emoKeyButton6 = findViewById(R.id.emoButton6);

        sendButton = findViewById(R.id.sendButton);
        exitTransparentButton = findViewById(R.id.exitTransparent);

        chatBubble = findViewById(R.id.chatLayout);
        transparentLayout = findViewById(R.id.transparentDisplay);

        // Set ImageView objects to images from emoticon
        emoKeyButton1.setImageResource(getEmoticonId(0));
        emoKeyButton2.setImageResource(getEmoticonId(1));
        emoKeyButton3.setImageResource(getEmoticonId(2));
        emoKeyButton4.setImageResource(getEmoticonId(3));
        emoKeyButton5.setImageResource(getEmoticonId(4));
        emoKeyButton6.setImageResource(getEmoticonId(5));

        // Set Buttons to an on-click function
        emoKeyButton1.setOnClickListener(this);
        emoKeyButton2.setOnClickListener(this);
        emoKeyButton3.setOnClickListener(this);
        emoKeyButton4.setOnClickListener(this);
        emoKeyButton5.setOnClickListener(this);
        emoKeyButton6.setOnClickListener(this);
        exitTransparentButton.setOnClickListener(this::exitTransparent);
        sendButton.setOnClickListener(this::sendEmoticon);
    }


    // This is the function for the emoticon keyboard.
    // It reads which button is pressed, and opens a pop up layout with that selected emoticon.
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.emoButton1:
                imageIndicator = 0;
                break;

            case R.id.emoButton2:
                imageIndicator = 1;
                break;

            case R.id.emoButton3:
                imageIndicator = 2;
                break;

            case R.id.emoButton4:
                imageIndicator = 3;
                break;

            case R.id.emoButton5:
                imageIndicator = 4;
                break;

            case R.id.emoButton6:
                imageIndicator = 5;
                break;
        }
        transparentLayout.setVisibility(View.VISIBLE);
        previewImage.setImageResource(getEmoticonId(imageIndicator));
    }


    // This is the function to close the semi-transparent pop up layout.
    public void exitTransparent(View v){
        transparentLayout.setVisibility(View.INVISIBLE);
    }


    // This function sends the emoticon to the chat bubble when user clicks the send button.
    public void sendEmoticon(View v) {
        if (transparentLayout.getVisibility() == View.VISIBLE) {
            transparentLayout.setVisibility(View.INVISIBLE);
            chatBubble.setVisibility(View.VISIBLE);
            sentImage.setImageResource(getEmoticonId(imageIndicator));
        }
    }

}