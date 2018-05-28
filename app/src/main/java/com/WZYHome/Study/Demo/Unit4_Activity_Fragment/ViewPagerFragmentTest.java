package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;

import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit4_Activity_Fragment.Unit4_ViewPagerFragment">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ViewPagerFragmentTest extends AppCompatActivity implements TabHost.OnTabChangeListener,ViewPager.OnPageChangeListener {
   private ViewPager mViewpager;
    private  TabHost mTabHost;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit4_viewpagerfragment);
        //获取viewpager页面

        mTabHost= (TabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup();
        mTabHost.addTab(mTabHost.newTabSpec("detail").setIndicator("detail").setContent(TF));
        mTabHost.addTab(mTabHost.newTabSpec("list").setIndicator("list").setContent(TF));
        mTabHost.addTab(mTabHost.newTabSpec("app").setIndicator("app").setContent(TF));
        mTabHost.setOnTabChangedListener(this);
        mViewpager= (ViewPager) findViewById(R.id.pager);
        mViewpager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager()));
        mViewpager.setOnPageChangeListener(this);


        /*//能过viewpager页面设置相应的内容
        PagerTitleStrip PTS= (PagerTitleStrip) findViewById(R.id.tab);
        PTS.setTextColor(Color.YELLOW);*/
    }
    //为TabHost设置选项卡内容
    TabHost.TabContentFactory TF =new TabHost.TabContentFactory() {
        @Override
        public View createTabContent(String tag) {
            View ret=new View(getApplicationContext());
            ret.setMinimumHeight(0);
            ret.setMinimumWidth(0);
            return ret;
        }
    };
    //重写TabHost.OnTabChangeListener的方法
    @Override
    public void onTabChanged(String tabId) {
        if(tabId.equals("detail")){
            mViewpager.setCurrentItem(0);
        }else if (tabId.equals("list")){
            mViewpager.setCurrentItem(1);
        }else {
            mViewpager.setCurrentItem(2);
        }

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mTabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //设置一个fragmentAdapter适配器，去显示fragment.
    class MyFragmentAdapter extends FragmentPagerAdapter{

        private ArrayList<android.support.v4.app.Fragment> fragments=new ArrayList<>();

        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
            //添加Fragment到对应的集合中去
            fragments.add(new ViewPagerFragment());
            fragments.add(new ViewPagerFragment());
            fragments.add(new ViewPagerFragment());
        }
        //通过getItem()方法去调用所要呈现的fragment
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
           /* return CountingFragment.newInstance(position) ;*/
           return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();//设置有3页
        }

      /*//标签页上显示名字
        @Override
        public CharSequence getPageTitle(int position) {

            return position+"";
        }*/
    }

    //自定义一个CountingFragment
   /* public static class CountingFragment extends android.support.v4.app.Fragment{
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

        @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.drawerlayout1.hello_world,container,false);
        View tv=v.findViewById(R.id.text1);
        ((TextView)tv).setText("Fragment"+mNum);
        return v;
    }
}*/
}
