package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver.MusicService;

import java.util.Timer;
import java.util.TimerTask;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.progressbarGameStart">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <activity
 android:name=".Unit2_View.option">
 </activity>

 </application>
 */

public class progressbarGameStart extends AppCompatActivity {
   static final int ITEM_OPTION = 0x111;
    static final int ITEM_ORDER = 0x112;
    RelativeLayout layoutC;
    ProgressBar progressBar3;
    TextView textView23;
    Button button12;
    Timer timer=new Timer();//定时器
    int progress=0;
    boolean isPause=false;
    static final int REQUEST_CODE=0x115;
    static final int RESULT_CODE=0X116;
    static final int RESULT_USERNAME=0X117;
    String bgMusic="开";
    String bgSound="开";
    String bgPlane="机型一";
    String str="";
    android.os.Handler handler=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0x001:
                    progressBar3.setVisibility(View.VISIBLE);
                    textView23.setVisibility(View.VISIBLE);
                    progressBar3.setProgress(progress);
                    break;
                case 0x002:
                    textView23.setText("游戏加载完成");
                    progressBar3.setVisibility(View.INVISIBLE);
                    task.cancel();
                    timer.cancel();
                    break;
            }

        }
    };
    TimerTask  task=new TimerTask() {
        @Override
        public void run() {
            if(progress<100){
                if(isPause==false){
            progress++;
            Log.i("test",progress+"");
                handler.sendEmptyMessage(0x001);
                }

            }else {
                handler.sendEmptyMessage(0x002);
            }
        }
    };//每次触发要做的工作

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit6_progressbartest);
        layoutC= (RelativeLayout) findViewById(R.id.layoutC);
        Intent service=new Intent(progressbarGameStart.this,MusicService.class);
        startService(service);
        registerForContextMenu(layoutC);
        progressBar3= (ProgressBar) findViewById(R.id.progressBar3);
        textView23= (TextView) findViewById(R.id.textView23);
        textView23.setVisibility(View.INVISIBLE);
        progressBar3.setVisibility(View.INVISIBLE);

        button12= (Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.schedule(task,0,100);
            }
        });

    }
    @Override
    protected void onPause() {
        isPause=true;
        super.onPause();
    }
    @Override
    protected void onResume()
    {
        isPause=false;
        super.onResume();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        SubMenu subMenu=menu.addSubMenu(Menu.NONE,0,0,"设置");
        subMenu.add(0, ITEM_OPTION, 0, "游戏设置");
        subMenu.add(0, ITEM_ORDER, 0, "英雄排行榜");
    }

    @Override
    public boolean onContextItemSelected(MenuItem menu)
    {
        switch (menu.getItemId())
        {
            case ITEM_OPTION:
                textView23.setVisibility(View.VISIBLE);
                textView23.setText("游戏设置");
                Intent intent=new Intent(progressbarGameStart.this,option.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case ITEM_ORDER:
                textView23.setVisibility(View.VISIBLE);
                textView23.setText("英雄排行榜");
                break;
        }
        return true;
    }
    // 当用户单击MENU键时触发该方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // -------------向menu中添加普通菜单项-------------
        menu.add(0, ITEM_OPTION, 0, "游戏设置");
        menu.add(0, ITEM_ORDER, 0, "英雄排行榜");
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    // 选项菜单的菜单项被单击后的回调方法
    public boolean onOptionsItemSelected(MenuItem mi)
    {
        //判断单击的是哪个菜单项，并有针对性地作出响应
        switch (mi.getItemId())
        {
            case ITEM_OPTION:
                textView23.setVisibility(View.VISIBLE);
                textView23.setText("游戏设置");
                Intent intent=new Intent(progressbarGameStart.this,option.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case ITEM_ORDER:
                textView23.setVisibility(View.VISIBLE);
                textView23.setText("英雄排行榜");
                intent=new Intent("android.intent.action.ITEM_ORDER");
                startActivity(intent);
                break;
        }
        return true;
    }
  //Intent_Login进行通信
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==RESULT_CODE){
            if(data!=null){
                bgMusic=data.getStringExtra("bgMusic");
                bgSound=data.getStringExtra("bgSound");
                bgPlane=data.getStringExtra("bgPlane");
                Toast.makeText(progressbarGameStart.this,"背景音乐: "+bgMusic+"音效: "+bgSound+"机型: "+bgPlane,Toast.LENGTH_LONG).show();
            }
        }
        if(requestCode==RESULT_USERNAME && resultCode==RESULT_USERNAME){
            if(data!=null){
                str=data.getStringExtra("str");
                textView23.setText("欢迎"+str+"一起玩游戏");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
