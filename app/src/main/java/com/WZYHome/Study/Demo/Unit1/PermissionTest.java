package com.WZYHome.Study.Demo.Unit1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.io.File;
import java.io.IOException;

/**
 *     <uses-permission android:name="android.permission.CALL_PHONE" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.WRITE_CONTACTS" />
 <uses-permission android:name="android.permission.CAMERA" />
 <uses-permission android:name="android.permission.GET_ACCOUNTS" />
 <uses-permission android:name="android.permission.READ_PROFILE" />
 <uses-permission android:name="android.permission.READ_CONTACTS" />

 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity android:name=".Unit1.PermissionTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>

 </application>
 */

public class PermissionTest extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.permission_test);
        }

        public void call() {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
          //   startActivity(intent);
        }
        public void go1(View v) {
         /*   Toast.makeText(this, "点到了按钮1", Toast.LENGTH_SHORT).show();*/
            if(Build.VERSION.SDK_INT>=23){
                int checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_CONTACTS);
                if(checkCallPhonePermission!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_CONTACTS},123);
                    return;


                }else{
                    //此处是用户已经授权过了
                    call();

                }
            }else{
                //此处是版本在6.0一下,直接执行打电话
                call();
            }



        }

    /**
     *
     * @param requestCode
     * @param permissions
     * @param grantResults  ActivityCompat.requestPermissions的回调方法 ,处理权限申请回调
     */
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            switch (requestCode){
                case 123:
                    //申请打电话的权限返回
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        //用户授权权限成功
                        Toast.makeText(this, "按钮1权限申请成功", Toast.LENGTH_SHORT).show();
                        call();


                    }else{
                        //用户拒绝权限
                        Toast.makeText(this, "拨号权限被拒绝,自己看着办", Toast.LENGTH_SHORT).show();

                    }

                    break;
                case 456:
                    if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "按钮2权限申请成功", Toast.LENGTH_SHORT).show();
                        writeSD();

                    }else{
                        Toast.makeText(this, "SD权限被拒绝,自己看着办", Toast.LENGTH_SHORT).show();
                    }

                    break;

                default:

                    break;


            }
            //表示从申请打电话权限返回

        }

        public void go2(View v) {
            Toast.makeText(this, "点到了按钮2", Toast.LENGTH_SHORT).show();
            if(Build.VERSION.SDK_INT>=23){
                int checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
                if(checkCallPhonePermission!= PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CAMERA},456);
                    return;


                }else{
                    //此处是用户已经授权过了
                    writeSD();

                }
            }else{
                //此处是版本在6.0一下,直接执行打电话
                writeSD();
            }



        }

        public void go3(View v) {
            Toast.makeText(this, "点到了按钮3", Toast.LENGTH_SHORT).show();
        }

        public void go4(View v) {
            Toast.makeText(this, "点到了按钮4", Toast.LENGTH_SHORT).show();
        }

        public void writeSD(){
            String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/1111aaaaaa";
            File file=new File(path);
            file.mkdirs();

            File file1=new File(path,"qq.txt");
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }

