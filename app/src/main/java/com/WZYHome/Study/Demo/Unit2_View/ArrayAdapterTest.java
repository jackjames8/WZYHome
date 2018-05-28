package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.ArrayAdapterTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ArrayAdapterTest extends Activity {
    TextView textView19;
    Button   button9;
    ListView ListView;
    List<String> dataScources= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        ListView= (ListView) findViewById(R.id.ListView);
        textView19=(TextView) findViewById(R.id.textView19);
        button9= (Button) findViewById(R.id.button9);
        String[]  course=getResources().getStringArray(R.array.Course);
        for(int i=0;i<course.length;i++){
            dataScources.add(course[i]);
        }
        final android.widget.ArrayAdapter adapter=new android.widget.ArrayAdapter(this,
                android.R.layout.activity_list_item,
                android.R.id.text1,
                dataScources
                );
        ListView.setAdapter(adapter);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=textView19.getText()+" ";
                dataScources.add(str);
                //通知adapter更新数据
                adapter.notifyDataSetChanged();

            }
        });
    }
}
