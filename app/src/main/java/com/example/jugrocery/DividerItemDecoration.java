package com.example.jugrocery;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private final Paint paint = new Paint();
    private final int dividerHeight;

    public DividerItemDecoration(@ColorInt int dividerColor, int dividerHeight, Context context) {
        paint.setColor(dividerColor);
        this.dividerHeight = dividerHeight;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 0; i < parent.getChildCount() - 1; i++) {
            View child = parent.getChildAt(i);
            int top = child.getBottom();
            int bottom = top + dividerHeight;
            c.drawRect(left, top, right, bottom, paint);
        }
    }
}
