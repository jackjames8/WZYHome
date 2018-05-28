package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/14.
 */

public class Unit10_BroadCastReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("com.receiver.MyReceiver")){
        String test=intent.getStringExtra("test");
        Toast.makeText(context,test,Toast.LENGTH_LONG).show();
        }

        if(intent.getAction().equals("android.intent.action.PHONE_STATE")){
            Toast.makeText(context,"快接电话了",Toast.LENGTH_LONG).show();

        }
    }
}
