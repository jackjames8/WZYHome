package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.EditText">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class EditText extends Activity {
    int mInt;
    static String sString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final android.widget.EditText editName,editPWD,LimtLengthEditText;
        final Button btnRegister;
        final TextView tvResult;

        super.onCreate(savedInstanceState);
        //显示界面与布局文件相关联
        setContentView(R.layout.test2);
        //代码与xml中控件相关联
        editName= (android.widget.EditText) findViewById(R.id.editName);
        editPWD= (android.widget.EditText) findViewById(R.id.editPWD);
        btnRegister=(Button) findViewById(R.id.btnRegister);
        tvResult=(TextView) findViewById(R.id.tvResult);
        LimtLengthEditText=(android.widget.EditText) findViewById(R.id.LimtLengthEditText);
        btnRegister.setEnabled(false);

        //用户名EditText监听,触发搜索事件
        editName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                String Content=editName.getText().toString();
                Toast.makeText(EditText.this,"正在搜索"+Content,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        editName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length()!=0){
                    btnRegister.setEnabled(true);
                }else{
                    btnRegister.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //LimtLengthEditText提醒还有多少个字符可以输入kc

        LimtLengthEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int lenth = 10 - s.length();//按F8快捷键断点调试，继续查看数据，意思是Resume program
                tvResult.setText("你还可以输入:"+lenth+"个字");

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //3.注册事件
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //实现事件
                String result="";
                result="用户名"+editName.getText()+""+"密码"+editPWD.getText();
                tvResult.setText(result+"");

            }
        });


    }

}
