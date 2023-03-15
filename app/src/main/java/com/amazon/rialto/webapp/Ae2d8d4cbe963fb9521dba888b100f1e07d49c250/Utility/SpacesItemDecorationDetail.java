package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecorationDetail extends RecyclerView.ItemDecoration {
    private int space;


    private int mLowestPosition = -1;


    public SpacesItemDecorationDetail(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position > mLowestPosition) {
            if (position == 0) {
                outRect.left = space;
                outRect.right = space;
                outRect.top = space * 2;
                outRect.bottom = space / 2;
            }
            //mLowestPosition = position;
        }
    }
}