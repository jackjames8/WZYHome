package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.SpinnerTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class SpinnerTest extends Activity {
    Spinner spinner;
    TextView textView19;
    String[]  dateScources={"AAA","BBB","CCC"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        textView19= (TextView) findViewById(R.id.textView19);
        spinner= (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(this,R.layout.unit5_listview_testview,
                R.id.Item_list,
                dateScources);
        spinner.setAdapter(adapter);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               TextView testView= (TextView) findViewById(R.id.Item_list);
               textView19.setText(testView.getText()+"");
              /* textView19.setText(dateScources[position]);*/
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });



    }
}
