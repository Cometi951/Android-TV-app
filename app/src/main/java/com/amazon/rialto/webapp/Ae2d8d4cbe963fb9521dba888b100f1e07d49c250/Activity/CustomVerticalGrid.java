package com.amazon.rialto.webapp.Ae2d8d4cbe963fb9521dba888b100f1e07d49c250.Activity;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;

import androidx.annotation.Nullable;
import androidx.leanback.widget.BaseCardView;
import androidx.leanback.widget.HorizontalGridView;
import androidx.leanback.widget.VerticalGridView;

public class CustomVerticalGrid extends VerticalGridView {


    public CustomVerticalGrid(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public CustomVerticalGrid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public CustomVerticalGrid(Context context) {
        super(context);
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        velocityY *= 0.6;
        return super.fling(velocityX, velocityY);
    }
}
