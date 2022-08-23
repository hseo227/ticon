package com.example.ticon.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.shapes.Shape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.models.Emoticon;

import java.util.List;

public class ViewPagerAdapter extends ArrayAdapter<Emoticon> {
    private Context context;
    private List<Emoticon> DetailsModelArrayList;
    String id = "";

    public ViewPagerAdapter(Context context, int resource, List<Emoticon> DetailsModelArrayList) {
        super(context, resource, DetailsModelArrayList);
        this.context = context;
        this.DetailsModelArrayList = DetailsModelArrayList;
    }

    @Override
    public View getView(int position,  View itemView, ViewGroup parent) {
        ImageView itemImage, emoImg1, emoImg2, emoImg3, emoImg4, emoImg5, emoImg6;
        TextView emoName, artistName, price;
        Emoticon emoticon = DetailsModelArrayList.get(position);

        itemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_details, parent, false);

        itemImage = itemView.findViewById(R.id.itemImage);
        int resId1 = context.getResources().getIdentifier(emoticon.getImages().get(0), "drawable", context.getPackageName());
        itemImage.setImageResource(resId1);

        emoName = itemView.findViewById(R.id.emoticonName);
        int resId2 = context.getResources().getIdentifier(emoticon.getImages().get(0), "drawable", context.getPackageName());
        itemImage.setImageResource(resId2);

//        emoImg1 = itemView.findViewById(R.id.imageView1);
//        emoImg2 = itemView.findViewById(R.id.imageView2);
//        emoImg3 = itemView.findViewById(R.id.imageView3);
////        emoImg4 = itemView.findViewById(R.id.imageView4);
////        emoImg5 = itemView.findViewById(R.id.imageView5);
////        emoImg6 = itemView.findViewById(R.id.imageView6);
//        emoName = itemView.findViewById(R.id.emoticonName);
//        artistName = itemView.findViewById(R.id.artistName);
//        price = itemView.findViewById(R.id.priceTag);

        return super.getView(position, itemView, parent);
    }

}
