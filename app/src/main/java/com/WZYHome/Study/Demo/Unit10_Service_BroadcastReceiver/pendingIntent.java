package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.WZYHome.Study.Demo.R;

/**
 *     <uses-permission android:name="android.permission.CALL_PHONE" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.WRITE_CONTACTS" />
 <uses-permission android:name="android.permission.CAMERA" />

 <!-- To auto-complete the email text field in the login form with the user's emails -->
 <uses-permission android:name="android.permission.GET_ACCOUNTS" />
 <uses-permission android:name="android.permission.READ_PROFILE" />
 <uses-permission android:name="android.permission.READ_CONTACTS" />

 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.pendingIntent">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <activity android:name="com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.pendingIntent2">
 </activity>


 </application>

 */

public class pendingIntent extends AppCompatActivity {
    NotificationManager mNotificationManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_intent);
        mNotificationManager= (NotificationManager) getSystemService(Service.NOTIFICATION_SERVICE);//传杆器服务
    }
    public void go1(View view){
        /**
         * PendingIntent.FLAG_NO_CREATE不会创建
         * PendingIntent.FLAG_CANCEL_CURRENT取后面的Notification的值(如果两个notification的requestCode码一样的样)
         * PendingIntent.FLAG_ONE_SHOT取前面的值,只能赋值一次(如果两个notification的requestCode码一样的样)
         * PendingIntent.FLAG_UPDATE_CURRENT一直会更新(如果两个notification的requestCode码一样的样)
         *110这个requestCode码应该要两个不同的码，这样就两个不同的notification
         */
        Intent intent=new Intent(this,pendingIntent2.class);
        intent.putExtra("data","1111111");
        PendingIntent pendingIntent=PendingIntent.getActivity(this,110,intent,PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder builder=new Notification.Builder(this)
                .setContentText("消息１１１")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent);
        mNotificationManager.notify(123,builder.getNotification());

    }
    public void go2(View view){
        Intent intent=new Intent(this,pendingIntent2.class);
        intent.putExtra("data","2222222");
        PendingIntent pendingIntent=PendingIntent.getActivity(this,110,intent,PendingIntent.FLAG_ONE_SHOT);
        Notification.Builder builder=new Notification.Builder(this)
                .setContentText("消息222")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(pendingIntent);
        mNotificationManager.notify(222,builder.getNotification());

    }
}
