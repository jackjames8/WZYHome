package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

/**
 *  <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit13_NetWork.Unit13_HttpURLConnection"
 android:theme="@style/AppBaseTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit13_HttpURLConnection extends Activity {
    static final String URL_STRING="http://39.108.161.138:9859/VehicleVMS/api/VehicleTypeInfo";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_http_url_connection);
        Button button29= (Button) findViewById(R.id.button29);
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsyncTask().execute();
            }
        });
    }
    class MyAsyncTask extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... params) {

            try {
                //以下通过直接获取URLConnection实例，读取网络API信息
                java.net.URL url=new java.net.URL(URL_STRING);
                HttpURLConnection cn= (HttpURLConnection) url.openConnection();
                InputStream inputStream=cn.getInputStream();
                StringBuffer stringBuffer=new StringBuffer();
                int c=0;
                while ((c=inputStream.read())!=-1){
                    stringBuffer.append((char)c);
                }
                 return stringBuffer.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView textView44= (TextView) findViewById(R.id.textView44);
            textView44.setText(s);
        }
    }
}
