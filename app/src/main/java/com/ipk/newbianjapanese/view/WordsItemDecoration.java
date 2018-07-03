package com.ipk.newbianjapanese.view;

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
    private int mBgColor;
    public WordsItemDecoration(Context context) {
        mDividerHeight = (int) context.getResources().getDimension(R.dimen.divider_height_words_item);
        mBottomHeight = (int) context.getResources().getDimension(R.dimen.bottom_height_words_item);
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        mBgColor = context.getResources().getColor(R.color.greyBgColor);
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
            mPaint.setColor(Color.WHITE);
            //默认所有item的顶部都有一条白线
            c.drawRect(left, top, right, bottom, mPaint);

            childAdapterPosition = parent.getChildAdapterPosition(view);
            if(childAdapterPosition == 0){
                //第一个item在白线之上再加宽一部分灰色背景
                bottom = top;
                top = bottom - mBottomHeight + mDividerHeight;
                mPaint.setColor(mBgColor);
                c.drawRect(left, top, right, bottom, mPaint);
            }
            if (childAdapterPosition == itemCount-1){
                //最后一个时，先画一条白线
                top = view.getBottom();
                bottom = top + mDividerHeight;
                mPaint.setColor(Color.WHITE);
                c.drawRect(left, top, right, bottom, mPaint);
                //再在白线下面画一个灰色背景矩形
                top = bottom;
                bottom = top + mBottomHeight - mDividerHeight;
                mPaint.setColor(mBgColor);
                c.drawRect(left, top, right, bottom, mPaint);
            }


        }


    }
}
