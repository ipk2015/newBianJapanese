package com.ipk.newbianjapanese.recyclerView_words;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ipk.newbianjapanese.R;

public class WordsItemDecoration extends RecyclerView.ItemDecoration {

    private int mDividerHeight;
    private int mBottomHeight;
    private Paint mPaint;
    public WordsItemDecoration(Context context) {
        mDividerHeight = (int) context.getResources().getDimension(R.dimen.divider_height_words_item);
        mBottomHeight = (int) context.getResources().getDimension(R.dimen.bottom_height_words_item);
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        outRect.top = mDividerHeight;

        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter.getItemCount();
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if(childAdapterPosition == 0){
            outRect.top = mBottomHeight;
        }
        if(childAdapterPosition == itemCount-1){
            outRect.bottom = mBottomHeight;
        }

    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        int itemCount = adapter.getItemCount();

        int childCount = parent.getChildCount();
        int left,right,bottom,top,childAdapterPosition;
        View view;
        for(int i = 0;i < childCount;i++){
            view = parent.getChildAt(i);
            left = parent.getPaddingLeft();
            right = parent.getWidth() - parent.getPaddingRight();
            bottom = view.getTop();
            top = (int) (bottom - mDividerHeight);
            c.drawRect(left, top, right, bottom, mPaint);

            childAdapterPosition = parent.getChildAdapterPosition(view);
            if(childAdapterPosition == 0){
                top = (int) (bottom - mBottomHeight);
                c.drawRect(left, top, right, bottom, mPaint);
            }
            if (childAdapterPosition == itemCount-1){
                top = view.getBottom();
                bottom = top + mBottomHeight;
                c.drawRect(left, top, right, bottom, mPaint);
            }


        }


    }
}
