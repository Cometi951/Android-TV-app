package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Utility;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int space;


    private int mLowestPosition = -1;


    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        boolean isLast = position == state.getItemCount() - 1;

        if (position > mLowestPosition) {
            if (isLast) {
                outRect.right = space;
                outRect.left = 0;
            }
            if (position == 0) {
                outRect.left = space;
                if (!isLast)
                    outRect.right = 0;
            }
            //mLowestPosition = position;
        }
    }
}