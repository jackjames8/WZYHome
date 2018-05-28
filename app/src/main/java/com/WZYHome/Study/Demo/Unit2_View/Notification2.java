package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Notification2">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <activity
 android:name=".Unit2_View.Intent_Login">
 </activity>
 </application>
 */

public class Notification2 extends Activity {
    Button button21;
    static final int Notification_ID=0x001;
    int count=0;
    boolean isPause;
    boolean flag;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_notification2);
        flag=true;
        button21= (Button) findViewById(R.id.button21);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Notification2.this,Intent_Login.class);
                startActivity(intent);
            }
        });
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                while (flag) {
                    if (!isPause) {
                        count++;
                        Log.i("count", count + "");
                    }
                }

            }
        }, 5000);

    }
    @Override
    protected void onPause() {
        isPause=true;
        showNotification();
        super.onPause();
    }

    private void showNotification() {
        Notification.Builder build=new Notification.Builder(this);
        build.setContentTitle("运行提示")
                .setContentText("ACtivity正在运行")
                .setSmallIcon(R.drawable.feiji_2);
        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,new Intent(Notification2.this,Notification2.class),PendingIntent.FLAG_UPDATE_CURRENT);
        build.setContentIntent(pi);
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(Notification_ID,build.getNotification());

    }

    @Override
    protected void onResume() {
        isPause=false;
        HiddenNotification();
        super.onResume();
    }


    private void HiddenNotification() {
        NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.cancel(Notification_ID);

    }

    @Override
    protected void onDestroy() {
        flag=false;
        super.onDestroy();
    }
}
