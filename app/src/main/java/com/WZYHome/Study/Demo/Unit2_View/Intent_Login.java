package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/7/7.
 */
//与Unit2_progressbarGameStart通信
public class Intent_Login extends Activity {
    Button button5;
    EditText editText4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        button5= (Button) findViewById(R.id.button5);
        editText4= (EditText) findViewById(R.id.editText4);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=editText4.getText()+"";
                Intent intent=getIntent();
                intent.putExtra("str",str);
                setResult(progressbarGameStart.RESULT_USERNAME,intent);
                finish();
            }
        });
    }
}
