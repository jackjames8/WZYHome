package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Administrator on 2018/7/16.
 */

public class Level1Receiver extends BroadcastReceiver {
    private static final String TAG = "Broadcasttest";



    @Override

    public void onReceive(Context context, Intent intent) {

        String message = getResultData();

        Log.i(TAG,"省级部门得到中央的消息:" + message);

//      abortBroadcast();  //这里是终止了消息,可以关闭或者取消这里查看LogCat中打印的效果。

        setResultData("给农民兄弟发5000块钱");

    }
}
