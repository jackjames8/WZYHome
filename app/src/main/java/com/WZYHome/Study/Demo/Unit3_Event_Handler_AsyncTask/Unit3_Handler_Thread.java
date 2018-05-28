package com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit3.Unit3_Handler_Thread"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit3_Handler_Thread extends Activity {
    private Handler handler=new Handler(){
        //接收并处理UI组件发来的message
        @Override
        public void handleMessage(Message msg) {
            TextView textView41_message= (TextView) findViewById(R.id.textView41_message);
            switch (msg.what){
                case result_cancel:
                    /*if(msg.arg1==cancel_byUser)*/
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
    MyThread  myThread=new MyThread();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit3_handler);
        Button btn= (Button) findViewById(R.id.button20_handlerMessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myThread.start();
            }
        });
        btn= (Button) findViewById(R.id.btn_cancelMessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点cancel终止线程
                myThread.interrupt();
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(result_cancel);

            }
        });

    }
    //创建一个MyThread线程去运行耗时的操作，等子线程完成了任务，通知主线程去更新界面或其它操作,这样UI主线程不会卡
      class MyThread extends Thread{
          @Override
          public void run() {
              super.run();
              try {
                  sleep(6*1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              handler.sendEmptyMessage(Result_OK);//请该线程sleep(6*1000)休眠6秒钟再发送消息
          }

      }

}
