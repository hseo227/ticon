package com.example.ticon.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.ticon.R;
import com.example.ticon.adapters.ViewPagerAdapter;
import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

    /**
     * This activity provides the details window UI of this application.
     * It uses the activity_details.xml to set the layout of the screen.
     * It shows the details of the selected emoticon.
     */

    Context context;

    String id;
    Emoticon emoticon;

    TextView emoticonTitle;
    TextView emoticonArtist;
    TextView emoticonPrice;
    TextView emoticonDescription;
    ImageView emoImage1;
    ImageView emoImage2;
    ImageView emoImage3;
    ImageView emoImage4;
    ImageView emoImage5;
    ImageView emoImage6;

    Button previewButton;
    ImageButton wishListButton;
    Button buyButton;

    Boolean wishListBool;
    Boolean myEmoBool;

    androidx.viewpager.widget.ViewPager viewPager;
    com.example.ticon.adapters.ViewPagerAdapter viewPagerAdapter;


    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Toolbar myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        id = intent.getStringExtra("clickedEmoticonId");
        emoticon = (Emoticon) intent.getSerializableExtra("clickedEmoticon");

        DataProvider.getWishlistData(emoticons -> {
            // We are calling Data Provider to initialise the wish list button display.
            for (Emoticon emoticon : emoticons) {
                if (emoticon.getId().equals(id)) {
                    setWishListImage(true);
                }
            }
        });

        // Get Boolean values for wish list and My Emoticon
        wishListBool = emoticon.isWishlist();
        myEmoBool = emoticon.isMy_emoticons();

        // Create objects from layout
        emoticonTitle = findViewById(R.id.emoticonTitle);
        emoticonArtist = findViewById(R.id.emoticonArtist);
        emoticonPrice = findViewById(R.id.emoticonPrice);
        emoticonDescription = findViewById(R.id.emoticonLabel);

        emoImage1 = findViewById(R.id.emoImage1);
        emoImage2 = findViewById(R.id.emoImage2);
        emoImage3 = findViewById(R.id.emoImage3);
        emoImage4 = findViewById(R.id.emoImage4);
        emoImage5 = findViewById(R.id.emoImage5);
        emoImage6 = findViewById(R.id.emoImage6);

        previewButton = findViewById(R.id.previewButton);
        wishListButton = findViewById((R.id.wishListButton));
        buyButton = findViewById((R.id.buyButton));

        // Set TextView objects to data from emoticon
        emoticonTitle.setText(emoticon.getName());
        emoticonArtist.setText(emoticon.getArtist());
        emoticonPrice.setText(String.valueOf(emoticon.getPrice()));
        emoticonDescription.setText(emoticon.getDescription());

        // Set ImageView objects to images from emoticon
        emoImage1.setImageResource(getEmoticonId(0));
        emoImage2.setImageResource(getEmoticonId(1));
        emoImage3.setImageResource(getEmoticonId(2));
        emoImage4.setImageResource(getEmoticonId(3));
        emoImage5.setImageResource(getEmoticonId(4));
        emoImage6.setImageResource(getEmoticonId(5));

        // Convert imageView into drawable into int
        emoImage1.setImageDrawable(getDrawable(getEmoticonId(0)));
        emoImage1.setTag(getEmoticonId(0));
        int drawableID1 = Integer.parseInt(emoImage1.getTag().toString());
        emoImage2.setImageDrawable(getDrawable(getEmoticonId(1)));
        emoImage2.setTag(getEmoticonId(1));
        int drawableID2 = Integer.parseInt(emoImage2.getTag().toString());
        emoImage3.setImageDrawable(getDrawable(getEmoticonId(2)));
        emoImage3.setTag(getEmoticonId(2));
        int drawableID3 = Integer.parseInt(emoImage3.getTag().toString());

        // Initialize image items in viewpager
        int[] images = {drawableID1, drawableID2, drawableID3};
        // Initialize ViewPager Object
        viewPager = findViewById(R.id.viewPagerMain);
        // Initialize ViewPagerAdapter
        viewPagerAdapter = new ViewPagerAdapter(DetailsActivity.this, images);
        // Set Adapter to ViewPager
        viewPager.setAdapter(viewPagerAdapter);

        // Right button is clicked for next image on the right
        ImageButton right = (ImageButton)findViewById(R.id.right);
        right.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                viewPager.arrowScroll(View.FOCUS_RIGHT);
            }
        });

        // Left button is clicked for next image on the left
        ImageButton left = (ImageButton)findViewById(R.id.left);
        left.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewPager.arrowScroll(View.FOCUS_LEFT);
            }
        });

        // Set on click function to navigate to preview screen
        previewButton.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), PreviewActivity.class);
            i.putExtra("clickedEmoticon", emoticon);

            view.getContext().startActivity(i);
        });

        // Set on click functions to the buttons
        wishListButton.setOnClickListener(this);
        buyButton.setOnClickListener(this::onClickBuy);
        emoticon.incrementViews();
    }


    // This function gets the id of emoticon image from drawable
    public int getEmoticonId(int index) {
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int resId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+
                emoticon.getImages().get(index), null, null);

        return resId;
    }


    //This function sets the image of wish list button
    public void setWishListImage(boolean wishBool) {
        if (wishBool){
            wishListButton.setImageResource(R.drawable.ic_favorite_pink);
        } else {
            wishListButton.setImageResource(R.drawable.ic_favorite_empty);
        }
    }


    // This is the on click function for wish list button.
    // This adds and takes out emoticon from wish list and changes the image of the button.
    @Override
    public void onClick(View view) {
        wishListBool = !wishListBool;
        setWishListImage(wishListBool);
        emoticon.updateWishList(wishListBool);
    }


    // This is the on click function for buy button.
    // As actual purchase is not implemented in the app, this button adds emoticon to the
    // My Emoticons list and displays a message to indicate the user.
    private void onClickBuy(View view) {
        context = getApplicationContext();
        if (myEmoBool){
            Toast.makeText(context, "This emoticon is already in My Emoticons", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added to My Emoticons", Toast.LENGTH_SHORT).show();
            myEmoBool = true;
            emoticon.updateMyEmoticons(myEmoBool);
        }
    }


    // This is the function for back button to go back to previous screen.
    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {

        super.onRestart();
        finish();
        return true;
    }

}