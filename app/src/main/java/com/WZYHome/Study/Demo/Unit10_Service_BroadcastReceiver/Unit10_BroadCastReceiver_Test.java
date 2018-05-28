package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit10_Service_BroadcastReceiver.Unit10_BroadCastReceiver_Test">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <receiver android:name=".Unit10_Service_BroadcastReceiver.Unit10_BatteryBroadCastReceiver">
 <intent-filter>
 <action android:name="com.receiver.MyReceiver" />
 </intent-filter>
 </receiver>
 </application>
 */

public class Unit10_BroadCastReceiver_Test extends Activity {
    Button button22,button23,button24;
    BroadcastReceiver receiver,batteryReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit12_broadcastreceiver_test);
        receiver=new Unit10_BroadCastReceiver();
        IntentFilter filter=new IntentFilter("com.zhiyong.receiver.MyReceiver");
        registerReceiver(receiver,filter);//动态注册

        button23= (Button) findViewById(R.id.button23);
        button22= (Button) findViewById(R.id.button22);
        button24= (Button) findViewById(R.id.button24);
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.receiver.MyReceiver");
                intent.putExtra("test","test,test,test");
                sendBroadcast(intent);
            }
        });
        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDestroy();//动态取消监听
            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //注册电池广播接收器
                batteryReceiver=new Unit10_BatteryBroadCastReceiver();
                IntentFilter filter1=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
                registerReceiver(batteryReceiver,filter1);

            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(receiver);
        super.onDestroy();
    }
}
