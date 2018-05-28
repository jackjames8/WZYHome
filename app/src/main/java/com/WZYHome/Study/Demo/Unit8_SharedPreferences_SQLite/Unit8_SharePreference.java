package com.WZYHome.Study.Demo.Unit8_SharedPreferences_SQLite;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit8_SharedPreferences_SQLite.Unit8_SharePreference">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit8_SharePreference extends Activity {
    TextView textView30;
    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_sharepreference);
        Button btn= (Button) findViewById(R.id.save_btn);
        btn.setOnClickListener(MyOnClickListener);
        btn= (Button) findViewById(R.id.load_btn);
        btn.setOnClickListener(MyOnClickListener);
        textView30= (TextView) findViewById(R.id.textView30);
        SharedPreferences sp2=getSharedPreferences("demo123445",0);
        int number=sp2.getInt("number",-2);
        textView30.setText("Value is"+number);

    }
    private View.OnClickListener MyOnClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.save_btn:
                    SharedPreferences sp1=getSharedPreferences("demo123445",0);
                    SharedPreferences.Editor editor=sp1.edit();
                    editor.putString("number","55000");
                    editor.commit();
                    break;
                case R.id.load_btn:
                    SharedPreferences sp2=getSharedPreferences("demo123445",0);
                    String number=sp2.getString("number","");
                    textView30.setText("Value is"+number);
                    break;
                default:
                    break;
            }
        }
    };
}
