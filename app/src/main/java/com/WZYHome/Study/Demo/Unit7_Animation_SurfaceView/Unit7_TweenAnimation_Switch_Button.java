package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_TweenAnimation_Switch_Button">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_TweenAnimation_Switch_Button extends AppCompatActivity{
    private View target;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_tweenanimation);
        target=findViewById(R.id.imageView_po);
        Button btn= (Button) findViewById(R.id.button28_rotate);
        btn.setOnClickListener(MyonClickListener);
        btn= (Button) findViewById(R.id.button26_Scale);
        btn.setOnClickListener(MyonClickListener);
        btn= (Button) findViewById(R.id.button27_alpha);
        btn.setOnClickListener(MyonClickListener);
        btn= (Button) findViewById(R.id.button25_translate);
        btn.setOnClickListener(MyonClickListener);
        btn= (Button) findViewById(R.id.button_set);
        btn.setOnClickListener(MyonClickListener);
    }
      View.OnClickListener MyonClickListener=new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Animation animation=null;
              switch (v.getId()){
                  case R.id.button26_Scale:
                      animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
                      break;
                  case R.id.button28_rotate:
                      animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                      break;
                  case R.id.button27_alpha:
                      animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                      break;
                  case R.id.button25_translate:
                      animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate);
                      break;
                  case R.id.button_set:
                      animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.set);
                  default:
                      break;
              }
              if(animation!=null){
                  target.startAnimation(animation);
              }
          }

      };
}
