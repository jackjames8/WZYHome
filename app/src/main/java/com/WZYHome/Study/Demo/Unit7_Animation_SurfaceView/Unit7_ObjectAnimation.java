package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_ObjectAnimation">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_ObjectAnimation extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_objectanimation);
        Button btn_objectAnimation= (Button) findViewById(R.id.btn_objectAnimation);
        btn_objectAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View target=findViewById(R.id.imageView_polo);
                //View.ALPHA得到ALPHA的变量值，然后把它设置成目标0.f的值，这样就会产生动画的效果
               /* ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(target,View.ALPHA,0f);*/
                //View.TRANSLATION_X得到移动的变量值,然后向轴移动目标500个像素
                ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(target,View.TRANSLATION_X,500f);
                //设置objectAnimator对象加速移动new AccelerateInterpolator();
                objectAnimator.setInterpolator(new AccelerateInterpolator());
                objectAnimator.setDuration(4000).start();
            }
        });
    }
}
