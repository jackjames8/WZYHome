package com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask.Unit3_onTouchEvent"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit3_onTouchEvent extends AppCompatActivity {
    TextView textView2,textView6;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit2);
        textView2= (TextView) findViewById(R.id.textView2);
        editText= (EditText) findViewById(R.id.editText);
        textView6= (TextView) findViewById(R.id.textView6);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
               if(keyCode== KeyEvent.KEYCODE_1){
                   Log.i("Test","KEYCODE_NUMPAD_100000");
                   textView6.setText("KeyEvent.KEYCODE_0");
               }
                return true;//当返回ture时，表明处理方法已经处理该事件,返回false时，可以没有处理该事件，事件可以向外扩展
            }
        });
    }
    //回调函数,响应触摸屏事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            Log.i("Test++++","ACTION_UP");
            String pos="";
            float x=event.getX();
            float y=event.getY();
            pos="x="+x +",y="+y;
            textView2.setText(pos);
            textView2.setBackgroundColor(Color.DKGRAY);
        }else if(event.getAction()==MotionEvent.ACTION_DOWN){
            Log.i("Test++++","ACTION_DOWN");
            textView2.setBackgroundColor(Color.RED);
        }

        return super.onTouchEvent(event);
    }


}
