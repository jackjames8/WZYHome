package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2018/7/16.
 */

public class MyOrderBroadcastReciverTwo extends BroadcastReceiver {



    private static final String TAG = "BroadCast";



    @Override

    public void onReceive(Context context, Intent intent) {

        //abortBroadcast();  //开启此处，可以截断广播，不让它传到third中

        String strMsg = intent.getStringExtra("msg");   //获取广播的原始数据



        Log.i(TAG, "第二个界面传过来的" + strMsg);

        Bundle extras = new Bundle();

        extras.putString("msg", "第二个界面传过来的" + strMsg);

        setResultExtras(extras); //继续向下传



        //"第二个:"+strMsg这是two中新的数据，传递到third中,

        //在third中是用getResultData来获得setResultData("")中的数据

        setResultData("第二个：" + strMsg);

    }



}