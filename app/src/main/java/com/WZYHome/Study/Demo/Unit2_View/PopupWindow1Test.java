package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.net.URI;

/**
 *  <uses-permission android:name="android.permission.INTERNET" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <application
 android:name=".HardDisk.MyApp"
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.PopupWindow1Test">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */
public class PopupWindow1Test extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow mPopWindow;
    private ImageView imagviewPicture;
    private  final int OPEN_RESULT=1;//打开照相机
    private final int PICK_RESULT=2;//选择图片库


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow1_test);
        imagviewPicture=(ImageView) findViewById(R.id.imagviewPicture);
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow();
            }
        });
    }

    private void showPopupWindow() {
        View contentView = LayoutInflater.from(PopupWindow1Test.this).inflate(R.layout.popuplayout, null);
        //问题1：明明在XML中设置了fill_parent，却没有充满全屏
        mPopWindow = new PopupWindow(contentView,ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);

        TextView tvTakePicture = (TextView) contentView.findViewById(R.id.tvTakePicture);
        TextView tvFromAlbum = (TextView) contentView.findViewById(R.id.tvFromAlbum);
        TextView tvcancelPhoto = (TextView) contentView.findViewById(R.id.tvcancelPhoto);
        tvTakePicture.setOnClickListener(this);
        tvFromAlbum.setOnClickListener(this);
        tvcancelPhoto.setOnClickListener(this);

        View rootview = LayoutInflater.from(PopupWindow1Test.this).inflate(R.layout.popupwindow1_test, null);
        mPopWindow.showAtLocation(rootview, Gravity.NO_GRAVITY, 0, 0);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tvTakePicture: {
                //打开相机拍照
                Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,OPEN_RESULT);
                mPopWindow.dismiss();
            }
            break;
            case R.id.tvFromAlbum: {
                //从相册图片库选择图片
               Intent intent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               startActivityForResult(intent,PICK_RESULT);
               //关闭popuWindow窗口
                mPopWindow.dismiss();
            }
            break;
            case R.id.tvcancelPhoto: {
                mPopWindow.dismiss();
            }
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            //表示拍照后的图片显示结果
            case OPEN_RESULT:
                if(resultCode==RESULT_OK){
                   Bundle bundle=data.getExtras();
                    Bitmap bitmap=(Bitmap) bundle.get("data");
                    imagviewPicture.setImageBitmap(bitmap);
                }
                break;
                //表示选择图片库的图片结果
            case PICK_RESULT:
                if(resultCode==RESULT_OK){
                    Uri uri = data.getData();
                    imagviewPicture.setImageURI(uri);
                }
                break;
        }
    }
}

