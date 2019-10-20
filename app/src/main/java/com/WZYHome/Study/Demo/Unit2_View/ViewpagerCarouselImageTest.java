package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.WZYHome.Study.Demo.Adapter.ViewPagerAdapter;
import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.interfaces.CallBack;

import java.util.ArrayList;
import java.util.List;

/**
 *

 <uses-permission android:name="android.permission.CALL_PHONE" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.WRITE_CONTACTS" />
 <uses-permission android:name="android.permission.CAMERA" />

 <!-- To auto-complete the email text field in the login form with the user's emails -->
 <uses-permission android:name="android.permission.GET_ACCOUNTS" />
 <uses-permission android:name="android.permission.READ_PROFILE" />
 <uses-permission android:name="android.permission.READ_CONTACTS" />

 <uses-permission android:name="android.permission.INTERNET"/>

 <permission android:name="com.pzf.permission" android:protectionLevel="normal"></permission>

 <uses-permission android:name="com.pzf.permission"/>

 <application
 android:name="com.WZYHome.Study.Demo.Unit1.base.BaseApplication"
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
 * 轮播+加动态指示
 */

public class ViewpagerCarouselImageTest extends AppCompatActivity implements ViewPager.OnPageChangeListener,CallBack {
    private ViewPager mViewPager;
    //定义一个view的集合
    ArrayList<View> View= new ArrayList<>();

    LinearLayout linearLayoutDots;

    List<String> ViewData=new ArrayList<>();;

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
        mViewPager.setAdapter(new ViewPagerAdapter(this,ViewData,this));
        mViewPager.setCurrentItem(0);
        //设置viewPager的监听事件
        mViewPager.addOnPageChangeListener(this);// 设置页面更新监听

    }
    private void initData() {
        ViewData.add("http://img4.imgtn.bdimg.com/it/u=1711471981,2115873771&fm=26&gp=0.jpg");
        ViewData.add("http://pic27.photophoto.cn/20130601/0036036814248019_b.jpg");
        ViewData.add("http://pic36.nipic.com/20131221/8097124_025507510000_2.jpg");
        ViewData.add("http://s7.sinaimg.cn/mw690/004kRGavgy6K7G1FN4i16&690");
        ViewData.add("http://pic31.nipic.com/20130723/7447430_105434565000_2.jpg");



        //初始化View
/*        newsList.add(new News("我是第一美女",R.drawable.a));//1
        newsList.add(new News("我是第二美女",R.drawable.a1));//2
        newsList.add(new News("我是第三美女",R.drawable.a2));//3
        newsList.add(new News("我是第四美女",R.drawable.a3));//4*/
    }
    private void intDots() {        //初始化小点
        for(int i=0;i<ViewData.size();i++){
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

        //设置当前页,smoothScroll是否平稳滑动过来
        mViewPager.setCurrentItem(position,false);

        //设置小点值
        for(int i=0;i<linearLayoutDots.getChildCount();i++){
            ImageView imageView = (ImageView) linearLayoutDots.getChildAt(i);
            if(i==position){
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

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void callBack(int position) {
        if(position==ViewData.size()-1){
            Toast.makeText(getApplicationContext(),"点击了最后一个"+position,Toast.LENGTH_SHORT).show();
        }

    }
}
