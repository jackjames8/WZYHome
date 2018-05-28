package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.*;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/11/13.
 */

public class EditTextPassWord extends AppCompatActivity {
    CheckBox cbDisplayPassword;
    android.widget.EditText  etPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_password);
        initView();
        initListener();
    }

    private void initView() {
        cbDisplayPassword= (CheckBox) findViewById(R.id.cbDisplayPassword);
        etPassword= (android.widget.EditText) findViewById(R.id.etPassword);
    }

    private void initListener() {

        cbDisplayPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

              /*  Log.d(TAG, "onCheckedChanged: "+isChecked);*/
                if(isChecked){
                    //选择状态 显示明文--设置为可见的密码

                    etPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
                    //默认状态显示密码--设置文本 要一起写才能起作用  InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD

                    etPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }
}
