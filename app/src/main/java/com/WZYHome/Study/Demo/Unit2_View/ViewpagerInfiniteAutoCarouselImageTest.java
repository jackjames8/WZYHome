package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.widget.ImageView;
import android.widget.LinearLayout;

import com.WZYHome.Study.Demo.Adapter.MyPagerAdapter;
import com.WZYHome.Study.Demo.Entity.News;
import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.interfaces.CallBack;

import java.util.ArrayList;

/**
 *
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit2_View.ViewpagerCarouselImageTest"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 * 无限轮播+加动态指示
 */

public class ViewpagerInfiniteAutoCarouselImageTest extends AppCompatActivity implements ViewPager.OnPageChangeListener,CallBack {
    private ViewPager mViewPager;
    private  static  final  int FIRST_PAGE=1;
    //定义一个view的集合
    ArrayList<News> newsList= new ArrayList<>();
    private  int currentPosition;
    LinearLayout linearLayoutDots;
    private boolean  isAlive=true;;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(currentPosition==0){
            mViewPager.setCurrentItem(currentPosition+2,false);
            }else {
                mViewPager.setCurrentItem(currentPosition+1,false);
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_pager_adapter_test);
        mViewPager= (ViewPager) findViewById(R.id.ViewPager);
        linearLayoutDots= (LinearLayout) findViewById(R.id.ll_dots);

        //初始化View
        initData();
        //初始化小点
        intDots();
        //设置数据适配器
        mViewPager.setAdapter(new MyPagerAdapter(this,newsList,this));
        mViewPager.setCurrentItem(FIRST_PAGE);
        //设置viewPager的监听事件
        mViewPager.addOnPageChangeListener(this);// 设置页面更新监听
        new MyThread().start();
    }

    private void intDots() {
        for(int i=0;i<newsList.size()-2;i++){
            //实例化imageView
            ImageView imageView=new ImageView(this);
            if(i==0){
               imageView.setImageResource(R.drawable.shape_bg_point_enable);
            }else {
              imageView.setImageResource(R.drawable.shape_bg_point_disable);
            }
            //代码设置大小是指相对像素
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(45,45);
            params.setMargins(5,5,5,5);
            //添加到线性布局中
            linearLayoutDots.addView(imageView,params);
        }
    }

    private void initData() {
        newsList.add(new News("我是第四美女",R.drawable.a3));//0页
        newsList.add(new News("我是第一美女",R.drawable.a));//1
        newsList.add(new News("我是第二美女",R.drawable.a1));//2
        newsList.add(new News("我是第三美女",R.drawable.a2));//3
        newsList.add(new News("我是第四美女",R.drawable.a3));//4
        newsList.add(new News("我是第一美女",R.drawable.a));//5页
    }

    //滑动过程中的方法position的索引值
    //positionOffset 0-1
    //positionOffsetPixels //偏移像素值
    //滑动过程中的方法position索引值
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    //选中某一页的监听
    @Override
    public void onPageSelected(int position) {
        if(position==newsList.size()-1){
            //设置当前值为1
            currentPosition=FIRST_PAGE;
        }else  if(position==0){
            currentPosition=newsList.size()-2;
        }else {
            currentPosition=position;
        }
        //设置小点值
        int dotPosition=currentPosition-1;
        for(int i=0;i<linearLayoutDots.getChildCount();i++){
            ImageView imageView = (ImageView) linearLayoutDots.getChildAt(i);
            if(i==dotPosition){
             //从线性布局取出对应小点，设置点亮
                imageView.setImageResource(R.drawable.shape_bg_point_enable);
            }else {
                imageView.setImageResource(R.drawable.shape_bg_point_disable);
            }
        }
    }
    //滑动状态改变的方法sate:dragging 拖动 idle 静止, setting惯性过程
    @Override
    public void onPageScrollStateChanged(int state) {
        //如果当滑动是静止状态，才把当前页给替换
        if(state==ViewPager.SCROLL_STATE_IDLE){
            //设置当前页,smoothScroll是否平稳滑动过来
            mViewPager.setCurrentItem(currentPosition,false);
        }
    }

    @Override
    public void callBack(int position) {

    }

    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            while (isAlive){
                try {
                    sleep(2000);
                    mHandler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isAlive=false;
    }
}
