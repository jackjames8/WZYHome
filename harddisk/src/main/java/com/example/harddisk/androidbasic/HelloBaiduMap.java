package com.example.harddisk.androidbasic;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.LogoPosition;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.example.harddisk.R;

import java.util.ArrayList;
import java.util.List;

/**
 *     <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
 //获取设备网络状态，禁用后无法获取网络状态
 <uses-permission android:name="android.permission.INTERNET"/>
 //网络权限，当禁用后，无法进行检索等相关业务
 <uses-permission android:name="android.permission.READ_PHONE_STATE" />
 //读取设备硬件信息，统计数据
 <uses-permission android:name="com.android.launcher.permission.READ_SETTINGS" />
 //读取系统信息，包含系统版本等信息，用作统计
 <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
 //获取设备的网络状态，鉴权所需网络代理
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
 //允许sd卡写权限，需写入地图数据，禁用后无法显示地图
 <uses-permission android:name="android.permission.WRITE_SETTINGS" />
 //获取统计数据
 <uses-permission android:name="android.permission.GET_TASKS" />
 //鉴权所需该权限获取进程列表
 <uses-permission android:name="android.permission.CAMERA" />


 <application
 android:name=".base.App"
 android:allowBackup="true"
 android:icon="@mipmap/ic_launcher"
 android:label="@string/app_name"
 android:roundIcon="@mipmap/ic_launcher_round"
 android:supportsRtl="true"
 android:theme="@style/AppTheme">
 <meta-data
 android:name="com.baidu.lbsapi.API_KEY"
 android:value="9j3GzmWtwtTUtEwrSjAAWlZKA89WCPp1" />

 <activity android:name="com.example.harddisk.androidbasic.HelloBaiduMap">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class HelloBaiduMap extends Activity {
    private MapView mMapView = null;
    private BaiduMap mBaiduMap;
    private UiSettings mUiSettings;
    private boolean enable=true;
    private PoiSearch mPoiSearch;

    OnGetPoiSearchResultListener poiListener = new OnGetPoiSearchResultListener(){

        public void onGetPoiResult(PoiResult result){
            //获取POI检索结果
            List<PoiInfo> allPoi = result.getAllPoi();
            for (PoiInfo poiInfo:allPoi){
                System.out.println("城市"+poiInfo.city+"名字"+poiInfo.name);
                System.out.println("地址"+poiInfo.address+"电话号码"+poiInfo.phoneNum);
                System.out.println("坐标"+poiInfo.location+""+"描述内容"+poiInfo.describeContents());
                System.out.println("----------------------------------------");
            }

        }

        public void onGetPoiDetailResult(PoiDetailResult result){
            //获取Place详情页检索结果
        }

        @Override
        public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.hello_baidu_map);
        //获取地图控件引用
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //通过以下方法，使用枚举类型控制显示的位置，共支持6个显示位置(左下，中下，右下，左上，中上，右上)。
        mMapView.setLogoPosition(LogoPosition.logoPostionRightTop);
        mUiSettings = mBaiduMap.getUiSettings();//指南针默认为开启状态，可以关闭显示 ：
        mUiSettings.setCompassEnabled(enable);//指南针默认为开启状态，可以关闭显示 ：
        mMapView. showScaleControl(enable);//比例尺默认为开启状态，可以关闭显示。
        mMapView. showZoomControls(enable);//控制缩放按钮是否显示

        mPoiSearch = PoiSearch.newInstance();
        mPoiSearch.setOnGetPoiSearchResultListener(poiListener);

    }


    int bitmapA[]={
            R.drawable.icon_marka,
            R.drawable.icon_markb,
            R.drawable.icon_markc,
            R.drawable.icon_markd,
            R.drawable.icon_marke,
            R.drawable.icon_markf,
            R.drawable.icon_markg,
            R.drawable.icon_markh,
            R.drawable.icon_marki,

    };

    public void go1(View view) {
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
//普通地图 ,mBaiduMap是地图控制器对象
        //定义Maker坐标点
        for(int i=0;i<6;i++) {
            LatLng point = new LatLng(39.963175+i*0.1, 116.400244+i*0.1);
//构建Marker图标
            BitmapDescriptor bitmap = BitmapDescriptorFactory
                    .fromResource( bitmapA[i]);
//构建MarkerOption，用于在地图上添加Marker
            OverlayOptions option = new MarkerOptions()
                    .position(point)
                    .icon(bitmap);
//在地图上添加Marker，并显示
            mBaiduMap.addOverlay(option);
        }
        /**
         *       发起检索请求；
         */

        mPoiSearch.searchInCity((new PoiCitySearchOption())
                .city("北京")
                .keyword("美食")
                .pageNum(16));


    }

    public void go2(View view) {
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_SATELLITE);
//卫星地图
    }

    Boolean isOpen=true;
    public void go3(View view) {
//开启交通图
        mBaiduMap.setTrafficEnabled(isOpen);
        isOpen=!isOpen;

        //创建OverlayOptions的集合
/*        List<OverlayOptions> options = new ArrayList<OverlayOptions>();
//设置坐标点
        LatLng point1 = new LatLng(39.92235, 116.380338);
        LatLng point2 = new LatLng(39.947246, 116.414977);
//创建OverlayOptions属性
        BitmapDescriptor bitmap1 = BitmapDescriptorFactory
                .fromResource(R.drawable.jd_people_0);
        BitmapDescriptor bitmap2 = BitmapDescriptorFactory
                .fromResource(R.drawable.jd_people_1);
        BitmapDescriptor bitmap3 = BitmapDescriptorFactory
                .fromResource(R.drawable.jd_people_2);
        BitmapDescriptor bitmap4 = BitmapDescriptorFactory
                .fromResource(R.drawable.jd_people_3);

        ArrayList<BitmapDescriptor> gifList=new ArrayList<BitmapDescriptor>();
        gifList.add(bitmap1);
        gifList.add(bitmap2);
        gifList.add(bitmap3);
        gifList.add(bitmap4);

        OverlayOptions option1 =  new MarkerOptions().position(point1).icons(gifList).period(10);

        //在地图上批量添加
     Marker marker=(Marker) (mBaiduMap.addOverlay(option1));*/

        /**
         *       添加信息窗（弹窗覆盖物InfoWindow）
         弹出窗覆盖物的实现方式如下，开发者可利用此接口，构建具有更强交互性的地图页面。
          */
//创建InfoWindow展示的view


        /**
         * 地图 Marker 覆盖物点击事件监听接口：
          */
        LatLng point = new LatLng(39.963175, 116.400244);
//构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_markb);
//构建MarkerOption，用于在地图上添加Marker
        OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
//在地图上添加Marker，并显示
        mBaiduMap.addOverlay(option);

        BaiduMap.OnMarkerClickListener listener = new BaiduMap.OnMarkerClickListener() {
            /**
             * 地图 Marker 覆盖物点击事件监听函数
             * @param marker 被点击的 marker
             */
            public boolean onMarkerClick(Marker marker) {

                Button button = new Button(getApplicationContext());
                button.setBackgroundResource(R.drawable.popup);
                button.setText("王志勇的地图");
                button.setTextColor(Color.BLACK);

//定义用于显示该InfoWindow的坐标点
                LatLng pt = new LatLng(39.963175,  116.400244);

//创建InfoWindow , 传入 view， 地理坐标， y 轴偏移量
                InfoWindow mInfoWindow = new InfoWindow(button, pt, -47);//-47是弹出窗的偏移位置

//显示InfoWindow
                mBaiduMap.showInfoWindow(mInfoWindow);
                return true;
            }
        };

      mBaiduMap.setOnMarkerClickListener(listener);



    }

    public void go4(View view) {
        //开启交通图
        mBaiduMap.setBaiduHeatMapEnabled(isOpen);
        isOpen=!isOpen;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPoiSearch.destroy();//释放poi资源
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}

