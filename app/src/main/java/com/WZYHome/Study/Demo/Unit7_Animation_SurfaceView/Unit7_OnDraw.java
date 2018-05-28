package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_OnDraw">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_OnDraw extends AppCompatActivity {
    com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView.Unit7_OnDraw_MyButton Unit7_OnDraw_MyButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_ondraw_mybutton);
        Unit7_OnDraw_MyButton= (com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView.Unit7_OnDraw_MyButton) findViewById(R.id.Target_btn);
    }
      public  void onClick(View view){
          Unit7_OnDraw_MyButton.clear();//调用此函数首先清空集合 partArrayList中的数据;
          Unit7_OnDraw_MyButton.addPart(Color.RED,0.10f);
          Unit7_OnDraw_MyButton.addPart(Color.GREEN,0.20f);
          Unit7_OnDraw_MyButton.addPart(Color.BLUE,0.30f);
          Unit7_OnDraw_MyButton.addPart(Color.YELLOW,0.40f);
          Unit7_OnDraw_MyButton.commit();//把上面的数据添加到集合里后，再刷新执行onDraw()方法
          Toast.makeText(getApplicationContext(),"Have Been Refresh",Toast.LENGTH_SHORT).show();

       }
   /*   class MyOnClickListener implements View.OnClickListener {

       @Override
       public void onClick(View v) {
           switch (v.getId()){
               case R.id.Target_btn:

                   break;
               case R.id.button20_nomal:
                   Target_btn.setText("22");
                   break;
               default:
                   break;
           }

       }
   }*/

}
