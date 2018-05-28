package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_ViewPropertyAnimator">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_ViewPropertyAnimator extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_view_property_animation);
       /* Button button20_start= (Button) findViewById(R.id.button20_start);*/
    }
    public  void onClick(View view){
        //属性动画改变对象的本身
        View target=findViewById(R.id.imageView4);
        //取得target的高度并按这个值去移动,在1秒内移完
       /* target.animate().translationYBy(target.getHeight()).setDuration(1000).start();*/
       //改target对象扩大2倍，并设置透明度为0，在1秒内执行完
        target.setPivotX(0);//设置target的支点为0
        target.setPivotY(0);//设置target的支点为0
        target.animate().scaleX(2f).scaleY(2f).alpha(0).setDuration(1000).start();
        Toast.makeText(getApplicationContext(),"target.getPivotX()="+target.getPivotX()+"target.getPivotY()="+target.getPivotY(),Toast.LENGTH_LONG).show();

    }
}
