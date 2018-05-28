package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService2 extends Service {

    public MyService2() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this,"我已经启动了MyService2",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
