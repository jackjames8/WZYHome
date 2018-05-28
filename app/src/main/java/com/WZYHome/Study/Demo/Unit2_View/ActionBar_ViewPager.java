package com.WZYHome.Study.Demo.Unit2_View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * <!--定义ActionBarStyle风格时,android:background,v7支持包中的android要去掉,变成background-->
 * <uses-sdk
 android:minSdkVersion="7"
 android:targetSdkVersion="26"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit2_View.ActionBar_ViewPager"
 android:theme="@style/CustomTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */
//viewPager只支持v4的Fragment,不支持标准的Fragment,所以把Activity改成FragmentActivity
public class ActionBar_ViewPager extends AppCompatActivity implements android.support.v7.app.ActionBar.TabListener,ViewPager.OnPageChangeListener {
    private ViewPager viewPager;
    android.support.v7.app.ActionBar actionBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit2_actionbar_viewpager);
        viewPager= (ViewPager) findViewById(R.id.ViewPager);
        actionBar=getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("WHAT'S NEW").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("JUST FOR YOU").setTabListener(this));
        actionBar.setTitle("SMT");
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(this);

    }
//实现了ActionBar.TabListener接口
    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
        //当选择标签时，下面viewPager跳转到相应的viewPager页
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
    //实现了ViewPager.OnPageChangeListener接口的方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CountingFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    //自定义一个CountingFragment
    public static class CountingFragment extends android.support.v4.app.Fragment{
        int mNum;
        static CountingFragment newInstance(int num){
            CountingFragment  f=new CountingFragment();
            Bundle args=new Bundle();
            args.putInt("num",num);
            f.setArguments(args);
            return f;
        }


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum=getArguments()!=null ?getArguments().getInt("num"):1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View v=inflater.inflate(R.layout.hello_world,container,false);
            View tv=v.findViewById(R.id.text1);
            ((TextView)tv).setText("Fragment"+mNum);
            return v;
        }
    }
}
