package com.WZYHome.Study.Demo.Util;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;


/**
 * @author: Unique
 * CreatedTime 2017/11/2on 14:11
 * function: ImageView创建工厂
 */
public class ViewFactory {
    private static Context mContext;
    private static ImageLoader mImageLoader = null;

    private static ViewFactory viewFactory = null;

    private ViewFactory() {

    }

    public static void init(Context context) {
        if (viewFactory == null) {
            synchronized (ViewFactory.class) {
                if (viewFactory == null) {
                    viewFactory = new ViewFactory();
                    mImageLoader = ImageLoader.getInstance();
                    mContext = context;
                }
            }
        }
    }

    public static ViewFactory getInstance() {
        return viewFactory;
    }

    /**
     * 加载网络图片
     *
     * @param imageView 显示控件
     * @param httpUrl   网络路径
     */
    public void getHttpImageView(ImageView imageView, String httpUrl) {
//        Glide.with(mContext).load(httpUrl).into(imageView);
        mImageLoader.displayImage(httpUrl, imageView);
    }

    /**
     * 加载网络图片
     *
     * @param imageView 显示控件
     * @param httpUrl   网络路径
     */
    public void getNewHttpImageView(ImageView imageView, String httpUrl) {
//        Glide.with(mContext).load(httpUrl).skipMemoryCache(true).into(imageView);
        mImageLoader.displayImage(httpUrl, imageView);
    }

    /**
     * 加载本地图片
     *
     * @param path      sd卡路径
     * @param imageView 显示控件
     */
    public void getPathImageView(String path, ImageView imageView) {
//        File file = new File(path);
//        Glide.with(mContext).load(file).into(imageView);
        mImageLoader.displayImage("file://" + path, imageView);
    }

    public String getPath(String httpUrl) {
        return mImageLoader.getDiskCache().get(httpUrl).getPath();
    }
    public Bitmap getBitmap(String httpUrl) {
        return mImageLoader.loadImageSync(httpUrl);
    }
}
