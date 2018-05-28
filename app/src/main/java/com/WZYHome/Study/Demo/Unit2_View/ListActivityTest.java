package com.WZYHome.Study.Demo.Unit2_View;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Unit2_ListActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
        */

public class ListActivityTest extends ListActivity {
    String[] dateresource={"北京","上海","广州","深圳","吉安"};
    TextView textView13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit5_listactivity);
        textView13=(TextView) findViewById(R.id.textView13);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.unit5_listview_testview,
                R.id.Item_list,dateresource);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String str=dateresource[position];
        textView13.setText(str);
    }
}
