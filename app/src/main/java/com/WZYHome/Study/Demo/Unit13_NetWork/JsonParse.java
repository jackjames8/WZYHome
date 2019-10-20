package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.ErrorInfo;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.ReturnValue;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.VehicleTypeInfo;
import com.WZYHome.Study.Demo.until;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit13_NetWork.JsonParse"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */
//手动JSON解析页面

//将JSON格式的字符串{}转换为Java对象
//将JSON格式的字符串[]转换为Java对象的List
//复杂JSON数据解析
//特殊JSON数据解析

public class JsonParse extends Activity implements View.OnClickListener {
    private Button bt_native_tojavaobject, bt_native_tojavalist, bt_native_complex, bt_native_special;
    TextView tv_native_orignal, tv_native_last;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.json_parse);
        initView();
        //初始化监听
        initListener();


    }

    //初始化button监听事件
    private void initListener() {
        bt_native_tojavaobject.setOnClickListener(this);
        bt_native_tojavalist.setOnClickListener(this);
        bt_native_complex.setOnClickListener(this);
        bt_native_special.setOnClickListener(this);

    }

    //实例化控件
    private void initView() {
        bt_native_tojavaobject = (Button) findViewById(R.id.bt_native_tojavaobject);
        bt_native_tojavalist = (Button) findViewById(R.id.bt_native_tojavalist);
        bt_native_complex = (Button) findViewById(R.id.bt_native_complex);
        bt_native_special = (Button) findViewById(R.id.bt_native_special);
        tv_native_last = (TextView) findViewById(R.id.tv_native_last);
        tv_native_orignal = (TextView) findViewById(R.id.tv_native_orignal);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //将JSON格式的字符串{}转换为Java对象
            case R.id.bt_native_tojavaobject:
                jsonToJavaObjectByNative();
                break;
            //将JSON格式的字符串数组[]转换为Java对象的List
            case R.id.bt_native_tojavalist:
                Toast.makeText(JsonParse.this,"Getjson",Toast.LENGTH_LONG).show();
                jsonToJavaListByNative();
                break;
            //复杂JSON数据解析
            case R.id.bt_native_complex:
                Toast.makeText(JsonParse.this,"Getjson",Toast.LENGTH_LONG).show();
                jsonToJavaOfComplex();
                break;
            //特殊JSON数据解析
            case R.id.bt_native_special:
                break;
        }

    }

    //复杂JSON数据解析
    private void jsonToJavaOfComplex() {
        //获取或创建JSON数据
        String url = until.url;

        //解析JSON数据
        VehicleTypeInfo vehicleTypeInfo = new VehicleTypeInfo();
        VehicleTypeInfo.ErrorInfoBean errorInfoBean = new VehicleTypeInfo.ErrorInfoBean();
        List<VehicleTypeInfo.ReturnValueBean> ReturnValueBeans=new ArrayList<>();
        List<VehicleTypeInfo.ReturnValueBean.SpecialSpecItemsBean> SpecialSpecItems=new ArrayList<>();

        //解析JSON
                try {
                    JSONObject jsonObject = new JSONObject(url);
                    //第一层解析
                    JSONObject errorInfo = jsonObject.optJSONObject("ErrorInfo");
                    JSONArray returnValue = jsonObject.optJSONArray("ReturnValue");
                    //第一层封装
                    vehicleTypeInfo.setErrorInfo(errorInfoBean);
                    vehicleTypeInfo.setReturnValue(ReturnValueBeans);
                    //第二层解析
                    String category = errorInfo.optString("Category");
                    String message = errorInfo.optString("Message");
                    boolean status = errorInfo.optBoolean("Status");
                    //第二层数据的封装
                    errorInfoBean.setCategory(category);
                    errorInfoBean.setMessage(message);
                    errorInfoBean.setStatus(status);
                    //第二层解析
                    for (int i = 0; i < returnValue.length(); i++) {
                        JSONObject jsonObject1 = returnValue.optJSONObject(i);
                        if (jsonObject1 != null) {
                            //第三层解析
                            double loadCapacity = jsonObject1.optDouble("LoadCapacity");
                            double loadHeight = jsonObject1.optDouble("LoadHeight");
                            double loadLength = jsonObject1.optDouble("LoadLength");
                            double loadWeight = jsonObject1.optDouble("LoadWeight");
                            double loadWidth = jsonObject1.optDouble("LoadWidth");
                            String vehicleImageUrl = jsonObject1.optString("VehicleImageUrl");
                            String vehicleTypeInfoCode = jsonObject1.optString("VehicleTypeInfoCode");
                            String vehicleTypeName = jsonObject1.optString("VehicleTypeName");
                            JSONArray specialSpecItems = jsonObject1.optJSONArray("SpecialSpecItems");
                            VehicleTypeInfo.ReturnValueBean returnValueBean = new VehicleTypeInfo.ReturnValueBean();
                            //第三层封装
                            returnValueBean.setLoadCapacity(loadCapacity );
                            returnValueBean.setLoadHeight(loadHeight);
                            returnValueBean.setLoadLength(loadLength);
                            returnValueBean.setLoadWeight(loadWeight);
                            returnValueBean.setLoadWidth(loadWidth);
                            returnValueBean.setVehicleImageUrl(vehicleImageUrl);
                            returnValueBean.setVehicleTypeInfoCode(vehicleTypeInfoCode);
                            returnValueBean.setVehicleTypeName(vehicleTypeName);
                            ReturnValueBeans.add(returnValueBean);
                            returnValueBean.setSpecialSpecItems(SpecialSpecItems);

                            //第四层解析
                            for (int x=0; x < specialSpecItems.length(); x++) {
                                JSONObject jsonObject2 = specialSpecItems.optJSONObject(x);
                                if (jsonObject2 !=null) {
                                    String specialSpec = jsonObject2.optString("SpecialSpec");
                                    String specialSpecName = jsonObject2.optString("SpecialSpecName");
                                    VehicleTypeInfo.ReturnValueBean.SpecialSpecItemsBean SpecialSpecItemsBean=new VehicleTypeInfo.ReturnValueBean.SpecialSpecItemsBean();
                                    //第四层封装
                                    SpecialSpecItemsBean.setSpecialSpec(specialSpec);
                                    SpecialSpecItemsBean.setSpecialSpecName(specialSpecName);
                                    SpecialSpecItems.add(SpecialSpecItemsBean);
                                }
                            }

                        }
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
        //显示JSON数据
        tv_native_orignal.setText(url);
        tv_native_last.setText(vehicleTypeInfo.toString());

    }


    //将JSON格式的字符串[]数组转换为Java对象的List
    private void jsonToJavaListByNative() {
        //获取或创建JSON数据
        String json = until.ReturnValue;

        List<ReturnValue> ReturnValues = new ArrayList<>();
        List<ReturnValue.SpecialSpecItemsBean> ReturnValueBean=new ArrayList<>();
        //解析JSON数据
        try {
            JSONArray ReturnValuesArray = new JSONArray(json);
            for (int i = 0; i < ReturnValuesArray.length(); i++) {
                JSONObject jsonObject = ReturnValuesArray.getJSONObject(i);
                if (jsonObject != null) {
                    String vehicleTypeInfoCode = jsonObject.optString("VehicleTypeInfoCode");
                    String vehicleTypeName = jsonObject.optString("VehicleTypeName");
                    double loadLength = jsonObject.optDouble("LoadLength");
                    double loadWidth = jsonObject.optDouble("LoadWidth");
                    double loadHeight = jsonObject.optDouble("LoadLength");
                    double loadCapacity = jsonObject.optDouble("LoadCapacity");
                    double loadWeight = jsonObject.optDouble("LoadWeight");
                    String vehicleImageUrl = jsonObject.optString("VehicleImageUrl");
                    JSONArray specialSpecItems = jsonObject.optJSONArray("SpecialSpecItems");
                 for (int y = 0; y<specialSpecItems.length(); y++){
                     JSONObject jsonObject1 = specialSpecItems.getJSONObject(y);
                     String specialSpec = jsonObject1.optString("SpecialSpec");
                     String specialSpecName = jsonObject1.optString("SpecialSpecName");
                     ReturnValue.SpecialSpecItemsBean bean=new ReturnValue.SpecialSpecItemsBean();
                     bean.setSpecialSpec(specialSpec);
                     bean.setSpecialSpecName(specialSpecName);
                     ReturnValueBean.add(bean);
                 }

                    //封装java对象
                    ReturnValue ReturnValue = new ReturnValue(loadCapacity, loadHeight,
                            loadLength, loadWeight, loadWidth, vehicleImageUrl, vehicleTypeInfoCode,vehicleTypeName,ReturnValueBean);
                    ReturnValues.add(ReturnValue);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //显示JSON数据
        tv_native_orignal.setText(json);
        tv_native_last.setText(ReturnValues.toString());
    }


    //将JSON格式的字符串{}对象转换为Java对象
    private void jsonToJavaObjectByNative() {
        ErrorInfo errorInfo = null;
        //获取或创建JSON数据
        String json = "{\n" +
                "        \"Status\": false,\n" +
                "        \"Message\": \"\",\n" +
                "        \"Category\": \"\"\n" +
                "    }";
        //解析JSON
        try {
            JSONObject jsonObject = new JSONObject(json);
            boolean Status = jsonObject.optBoolean("Status");
            String Message = jsonObject.optString("Message");
            String Category = jsonObject.optString("Category");
            errorInfo = new ErrorInfo(Category, Message, Status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //显示JSON数据
        tv_native_orignal.setText(json);
        tv_native_last.setText(errorInfo.toString());


    }
}
