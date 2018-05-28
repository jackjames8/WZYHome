package com.example.harddisk.base;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by Administrator on 2017/12/19.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);//极光推送初始化
        //ImageLoader配置
        initImageLoader(getApplicationContext());
        //Logger配置
     /*   initLogger(getApplicationContext());*/

    }



    public static void initLogger(Context context) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true　是否显示线程信息
                .methodCount(2)         // (Optional) How many method line to show. Default 2 默认显示2级
                .methodOffset(0)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("com.WZYHome.Study.Demo")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

    }

    public static void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you may tune some of them,
        // or you can create default configuration by
        //  ImageLoaderConfiguration.createDefault(this);
        // method.
       //------------------------ImageLoader配置------------------------------------------------------------------->
        ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
        //设置图片加载的优先级
        config.threadPriority(Thread.NORM_PRIORITY + 2);
        //是否不缓存多种尺寸在内存
        config.denyCacheImageMultipleSizesInMemory();
        //本地SD存储的文件加密规范
        config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
        //本地SD存储的上限
        config.diskCacheSize(50 * 1024 * 1024); // 50 MiB
        //任务执行顺序　队列 栈LIFO后进先出
        config.tasksProcessingOrder(QueueProcessingType.LIFO);
        //打印日志
        config.writeDebugLogs(); // Remove for release app
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config.build());
        //------------------------ImageLoader配置------------------------------------------------------------------->

    }
}
