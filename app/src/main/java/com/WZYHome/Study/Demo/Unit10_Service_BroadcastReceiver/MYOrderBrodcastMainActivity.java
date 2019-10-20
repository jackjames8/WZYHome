package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 *     <permission android:name="com.pzf.permission" android:protectionLevel="normal"></permission>

 <uses-permission android:name="com.pzf.permission"/>

 <application

 android:allowBackup="true"

 android:icon="@drawable/ic_launcher"

 android:label="@string/app_name"

 android:theme="@style/AppTheme" >

 <activity

 android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.MYOrderBrodcastMainActivity"

 android:label="@string/app_name" >

 <intent-filter>

 <action android:name="android.intent.action.MAIN" />



 <category android:name="android.intent.category.LAUNCHER" />

 </intent-filter>

 </activity>

 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.MyOrderBroadcastReciver">

 <intent-filter android:priority="1000">

 <action android:name="com.pzf.mybroadcast"></action>

 </intent-filter>

 </receiver>

 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.MyOrderBroadcastReciverTwo">

 <intent-filter android:priority="900">

 <action android:name="com.pzf.mybroadcast"></action>

 </intent-filter>

 </receiver>

 <receiver android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.MyOrderBroadcastReciverThird">

 <intent-filter android:priority="800">

 <action android:name="com.pzf.mybroadcast"></action>

 </intent-filter>

 </receiver>

 </application>
 */

public class MYOrderBrodcastMainActivity extends Activity {
    private Button btnSendOrderBroadCast;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_order_brodcast_main_activity);

        initView();

    }



    private void initView() {

        btnSendOrderBroadCast = (Button) this.findViewById(R.id.btn);

        btnSendOrderBroadCast.setOnClickListener(new MyOnclickListener());

    }



    private class MyOnclickListener implements View.OnClickListener {



        public void onClick(View v) {

            if (btnSendOrderBroadCast==v) {

                sendOrderBroadCast();

            }

        }

    }



    public void sendOrderBroadCast() {

        Intent intent = new Intent("com.pzf.mybroadcast");

        intent.putExtra("msg", "toto ni hao");

        sendOrderedBroadcast(intent, "com.pzf.permission");//第二个参数是权限问题

    }
}
