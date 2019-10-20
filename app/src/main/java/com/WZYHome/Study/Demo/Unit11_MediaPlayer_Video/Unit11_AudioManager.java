package com.WZYHome.Study.Demo.Unit11_MediaPlayer_Video;
import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit11_MediaPlayer_Video.Unit11_AudioManager">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit11_AudioManager extends Activity {
    AudioManager am;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_audiomanager);
        Button btn= (Button) findViewById(R.id.btn_down);
        btn.setOnClickListener(Listener);
        btn= (Button) findViewById(R.id.btn_up);
        btn.setOnClickListener(Listener);
        //得到系统多媒体管理器
         am= (AudioManager) getSystemService(AUDIO_SERVICE);
    }
    View.OnClickListener Listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_down:
                    //AudioManager.STREAM_ALARM闹钟的音量调节　
                    am.adjustStreamVolume(AudioManager.STREAM_ALARM,AudioManager.ADJUST_LOWER,AudioManager.FLAG_SHOW_UI);
                    break;
                case R.id.btn_up:
                    am.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE,AudioManager.FLAG_PLAY_SOUND);
                    break;
                default:
                    break;
            }
        }
    };
}
