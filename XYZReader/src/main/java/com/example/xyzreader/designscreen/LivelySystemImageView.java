package com.example.xyzreader.designscreen;

import android.content.Context;
import android.util.AttributeSet;

import com.android.volley.toolbox.NetworkImageView;

public class LivelySystemImageView extends NetworkImageView {
    private float mAspectRatio = 1.5f;

    public LivelySystemImageView(Context context) {
        super(context);
    }

    public LivelySystemImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LivelySystemImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAspectRatio(float aspectRatio) {
        mAspectRatio = aspectRatio;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        setMeasuredDimension(measuredWidth, (int) (measuredWidth / mAspectRatio));
    }
}
