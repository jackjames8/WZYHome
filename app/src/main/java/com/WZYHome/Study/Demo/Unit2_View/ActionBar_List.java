package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/CustomTheme">
 <activity
 android:name=".Unit2_View.ActionBar_List">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ActionBar_List extends AppCompatActivity implements ActionBar.OnNavigationListener {
    private static final String[] LIST_ITEMS={"frament1","fragment2","fragment3"};
    Fragment[] fragmentList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit2_actionbar_list);
        ActionBar actionBar=getSupportActionBar();
        //设置actionBar导航模式
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        //设置列表下拉导航出现的内容
        SpinnerAdapter adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,
                LIST_ITEMS);
        //设置actionBar的回调函数
        actionBar.setListNavigationCallbacks(adapter,this);


        actionBar.setTitle("");
        fragmentList=new Fragment[3];
        for(int i=0;i<3;i++){
            fragmentList[i]=CountingFragment.newInstance(i);
        }

    }
    //选择相应的列表内容所产出的事件
    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        android.support.v4.app.FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container,fragmentList[itemPosition]);
        fragmentTransaction.commit();
        return false;
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
