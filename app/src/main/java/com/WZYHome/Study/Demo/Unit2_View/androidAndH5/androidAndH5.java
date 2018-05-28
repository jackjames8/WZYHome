package com.WZYHome.Study.Demo.Unit2_View.androidAndH5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 *
 <uses-permission android:name="android.permission.CALL_PHONE" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.WRITE_CONTACTS" />
 <uses-permission android:name="android.permission.CAMERA" />

 <!-- To auto-complete the email text field in the login form with the user's emails -->
 <uses-permission android:name="android.permission.GET_ACCOUNTS" />
 <uses-permission android:name="android.permission.READ_PROFILE" />
 <uses-permission android:name="android.permission.READ_CONTACTS" />

 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity android:name="com.WZYHome.Study.Demo.Unit2_View.androidAndH5.androidAndH5">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <activity android:name="com.WZYHome.Study.Demo.Unit2_View.androidAndH5.JavaAndJSActivity">
 </activity>
 <activity android:name="com.WZYHome.Study.Demo.Unit2_View.androidAndH5.JsCallJavaVideoActivity">
 </activity>
 <activity android:name="com.WZYHome.Study.Demo.Unit2_View.androidAndH5.JsCallJavaCallPhoneActivity">
 </activity>

 </application>
 */

public class androidAndH5 extends Activity implements View.OnClickListener{

    private Button btnJavaAndJs;
    private Button btnJsCallJava;
    private Button btnJsCallPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_and_h5);
        findViews();//初始化控件
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2018-05-14 11:25:38 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        btnJavaAndJs = (Button)findViewById( R.id.btn_java_and_js );
        btnJsCallJava = (Button)findViewById( R.id.btn_js_call_java );
        btnJsCallPhone = (Button)findViewById( R.id.btn_js_call_phone );

        btnJavaAndJs.setOnClickListener( this );
        btnJsCallJava.setOnClickListener( this );
        btnJsCallPhone.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2018-05-14 11:25:38 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == btnJavaAndJs ) {
            Intent intent=new Intent(androidAndH5.this,JavaAndJSActivity.class);
            startActivity(intent);
        } else if ( v == btnJsCallJava ) {
            // Handle clicks for btnJsCallJava
            Intent intent=new Intent(androidAndH5.this,JsCallJavaVideoActivity.class);
            startActivity(intent);
        } else if ( v == btnJsCallPhone ) {
            // Handle clicks for btnJsCallPhone
            Intent intent=new Intent(androidAndH5.this,JsCallJavaCallPhoneActivity.class);
            startActivity(intent);
        }
    }

}
