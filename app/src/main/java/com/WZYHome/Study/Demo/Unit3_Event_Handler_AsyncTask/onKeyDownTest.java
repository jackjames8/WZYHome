package com.WZYHome.Study.Demo.Unit3_Event_Handler_AsyncTask;

import android.app.Activity;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.view.View.OnKeyListener;
import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2018/2/28.
 */

public class onKeyDownTest extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onkey_down_test);
        Button bn = (Button) findViewById(R.id.bn);
        // 为bn绑定事件监听器
        bn.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View source
                    , int keyCode, KeyEvent event) {
                // 只处理按下键的事件,按下键盘上的键,才会触发该事件
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    Log.v("-Listener-", "the onKeyDown in Listener");
                }
                // 返回false，表明该事件会向外传播
                return false; // ①
                /**
                 * 当return false时打印结果
                 * 02-28 23:06:28.419 9398-9398/com.example.administrator.myapplication V/-Listener-: the onKeyDown in Listener
                 02-28 23:06:28.419 9398-9398/com.example.administrator.myapplication V/-MyButton-: the onKeyDown in MyButton
                 02-28 23:06:28.419 9398-9398/com.example.administrator.myapplication V/-Activity-: the onKeyDown in Activity
                 */
            }
        });
    }
    // 重写onKeyDown方法，该方法可监听它所包含的所有组件的按键被按下事件
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        super.onKeyDown(keyCode , event);
        Log.v("-Activity-" , "the onKeyDown in Activity");
        //返回false，表明并未完全处理该事件，该事件依然向外扩散
        return false;
    }
}
