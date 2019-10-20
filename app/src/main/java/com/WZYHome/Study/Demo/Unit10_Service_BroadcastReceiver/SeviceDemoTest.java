package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity android:name=".Unit10_Service_BroadcastReceiver.SeviceDemoTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>

 <service
 android:name=".Unit10_Service_BroadcastReceiver.MyService"
 android:enabled="true"
 android:exported="false" />
 <service
 android:name=".Unit10_Service_BroadcastReceiver.MyService2"
 android:enabled="true"
 android:exported="false">
 <intent-filter>
 <action android:name="android.intent.action.heheMyService2" />
 </intent-filter>
 </service>
 </application>
 */

public class SeviceDemoTest extends AppCompatActivity {
    Intent intent;
    MyService.MyServiceBind binder;
    static final String TAG = "SeviceDemoTest";
    TextView serviceValueTextView,clickGetValueTextView;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            serviceValueTextView.setText("从服务器得到的数据"+ msg.arg1);
        }
    };
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {//监听服务是否连接
            Log.i(TAG, "onServiceConnected");
            binder=(MyService.MyServiceBind)iBinder;
            binder.setHandler(mHandler);//建立连接后，把mHandler传递过去

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {//监听服务是否断开
            Log.i(TAG, "onServiceDisconnected");


        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sevice_demo);
        serviceValueTextView= (TextView) findViewById(R.id.serviceValueTextView);
        clickGetValueTextView= (TextView) findViewById(R.id.clickGetValueTextView);
    }

    /**
     *
     * @param view 当点击线程运行后,即使关闭了UI线程，后台线程依然运行
     */
    public void go1(View view){
        Toast.makeText(this,"点击了go1",Toast.LENGTH_SHORT).show();
        intent=new Intent(this,MyService.class);
        intent.putExtra("fromActiviy","fromActiviy");
        //启动服务
        this.startService(intent);

    }
    public void go3(View view){
        //隐式方式启动,
        Intent intent=new Intent("android.intent.action.heheMyService2");
        //如果是5.0以后的系统就要设置包名,不然会报错
        intent.setPackage("com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver");
        startService(intent);

    }
    public void go4(View view){//绑定服务
        Intent intent = new Intent(SeviceDemoTest.this,MyService.class);
        bindService(intent,conn,BIND_IMPORTANT);//BIND_AUTO_CREATE如果服务没有创建，则自动创建
    }
    public void go5(View view){//获取绑定后的数据
        int count = binder.getCount();
        clickGetValueTextView.setText("从服务器得到的数据"+count);
        /*Toast.makeText(this,"从服务器得到的数据"+getdata,Toast.LENGTH_SHORT).show();*/
    }
    public void go6(View view){//解除绑定
        unbindService(conn);//BIND_AUTO_CREATE如果服务没有创建，则自动创建
        Toast.makeText(this,"点击了go2",Toast.LENGTH_SHORT).show();
        //启动服务,显示方式启动
        Intent intent=new Intent(this,MyService.class);
        stopService( intent);//关闭服务,会调用服务MyService中的destroy()方法
    }
}
