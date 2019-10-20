package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by Administrator on 2018/7/16.
 */
public class MyOrderBroadcastReciverThird extends BroadcastReceiver {

    private static final String TAG = "BroadCast";



    @Override

    public void onReceive(Context context, Intent intent) {

        //获得two中setResultData中的数据

        String resultData = getResultData();

        //获取two中setResultExtras中的数据

        Bundle bundle = getResultExtras(true);

        //获取广播的原始数据

        String bundleData = bundle.getString("msg");



        //获取广播的原始数据

        String strMsg = intent.getStringExtra("msg");

        Log.i(TAG, "第三个：" + strMsg);



        Log.i(TAG,"two中传递到third新的数据：" + resultData);

        Log.i(TAG, "two中setResultExtras(extras)传到third新的数据：" + bundleData);

    }

}