package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.WZYHome.Study.Demo.R;
/*
*  <application
        android:allowBackup="true"
        android:icon="@drawable/feiji_1"
        android:label="@string/app_name"
        android:theme="@style/AppTheme">
        <activity
            android:name=".Unit2_View.checkboxdemo">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
 */


public class checkboxdemo extends Activity {
    CheckBox chek_chinese, chek_English, chek_jap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkboxdemo);
        chek_chinese = (CheckBox) findViewById(R.id.chek_chinese);
        chek_English = (CheckBox) findViewById(R.id.chek_English);
        chek_jap = (CheckBox) findViewById(R.id.chek_jap);
        chek_chinese.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //当状态变化时，自动调回;
                //选中－〉非选中,非选中->选中
                /*boolean b=(buttonView==chek_English);*/
                Log.i("TEST", buttonView + " " + isChecked);
            }
        });

    }



}
