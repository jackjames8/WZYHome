package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;


/**
 * Created by Administrator on 2017/6/18.
 */

public class Custom_MyButton extends AppCompatButton {


    public Custom_MyButton(Context context) {
        super(context);
    }

    public Custom_MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Custom_MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                setScaleX(0.5f);
                setScaleY(0.5f);
                break;
            case MotionEvent.ACTION_UP:
                setScaleX(1.0f);
                setScaleY(1.0f);
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        Log.v("-MyButton-", "the onKeyDown in MyButton");
        // 返回false，表明并未完全处理该事件，该事件依然向外扩散
        return false;
    }
}