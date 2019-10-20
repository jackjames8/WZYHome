package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;
/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit2_View.TableLayoutTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

/**
 * Created by Administrator on 2018/2/26.
 * function:表格布局
 */

public class TableLayoutTest extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout);
    }
}
