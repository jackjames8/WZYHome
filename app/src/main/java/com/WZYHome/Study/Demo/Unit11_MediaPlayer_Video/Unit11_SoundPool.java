package com.WZYHome.Study.Demo.Unit11_MediaPlayer_Video;

import android.app.Activity;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.WZYHome.Study.Demo.R;

import java.io.IOException;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit11_MediaPlayer_Video.Unit11_SoundPool">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit11_SoundPool extends Activity {
    SoundPool soundPool;
    //开辟两个数组空间来存两个数;
    int res[]=new int[2];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_soundpool);
        PreparesoudPool();
        ImageButton btn_play= (ImageButton) findViewById(R.id.btn_play1);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(res[0],1.0f,1.0f,0,0,1.0f);
            }
        });
        btn_play= (ImageButton) findViewById(R.id.btn_play2);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(res[1],1.0f,1.0f,0,0,1.0f);
            }
        });
    }
    public void PreparesoudPool(){
        soundPool=new SoundPool(4, AudioManager.STREAM_MUSIC,1);
        try {
           res[0] =soundPool.load(getAssets().openFd("shot.mp3"),1);
            res[1] =soundPool.load(getAssets().openFd("bomb.mp3"),1);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
