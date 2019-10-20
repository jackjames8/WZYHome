package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.NotificationTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class NotificationTest extends AppCompatActivity {
    Button Notification,button_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_notification);
        Notification= (Button) findViewById(R.id.Notification);
        button_cancel= (Button) findViewById(R.id.button_cancel);
        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification.Builder builder=new Notification.Builder(NotificationTest.this);
                builder.setContentTitle("test")
                .setContentText("this is test")
                .setSmallIcon(R.drawable.feiji_1);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(),0,new Intent(getApplicationContext(),Intent_Login.class),PendingIntent.FLAG_UPDATE_CURRENT);
                /*builder.setContentIntent(pi);//当触摸通知信息的时候，弹出登录窗口;*/
                builder.setDeleteIntent(pi);
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.notify(1,builder.getNotification());

            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.cancel(1);

            }
        });


    }
}
