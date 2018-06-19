package com.ipk.newbianjapanese.recyclerView_unit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ipk.newbianjapanese.R;
import com.ipk.newbianjapanese.bean.SimpleClassInfo;

public class UnitClassDecoration extends RecyclerView.ItemDecoration {


    private final int mFontColor;
    private Paint.FontMetrics mFontMetrics;
    public interface SimpleClassInfoCallback {
        SimpleClassInfo getSimpleClassInfo(int position);
    }

    private float mHeaderHeight;    //每组标题高度
    private float mDividerHeight;   //组内item间距
    private final float mOffsetTextLeft;//标题距左边缘
    private final float mUnitTextSize;//标题距左边缘

    private SimpleClassInfoCallback mCallback;
    private Paint mPaint;   //单元标题局域绘制
    private Paint mTextPaint;//单元标题文字绘制


    public UnitClassDecoration(Context context, SimpleClassInfoCallback callback) {
        mCallback = callback;
        mHeaderHeight = context.getResources().getDimension(R.dimen.unit_title_height);
        mDividerHeight = context.getResources().getDimension(R.dimen.border_unit_class);
        mOffsetTextLeft = context.getResources().getDimension(R.dimen.unit_title_margin_left);
        mUnitTextSize = context.getResources().getDimension(R.dimen.unit_title_size);
        mFontColor = context.getResources().getColor(R.color.formFontColor);

        mPaint = new Paint();
        mPaint.setColor(Color.YELLOW);
        mTextPaint = new Paint();
        mTextPaint.setColor(mFontColor);
        mTextPaint.setTextSize(mUnitTextSize);
        mFontMetrics = mTextPaint.getFontMetrics();
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        int index = parent.indexOfChild(view);

        if (null != mCallback) {
            SimpleClassInfo simpleClassInfo = mCallback.getSimpleClassInfo(position);
            if (null != simpleClassInfo && simpleClassInfo.isFirstClassInUnit()) {
                outRect.top = (int) mHeaderHeight;
            } else {
                outRect.top = (int) mDividerHeight;
            }
        }


    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        //这里得到的屏幕上显示的view，而不是全部子view
        int childCount = parent.getChildCount();
//                Log.e("fyp-onDraw1111",childCount+"");
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(view);
            if (null != mCallback) {
                SimpleClassInfo simpleClassInfo = mCallback.getSimpleClassInfo(position);
                int left = parent.getPaddingLeft();
                int right = parent.getWidth() - parent.getPaddingRight();
                if (i == 0) {
                    //屏幕上第一个view一定显示header

                    int top = parent.getPaddingTop();

                    if(simpleClassInfo.isLastClassInUnit()){
                        float shouldTop = view.getBottom() - mHeaderHeight;
                        if(shouldTop < top){
                            top = (int) shouldTop;
                        }
                    }
                    int bottom = (int) (top+mHeaderHeight);
                    drawHeader(c,left,top,right,bottom,simpleClassInfo);
                } else {
                    //不是第一个，但是组内第一个，也要显示header
                    if (simpleClassInfo.isFirstClassInUnit()) {
                        int bottom = view.getTop();
                        int top = (int) (bottom - mHeaderHeight);
                        drawHeader(c,left,top,right,bottom,simpleClassInfo);
                    } else {

                    }
                }
            }
        }

    }

    private void drawHeader(Canvas c,int left,int top,int right,int bottom,SimpleClassInfo simpleClassInfo){
        c.drawRect(left, top, right, bottom, mPaint);
        float textX = left + mOffsetTextLeft;
        float textY = bottom - mFontMetrics.descent;
        c.drawText(simpleClassInfo.getUnitTitle(), textX, textY, mTextPaint);
    }
}