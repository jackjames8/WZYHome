package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2018/5/2.
 */

public class MusicServiceTest extends AppCompatActivity{
    Button loadMusic,playMusic;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playMusic= (Button) findViewById(R.id.playMusic);
        loadMusic= (Button) findViewById(R.id.loadMusic);
        playMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        loadMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
