package com.WZYHome.Study.Demo.Unit7_Animation_SurfaceView;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.WZYHome.Study.Demo.R;

/**
 *      <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit7_Animation_SurfaceView.Unit7_NinePatch">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit7_NinePatch extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_ninepatch);
    }
}
