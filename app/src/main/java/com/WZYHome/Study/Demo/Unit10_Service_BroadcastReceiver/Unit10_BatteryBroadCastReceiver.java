package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/14.
 */

public class Unit10_BatteryBroadCastReceiver extends BroadcastReceiver {
    public Unit10_BatteryBroadCastReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
        Toast.makeText(context,"当前电池量:"+level,Toast.LENGTH_LONG).show();
    }
}
