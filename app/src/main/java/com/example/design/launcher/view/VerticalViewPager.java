package com.example.design.launcher.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class VerticalViewPager extends ViewPager {

    private boolean isVertical;
    public static final int VERTICAL = 0;
    public static final int HORIZONTAL = 1;

    public VerticalViewPager(@NonNull Context context) {
        super(context);
    }

    public VerticalViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        final int action = ev.getAction() & MotionEvent.ACTION_MASK;
        if (!isVertical) {
            return super.onInterceptTouchEvent(ev);
        } else {
            return false;
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(ev);
    }

    public void setDirection(int direction) {
        if (direction == HORIZONTAL && isVertical) {
            isVertical = false;
        } else if (direction == VERTICAL && !isVertical) {
            isVertical = true;
        }
        requestLayout();
    }
}
