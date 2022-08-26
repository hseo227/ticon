package com.example.ticon.activities.ui.wishlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.activities.EmoticonAdapter;
import com.example.ticon.activities.MyEmoticonAdapter;
import com.example.ticon.activities.SavedModel;
import com.example.ticon.data.DataProvider;
//import com.example.ticon.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class WishlistFragment extends Fragment {

        //    private FragmentGalleryBinding binding;
        private ArrayList<SavedModel> savedModelArrayList;
        private RecyclerView SavedListRV;

        public View onCreateView(@NonNull LayoutInflater inflater,
                                 ViewGroup container, Bundle savedInstanceState) {

            View view = inflater.inflate(R.layout.activity_search, container, false);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRView);

//        MyEmoticonAdapter myEmoticonAdapter = new MyEmoticonAdapter(getContext(), savedModelArrayList);
//        recyclerView.setAdapter(myEmoticonAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);

            DataProvider.getAllData(emoticons -> {
                // we are initializing our adapter class and passing our arraylist to it.
                EmoticonAdapter emoticonAdapter = new EmoticonAdapter(getContext(), emoticons, "sidebar_list");
                getData(emoticonAdapter);
            });

            return view;
        }

        protected void getData(EmoticonAdapter emoticonAdapter) {
            // below line is for setting a layout manager for our recycler view.
            // here we are creating vertical list so we will provide orientation as vertical
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            // in below two lines we are setting layoutmanager and adapter to our recycler view.
            SavedListRV.setLayoutManager(layout);
            SavedListRV.setAdapter(emoticonAdapter);
        }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}