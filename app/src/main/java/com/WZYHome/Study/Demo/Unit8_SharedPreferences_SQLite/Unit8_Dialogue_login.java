package com.WZYHome.Study.Demo.Unit8_SharedPreferences_SQLite;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit8_SharedPreferences_SQLite.Unit8_Dialogue_login">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit8_Dialogue_login extends AppCompatActivity {
    EditText edit_user,edit_password;
    Button button_ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit8_dialogue_login);
        button_ok= (Button) findViewById(R.id.button_ok);
        edit_password= (EditText) findViewById(R.id.edit_password);
        edit_user= (EditText) findViewById(R.id.edit_user);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //事件处理程序
                //1.判断输入的姓名是否为空
                //得到edit_user的输入姓名
                String name=(edit_user.getText()+"").trim();
                if(name==null||name.equals("")){
                    //后期给出对话框或消息框
                    edit_user.setText("姓名必须输入");
                     new AlertDialog.Builder(Unit8_Dialogue_login.this)
                             .setIcon(R.drawable.feiji_1)
                             .setTitle("雷神")
                             .setMessage("姓名必须输入,不可为空")
                             .setNegativeButton("确定",null)
                             .show();

                }else{
                    //自定义Toast
                   /* Toast toast=new Toast(Unit8_Dialogue_login.this);
                    View view= LayoutInflater.from(Unit8_Dialogue_login.this).inflate(R.drawerlayout1.unit8_toast ,null);
                    toast.setView(view);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
                    toast.show();*/
                    //后期给出对话框或消息框
                    Toast.makeText(Unit8_Dialogue_login.this,"用户名已经保存",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}
