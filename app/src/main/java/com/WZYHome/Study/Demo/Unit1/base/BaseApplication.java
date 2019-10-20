package com.WZYHome.Study.Demo.Unit1.base;

import android.app.Application;
import android.content.Context;


import androidx.multidex.MultiDex;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Util.SaveData;
import com.WZYHome.Study.Demo.Util.SkipActivity;
import com.WZYHome.Study.Demo.Util.ToastUtils;
import com.WZYHome.Study.Demo.Util.Utils;
import com.WZYHome.Study.Demo.Util.ViewFactory;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;


/**
 * @author: Unique
 * createDate: 2017/10/26 17:51
 * function:
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        try {
            ToastUtils.init(true);

            ViewFactory.init(getApplicationContext());

            initImagerLoader(getApplicationContext());
//            CrashReport.initCrashReport(getApplicationContext(), "cb8f30a956", false);
            SaveData.init(getApplicationContext());
            SkipActivity.init(getApplicationContext());
            Utils.init(getApplicationContext());
        } catch (Exception e) {

        }
    }



    private void initImagerLoader(Context context) {

        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.app_default_icon_white)      //默认图
                .showImageForEmptyUri(R.drawable.app_default_icon_white)    //默认图
                .showImageOnFail(R.drawable.app_default_icon_white)         //默认图
                .cacheInMemory(true)                                    //在内存中缓存
                .cacheOnDisk(true)                                      //在SD卡缓存
                .build();                                               //返回DisplayImageOptions对象

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(defaultOptions)
                .threadPriority(Thread.NORM_PRIORITY - 2)               //线程优先级
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //把图片名MD5
                .memoryCache(new LruMemoryCache(8 * 1024 * 1024))
                .diskCacheSize(12 * 1024 * 1024)
                .denyCacheImageMultipleSizesInMemory()                  //否认在内存中缓存图像多种尺寸
                .tasksProcessingOrder(QueueProcessingType.LIFO)         //图片加载处理方式
                .build();
        ImageLoader.getInstance().init(config);
    }


    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this); // Enable MultiDex.
    }

}
