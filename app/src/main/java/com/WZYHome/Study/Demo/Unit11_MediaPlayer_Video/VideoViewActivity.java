package com.WZYHome.Study.Demo.Unit11_MediaPlayer_Video;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.WZYHome.Study.Demo.R;

import java.io.File;

/**
 *  <!-- 授予该程序读取外部存储器的权限 -->
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit11_MediaPlayer_Video.VideoViewActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */


public class VideoViewActivity extends Activity
{
	VideoView videoView;
	MediaController mController;
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		setContentView(R.layout.video_view_activity);
		// 获取界面上VideoView组件
		videoView = (VideoView) findViewById(R.id.video);
		// 创建MediaController对象
		mController = new MediaController(this);
		File video = new File("/mnt/sdcard/PictureSelector/CameraImage/cheshivideo.mp4");
		if(video.exists())
		{
			videoView.setVideoPath(video.getAbsolutePath());  // ①
			// 设置videoView与mController建立关联
			videoView.setMediaController(mController);  // ②
			// 设置mController与videoView建立关联
			mController.setMediaPlayer(videoView);  // ③
			// 让VideoView获取焦点
			videoView.requestFocus();
		}
	}
}

