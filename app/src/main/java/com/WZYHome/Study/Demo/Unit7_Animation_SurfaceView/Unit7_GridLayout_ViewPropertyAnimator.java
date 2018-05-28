package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.animation.AnimatorSet;
import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_GridLayout_ViewPropertyAnimator">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_GridLayout_ViewPropertyAnimator extends Activity {
    int num=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_gridlayout_viewpropertyanimator);

        final GridLayout gridContainer= (GridLayout) findViewById(R.id.gridLayoutAnimation);

        Button btn_layoutAnimation= (Button) findViewById(R.id.btn_layoutAnimation);

        btn_layoutAnimation.setOnClickListener(new View.OnClickListener() {
            //每次点击增加一个Button
            @Override
            public void onClick(View v) {
                Button newButton = new Button(Unit7_GridLayout_ViewPropertyAnimator.this);
                if(gridContainer.getChildCount()==0){
                    gridContainer.addView(newButton,0);
                }else {
                    gridContainer.addView(newButton,1);
                }
                newButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        gridContainer.removeView(v);
                    }
                });

            }
        });

        //得到gridContainer对像的布局对象，通过这个布局对象去设置它的布局动画。
        LayoutTransition layoutTransition=gridContainer.getLayoutTransition();
        //当增加控件LayoutTransition.DISAPPEARING的行为，第二个参数null是控件的出现没有动画,你可以在第二个参数插入自定义动画Animator。
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING,PlayAnimeToView.getPlayAnime(null));

    }

       static class PlayAnimeToView{

          static  public  AnimatorSet getPlayAnime(View target){
            ObjectAnimator AnimatorROTATION=ObjectAnimator.ofFloat(target,View.ROTATION,720f);
            ObjectAnimator AnimatorSCALE_X=ObjectAnimator.ofFloat(target,View.SCALE_X,0.1f);
            ObjectAnimator AnimatorSCALE_Y=ObjectAnimator.ofFloat(target,View.SCALE_Y,0.1f);
            ObjectAnimator AnimatorALPHA=ObjectAnimator.ofFloat(target,View.ALPHA,0f);
            //创建一个动画集合类，保存上面的ObjectAnimator的对象集合
            AnimatorSet animatorSet1=new AnimatorSet();
            animatorSet1.playTogether(AnimatorROTATION,AnimatorSCALE_X,AnimatorSCALE_Y,AnimatorALPHA);
            animatorSet1.setDuration(1000);
            return animatorSet1;
        }

    }

}
