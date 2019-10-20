package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2018/7/16.
 */

public class Level3Receiver extends BroadcastReceiver {

    private static final String TAG = "Broadcasttest";



    @Override

    public void onReceive(Context context, Intent intent) {

        String message = getResultData();

        Log.i(TAG, "乡级部门得到市的消息：" + message);

        setResultData("给农民兄弟发两大大米");

    }



}