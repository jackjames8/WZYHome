package com.WZYHome.Study.Demo.Unit1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit1.butterknifeActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class butterknifeActivity extends AppCompatActivity {
    @BindView(R.id.tvButterKnife)
    TextView tvButterKnife;
    @BindView(R.id.cheButterKnife)
    CheckBox cheButterKnife;
    @BindView(R.id.btnButterKnife)
    Button btnButterKnife;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.butterknife);
        butterknife.ButterKnife.bind(this);

    }
    @OnClick(R.id.cheButterKnife)
      void chexBox(){
        Toast.makeText(this,"我点击了chexBox",Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.btnButterKnife)
    void click(){
        Toast.makeText(this,"我点击了Button",Toast.LENGTH_SHORT).show();
        tvButterKnife.setText("我好喜欢ButterKnife");
    }
}
