package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.Cars;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.jsonBean;
import com.WZYHome.Study.Demo.Util.GogleGsonUtil;
import com.WZYHome.Study.Demo.until;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;

/**
 *  <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit13_NetWork.GSonParse"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class GSonParse extends Activity implements View.OnClickListener {
    private Button bt_gson_tojavaobject, bt_gson_tojavalist, bt_gson_JavaToJsonObject, bt_gson_JavaToJsonArray;
    TextView tv_gson_orignal, tv_gson_last;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gson_parse);
        initView();
        //初始化监听
        initListener();
    }

    //初始化button监听事件
    private void initListener() {
        bt_gson_tojavaobject.setOnClickListener(this);
        bt_gson_tojavalist.setOnClickListener(this);
        bt_gson_JavaToJsonObject.setOnClickListener(this);
        bt_gson_JavaToJsonArray.setOnClickListener(this);

    }

    //实例化控件
    private void initView() {
        bt_gson_tojavaobject = (Button) findViewById(R.id.bt_gson_tojavaobject);
        bt_gson_tojavalist = (Button) findViewById(R.id.bt_gson_tojavalist);
        bt_gson_JavaToJsonObject = (Button) findViewById(R.id.bt_gson_JavaToJsonObject);
        bt_gson_JavaToJsonArray = (Button) findViewById(R.id.bt_gson_JavaToJsonArray);
        tv_gson_last = (TextView) findViewById(R.id.tv_gson_last);
        tv_gson_orignal = (TextView) findViewById(R.id.tv_gson_orignal);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //将JSON格式的字符串{}转换为Java对象
            case R.id.bt_gson_tojavaobject:
                gson_tojavaobject();
                break;
            //将JSON格式的字符串数组[]转换为Java对象的List
            case R.id.bt_gson_tojavalist:
                jsonToJavaListByGson();
                break;
            //复杂JSON数据解析
            case R.id.bt_gson_JavaToJsonObject:

               /* jsonToJavaOfComplex();*/
                break;
            //特殊JSON数据解析
            case R.id.bt_gson_JavaToJsonArray:
                Toast.makeText(GSonParse.this, "bt_gson_JavaToJsonArray", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void   gson_tojavaobject(){
        String json = until.myMenu;

        jsonBean jsonBean=(jsonBean) GogleGsonUtil.JsonToObject(json, jsonBean.class);


        String menuname = jsonBean.get个人信息().get(0).getMenuname();
        tv_gson_last.setText( menuname);

/*        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //通过迭代器获取这段json当中所有的key值
        Iterator keys = jsonObject.keys();
        //然后通过一个循环取出所有的key值
        while (keys.hasNext()){
            String key = String.valueOf(keys.next());
            System.out.println(key);
            //最后就可以通过刚刚得到的key值去解析后面的json了
        }*/

    }






    //将JSON格式的字符串数组[]转换为Java对象的List
    private void jsonToJavaListByGson() {
        //1.获取或创建JSON数据
        String json = until.ReturnValue;
        //2.解析JSON数据
        Gson gson = new Gson();

        List<Cars> Cars = gson.fromJson(json, new TypeToken<List<Cars>>() {
        }.getType());
        //3.展示数据
        tv_gson_orignal.setText(json);
        tv_gson_last.setText(Cars.toString());
    }

    //通过volley访问网络将JSON格式的字符串{}转换为Java对象

}
