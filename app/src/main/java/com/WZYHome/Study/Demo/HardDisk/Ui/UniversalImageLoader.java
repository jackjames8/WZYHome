package com.WZYHome.Study.Demo.HardDisk.Ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;


import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.WZYHome.Study.Demo.HardDisk.Entity.Dog;
import com.WZYHome.Study.Demo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.orhanobut.logger.Logger;




import static com.WZYHome.Study.Demo.until.url;


/**
 * Created by Administrator on 2017/12/19.
 */

public class UniversalImageLoader extends AppCompatActivity {

    ImageView UniversalImageLoader;
    private DisplayImageOptions options;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_image_loader);

        UniversalImageLoader=(ImageView) findViewById(R.id.UniversalImageLoader);

        options = new DisplayImageOptions.Builder()
                //加载中
                .showImageOnLoading(R.drawable.ic_launcher)
                //当url为空时候加载什么图片
                .showImageForEmptyUri(R.drawable.ic_launcher)
                //当图片加载失败时
                .showImageOnFail(R.drawable.ic_launcher)
                //是否在内存缓存
                .cacheInMemory(true)
                //是否在SD缓存
                .cacheOnDisk(true)
                //缩放模式
                .imageScaleType(ImageScaleType.EXACTLY)
                //Bitmap像素格式
                .bitmapConfig(Bitmap.Config.RGB_565)
                //是否加载EXIF信息
                .considerExifParams(false)
                //控制加载特效，正方形图片
                /*.displayer(new FadeInBitmapDisplayer(300))*/
                //显示圆角图片
                /*.displayer(new RoundedBitmapDisplayer(20))*/
                //显示圆形图片
                .displayer(new CircleBitmapDisplayer())
                .build();

    }

    public void go1(View view){
        Toast.makeText(this,"wq vb ",Toast.LENGTH_SHORT).show();
        Logger.v("hello1");
        Logger.d("hello2");
        Logger.i("hello3");
        Logger.w("hello4");
        Logger.e("hello5");
        Dog dog=new Dog("wangwang","goutou");
        Logger.d(dog);


        String url="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3402673758,3638961754&fm=173&s=C2B01CC544630B173A9CE0C30300F093&w=560&h=378&img.JPEG";
        ImageLoader.getInstance().displayImage(url, UniversalImageLoader, options, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {
                System.out.println(total+"--------->"+current);
                Log.e("--------->",total+"--------->"+current);

            }
        });
    }
}
