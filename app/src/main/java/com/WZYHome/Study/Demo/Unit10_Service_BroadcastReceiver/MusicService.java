package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/11.
 */

public class MusicService extends Service {
    static final String TAG="MUSICPLAYER";
    MediaPlayer player=new MediaPlayer();
    public MusicService() {
        super();
    }

    @Override
    public void onCreate() {
        Log.i(TAG,"onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.i(TAG,"onStartCommand");
        play();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void play() {
        if (Environment.getExternalStorageDirectory().equals(Environment.MEDIA_MOUNTED)) {
            try {
                player.setDataSource(Environment.getExternalStorageDirectory() +"/start.mp3");
                player.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            player.start();
        }else {
            Toast.makeText(getApplicationContext(),"SD卡没准备好",Toast.LENGTH_LONG).show();
        }
    }
}
