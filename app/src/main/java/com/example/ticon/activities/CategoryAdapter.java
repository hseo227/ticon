package com.example.ticon.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.activities.ListActivity;
import com.example.ticon.models.Category;

import java.util.List;

//public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
//
//    public static final String CATEGORY_LIST_KEY = "category";
//
//    private List<Category> categories;
//    private Context context;
//
//    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView cName;
//
//        public ViewHolder(View view) {
//            super(view);
//            view.setOnClickListener(this);
//
//            cName = (TextView) view.findViewById(R.id.);
//        }
//
//        @Override
//        public void onClick(View view) {
//            Activity activity = (Activity) context;
//            Intent intent = new Intent(context, ListActivity.class);
//
//            intent.putExtra(CATEGORY_LIST_KEY, categories.get(getAdapterPosition()).getCategoryName());
//
//            activity.startActivity(intent);
////        activity.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_from_left);
//        }
//
//    }
//
//    public CategoryAdapter(List<Category> categories) {
//        this.categories = categories;
//    }
//
////    @NonNull
////    @Override
////    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        //Links and inflates the views in category_item.xml with the data
////        context = parent.getContext();
////        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
////        View categoryView = inflater.inflate(R.layout.category, parent, false);
////        ViewHolder holder = new ViewHolder(categoryView);
////        return holder;
////
////    }
////
////
////    @Override
////    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
////        //Setting the text and image for the current category
////        Category thisCategory = categories.get(position);
////        holder.categoryTextView.setText(thisCategory.getCategoryDisplayName());
////        Log.d(TAG, "onBindViewHolder: thisCategory - " + thisCategory);
////        int imageID = thisCategory.getCategoryImageName();
////        holder.categoryImageView.setImageResource(imageID);
////    }
//
//    @Override
//    public int getItemCount() { return categories.size(); }
//}
//
