package com.WZYHome.Study.Demo.Unit16_Map;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.WZYHome.Study.Demo.R;

/**
 *
 <uses-permission android:name="android.permission.RECORD_AUDIO"/>
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>
 <uses-permission android:name="android.permission.INTERNET"/>
 <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/ic_launcher"
 android:label="@string/app_name1"
 android:theme="@style/AppTheme" >
 <!-- 启用高德地图服务 -->
 <meta-data
 android:name="com.amap.api.v2.apikey"
 android:value="9cc9178433b02fac6fed47dba34da894"/>

 <activity
 android:name=".Unit16_Map.LocationMap"
 android:label="@string/app_name" >
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
 <uses-permission android:name="android.permission.READ_PHONE_STATE" />
 <uses-permission android:name="android.permission.CHANGE_WIFI_STATE" />
 <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 <uses-permission android:name="android.permission.CHANGE_CONFIGURATION" />
 <uses-permission android:name="android.permission.WRITE_SETTINGS" />
 <!-- Optional for location -->
 <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" /> <!-- 用于开启 debug 版本的应用在6.0 系统上 层叠窗口权限 -->
 <uses-permission android:name="android.permission.ACCESS_LOCATION_EXTRA_COMMANDS" />
 <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE" />
 <uses-permission android:name="android.permission.GET_TASKS" />
 */

public class LocationMap extends AppCompatActivity {
	private MapView mapView;
	private AMap aMap;
	private LocationManager locationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.location_map);
		locationManager = (LocationManager) getSystemService(Context
				.LOCATION_SERVICE);
		mapView = (MapView) findViewById(R.id.mapk);
		// 必须回调MapView的onCreate()方法
		mapView.onCreate(savedInstanceState);
		init();
		RadioButton rb = (RadioButton) findViewById(R.id.gps);
		// 为GPS单选按钮设置监听器
		rb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView
					, boolean isChecked) {
				// 如果该单选框已经被勾选
				if (isChecked) {
					// 通过监听器监听GPS提供的定位信息的改变
					locationManager = (LocationManager) getSystemService(Context
							.LOCATION_SERVICE);
					// 通过监听器监听GPS提供的定位信息的改变
					locationManager.requestLocationUpdates(
							LocationManager.GPS_PROVIDER,
							300, 8 , new LocationListener() {
								@Override
								public void onLocationChanged(Location loc)
								{
									// 使用GPS提供的定位信息来更新位置
									updatePosition(loc);
								}
								@Override
								public void onStatusChanged(String provider
										, int status, Bundle extras){}
								@Override
								public void onProviderEnabled(String provider)
								{
									// 使用GPS提供的定位信息来更新位置
									updatePosition(locationManager
											.getLastKnownLocation(provider));
								}
								@Override
								public void onProviderDisabled(String provider){}
							});
				}
			}
		});
	/*	Button bn = (Button) findViewById(R.id.loc);
		final EditText latTv = (EditText) findViewById(R.id.lat);
		final EditText lngTv = (EditText) findViewById(R.id.lng);*/
	/*	bn.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				// 获取用户输入的经度、纬度值
				String lng = lngTv.getEditableText().toString().trim();
				String lat = latTv.getEditableText().toString().trim();
				if (lng.equals("") || lat.equals(""))
				{
					Toast.makeText(LocationMap.this, "请输入有效的经度、纬度!",
							Toast.LENGTH_SHORT).show();
				}
				else
				{
					// 设置根据用户输入的地址定位
					((RadioButton)findViewById(R.id.manual)).setChecked(true);
					double dLng = Double.parseDouble(lng);
					double dLat = Double.parseDouble(lat);
					// 将用户输入的经、纬度封装成LatLng
					LatLng pos = new LatLng(dLat, dLng);  // ①
					// 创建一个设置经纬度的CameraUpdate
					CameraUpdate cu = CameraUpdateFactory.changeLatLng(pos);  // ②
					// 更新地图的显示区域
					aMap.moveCamera(cu);  // ③
					// 创建MarkerOptions对象
					MarkerOptions markerOptions = new MarkerOptions();
					// 设置MarkerOptions的添加位置
					markerOptions.position(pos);
					// 设置MarkerOptions的标题
					markerOptions.title("疯狂软件教育中心");
					// 设置MarkerOptions的摘录信息
					markerOptions.snippet("专业的Java、iOS培训中心");
					// 设置MarkerOptions的图标
					markerOptions.icon(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_RED));
					markerOptions.draggable(true);
					// 添加MarkerOptions（实际上就是添加Marker）
					Marker marker = aMap.addMarker(markerOptions);
					marker.showInfoWindow(); // 设置默认显示信息窗
					// 创建MarkerOptions、并设置它的各种属性
					MarkerOptions markerOptions1 = new MarkerOptions();
					markerOptions1.position(new LatLng(dLat + 0.001, dLng))
							// 设置标题
							.title("疯狂软件教育中心学生食堂")
							.icon(BitmapDescriptorFactory
									.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
							.draggable(true);
					// 使用集合封装多个图标，这样可为MarkerOptions设置多个图标
					ArrayList<BitmapDescriptor> giflist = new ArrayList<>();
					giflist.add(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
					giflist.add(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
					giflist.add(BitmapDescriptorFactory
							.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
					// 在创建一个MarkerOptions、并设置它的各种属性
					MarkerOptions markerOptions2 = new MarkerOptions()
							.position(new LatLng(dLat - 0.001, dLng))
									// 为MarkerOptions设置多个图标
							.icons(giflist)
							.title("疯狂软件教育中心学生宿舍")
							.draggable(true)
									// 设置图标的切换频率
							.period(10);
					// 使用ArrayList封装多个MarkerOptions，即可一次添加多个Marker
					ArrayList<MarkerOptions> optionList = new ArrayList<>();
					optionList.add(markerOptions1);
					optionList.add(markerOptions2);
					// 批量添加多个Marker
					aMap.addMarkers(optionList, true);
				}
			}
		});*/
	}
	private void updatePosition(Location location)
	{
		LatLng pos = new LatLng(location.getLatitude(), location.getLongitude());
		// 创建一个设置经纬度的CameraUpdate
		CameraUpdate cu = CameraUpdateFactory.changeLatLng(pos);
		// 更新地图的显示区域
		aMap.moveCamera(cu);
		// 清除所有Marker等覆盖物
		aMap.clear();
		// 创建一个MarkerOptions对象
		MarkerOptions markerOptions = new MarkerOptions();
		markerOptions.position(pos);
		// 设置MarkerOptions使用自定义图标
		markerOptions.icon(BitmapDescriptorFactory.fromResource(R.drawable.car));
		markerOptions.draggable(true);
		// 添加MarkerOptions（实际上是添加Marker）
		Marker marker = aMap.addMarker(markerOptions);
	}
	// 初始化AMap对象
	private void init() {
		if (aMap == null) {
			aMap = mapView.getMap();
			// 创建一个设置放大级别的CameraUpdate
			CameraUpdate cu = CameraUpdateFactory.zoomTo(15);
			// 设置地图的默认放大级别
			aMap.moveCamera(cu);
			// 创建一个更改地图倾斜度的CameraUpdate
			CameraUpdate tiltUpdate = CameraUpdateFactory.changeTilt(30);
			// 改变地图的倾斜度
			aMap.moveCamera(tiltUpdate);
		}
	}
	@Override
	protected void onResume() {
		super.onResume();
		// 必须回调MapView的onResume()方法
		mapView.onResume();
	}
	@Override
	protected void onPause() {
		super.onPause();
		// 必须回调MapView的onPause()方法
		mapView.onPause();
	}
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// 必须回调MapView的onSaveInstanceState()方法
		mapView.onSaveInstanceState(outState);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 必须回调MapView的onDestroy()方法
		mapView.onDestroy();
	}
}

