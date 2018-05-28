package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.OverActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class OverActivity extends Activity {

    EditText TVName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.over);

        Button btOk=(Button) findViewById(R.id.btOk);

        TVName= (EditText) findViewById(R.id.TVName);

        btOk.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String name=(TVName.getText()+"").trim();
                if(name==null || name.equals("")){
                    TVName.setText("姓名必须输入");
                    return;//继续判断上面那if条件
                }
                finish();
            }
        });


    }
}
