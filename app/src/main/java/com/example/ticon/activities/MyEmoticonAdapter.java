package com.example.ticon.activities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyEmoticonAdapter extends RecyclerView.Adapter<MyEmoticonAdapter.Viewholder> {
    private Context context;
    private ArrayList<SavedModel> SavedModelArrayList;

    //    Constructor
    public MyEmoticonAdapter(Context context, ArrayList<SavedModel> SavedModelArrayList) {
        this.context = context;
        this.SavedModelArrayList = SavedModelArrayList;
    }

    @NonNull
    @Override
    public MyEmoticonAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_card,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyEmoticonAdapter.Viewholder holder, int position) {
        SavedModel model = SavedModelArrayList.get(position);
        holder.emoimg.setImageResource(model.getEmoticonimg());
//        holder.himg.setImageResource(model.getHeartimg());
        holder.emoName.setText(model.getEmoticonName());
        holder.aut.setText(model.getAuthor());
    }

    @Override
    public int getItemCount() { return SavedModelArrayList.size(); }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView emoimg, himg;
        private TextView emoName, aut;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            emoimg = itemView.findViewById(R.id.imageView1);
//            himg = itemView.findViewById(R.id.heartButton);
            emoName = itemView.findViewById(R.id.TextView);
            aut = itemView.findViewById(R.id.author);

        }
    }
}
