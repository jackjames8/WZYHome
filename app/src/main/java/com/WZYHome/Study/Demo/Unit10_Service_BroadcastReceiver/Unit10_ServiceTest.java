package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit10_Service_BroadcastReceiver.Unit10_ServiceTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <service
 android:name=".Unit10_Service_BroadcastReceiver.Unit10_Service">
 </service>

 </application>
 service 生命周期常用手动方法startService-->stopService-->bindService--->unbindService
 自动调用方法---onCreate-->onstartCommand-->onbind ->onunbind-->ondestroy
 */


public class Unit10_ServiceTest extends Activity {
    private Button btnStartService;
    private Button btnStopService ,btnBindService,UnBindService,button18;
    Unit10_Service.MyBind binder;

    //得到联系后的数据
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(Unit10_Service.TAG, "onServiceConnected");
            binder=(Unit10_Service.MyBind)iBinder;


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {


        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_service);
        btnStartService = (Button)findViewById(R.id.button11);
        btnStopService = (Button)findViewById(R.id.button14);
        btnBindService= (Button) findViewById(R.id.button15);
        UnBindService= (Button) findViewById(R.id.button17);
        button18= (Button) findViewById(R.id.button18);
        btnStartService.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Unit10_ServiceTest.this,Unit10_Service.class);
                startService(intent);
            }
        });
        btnStopService.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Unit10_ServiceTest.this,Unit10_Service.class);
                stopService(intent);
            }
        });
        btnBindService.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Unit10_ServiceTest.this,Unit10_Service.class);
                bindService(intent,conn,BIND_AUTO_CREATE);
            }
        });
        UnBindService.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(conn);
            }
        });
        button18.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int cnt=binder.getdata();
                Toast.makeText(Unit10_ServiceTest.this,cnt+"",Toast.LENGTH_LONG).show();
            }
        });
    }
}