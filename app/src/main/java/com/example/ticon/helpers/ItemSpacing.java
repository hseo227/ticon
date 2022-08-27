package com.example.ticon.helpers;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class ItemSpacing extends RecyclerView.ItemDecoration {
    private final int verticalSpaceHeight;

    public ItemSpacing(int verticalSpacingHeight) {
        this.verticalSpaceHeight = verticalSpacingHeight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;
    }
}
