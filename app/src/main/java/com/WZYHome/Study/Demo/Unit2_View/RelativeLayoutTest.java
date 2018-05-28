package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;

import com.WZYHome.Study.Demo.R;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.RelativeLayoutTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class RelativeLayoutTest extends Activity {
   /* TextView textView8,textView13;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over3);
 /*       String context=getString(R.string.test);
        String context1="";
        String[] s=getResources().getStringArray(R.array.arryTest);
        for(int i=0;i<s.length;i++){
            context1+=s[i];
            textView13.setText(context1);
        }*/

    }
}
