package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.DialogueTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class DialogueTest extends Activity {
    Button button13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit8_dialogue_test);
        button13= (Button) findViewById(R.id.button13);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* View view=getLayoutInflater().from(Unit2_DialogueTest.this).inflate(R.drawerlayout1.unit8_dialogue_test1,null);*/

                final String[] content={"AAA","BBB","CCC"};
                new AlertDialog.Builder(DialogueTest.this)
                        .setPositiveButton("ok",null)
                        .setMultiChoiceItems(content, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                Toast.makeText(DialogueTest.this,content[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        //设置一个复选按钮
                        .setMessage("这是一个对话框")
                        .setItems(content, new DialogInterface.OnClickListener() {//设置多选项选择
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogueTest.this,content[which],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(DialogueTest.this,"取消按钮被点击",
                                        Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定",null)
                        .setTitle("测试")
                        .show();
            }
        });

    }
}
