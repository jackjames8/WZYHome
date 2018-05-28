package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.WZYHome.Study.Demo.R;

/**
 *<application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit4_Activity_Fragment.Unit4_DetailFragment"
 android:theme="@style/CustomTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit4_DetailFragment extends AppCompatActivity {
  private Unit4_FragmentDemo1 lm;
    private Unit4_FragmentDemo2 dm;
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit4_detailfragment);
        FragmentManager fm=getSupportFragmentManager();
         dm=(Unit4_FragmentDemo2)fm.findFragmentById(R.id.detailFragment);
         lm=(Unit4_FragmentDemo1)fm.findFragmentById(R.id.ListFragment);
        lm.setOnNameSelectedListener(new Unit4_FragmentDemo1.OnListenerA() {
            @Override
            public void onNameSelected(String name) {
                dm.setName(name);
            }

            @Override
            public void getView(View view) {

            }
        });
    }

}
