package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.WZYHome.Study.Demo.R;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit4_Activity_Fragment.FragmentSendFragmentActivity"
 android:theme="@style/CustomTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class FragmentSendFragmentActivity extends AppCompatActivity implements Fragment1.MyInter {

    private FragmentManager manager ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_send_fragment_activity);
        manager = getSupportFragmentManager();
        initFragment();
    }

    //初始化fragment
    private void initFragment() {
        FragmentTransaction trans1 = manager.beginTransaction();
        Fragment1 f1 = new Fragment1();
        trans1.replace(R.id. frameLayoutId, f1);
        trans1.addToBackStack( null);
        trans1.commit();
    }

    //接口回调的方法，在这个方法中接收数据并且传递给另一个Fragment2
    @Override
    public void passValue(String info) {

        FragmentTransaction trans = manager.beginTransaction(); //这个变量只能使用一次
        Fragment2 fm2 = new Fragment2();
        Bundle bundle = new Bundle();
        bundle.putString( "msg", info);
        fm2.setArguments(bundle);
        trans.add(R.id.frameLayoutId,fm2);
        trans.addToBackStack(null);
        trans.commit();
        Toast. makeText(this, info, Toast.LENGTH_SHORT).show();
    }
}
