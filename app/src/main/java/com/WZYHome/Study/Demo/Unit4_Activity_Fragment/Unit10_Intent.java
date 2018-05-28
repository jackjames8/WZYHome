package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.WZYHome.Study.Demo.R;

/**
 *    <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit10_Service_BroadcastReceiver.Unit10_Intent">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <activity android:name=".Unit10_Service_BroadcastReceiver.Unit10_Intent_SecondActivity">
 <intent-filter>
 <action android:name="my.intent.action.Second"/>
 <category android:name="android.intent.category.DEFAULT"/>
 </intent-filter>
 </activity>

 </application>
 */

public class Unit10_Intent extends Activity {
    static final String Tag="MainActivity";
    Button button2 ,button;
    int count;
    EditText ed_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit10_intent);
      /*  if(savedInstanceState!=null){
        count=savedInstanceState.getInt("count");
        }//判断savedInstanceState是否有保存了数据，有直接取出来*/
        Log.i(Tag,"onCreate");//首先创建
        button2= (Button) findViewById(R.id.button2);
        button= (Button) findViewById(R.id.button);
        ed_content= (EditText) findViewById(R.id.ed_content);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动第二个界面
                //第一种方法启动第二个SecondActivity.class组件界面
                /*Intent intent=new Intent(MainActivity.this,SecondActivity.class);*/
                //第二种方法启动第二个SecondActivity.class组件界面
                Intent intent=new Intent();
               /* ComponentName componentName=new ComponentName(MainActivity.this,SecondActivity.class);
                intent.setComponent(componentName);*/
                //第三种方法启动第二个SecondActivity.class组件界面
               /* intent.setClass(MainActivity.this,SecondActivity.class);*/
                //第四种方法启动第二个SecondActivity.class组件界面
              /* intent.setClassName("com.example.administrator.myapplication1","com.example.administrator.myapplication1.SecondActivity");
                startActivity(intent);*/
                //隐式启动第二个界面
                intent.setAction("my.intent.action.Second");
                //用intent传参数
                /*intent.putExtra("content",ed_content.getText()+"");
                intent.putExtra("count",10);*/
                //用bundle这个map对象一次性传过去
                Bundle bundle=new Bundle();
                bundle.putString("content",ed_content.getText()+"");
                bundle.putInt("count",10);
                intent.putExtra("bundle",bundle);
                startActivity(intent);



            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(Tag,"当前count="+count+"");
                count++;
            }
        });

    }

    @Override
    public void onStart() {
        Log.i(Tag,"onStart");//成可见
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(Tag,"onResume");//成获得焦点
        super.onResume();
    }


    @Override
    protected void onRestart() {
        Log.i(Tag,"onRestart");//重新调用
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.i(Tag,"onPause");//成失去焦点
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.i(Tag,"onDestroy");//成销毁状态
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i(Tag,"onStop");//成不可见状态
        super.onStop();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.i(Tag,"savedInstanceState");
        outState.putInt("count",count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.i(Tag,"onRestoreInstanceState");
        count=savedInstanceState.getInt("count");
        super.onRestoreInstanceState(savedInstanceState);
    }//第一次初始化是不会调用此方法

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.i(Tag,"onConfigurationChanged");
        super.onConfigurationChanged(newConfig);
    }
}
