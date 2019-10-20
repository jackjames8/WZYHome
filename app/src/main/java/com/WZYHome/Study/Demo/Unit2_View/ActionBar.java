package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 * 配置信息
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme2">
 <activity
 android:name=".Unit2_View.ActionBar">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />
 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <!-- 返回主界面-->
 <activity android:name=".Unit2_View.Sub_ActionBar"
 android:parentActivityName=".Unit2_View.ActionBar"
 android:label="Sub_ActionBar"/>
 </application>
 */

public class ActionBar extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit2_actionbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.actionba_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()){
            case R.id.play:
                Intent intent=new Intent();
                intent.setClass(ActionBar.this,Sub_ActionBar.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"play",Toast.LENGTH_LONG).show();
                break;
            case R.id.pause:
                Toast.makeText(getApplicationContext(),"pause",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }

        return super.onMenuItemSelected(featureId, item);
    }
}
