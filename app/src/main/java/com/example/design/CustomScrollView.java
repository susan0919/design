package com.example.design;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView {

    float lastY = 0;
    boolean isScrollToBottom;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr,
                            int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercept = false;
        int actionMasked = ev.getActionMasked();

        switch (actionMasked) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                break;
            case MotionEvent.ACTION_MOVE:
                LinearLayout linearLayout = (LinearLayout) getChildAt(0);
                ListView listView = (ListView) getChildAt(1);
                if (!isScrollToBottom) {
                    intercept = true;
                } else if (!ifTop(listView)) {
                    intercept = false;
                } else {
                    intercept = ev.getY() > lastY;
                }

                break;
        }
        lastY = ev.getY();
        super.onInterceptTouchEvent(ev);
        return intercept;
    }

    private boolean ifTop(ListView listView) {
        if (listView.getFirstVisiblePosition() == 0) {
            View view = listView.getChildAt(0);
            return view == null && view.getTop() >= 0;

        }
        return false;
    }
}
