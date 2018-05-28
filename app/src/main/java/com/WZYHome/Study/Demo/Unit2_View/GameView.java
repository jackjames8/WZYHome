package com.WZYHome.Study.Demo.Unit2_View;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.WZYHome.Study.Demo.R;


/**
 * Created by Administrator on 2017/6/3.
 */

public class GameView extends View {
    public int planeX;
    public int planeY;
    Bitmap bmpPlane=null;
    Paint paint=new Paint();

    //希望在XML布局文件中添加控件
    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bmpPlane= BitmapFactory.decodeResource(getResources(), R.drawable.feiji_1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bmpPlane,planeX,planeX,paint);

    }
    public boolean onTouchEvent(MotionEvent event) {
        this.planeX= (int) event.getX();
        this.planeY= (int) event.getY();
        this.invalidate();
        return super.onTouchEvent(event);
    }
}
