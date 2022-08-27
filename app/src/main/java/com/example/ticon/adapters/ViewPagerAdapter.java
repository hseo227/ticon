package com.example.ticon.adapters;
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
     * Initializes the imageview items for the viewPager. Used in DetailsActivity to enable
     * navigation through multiple images of the item.
     */

    final Context context;
    final int[] images;
    final LayoutInflater layoutInflater;


    public ViewPagerAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return images.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        // Inflate imageview items for viewpager
        View itemView = layoutInflater.inflate(R.layout.view_pager_item, container, false);

        // Initialize image view
        ImageView imageView = itemView.findViewById(R.id.viewPagerImage);

        // Set the image in the imageView
        imageView.setImageResource(images[position]);

        // Add View
        Objects.requireNonNull(container).addView(itemView);

        return itemView;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}