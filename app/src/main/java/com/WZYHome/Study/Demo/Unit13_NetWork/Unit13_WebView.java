package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.app.Activity;
import android.os.Bundle;

import android.webkit.WebView;

import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit13_NetWork.Unit13_WebView"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit13_WebView extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_webview);
        WebView webView= (WebView) findViewById(R.id.WebView);
        //引用loadUrl加载网络地址
        /*webView.loadUrl("http://www.android-doc.com/develop/index.html");*/
        //设置WebView允许执行JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        //通过addJavascriptInterface()绑定两者
        webView.addJavascriptInterface(new Unit13_MyJavaScriptInterface(
                Unit13_WebView.this),"Android");//传递一个android对象及名字给javascript
        webView.loadUrl("file:///android_asset/demo.html");

    }
}
