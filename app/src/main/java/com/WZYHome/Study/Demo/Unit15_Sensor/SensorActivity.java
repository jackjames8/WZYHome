package com.WZYHome.Study.Demo.Unit15_Sensor;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit1.base.BaseMvpActivity;
import com.WZYHome.Study.Demo.Unit1.base.presenter.MvpBasePresenter;
import com.WZYHome.Study.Demo.Unit1.base.view.MvpBaseView;

import java.util.List;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit15_Sensor.SensorActivity"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 *
 * function:加速传感器
 */

public class SensorActivity extends BaseMvpActivity implements SensorEventListener {
    SensorManager mSensorManager;
    TextView yaoTextView;
    boolean yaoDao;
    ObjectAnimator objectAnimator;
    ImageView meiNvImageView;
    @Override
    protected int initLayout() {
        return R.layout.sensor_activity;
    }

    @Override
    public MvpBasePresenter createPresenter() {
        return null;
    }

    @Override
    public MvpBaseView createView() {
        return null;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        yaoTextView= (TextView) byId(R.id.yaoTextView);
        meiNvImageView= (ImageView) byId(R.id.meiNvImageView);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = mSensorManager.getSensorList(Sensor.TYPE_ALL);
   /*     for(Sensor sensor:sensorList){
            System.out.println(sensor.getName());//遍历本机所有的传感器
        }*/
      startAnim();
      Sensor defaultSensor=mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
      mSensorManager.registerListener(this,defaultSensor,SensorManager.SENSOR_DELAY_UI);



    }

    private void startAnim() {
        objectAnimator=ObjectAnimator.ofFloat(yaoTextView,"rotationY",-45,45);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatMode(ObjectAnimator.REVERSE);
        objectAnimator.setRepeatCount(-1);
        objectAnimator.start();
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float[] values = event.values;
        System.out.println(values[0]);//x
        System.out.println(values[1]);//y
        System.out.println(values[2]);//z
        System.out.println("------------------------------");
        if(!yaoDao&&(values[0]>=20||values[1]>=20||values[2]>=20)){
            yaoDao=true;
            Toast.makeText(getApplicationContext(),"摇到了",Toast.LENGTH_SHORT).show();
            objectAnimator.cancel();
            meiNvImageView.setVisibility(View.VISIBLE);
            yaoTextView.setVisibility(View.GONE);

        }

    }

    public  void  go1(View view){
        Toast.makeText(getApplicationContext(),"再摇一次",Toast.LENGTH_SHORT).show();
        meiNvImageView.setVisibility(View.GONE);
        yaoTextView.setVisibility(View.VISIBLE);
        yaoDao=false;
        startAnim();
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this);
    }
}
