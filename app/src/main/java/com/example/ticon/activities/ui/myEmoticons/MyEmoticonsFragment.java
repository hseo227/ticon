package com.example.ticon.activities.ui.myEmoticons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticon.R;
import com.example.ticon.activities.MyEmoticonAdapter;
import com.example.ticon.activities.SavedModel;

import java.util.ArrayList;

public class MyEmoticonsFragment extends Fragment {

//    private FragmentSlideshowBinding binding;
    private ArrayList<SavedModel> savedModelArrayList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        SlideshowViewModel slideshowViewModel =
//                new ViewModelProvider(this).get(SlideshowViewModel.class);
//
//        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textSlideshow;
//        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        View view = inflater.inflate(R.layout.activity_search, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRView);

        savedModelArrayList = new ArrayList<>();
        savedModelArrayList.add(new SavedModel(R.drawable.crazy_dog1, R.drawable.ic_favorite_pink, "Crazy Dog", "Hoo"));
        savedModelArrayList.add(new SavedModel(R.drawable.princess_moments1, R.drawable.ic_favorite_pink, "Princess Moments", "JK"));
        savedModelArrayList.add(new SavedModel(R.drawable.stockman_monkey1, R.drawable.ic_favorite_pink, "Stockman Monkey", "JK"));

        MyEmoticonAdapter myEmoticonAdapter = new MyEmoticonAdapter(getContext(), savedModelArrayList);
        recyclerView.setAdapter(myEmoticonAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}