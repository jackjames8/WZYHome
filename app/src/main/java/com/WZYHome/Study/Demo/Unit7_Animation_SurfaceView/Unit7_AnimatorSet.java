package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_AnimatorSet">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_AnimatorSet extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_animatorset);
        Button btn_AnimatorSet= (Button) findViewById(R.id.btn_AnimatorSet);
        btn_AnimatorSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View target=findViewById(R.id.imageView6_polo);
                ObjectAnimator AnimatorROTATION=ObjectAnimator.ofFloat(target,View.ROTATION,720f);
                ObjectAnimator AnimatorSCALE_X=ObjectAnimator.ofFloat(target,View.SCALE_X,0.1f);
                ObjectAnimator AnimatorSCALE_Y=ObjectAnimator.ofFloat(target,View.SCALE_Y,0.1f);
                ObjectAnimator AnimatorALPHA=ObjectAnimator.ofFloat(target,View.ALPHA,0f);
                //创建一个动画集合类，保存上面的ObjectAnimator的对象集合
                AnimatorSet animatorSet1=new AnimatorSet();
                animatorSet1.playTogether(AnimatorROTATION,AnimatorSCALE_X,AnimatorSCALE_Y,AnimatorALPHA);
                animatorSet1.setDuration(1000);

                ObjectAnimator AnimatorSCALE_Xbefore=ObjectAnimator.ofFloat(target,View.SCALE_X,2f);
                ObjectAnimator AnimatorSCALE_Ybefore=ObjectAnimator.ofFloat(target,View.SCALE_Y,2f);
                //创建一个动画集合对象animatorSet2,然后把上面的animatorSet1和下面的ObjectAnimator动画一起播放
                AnimatorSet animatorSet2=new AnimatorSet();
                animatorSet2.play(AnimatorSCALE_Xbefore).with(AnimatorSCALE_Ybefore).before(animatorSet1);
                animatorSet2.start();
            }
        });

    }
}
