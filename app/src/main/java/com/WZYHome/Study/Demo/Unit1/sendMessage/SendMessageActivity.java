package com.WZYHome.Study.Demo.Unit1.sendMessage;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Util.LogUtil;

/**
 * Created by Administrator on 2018/1/18.
 * function模拟发送短信
 * <uses-permission android:name="android.permission.INTERNET"/>
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
 <uses-permission android:name="android.permission.SEND_SMS"></uses-permission>

 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/CustomTheme">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit1.sendMessage.SendMessageActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>

 */

public class SendMessageActivity extends AppCompatActivity{
    EditText phoneEditText,sendContentEditText;
    Button sendMessageButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_message_activity);
        phoneEditText= (EditText) findViewById(R.id.phoneEditText);
        sendContentEditText= (EditText) findViewById(R.id.sendContentEditText);
        sendMessageButton= (Button) findViewById(R.id.sendMessageButton);
        
        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SendMessageActivity.this,"我点了",Toast.LENGTH_SHORT).show();
                String phoneNum = phoneEditText.getText().toString();
                String ContentEditText = sendContentEditText.getText().toString().trim();
                SmsManager smsManager=SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNum,"110",ContentEditText,null,null);
                LogUtil.LogI("nihao",phoneNum);

            }
        });

    }
}
