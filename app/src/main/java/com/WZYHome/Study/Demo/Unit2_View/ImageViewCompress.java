package com.WZYHome.Study.Demo.Unit2_View;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit1.base.BaseMvpActivity;
import com.WZYHome.Study.Demo.Unit1.base.presenter.MvpBasePresenter;
import com.WZYHome.Study.Demo.Unit1.base.view.MvpBaseView;


import java.io.ByteArrayOutputStream;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2019/4/2.
 *
 * function:压缩图片
 */

public class ImageViewCompress extends BaseMvpActivity {
    ImageView originPictureImageView,comPressPictureImageView;//原图
    private String path1= Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/111.jpg";
    private String pathYA= Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera/pic5YA.jpg";
    Bitmap mBitmapOrigin;
    @Override
    protected int initLayout() {
        return R.layout.image_view_compress;
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
       originPictureImageView= (ImageView) byId(R.id.originPictureImageView);//原图
       comPressPictureImageView= (ImageView) byId(R.id.comPressPictureImageView);//压缩后的图
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        //  /DCIM/Camera/111.jpg


    }

    public void go1(View view){
        Toast.makeText(getApplicationContext(),"压缩",Toast.LENGTH_SHORT).show();
        mBitmapOrigin= BitmapFactory.decodeFile(path1);
        //100k以下
        //600k


        //第一种压缩法
/*        try {

            File file=new File(path1);
            long length = file.length();
            int b1 = (int) (length / (100 * 1024));
            int quality=100/b1;
            System.out.println("quality="+quality);
            FileOutputStream fileOutputStream=new FileOutputStream(pathYA);
            mBitmapOrigin.compress(Bitmap.CompressFormat.JPEG,quality,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        //第二种压缩法



        try {
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();//内存输出流
            int quality=100;
            while (true){
                byteArrayOutputStream.reset();
                mBitmapOrigin.compress(Bitmap.CompressFormat.JPEG,quality,byteArrayOutputStream);
                int size = byteArrayOutputStream.size();

                if(size>(100 * 1024)){
                    quality-=2;
                }else {
                    break;
                }
            }
            System.out.println("quality="+quality);
            FileOutputStream fileOutputStream = new FileOutputStream(pathYA);
            mBitmapOrigin.compress(Bitmap.CompressFormat.JPEG,quality,fileOutputStream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }
    public void go2(View view){
        //呈现原图
        if(mBitmapOrigin!=null){
            mBitmapOrigin= BitmapFactory.decodeFile(path1);
            originPictureImageView.setImageBitmap(mBitmapOrigin);
        }

    }
    public void go3(View view){
        //呈现压缩图
        Bitmap bitmapya= BitmapFactory.decodeFile(pathYA);
        comPressPictureImageView.setImageBitmap(bitmapya);
    }
    public void go4(View view){

    }

}
