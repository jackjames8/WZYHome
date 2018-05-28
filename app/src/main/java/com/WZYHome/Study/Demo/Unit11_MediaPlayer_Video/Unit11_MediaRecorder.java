package com.WZYHome.Study.Demo.Unit11_MediaPlayer_Video;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

import java.io.File;
import java.io.IOException;

/**
 * <uses-permission android:name="android.permission.RECORD_AUDIO"/>
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit11_MediaPlayer_Video.Unit11_MediaRecorder">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit11_MediaRecorder extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_mediarecorder);
        Button btn = (Button) findViewById(R.id.btn_start);
        btn.setOnClickListener(Listener);
        btn = (Button) findViewById(R.id.btn_stop);
        btn.setOnClickListener(Listener);
        btn = (Button) findViewById(R.id.btn_play);
        btn.setOnClickListener(Listener);
    }

    View.OnClickListener Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_start:
                    start_record();
                    break;
                case R.id.btn_stop:
                    stop_record();
                    break;
                case R.id.btn_play:
                    play();
                    break;
                default:
                    break;


            }
        }

        ;

    };
    MediaRecorder mediaRecorder;
    void start_record(){
        mediaRecorder=new MediaRecorder();
        //设置是麦克风数据输入
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        //设置输出格式是默认
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        //设置默认录音编码格式
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        //设置保存路径
        mediaRecorder.setOutputFile(getRecordFilePath());
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaRecorder.start();
    }
    String getRecordFilePath(){
        return getExternalFilesDir("record").getAbsolutePath()+"/sound.amr";
    }
    void stop_record(){
         mediaRecorder.stop();
        mediaRecorder.reset();;
    }
    void play(){
        Intent intent=new Intent();
        //委托系统去打开这个intent
        intent.setAction(Intent.ACTION_VIEW);
        //定义intent数据
        intent.setDataAndType(Uri.fromFile(new File(getRecordFilePath())),"audio/amr");
        startActivity(intent);
    }
}
