package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * <uses-permission android:name="android.permission.INTERNET"/>
 * <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
 * <application
 * android:allowBackup="true"
 * android:icon="@drawable/feiji_1"
 * android:label="@string/app_name"
 * android:theme="@style/AppTheme">
 * <activity
 * android:name=".Unit13_NetWork.asynchronizationOkhttp">
 * <intent-filter>
 * <action android:name="android.intent.action.MAIN" />
 * <p>
 * <category android:name="android.intent.category.LAUNCHER" />
 * </intent-filter>
 * </activity>
 * </application>
 */

public class asynchronizationOkhttp extends AppCompatActivity {


    @BindView(R.id.btn_OkHttp3)
    Button btnOkHttp3;
    @BindView(R.id.btn_getOkHttp3)
    Button btnGetOkHttp3;
    @BindView(R.id.btn_post)
    Button btnPost;
    @BindView(R.id.progressBarOkHttp)
    ProgressBar progressBarOkHttp;
    @BindView(R.id.imageOkhttp)
    ImageView imageOkhttp;
    @BindView(R.id.tv_resultOkHttp)
    TextView tvResultOkHttp;
    @BindView(R.id.btn_postJson)
    Button btnPostJson;
    @BindView(R.id.btn_download)
    Button btnDownload;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asynchronization_okhttp);
        ButterKnife.bind(this);
        requestPermission();//请求下载权限

    }

    @OnClick(R.id.btn_OkHttp3)
    void click() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://39.108.161.138:9859/VehicleVMS/api/VehicleTypeInfo";
        final Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("asynchronizati失败", e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.e("asynchronizati成功", string);
                if (response.body() != null) {
                    response.body().close();
                }
            }
        });
    }


    /**
     * OkHttp3 get请求
     */
    @OnClick(R.id.btn_getOkHttp3)
    void click1() {
        getUserInfo();
    }

    private void getUserInfo() {
        String url = "http://39.108.161.138:9859/VehicleVMS/api/VehicleTypeInfo";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String json = response.body().string();
                    showUserinfor(json);
                }

            }
        });

    }

    private void showUserinfor(final String json) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject jsonObject = new JSONObject(json);
                    String returnValue = jsonObject.optString("ReturnValue");
                    tvResultOkHttp.setText(returnValue);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    /**
     * 通过表单形式发送post请求
     */
    @OnClick(R.id.btn_post)
    public void click3() {
        loginWithForm("15876573558", "a12345678");
    }

    private void loginWithForm(String UserAccount, String UserPassword) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://39.108.161.138:9859/PersonAMS/api/Login/";
        RequestBody RequestBody = new FormBody.Builder().add("UserAccount", UserAccount).add("UserPassword", UserPassword).build();
        Request request = new Request.Builder().url(url).post(RequestBody).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("请求出错", e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(string);
                        final String message = jsonObject.optString("Message");
                        final String returnValue = jsonObject.optString("ReturnValue");
                        //放主线程中运行ui界面
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if ("null".equals(returnValue)) {
                                    Toast.makeText(asynchronizationOkhttp.this, message, Toast.LENGTH_SHORT).show();
                                } else {
                                    tvResultOkHttp.setText(returnValue);
                                }
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }
        });


    }

    /**
     * 通过发送Json数据post请求
     */
    @OnClick(R.id.btn_postJson)
    public void onViewClicked() {
        loginWithJson("15876573558", "a12345678");
    }

    private void loginWithJson(String UserAccount, String UserPassword) {
        OkHttpClient okHttpClient = new OkHttpClient();
        String url = "http://39.108.161.138:9859/PersonAMS/api/Login/";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("UserAccount", UserAccount);
            jsonObject.put("UserPassword", UserPassword);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String s = jsonObject.toString();

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), s);
        Request request = new Request.Builder().url(url).post(body).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("请求出错", e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String string = response.body().string();
                    JSONObject jsonObject = null;
                    try {
                        jsonObject = new JSONObject(string);
                        final String message = jsonObject.optString("Message");
                        final String returnValue = jsonObject.optString("ReturnValue");
                        //放主线程中运行ui界面
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if ("null".equals(returnValue)) {
                                    Toast.makeText(asynchronizationOkhttp.this, message, Toast.LENGTH_SHORT).show();
                                } else {
                                    tvResultOkHttp.setText(returnValue);
                                }
                            }
                        });

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    /**
     * 获取权限
     */
 public static final int EXTERNAL_STORAGE_REQ_CODE=10;
 public void requestPermission(){
     //判断当前Activity是否已经获得权限
     if(ContextCompat.checkSelfPermission(this,
             Manifest.permission.WRITE_EXTERNAL_STORAGE)
             != PackageManager.PERMISSION_GRANTED){
         //如果APP的权限申请曾经被用户拒绝过，就需要在这里跟用户做出解释
         if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                 Manifest.permission.WRITE_EXTERNAL_STORAGE)){
             Toast.makeText(this,"Please give me the permission",Toast.LENGTH_SHORT).show();
         }else {
             //进行权限请求
          ActivityCompat.requestPermissions(this,
                  new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                  EXTERNAL_STORAGE_REQ_CODE);
         }
     }
 }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case EXTERNAL_STORAGE_REQ_CODE:{
                //如果请求被拒绝，那么通常grantResults数组为空
                if(grantResults.length> 0
                        &&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(this,"已经获取权限",Toast.LENGTH_SHORT).show();
                }else {
                    //申请失败,可以继续向用户解释.
                }
                return;
            }
        }
    }

    /**
     * 下载数据
     */
    @OnClick(R.id.btn_download)
    public void click2() {
      downLoad();
    }

    private void downLoad() {
        String url = "http://vfx.mtime.cn/Video/2016/07/24/mp4/160724055620533327_480.mp4";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("download", "请求文件出错");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                writeFile(response);
            }
        });
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
          if(msg.what==1){
              int progress=msg.arg1;
              progressBarOkHttp.setProgress(progress);
          }
        }
    };
    private void writeFile(Response response) {
        InputStream inputStream=null;
        FileOutputStream fileOutputStream=null;
        inputStream=response.body().byteStream();
        String path= Environment.getExternalStorageDirectory().getAbsolutePath();
        Log.e("pathName","path"+path);
        File file=new File(path,"480.mp4");
        try {
            fileOutputStream=new FileOutputStream(file);
            byte[] bytes=new byte[1024];
            int len=0;
           long totalSize= response.body().contentLength();//文件的大小
            long sum=0;

            while ((len=inputStream.read(bytes))!=-1){
                fileOutputStream.write(bytes);
                sum+=len;
                int progress= (int) ((sum*1.0f/totalSize)*100);//读了多少除了文件总数
                Message message = handler.obtainMessage(1);
                message.arg1=progress;
                handler.sendMessage(message);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


}
