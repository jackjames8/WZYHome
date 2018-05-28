package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.GridViewTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class GridViewTest extends Activity {
    android.widget.GridView GridView1;
    String[] data={"AAA","BBB","CCC","DDD","EEE","FFF","GGG","KKK"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        GridView1= (android.widget.GridView) findViewById(R.id.GridView1);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.unit5_listview_testview,
                R.id.Item_list,
                data);
        GridView1.setAdapter(adapter);
    }
}
