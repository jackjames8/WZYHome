package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.WZYHome.Study.Demo.R;

import java.util.Random;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_SurfaceView">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_SurfaceView extends Activity {
    MyThread myThread;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_surfaceview);
        SurfaceView sfv= (SurfaceView) findViewById(R.id.surfaceView);
        SurfaceHolder surfaceHolder=sfv.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                myThread=new MyThread(holder);
                myThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                    myThread.MyStop();
            }
        });
    }

    class MyThread extends Thread{
        boolean refresh=true;
        SurfaceHolder holder;
        Random random=new Random();
        public MyThread(SurfaceHolder holder){
            this.holder=holder;
        }

        @Override
        public void run() {

            while (refresh){
            Canvas canvas= holder.lockCanvas();
            float left=random.nextInt(canvas.getWidth());
            float top=random.nextInt(canvas.getHeight());
            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.feiji_1);
            canvas.drawBitmap(bitmap,left,top,new Paint());
            holder.unlockCanvasAndPost(canvas);
                try {
                    Thread.sleep(1000/24);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
           public void MyStop(){
             refresh=false;
        }

    }

}
