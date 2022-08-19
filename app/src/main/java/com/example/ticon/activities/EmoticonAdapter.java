package com.example.ticon.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EmoticonAdapter extends RecyclerView.Adapter<EmoticonAdapter.Viewholder> {
    private Context context;
    private ArrayList<ListModel> listModelArrayList;

//    Constructor
    public EmoticonAdapter(Context context, ArrayList<ListModel> listModelArrayList) {
        this.context = context;
        this.listModelArrayList = listModelArrayList;
    }

    @NonNull
    @Override
    public EmoticonAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmoticonAdapter.Viewholder holder, int position) {
        ListModel model = listModelArrayList.get(position);
        holder.emoImg1.setImageResource(model.getEmoticonimg1());
        holder.emoImg2.setImageResource(model.getEmoticonimg2());
        holder.emoImg3.setImageResource(model.getEmoticonimg3());
        holder.emoName.setText(model.getEmoticonName());

        holder.itemView.setOnClickListener(view -> {
            //                    itemView.getContext().startActivity(new Intent(itemView.getContext(), ListActivity.class));
            Toast.makeText(context, "You clicked", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(context, DetailsActivity.class);
//                intent.putExtra("title", listModelArrayList.get(position).getEmoticonName());
//                context.startActivity(intent);

            //                    view.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listModelArrayList.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView emoImg1, emoImg2, emoImg3;
        private TextView emoName;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            emoImg1 = itemView.findViewById(R.id.imageView1);
            emoImg2 = itemView.findViewById(R.id.imageView2);
            emoImg3 = itemView.findViewById(R.id.imageView3);
            emoName = itemView.findViewById(R.id.TextView);

        }
    }

}
