package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit1.base.BaseMvpActivity;
import com.WZYHome.Study.Demo.Unit1.base.presenter.MvpBasePresenter;
import com.WZYHome.Study.Demo.Unit1.base.view.MvpBaseView;
import com.WZYHome.Study.Demo.Unit2_View.Custom.MyScrollView;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit2_View.XuanFuActivity"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 * function:悬浮功能
 */

public class XuanFuActivity extends AppCompatActivity {

    private View top;
    private TextView xuanfuB,xuanfuA;
    private MyScrollView myScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xuan_fu_activity);
        top=findViewById(R.id.top);
        xuanfuB= (TextView) findViewById(R.id.xuanfuB);;
        xuanfuA= (TextView) findViewById(R.id.xuanfuA);
        myScrollView= (MyScrollView) findViewById(R.id.myScrollView);;
        myScrollView.setOnScrollChangeListener(new MyScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                System.out.println(scrollY+"==="+top.getBottom());
                if(scrollY>=top.getBottom()){
                    xuanfuB.setVisibility(View.VISIBLE);
                }else {
                    xuanfuB.setVisibility(View.GONE);
                }
            }
        });
    }


}
