package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/CustomTheme">
 <activity
 android:name=".Unit2_View.Custom_loginLayoutTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Custom_loginLayoutTest extends Activity {
    Custom_loginLayout customLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit2_custom_loginlayout_test);
        customLogin= (Custom_loginLayout) findViewById(R.id.customLogin);
        customLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Test",customLogin.GetedUseName()+""+customLogin.GetedPassWord()+"");
            }
        });
        customLogin.SetPassword("确认密码");
        customLogin.SetUseName("密码");



    }
}
