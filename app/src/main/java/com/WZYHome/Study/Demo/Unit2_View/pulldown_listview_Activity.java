package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.WZYHome.Study.Demo.Adapter.pulldownBaseAdapter;
import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.Custom.MyCusListView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.widget.Toast;

/**
 *
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit2_View.pulldown_listview_Activity"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */
public class pulldown_listview_Activity extends Activity {
        protected static final int REF = 0x1;
        private MyCusListView myCuLv;
        private pulldownBaseAdapter mAdapter;
        private List<String> mList;
        private List<String> mList1;
        private int index=1;
    private List<String> mList2;
        private MyHandler handler = new MyHandler(this);

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.pulldown_listview_activity);
            myCuLv = (MyCusListView) findViewById(R.id.myCuLv);
            mList = new ArrayList<String>();
            mList.add("origin item 1");
            mList.add("origin item 2");
            mList.add("origin item 3");
            mList.add("origin item 4");
            mList.add("origin item 5");
            mList.add("origin item 6");
            mList.add("origin item 7");
            mList.add("origin item 8");
            mList.add("origin item 9");
            mList.add("origin item 10");
            mList1= new ArrayList<String>();
            mList1.add("origin item 11");
            mList1.add("origin item 12");
            mList1.add("origin item 13");
            mList1.add("origin item 14");
            mList1.add("origin item 15");
            mList1.add("origin item 16");
            mList1.add("origin item 17");
            mList1.add("origin item 18");
            mList1.add("origin item 19");
            mList1.add("origin item 20");

            mList2= new ArrayList<String>();
            mList2.add("origin item 21");
            mList2.add("origin item 22");
            mList2.add("origin item 23");
            mList2.add("origin item 24");
            mList2.add("origin item 25");
            mList2.add("origin item 26");
            mList2.add("origin item 27");
            mList2.add("origin item 28");
            mList2.add("origin item 29");
            mList2.add("origin item 30");
            Collections.reverse(mList);//反转
            mAdapter = new pulldownBaseAdapter(mList,getApplicationContext());
            myCuLv.setAdapter(mAdapter);
            myCuLv.setOnRefreshListener(new MyCusListView.OnRefreshListener() {
                @Override
                public void toRefresh() {
                    upDateList();
                }
            });
        }

        private void upDateList() {


            if(index==1){
                getdata( mList1);
                handler.sendEmptyMessage(REF);
            }else if(index==2){
                getdata( mList2);
                handler.sendEmptyMessage(REF);
            }else {
                Toast.makeText(this,"没有更多的数据",Toast.LENGTH_SHORT).show();
                myCuLv.onRefreshFinished();
            }
            index++;

        }

    public void getdata(List<String> List) {
        for(String s:List){
            mList.add(0, s);
        }
    }


    static class MyHandler extends Handler {
            WeakReference<pulldown_listview_Activity> mActivity;

            public MyHandler(pulldown_listview_Activity activity) {
                mActivity = new WeakReference<pulldown_listview_Activity>(activity);
            }

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                pulldown_listview_Activity mainActivity = mActivity.get();
                switch (msg.what) {
                    case REF:
                        mainActivity.mAdapter.notifyDataSetChanged();
                        mainActivity.myCuLv.onRefreshFinished();
                        break;
                }
            }
        }
    }


