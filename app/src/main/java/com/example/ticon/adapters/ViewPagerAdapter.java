package com.example.ticon.adapters;

//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.view.menu.MenuView;
//import androidx.viewpager.widget.PagerAdapter;
//
//import com.example.ticon.R;
//import com.example.ticon.models.Emoticon;
//
//import java.util.List;
//import java.util.Objects;
//
//
//public class ViewPagerAdapter extends PagerAdapter {
//    Context context;
//    int[] images;
//    LayoutInflater mLayOutInflator;
//
//    public ViewPagerAdapter(Context context, int[] images) {
//        this.context = context;
//        this.images = images;
//        LayoutInflater inflater = LayoutInflater.from(context);
//    }
//
//    @Override
//    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
//
//        View itemView = mLayOutInflator.inflate(R.layout.details_slider_image, collection, false);
//        ImageView imageView = (ImageView) itemView.findViewById(R.id.pagerImage);
//
//        imageView.setImageResource(images[position]);
//
//        Objects.requireNonNull(collection).addView(itemView);
//
//        return itemView;
//    }
//
//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
//        container.removeView((View) view);
//    }
//
//    @Override
//    public int getCount() {
//        return this.images.size();
//    }
//
//    @Override
//    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
//        return view == object;
//    }
//}

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.Objects;
import com.example.ticon.R;

public class ViewPagerAdapter extends PagerAdapter {

    /**
     * Summarise adapter functionality
     */

    // Context object
    final Context context;

    // Array of images
    final int[] images;

    // Layout Inflater
    final LayoutInflater mLayoutInflater;


    // Viewpager Constructor
    public ViewPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // return the number of images
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // inflating the item.xml
        View itemView = mLayoutInflater.inflate(R.layout.view_pager_item, container, false);

        // referencing the image view from the item.xml file
        ImageView imageView = itemView.findViewById(R.id.imageViewMain);

        // setting the image in the imageView
        imageView.setImageResource(images[position]);

        // Adding the View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);
    }
}