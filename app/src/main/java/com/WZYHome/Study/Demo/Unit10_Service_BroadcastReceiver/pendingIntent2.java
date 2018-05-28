package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2018/5/11.
 */

public class pendingIntent2 extends AppCompatActivity {
    TextView getTextTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pending_intent2);
        getTextTextView = (TextView) findViewById(R.id.getTextTextView);

        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        if(!TextUtils.isEmpty(data)) {
            getTextTextView.setText(data);
        }
    }
}
