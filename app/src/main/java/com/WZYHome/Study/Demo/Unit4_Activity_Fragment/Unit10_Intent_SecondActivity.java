package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/7/2.
 */

public class Unit10_Intent_SecondActivity extends Activity {
    Button button3;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit10_secondactivity);
        button3= (Button) findViewById(R.id.button3);
        textView= (TextView) findViewById(R.id.textView);
        Intent intent=getIntent();
        //用intent这个对像取出键值对
        /*String content=intent.getStringExtra("content");
        int count=intent.getIntExtra("count",0);*/
        //用Bundle对像取出值
        Bundle bundle=intent.getBundleExtra("bundle");
        String content=bundle.getString("content");
        int count=bundle.getInt("count");
        textView.setText(content+count);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Unit10_Intent_SecondActivity.this.finish();
            }
        });
    }
}
