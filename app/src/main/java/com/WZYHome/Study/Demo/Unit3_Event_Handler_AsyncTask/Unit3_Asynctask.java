package com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
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
 android:name=".Unit3.Unit3_Asynctask"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit3_Asynctask extends Activity {
    Button button20_handlerMessage;
    TextView txt;
    MyAsyncTask myAsyncTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit3_handler);
        txt= (TextView) findViewById(R.id.textView41_message);
        button20_handlerMessage= (Button) findViewById(R.id.button20_handlerMessage);
        button20_handlerMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAsyncTask=new MyAsyncTask();
                myAsyncTask.execute(10);

            }
        });
        Button btn= (Button) findViewById(R.id.btn_cancelMessage);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //调用cancel方法回调onCancelled()方法.
                myAsyncTask.cancel(true);
                /*myAsyncTask=null;*/
            }
        });
    }
    //当应用程序被关掉的时候，回调onDestroy()方法删除myAsyncTask对象实例;
    @Override
    protected void onDestroy(){
        if (myAsyncTask!=null){
            myAsyncTask.cancel(true);
        }
    }


    class MyAsyncTask extends AsyncTask<Integer,Integer,Boolean>{
        //在执行阻塞操作之前初始化就会调用onPreExecute()方法
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txt.setText("start");
        }
        @Override
        protected Boolean doInBackground(Integer[] params) {

            //下面做一个阻塞操作
            try {
                for(int i=0;i<params[0];i++){
                    //如果调用了 myAsyncTask.cancel(true);则直接取消这个线程
                    if(isCancelled()){
                        break;
                    }
                    Log.i("1 second","txt,pass");
                    //通过调用 publishProgress(null);回调onProgressUpdate()方法去更新;
                    publishProgress(i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        //当执行doInBackground()方法时会执行下面的方法onProgressUpdate()去更新
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txt.setText(values[0]+"+");
        }

        //doInBackground()方法阻塞操作完成以后，会调用下面的onPostExecute()方法
        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            txt.setText("finish"+result);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            txt.setText("canceled");
        }
    }
}
