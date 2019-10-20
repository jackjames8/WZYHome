package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.Custom.MyExpandableAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.ExpandableAdapterTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ExpandableAdapterTest extends Activity {
    List<String> groupArray=new ArrayList<>();
    List<List<String>> childArray=new ArrayList<>();
    List<String> sounds1=new ArrayList<>();
    List<String> sounds2=new ArrayList<>();
    List<String> sound3=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandable_adapter_test);
        groupArray.add("特殊规格");
        groupArray.add("特殊规格");
        groupArray.add("特殊规格");
        sounds1.add("双排座");
        sounds1.add("车辆尾板");
        sound3.add("全拆座");
        childArray.add(sounds1);
        childArray.add(sounds2);
        childArray.add(sound3);
        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.ExpandableListView);
        ExpandableListAdapter adapter = new MyExpandableAdapter(ExpandableAdapterTest.this,groupArray,childArray);
        expandableListView.setAdapter(adapter);
        expandableListView.setGroupIndicator(null);
    }
}
