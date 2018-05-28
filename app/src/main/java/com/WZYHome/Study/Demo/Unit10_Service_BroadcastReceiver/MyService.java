package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

/**
 * 服务是在主线程中运行的，所以服务不能写耗时操作，如果要写耗时操作，只能写在子线程中(new Thread)。
 */
public class MyService extends Service {
    MyThread MyThread;
    Boolean isRun;
    Handler mHandler;
    int count;
    static final String TAG = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MyThread=new MyThread();
        MyThread.start();
        isRun=true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String extras = intent.getStringExtra("fromActiviy");
        Toast.makeText(this,"得到Acitivity中的数据"+extras,Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {//在服务中检测服务是否绑定
        //此方法只调用一次
        MyServiceBind bind=new MyServiceBind();
        bind.setCount(count);
        return bind;
    }
    @Override
    public boolean onUnbind(Intent intent) {////在服务中检测服务是否断开
        System.out.print("MyService-----onUnbind");
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "MyService-onDestroy");
        isRun=false;
    }
    public class MyThread extends Thread{

        @Override
        public void run() {
            super.run();
                while (isRun) {
                    SystemClock.sleep(500);
                    if(mHandler!=null) {
                        Message message = Message.obtain();
                        message.arg1 = count;
                        mHandler.sendMessage(message);
                    }
                    System.out.println("当前已经执行到此----〉" + count);
                    count++;
                    if(count==10){

                       Intent intent=new Intent(MyService.this,pendingIntent2.class);
                        //从Activity之外启动Activity,必须加上下面这句
                       intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                       startActivity(intent);
                    }
                }


        }
    }
    class MyServiceBind extends Binder {
     int count;
        public  void setHandler(Handler myHandler){
            mHandler=myHandler;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
