package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.WZYHome.Study.Demo.R;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit4_Activity_Fragment.popstackfragementTest"
 android:theme="@style/CustomTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class popstackfragementTest extends AppCompatActivity {
    FrameLayout     containerFrameLayout;//
    private Unit4_FragmentDemo1 lm= new Unit4_FragmentDemo1();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popstack_fragement_test);
        containerFrameLayout= (FrameLayout) findViewById(R.id.containerFrameLayout);
        FragmentManager fm=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.containerFrameLayout, lm);
        ft.addToBackStack(null);//增加一个回退栽操作
        ft.commit();
    }
}
