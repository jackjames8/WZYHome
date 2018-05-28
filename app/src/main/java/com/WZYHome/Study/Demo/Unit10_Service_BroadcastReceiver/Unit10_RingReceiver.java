package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/7/15.
 */

public class Unit10_RingReceiver extends BroadcastReceiver {
    public Unit10_RingReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"caling coming....",Toast.LENGTH_LONG).show();
    }
}
