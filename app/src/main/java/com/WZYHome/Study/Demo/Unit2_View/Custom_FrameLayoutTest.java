package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Unit2_Custom_FrameLayoutTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Custom_FrameLayoutTest extends Activity {
    Custom_FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit6_custom_framelayout_test);
        frameLayout= (Custom_FrameLayout) findViewById(R.id.custom_framelayout);
        frameLayout.setImageRresoures(R.drawable.timg3);
        frameLayout.setTite("good picture");
    }
}
