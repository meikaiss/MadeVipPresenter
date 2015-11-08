package com.android.mvp.core.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by meikai on 15/11/8.
 */
public class InputMethodLinearLayout extends LinearLayout {

    private InputMethodLinearLayout.OnSizeChangeListener onSizeChangeListener;

    public InputMethodLinearLayout(Context context) {
        super(context);
    }

    public InputMethodLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InputMethodLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public InputMethodLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes, OnSizeChangeListener onSizeChangeListener) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.onSizeChangeListener = onSizeChangeListener;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {

        if (oldh != 0) {
            if (oldh > h && this.onSizeChangeListener != null) {
                this.onSizeChangeListener.onSizeSmaller();
            } else if (oldh < h && this.onSizeChangeListener != null) {
                this.onSizeChangeListener.onSizeLarger();
            }
        }

        super.onSizeChanged(w, h, oldw, oldh);
    }

    public void setOnSizeChangeListener(InputMethodLinearLayout.OnSizeChangeListener onSizeChangeListener) {

        this.onSizeChangeListener = onSizeChangeListener;

    }



    public interface OnSizeChangeListener {

        void onSizeLarger();

        void onSizeSmaller();

    }
}