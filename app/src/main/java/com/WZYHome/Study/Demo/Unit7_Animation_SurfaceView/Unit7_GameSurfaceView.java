package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/8/2.
 */

public class Unit7_GameSurfaceView extends SurfaceView {
    SurfaceHolder surfaceHolder;
    Bitmap bmpBackground=null;
    public Unit7_GameSurfaceView(Context context,AttributeSet attributeSet) {
        super(context,attributeSet);
        bmpBackground= BitmapFactory.decodeResource(getResources(), R.drawable.gamebackground);
        surfaceHolder=getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                draw();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
    //自定义draw()方法
     protected void draw(){
         Canvas canvas=surfaceHolder.lockCanvas();
         if (canvas==null){
             return;
         }
         canvas.drawBitmap(bmpBackground,0,0,null);

         surfaceHolder.unlockCanvasAndPost(canvas);

     }
}
