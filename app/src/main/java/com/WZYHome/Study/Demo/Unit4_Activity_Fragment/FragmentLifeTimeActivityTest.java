package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.ToolBar;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit4_Activity_Fragment.FragmentLifeTimeActivityTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <activity android:name=".Unit2_View.ToolBar"></activity>
 </application>
 */

public class FragmentLifeTimeActivityTest extends AppCompatActivity {
    private  final static String Tag="AppCompatActivity";
    //Activity的生命周期
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit4_fragment);
        Log.i(Tag,"onCreate()");
    }
//可见
    @Override
    public void onStart() {
        super.onStart();
        Log.i(Tag,"onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"onResume()");
    }

    //失去焦点
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag,"onPause()");
    }

    //不可见
    @Override
    public void onStop() {
        super.onStop();
        Log.i(Tag,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"onDestroy()");
    }

   public void  sendSecondActivity(View view) {
       startActivity(new Intent(FragmentLifeTimeActivityTest.this, ToolBar.class));
    }

}
