package com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask.Unit3_Handler"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 </manifest>
 */

public class Unit3_Handler extends AppCompatActivity {
   private Handler handler=new Handler(){
        //接收并处理UI组件发来的message
        @Override
        public void handleMessage(Message msg) {
            TextView textView41_message= (TextView) findViewById(R.id.textView41_message);
            switch (msg.what){
                case result_cancel:
                    if(msg.arg1==cancel_byUser)
                    textView41_message.setText("cancel_byUser"+cancel_byUser);
                    break;
                case Result_OK:
                    textView41_message.setText("OK");
                    break;
                    default:
                        break;
            }

            //Log.i("handle","handleMessage msg.what="+msg.what);
        };
    };
    private static final int Result_OK=13;
    private static final int result_cancel=14;
    private static final int cancel_byUser=15;
    private static final int cancel_bySystem=16;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit3_handler);
        Button btn= (Button) findViewById(R.id.button20_handlerMessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Message msg=new Message();
                msg.what=Result_OK;
                handler.sendMessage(msg);//通过UI主线程创建一个handler对像发送消息;*/
                //通过sendEmptyMessage()直接发送一个变量过去，是上面创建msg对象的简化版
                // handler.sendEmptyMessage(Result_OK);
                handler.sendEmptyMessageDelayed(Result_OK,6*1000);//时间间隔6秒发送Result_OK消息
            }
        });
         btn= (Button) findViewById(R.id.btn_cancelMessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Message msg=Message.obtain();
                msg.what=result_cancel;
                msg.arg1=cancel_byUser;//msg.arg1是传递整数类型的参数
                handler.sendMessage(msg);//通过UI主线程创建一个handler对像发送消息;*/
                handler.removeMessages(Result_OK);//取消Result_OK消息
            }
        });

    }


}
