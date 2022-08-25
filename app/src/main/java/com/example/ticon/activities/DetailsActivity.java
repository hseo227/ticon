package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticon.R;
import com.example.ticon.data.DataProvider;
import com.example.ticon.databinding.ActivityDetailsBinding;
import com.example.ticon.models.Emoticon;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

//    ViewPager viewPager;
//    ViewPagerAdapter viewPagerAdapter;

    Emoticon emoticon;

    TextView emoticonTitle;
    TextView emoticonArtist;
    TextView emoticonPrice;
    TextView emoticonDescription;
    ImageView emoticonImage;
    ImageView emoImage1;
    ImageView emoImage2;
    ImageView emoImage3;
    ImageView emoImage4;
    ImageView emoImage5;
    ImageView emoImage6;

    Button previewButton;
    ImageButton wishListButton;

    Boolean isWishList;
    Boolean isMyEmoticon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        viewPager = (ViewPager) findViewById(R.id.viewPager);
//        viewPager.setAdapter(new ViewPagerAdapter(this, emoticon.getImages()));

        Intent intent = getIntent();
        emoticon = (Emoticon) intent.getSerializableExtra("clickedEmoticon");

        // Get Boolean values for wish list and My Emoticon
        isWishList = emoticon.isWishlist();
        isMyEmoticon = emoticon.isMyEmoticons();

        // Create objects from layout
        emoticonTitle = findViewById(R.id.emoticonTitle);
        emoticonArtist = findViewById(R.id.emoticonArtist);
        emoticonPrice = findViewById(R.id.emoticonPrice);
        emoticonDescription = findViewById(R.id.emoticonLabel);

        emoticonImage = findViewById(R.id.emoticonImage);
        emoImage1 = findViewById(R.id.emoImage1);
        emoImage2 = findViewById(R.id.emoImage2);
        emoImage3 = findViewById(R.id.emoImage3);
        emoImage4 = findViewById(R.id.emoImage4);
        emoImage5 = findViewById(R.id.emoImage5);
        emoImage6 = findViewById(R.id.emoImage6);

        previewButton = findViewById(R.id.previewButton);
        wishListButton = findViewById((R.id.wishListButton));

        // Set TextView objects to data from emoticon
        emoticonTitle.setText(emoticon.getName());
        emoticonArtist.setText(emoticon.getArtist());
        emoticonPrice.setText(String.valueOf(emoticon.getPrice()));
        emoticonDescription.setText(emoticon.getDescription());

        // Set ImageView objects to images from emoticon

        emoticonImage.setImageResource(getEmoticonId(4));

        emoImage1.setImageResource(getEmoticonId(0));
        emoImage2.setImageResource(getEmoticonId(1));
        emoImage3.setImageResource(getEmoticonId(2));
        emoImage4.setImageResource(getEmoticonId(3));
        emoImage5.setImageResource(getEmoticonId(4));
        emoImage6.setImageResource(getEmoticonId(5));

        // Set Wish List icon based on if the emoticon is in wish list or not

        if (isWishList){
            wishListButton.setImageResource(R.drawable.ic_favorite_pink);
        } else {
            wishListButton.setImageResource(R.drawable.ic_favorite_empty);
        }

        // Set on click function to navigate to preview screen
        previewButton.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), PreviewActivity.class);
            i.putExtra("clickedEmoticon", emoticon);

            view.getContext().startActivity(i);

        });

//        DataProvider.getAllData(emoticons -> {
//            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, emoticons);
//            getData(viewPagerAdapter);
//        });

    }

    public int getEmoticonId(int index) {
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int resId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+ emoticon.getImages().get(index), null, null);

        return resId;
    }

    public void onClickWishList (View view) {


    }

//    protected void getData(EmoticonAdapter emoticonAdapter) {
//        // below line is for setting a layout manager for our recycler view.
//        // here we are creating vertical list so we will provide orientation as vertical
//        LinearLayoutManager layout = new LinearLayoutManager(this);
//        // in below two lines we are setting layoutmanager and adapter to our recycler view.
//        detailsLayout.setAdapter(emoticonAdapter);
//    }

}