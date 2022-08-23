package com.example.ticon.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.models.Emoticon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EmoticonAdapter extends RecyclerView.Adapter<EmoticonAdapter.Viewholder> {
    private Context context;
    private List<Emoticon> listModelArrayList;
    private String listType;

//    Constructor
    public EmoticonAdapter(Context context, List<Emoticon> listModelArrayList, String listType) {
        this.context = context;
        this.listModelArrayList = listModelArrayList;
        this.listType = listType;
    }

    @NonNull
    @Override
    public EmoticonAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (listType.equals("home")) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card,parent,false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card,parent,false);
        }
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmoticonAdapter.Viewholder holder, int position) {
        Emoticon emoticon = listModelArrayList.get(position);

//        int resId1 = context.getResources().getIdentifier(emoticon.getImages().get(0), "drawable", context.getPackageName());
//        holder.emoImg1.setImageResource(resId1);
//        int resId2 = context.getResources().getIdentifier(emoticon.getImages().get(1), "drawable", context.getPackageName());
//        holder.emoImg2.setImageResource(resId2);
//        int resId3 = context.getResources().getIdentifier(emoticon.getImages().get(2), "drawable", context.getPackageName());
//        holder.emoImg3.setImageResource(resId3);

//        holder.emoImg1.setImageResource(getCardImages(0, emoticon, holder));
//        holder.emoImg2.setImageResource(getCardImages(1, emoticon, holder));
//        holder.emoImg3.setImageResource(getCardImages(2, emoticon, holder));

        if (listType.equals("home")) {
            holder.titleText.setText(emoticon.getName());
            holder.imageButton.setImageResource(getCardImages(0, emoticon, holder));
        } else {
            holder.emoName.setText(emoticon.getName());
            holder.emoImg1.setImageResource(getCardImages(0, emoticon, holder));
            holder.emoImg2.setImageResource(getCardImages(1, emoticon, holder));
            holder.emoImg3.setImageResource(getCardImages(2, emoticon, holder));
        }

        holder.itemView.setOnClickListener(view -> {
            //                    itemView.getContext().startActivity(new Intent(itemView.getContext(), ListActivity.class));
            Toast.makeText(context, "You clicked", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(context, DetailsActivity.class);
//                intent.putExtra("title", listModelArrayList.get(position).getEmoticonName());
//                context.startActivity(intent);

            //                    view.getContext().startActivity(intent);
        });
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
        private ImageView emoImg1, emoImg2, emoImg3, imageButton;
        private TextView emoName, titleText;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.image_button);
            titleText = itemView.findViewById(R.id.title_text);
            emoImg1 = itemView.findViewById(R.id.imageView1);
            emoImg2 = itemView.findViewById(R.id.imageView2);
            emoImg3 = itemView.findViewById(R.id.imageView3);
            emoName = itemView.findViewById(R.id.TextView);

        }
    }

    public List<Emoticon> getAllEmoticons() {
        return listModelArrayList;
    }

}
