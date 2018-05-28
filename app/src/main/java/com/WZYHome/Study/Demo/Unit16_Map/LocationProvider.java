package com.WZYHome.Study.Demo.Unit16_Map;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.WZYHome.Study.Demo.R;

import java.util.List;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/LocationProvider">
 <activity
 android:name=".Unit16.LocationProvider">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class LocationProvider extends Activity {
    ListView providers;
    LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_provider);
        providers= (ListView) findViewById(R.id.providers);
        //获取系统的locationManager对象
        locationManager= (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //获取系统所有的LocationProvider的名称
       List<String> providersNames = locationManager.getAllProviders();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,providersNames);
        //使用ListView来显示所有可用的LocationProvider
        providers.setAdapter(adapter);
    }
}
