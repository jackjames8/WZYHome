package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *  <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit13_NetWork.Unit13_ConnectivityManager"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit13_ConnectivityManager extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_connectivitymanager);
        Button button28= (Button) findViewById(R.id.button28);
        final TextView textView43= (TextView) findViewById(R.id.textView43);
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取系统网络管理对象，通过它得到在线网络状态信息.
                ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                //如果是断网的情况下,connectivityManager.getActiveNetworkInfo()获取一个null值,null是不能调用函数的
                NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
                if (networkInfo==null){
                    textView43.setText("UnConnected");
                }else if(networkInfo.getState().equals(NetworkInfo.State.CONNECTED)){
                    textView43.setText("Connected");
                }else {
                    textView43.setText("UnConnected");
                }


            }
        });
    }
}
