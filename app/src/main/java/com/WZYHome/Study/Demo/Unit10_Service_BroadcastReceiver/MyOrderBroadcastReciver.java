package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2018/7/16.
 */

public class MyOrderBroadcastReciver extends BroadcastReceiver {



    private static final String TAG = "BroadCast";



    @Override

    public void onReceive(Context context, Intent intent) {

        String strMsg = intent.getStringExtra("msg");

        Log.i(TAG, "第一个:" + strMsg);

        //通过Bundle传递参数

        Bundle extras = new Bundle();

        extras.putString("msg", "第一个界面传过来的" + strMsg);

        setResultExtras(extras);//继续向下传

    }

}