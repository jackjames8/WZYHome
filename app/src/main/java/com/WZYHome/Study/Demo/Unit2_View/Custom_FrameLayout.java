package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/6/19.
 */

public class Custom_FrameLayout extends FrameLayout {
    TextView title;
    ImageView imageView3;
    FrameLayout FrameLayout1;
    //构造方法初始化
    public Custom_FrameLayout(Context context) {
        super(context);
        init(context);
    }

    public Custom_FrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Custom_FrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

    }

    void init(Context context){
        View view= LayoutInflater.from(context).inflate(R.layout.unit6_custom_framelayout,this,true);
        title= (TextView) view.findViewById(R.id.textView24);
        imageView3= (ImageView) view.findViewById(R.id.imageView3);
        FrameLayout1= (FrameLayout) view.findViewById(R.id.FrameLayout1);
        setClickable(true);
    }
    public void setImageRresoures(int resId){
        this.imageView3.setImageResource(resId);
    }
    public void setTite(String title){
        this.title.setText(title);
    }
    //回调函数
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                FrameLayout1.setVisibility(View.VISIBLE);
                break;
            case MotionEvent.ACTION_UP:
                FrameLayout1.setVisibility(View.INVISIBLE);
                break;
        }
        return super.onTouchEvent(event);
    }
}
