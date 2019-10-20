package com.WZYHome.Study.Demo.Unit16_Map;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;

import java.util.List;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/LocationProvider">
 <activity
 android:name=".Unit16_Map.Criteria">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Criteria extends Activity {
    ListView providers;
    LocationManager locationManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_provider);
        providers= (ListView) findViewById(R.id.providers);
        //获取locationManager对象
        locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //创建一个locationProvider的过滤条件
        android.location.Criteria criteria=new android.location.Criteria();
        //设置locationProvider必须免费的
        criteria.setCostAllowed(false);
        //设置要求locationProvider能提供高度信息
        criteria.setAltitudeRequired(true);
        //设置要求locationProvider能提供方向信息
        criteria.setBearingRequired(true);
        //获取系统中所有符合条件的locationProvider的名称
        List<String> providerNames=locationManager.getProviders(criteria,false);
        System.out.println(providerNames.size());
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,providerNames);
        //使用ListView来显示所有可用的locationProvider
        providers.setAdapter(arrayAdapter);



    }
}
