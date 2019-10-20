package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2018/7/16.
 */

public class FinalReceiver extends BroadcastReceiver {

    private static final String TAG = "Broadcasttest";



    @Override

    public void onReceive(Context context, Intent intent) {

        String message = getResultData();

        Log.i(TAG, "农民兄弟得到乡的消息：" + message+1);

    }

}