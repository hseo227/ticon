package com.example.ticon.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.activities.DetailsActivity;
import com.example.ticon.models.Emoticon;

import java.util.List;

public class EmoticonAdapter extends RecyclerView.Adapter<EmoticonAdapter.Viewholder> {

    /**
     * This adapter acts a bridge between the view and underlying data of the activity classes -
     * MainActivity, ListActivity, SearchActivity, WishlistActivity, MyEmoticonsActivity.
     */

    private final Context context;
    private final List<Emoticon> listModelArrayList;
    private final String listType;
    String id = "";


    public EmoticonAdapter(Context context, List<Emoticon> listModelArrayList, String listType) {
        this.context = context;
        this.listModelArrayList = listModelArrayList;
        this.listType = listType;
    }


    @NonNull
    @Override
    public EmoticonAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        // Initiate the appropriate card view needed for each list type
        if (listType.equals("home")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card,parent,false);
        } else if (listType.equals("three")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card,parent,false);
        } else if (listType.equals("sidebar_list")){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_card,parent,false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_card,parent,false);
        }
        return new Viewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull EmoticonAdapter.Viewholder holder, int position) {
        Emoticon emoticon = listModelArrayList.get(position);

        // Initiate the required data for each list type
        if (listType.equals("home")) {
            holder.emoName.setText(emoticon.getName());
            holder.imageButton.setImageResource(getCardImages(0, emoticon, holder));
        } else if (listType.equals("three")) {
            holder.emoName.setText(emoticon.getName());
            holder.emoImg1.setImageResource(getCardImages(0, emoticon, holder));
            holder.emoImg2.setImageResource(getCardImages(1, emoticon, holder));
            holder.emoImg3.setImageResource(getCardImages(2, emoticon, holder));
        } else if (listType.equals("sidebar_list")){
            holder.emoName.setText(emoticon.getName());
            holder.artist.setText(emoticon.getArtist());
            holder.emoImg1.setImageResource(getCardImages(0, emoticon, holder));
        } else {
            holder.emoName.setText(emoticon.getName());
            holder.emoImg1.setImageResource(getCardImages(0, emoticon, holder));
            holder.emoImg2.setImageResource(getCardImages(1, emoticon, holder));
            holder.emoImg3.setImageResource(getCardImages(2, emoticon, holder));
            holder.emoImg4.setImageResource(getCardImages(3, emoticon, holder));
        }

        // Make item in the list view clickable to navigate to DetailsActivity.
        // Item in wishlist and myEmoticons activity is not available for details.
        if (!listType.equals("sidebar_list")) {
            holder.itemView.setOnClickListener(view -> {

                Intent i = new Intent(view.getContext(), DetailsActivity.class);
                String id = emoticon.getId();
                i.putExtra("clickedEmoticonId", listModelArrayList.get(holder.getAdapterPosition()).getId());
                i.putExtra("clickedEmoticon", listModelArrayList.get(holder.getAdapterPosition()));

                view.getContext().startActivity(i);
            });
        }

        // Applying animations for Recylerview
        Animation animation = AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.recycler_view_animation);
        holder.itemView.startAnimation(animation);
    }


    public int getCardImages(int index, Emoticon emoticon, EmoticonAdapter.Viewholder holder) {
        int resId = context.getResources().getIdentifier(emoticon.getImages().get(index), "drawable", context.getPackageName());
        return resId;
    }


    @Override
    public int getItemCount() {
        return listModelArrayList.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder {
        private final ImageView emoImg1;
        private final ImageView emoImg2;
        private final ImageView emoImg3;
        private final ImageView emoImg4;
        private final ImageView imageButton;
        private final TextView emoName;
        private final TextView artist;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.image_button);
            emoImg1 = itemView.findViewById(R.id.imageView1);
            emoImg2 = itemView.findViewById(R.id.imageView2);
            emoImg3 = itemView.findViewById(R.id.imageView3);
            emoImg4 = itemView.findViewById(R.id.imageView4);
            emoName = itemView.findViewById(R.id.TextView);
            artist = itemView.findViewById(R.id.author);
        }
    }


    public List<Emoticon> getAllEmoticons() {
        return listModelArrayList;
    }

}
