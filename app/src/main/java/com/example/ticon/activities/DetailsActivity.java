package com.example.ticon.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ticon.R;

import com.example.ticon.data.DataProvider;
import com.example.ticon.models.Emoticon;

import java.util.List;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener{

//    ViewPager viewPager;
//    ViewPagerAdapter viewPagerAdapter;
    Context context;

    int boolCount = 0;
    String id;
    String category;
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
    Button buyButton;

    Boolean wishListBool;
    Boolean myEmoBool;


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
        id = intent.getStringExtra("clickedEmoticonId");
        category = intent.getStringExtra("clickedEmoticonCategory");
        emoticon = (Emoticon) intent.getSerializableExtra("clickedEmoticon");


        DataProvider.getWishlistData(emoticons -> {
            // we are initializing our adapter class and passing our arraylist to it.
            for (Emoticon emoticon : emoticons) {
                if (emoticon.getId().equals(id)) {
                    setWishListImage(true);
                }
            }
        });


        // Get Boolean values for wish list and My Emoticon
        wishListBool = emoticon.isWishlist();
        myEmoBool = emoticon.isMyEmoticons();

        System.out.println("The initial wish Boolean is" + wishListBool);

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
        buyButton = findViewById((R.id.buyButton));

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

//        setWishListImage(wishListBool);

        // Set on click function to navigate to preview screen
        previewButton.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), PreviewActivity.class);
            i.putExtra("clickedEmoticon", emoticon);

            view.getContext().startActivity(i);

        });

        wishListButton.setOnClickListener(this);
        buyButton.setOnClickListener(this::onClickBuy);

//        DataProvider.getAllData(emoticons -> {
//            ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, emoticons);
//            getData(viewPagerAdapter);
//        });

        emoticon.incrementViews();

    }

    public int getEmoticonId(int index) {
        String PACKAGE_NAME = getApplicationContext().getPackageName();
        int resId = getResources().getIdentifier(PACKAGE_NAME+":drawable/"+ emoticon.getImages().get(index), null, null);

        return resId;
    }

    public void setWishListImage(boolean wishBool) {
        System.out.println(wishBool);
        if (wishBool){
            wishListButton.setImageResource(R.drawable.ic_favorite_pink);
        } else {
            wishListButton.setImageResource(R.drawable.ic_favorite_empty);
        }
    }

    @Override
    public void onClick(View view) {
        if (wishListBool){
            wishListBool = false;

        } else {
            wishListBool = true;
        }
        setWishListImage(wishListBool);
        emoticon.updateWishList(wishListBool);
    }

    public void onClickBuy(View view) {
        context = getApplicationContext();
        if (myEmoBool){
            Toast.makeText(context, "This item is already purchased", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "This item id added to My Emoticons", Toast.LENGTH_SHORT).show();
            myEmoBool = true;
            emoticon.updateMyEmoticons(myEmoBool);
        }
    }

//    protected void getData(EmoticonAdapter emoticonAdapter) {
//        // below line is for setting a layout manager for our recycler view.
//        // here we are creating vertical list so we will provide orientation as vertical
//        LinearLayoutManager layout = new LinearLayoutManager(this);
//        // in below two lines we are setting layoutmanager and adapter to our recycler view.
//        detailsLayout.setAdapter(emoticonAdapter);
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu) {

//        System.out.print(getClass().getSuperclass().toString());

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//        finish();
//        return true;
//        super.onRestart();
        finish();
//        startActivity(
        return true;

    }

}