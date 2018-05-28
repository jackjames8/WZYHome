package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.LayoutInflaterTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class LayoutInflaterTest extends Activity {
    LinearLayout mainlayout;
    Button  button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);
        button7= (Button) findViewById(R.id.button7);
        mainlayout=(LinearLayout)findViewById(R.id.mainlayout);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater  Inflater=getLayoutInflater();
                View view=Inflater.inflate(R.layout.testlayout,null);
                mainlayout.addView(view);
            }
        });
    }


}
