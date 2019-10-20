package com.WZYHome.Study.Demo.Unit11_MediaPlayer_Video;

import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.io.IOException;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit11_MediaPlayer_Video.Unit11_MediaPlayer">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit11_MediaPlayer extends AppCompatActivity {
    MediaPlayer mediaPlayer=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_mediaplayer);
        PrepareMusic();
        ImageButton btn= (ImageButton) findViewById(R.id.btn_play);
        btn.setOnClickListener(MyOnClickListener);
        btn= (ImageButton) findViewById(R.id.btn_pause);
        btn.setOnClickListener(MyOnClickListener);
        btn= (ImageButton) findViewById(R.id.btn_stop);
        btn.setOnClickListener(MyOnClickListener);
    }
    View.OnClickListener MyOnClickListener= new View.OnClickListener() {

        public void onClick(View v) {
           switch (v.getId()){
               case R.id.btn_play:
                   mediaPlayer.start();
                   Toast.makeText(getApplicationContext(),"点击了start",Toast.LENGTH_LONG).show();
                   break;
               case R.id.btn_pause:
                   mediaPlayer.pause();
                   Toast.makeText(getApplicationContext(),"点击了pause",Toast.LENGTH_LONG).show();
                   break;
               case R.id.btn_stop:
                   mediaPlayer.stop();//执行Stop()操作后,meadiaPlayer就会回到初始状态;
                   Toast.makeText(getApplicationContext(),"点击了stop",Toast.LENGTH_LONG).show();
                   break;
               default:
                   break;
           }

        }
    };
        void PrepareMusic(){
           mediaPlayer=new MediaPlayer();
        /*AssetManager am = getAssets();*/
        try {
           /* AssetFileDescriptor afd = getAssets().openFd("Backstreet.mp3");*/
            mediaPlayer.setDataSource(getAssets().openFd("Backstreet.mp3").getFileDescriptor());
            /*mediaPlayer.setDataSource(am.openFd("Backstreet.mp3").getFileDescriptor());*/
            mediaPlayer.prepare();//阻塞操作

        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }catch(IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
