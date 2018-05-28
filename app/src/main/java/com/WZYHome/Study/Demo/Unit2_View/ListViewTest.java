package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
 android:name=".Unit2_View.ListViewTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ListViewTest extends Activity {
    TextView textView19;
    ListView ListView;
    String[] dateresource={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        dateresource=getResources().getStringArray(R.array.Course);
        ListView= (ListView) findViewById(R.id.ListView);
        textView19= (TextView) findViewById(R.id.textView19);
        ArrayAdapter<String>  adapter=new ArrayAdapter<String>(this,android.R.layout.activity_list_item,
                android.R.id.text1,
                dateresource);
                ListView.setAdapter(adapter);
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Str=dateresource[position];
                textView19.setText(Str);

            }
        });
    }
}
