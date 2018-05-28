package com.WZYHome.Study.Demo.Unit2_View.Custom;

/**
 * Created by Administrator on 2017/10/30.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.WZYHome.Study.Demo.R;

/**
 * Created by lp on 2016/9/21.
 */
public class TextViewBorder extends android.support.v7.widget.AppCompatTextView {
    private static final int STROKE_WIDTH = 2;
    private int borderCol;

    private Paint borderPaint;

    public TextViewBorder(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.TextViewBorder, 0, 0);
        try {
            borderCol = a.getInteger(R.styleable.TextViewBorder_borderColor, 0);//0 is default
        } finally {
            a.recycle();
        }

        borderPaint = new Paint();
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setStrokeWidth(STROKE_WIDTH);
        borderPaint.setAntiAlias(true);
    }

    /**
     *
     * @param canvas 有paint和帆布，就可以画形状了
     */
    @Override
    protected void onDraw(Canvas canvas) {

        if (0 == this.getText().toString().length())
            return;

        borderPaint.setColor(borderCol);


        int w = this.getMeasuredWidth();
        int h = this.getMeasuredHeight();

        RectF r = new RectF(2, 2, w - 2, h - 2);
        canvas.drawRoundRect(r, 55, 55, borderPaint);
        super.onDraw(canvas);
    }

    public int getBordderColor() {
        return borderCol;
    }

    public void setBorderColor(int newColor) {
        borderCol = newColor;
        /*invalidate();*/
    /*    requestLayout();*/
    }

}

