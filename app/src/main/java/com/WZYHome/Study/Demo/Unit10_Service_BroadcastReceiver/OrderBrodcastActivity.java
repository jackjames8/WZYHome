package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.WZYHome.Study.Demo.R;

/**
 *  <application

 android:allowBackup="true"

 android:icon="@drawable/ic_launcher"

 android:label="@string/app_name"

 android:theme="@style/AppTheme" >

 <activity

 android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.OrderBrodcastActivity"

 android:label="@string/app_name" >

 <intent-filter>

 <action android:name="android.intent.action.MAIN" />



 <category android:name="android.intent.category.LAUNCHER" />

 </intent-filter>

 </activity>



 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.Level1Receiver" >

 <intent-filter android:priority="1000" >

 <action android:name="com.itheima.broadcasttest.songwennuan" />

 </intent-filter>

 </receiver>

 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.Level2Receiver" >

 <intent-filter android:priority="500" >

 <action android:name="com.itheima.broadcasttest.songwennuan" />

 </intent-filter>

 </receiver>

 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.Level3Receiver" >

 <intent-filter android:priority="100" >

 <action android:name="com.itheima.broadcasttest.songwennuan" />

 </intent-filter>

 </receiver>

 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.FinalReceiver" >

 <intent-filter android:priority="0" >

 <action android:name="com.itheima.broadcasttest.songwennuan" />

 </intent-filter>

 </receiver>

 </application>

 */

public class OrderBrodcastActivity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.order_brodcast_activity);

    }



    /**

     * 发送无序广播

     * @param view

     */

    public void send1(View view) {

        Intent intent = new Intent();

        intent.setAction("com.itheima.broadcasttest.songwennuan");

        intent.putExtra("msg", "发1万块");

        //无序广播，不可被拦截，不可终止

        sendBroadcast(intent);//无序广播都听得到

    }



    public void send2(View view) {

        Intent intent = new Intent();

        intent.setAction("com.itheima.broadcasttest.songwennuan");

        //有序广播，可被拦截，可终止，可以修改数据

//        sendOrderedBroadcast(intent, null,new FinalReceiver(),null,0,"给农民兄弟发10000块钱",null);//new FinalReceiver()指定一定会发给FinalReceiver()
        sendOrderedBroadcast(intent, null,null,null,0,"给农民兄弟发10000块钱",null);
    }
}
