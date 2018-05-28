package com.WZYHome.Study.Demo.Unit8_SharedPreferences_SQLite;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.io.File;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit8_SharedPreferences_SQLite.Unit8_ExternalStorage">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit8_ExternalStorage extends Activity {
    Button External_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_externalstorage);
        External_btn= (Button) findViewById(R.id.External_btn);
        External_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Ret= Environment.getExternalStorageState();
                if(Ret.equals(Environment.MEDIA_MOUNTED)){
                   // File file=getExternalFilesDir("Music");//获取一个本应用程序的Music目录
                    File file=Environment.getExternalStorageDirectory();//获取sd卡外部目录
                    Toast.makeText(getApplicationContext(),file.getAbsolutePath(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
