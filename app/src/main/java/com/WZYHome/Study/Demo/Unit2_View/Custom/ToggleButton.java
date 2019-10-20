package com.WZYHome.Study.Demo.Unit2_View.Custom;

import android.content.Context;

import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Administrator on 2019/4/15.
 */

public class ToggleButton extends View {
    public ToggleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private  float startX;

    public boolean onTouchEvent(MotionEvent event) {
         super.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //1记录安下的坐标

                break;
            case MotionEvent.ACTION_UP:

                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }
        return true;
    }


}
