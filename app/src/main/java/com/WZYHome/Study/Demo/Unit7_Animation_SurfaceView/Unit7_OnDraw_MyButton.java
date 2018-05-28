package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;


/**
 * Created by Administrator on 2017/8/1.
 */

public class Unit7_OnDraw_MyButton extends View {



    public Unit7_OnDraw_MyButton(Context context) {
        super(context);
    }

    public Unit7_OnDraw_MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Unit7_OnDraw_MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
   private class part{
       private int color;
       private float percent;

       public part(int color, float percent) {
           this.color = color;
           this.percent = percent;
       }


       public int getColor() {
           return color;
       }

       public void setColor(int color) {
           this.color = color;
       }

       public float getPercent() {
           return percent;
       }

       public void setPercent(float percent) {
           this.percent = percent;
       }
   }
   ArrayList<part> partArrayList=new ArrayList<part>();
    public void addPart(int color, float percent){

        partArrayList.add(new part(color,percent));


    }
    //Activity中调用commit()函数进行刷新
    public void commit(){
        invalidate();
    }
    public void clear(){
        partArrayList.clear();
        /*invalidate();*/
    }

    //当View类运行时，View会自动调用onFinishInflate()方法
   /* @Override
    protected void onFinishInflate(){
        partArrayList.add(new part(Color.RED,0.17f));
        partArrayList.add(new part(Color.GREEN,0.37f));
        partArrayList.add(new part(Color.BLUE,0.37f));
    }*/

    Paint paint=new Paint();
    Rect rect=new Rect();
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //在这个Unit7_OnDraw_MyButton这个按钮上面画线，设置文字;
      /*  paint.setColor(Color.GREEN);
        paint.setTextSize(50);
        canvas.drawText("wangzhiyong",20,20,paint);*/
      //把feiji_1这个图画在Unit7_OnDraw_MyButton按钮上
     /*   Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.feiji_1);
      canvas.drawBitmap(bitmap,0,0,paint);*/
     //测试OnDraw()函数被调用的情况
       /* Toast.makeText(getContext(),"OnDraw",Toast.LENGTH_LONG).show();*/
        int width=getMeasuredWidth();
        canvas.drawColor(Color.BLACK);
       rect.top=0;
        rect.bottom=getMeasuredHeight();
        rect.left=0;
        rect.right=0;
        for(part part:partArrayList){
            rect.left=rect.right;
            rect.right= (int) (rect.left+part.percent*width);
            paint.setColor(part.color);
            canvas.drawRect(rect,paint);


        }

    }

    @Override
    public void invalidate() {
        super.invalidate();
    }

    @Override
    public void invalidate(int l, int t, int r, int b) {
        super.invalidate(l, t, r, b);
        //测试invalidate()函数被调用的情况
       /* Toast.makeText(getContext(),"invalidate",Toast.LENGTH_LONG).show();*/
    }
}
