package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit10_Service_BroadcastReceiver.DynamicReceiverTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>

 </application>
 */

    public class DynamicReceiverTest extends AppCompatActivity {
        DynamicReceiver dynamicReceiver;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.dynamic_receiver);
            IntentFilter filter = new IntentFilter();
            filter.addAction("fuckYou");
            filter.setPriority(1000);//设置动态优先级
            dynamicReceiver = new DynamicReceiver();
            registerReceiver(dynamicReceiver,filter);
        }
        //静态广播点击
        public void send(View v){
            Intent intent = new Intent();
            //设置与动态相同的Action，方便同时触发静态与动态
            intent.setAction("fuckYou");
            intent.putExtra("info","fuck you");
            intent.putExtra("inf","fuck me");
            sendBroadcast(intent);//默认广播
        }
        @Override
        protected void onPause() {
            super.onPause();
            unregisterReceiver(dynamicReceiver);
        }
        class DynamicReceiver extends BroadcastReceiver{
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast t = Toast.makeText(context,"动态广播："+ intent.getStringExtra("info"), Toast.LENGTH_SHORT);
                t.setGravity(Gravity.TOP,0,0);
                t.show();
                Toast.makeText(context,"动态广播："+ intent.getStringExtra("inf"), Toast.LENGTH_SHORT).show();
            }
        }
    }

