package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.Custom.FlowLayout;

import java.util.zip.Inflater;

/**
 *   <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <application
 android:name=".HardDisk.MyApp"
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Custom.FlowLayoutTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class FlowLayoutTest extends AppCompatActivity {
    FlowLayout flowLayout;

    private String[] mVals=new String[]
            {
                   "hello","Android","welfdcom","Button","TextView",
                    "hellfao","Android","welfm","Butfdaton","TextVfdiew",
                    "hellofd","Androigfd","welgfcom","Bufdtton","TefdxtView",
            };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flow_layout_test);
        flowLayout= (FlowLayout) findViewById(R.id.flowLayout);

        initData();
    }

    private void initData() {




      /*  for(int i=0;i<mVals.length;i++){
            TextView tv=new TextView(this);
            tv.setBackgroundDrawable(this.getResources().getDrawable(R.drawable.border_orange));
            ViewGroup.MarginLayoutParams lp=new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            tv.setText(mVals[i]);
            flowLayout.addView(tv,lp);
        }*/
        LayoutInflater mInflater=LayoutInflater.from(this);
        for(int i=0;i<mVals.length;i++){
          //把一个个TextView填充到flowLayout中去
            TextView inflate = (TextView)mInflater.inflate(R.layout.tv,flowLayout, false);
            inflate.setText(mVals[i]);
            flowLayout.addView(inflate);
        }

    }

}
