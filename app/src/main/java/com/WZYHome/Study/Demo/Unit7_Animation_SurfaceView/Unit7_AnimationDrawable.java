package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_AnimationDrawable"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_AnimationDrawable extends Activity {
    boolean isplaying=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_animationdrawable);
        Button play_btn= (Button) findViewById(R.id.play_btn);
        play_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayout frameLayout= (FrameLayout) findViewById(R.id.frame_Layout1);
                //获取一个逐帧动画对象,通过button按钮控制动画播放
                AnimationDrawable animationDrawable= (AnimationDrawable) frameLayout.getBackground();
                if(isplaying){
                    animationDrawable.stop();
                    isplaying=false;
                }else {
                    animationDrawable.start();
                    isplaying=true;
                }

            }
        });

    }
}
