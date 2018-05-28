package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Menu2">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Menu2 extends Activity {
   EditText editText3;
    TextView textView26;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_menu);
        editText3= (EditText) findViewById(R.id.editText3);
        textView26= (TextView) findViewById(R.id.textView26);
        registerForContextMenu(editText3);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item10:
                item.setChecked(true);
                textView26.setTextSize(10*2);
                break;
            case R.id.item12:
                item.setChecked(true);
                textView26.setTextSize(12*2);
                break;
            case R.id.item14:
                item.setChecked(true);
                textView26.setTextSize(14*2);
            case R.id.itemRed:
                textView26.setTextColor(Color.RED);
                break;
            case R.id.itemBlue:
                textView26.setTextColor(Color.BLUE);
                break;
            case R.id.itemGreen:
                textView26.setTextColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
