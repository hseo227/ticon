//package com.example.ticon.activities;
//
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