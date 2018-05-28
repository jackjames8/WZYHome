package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.BaseAdapterTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class BaseAdapterTest extends AppCompatActivity {
    ListView ListView;
     List<String> dataScources= new ArrayList<String>();
    List<Map<String,String>>  data=new ArrayList<Map<String,String>>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        ListView= (ListView) findViewById(R.id.ListView);
        String[]  course=getResources().getStringArray(R.array.Course);
        for(int i=0;i<course.length;i++){
            dataScources.add(course[i]);
        }
        fill();
        //SimpleAdapter与Map集合一起用来显示图片加文字
        final SimpleAdapter adapter=new SimpleAdapter(this,
        data,R.layout.unit5_listview_testview,
                new String[]{"name","age"},
                new int[]{R.id.Item_list,R.id.textView_age});
        ListView.setAdapter(adapter);


        /*ListView.setAdapter(new MyAdapter());*/
    }
    void fill(){
        Map<String,String>  map= new HashMap();
        map.put("name","张三");
        map.put("age","20");
        data.add(map);
        map=new HashMap<String,String>();
        map.put("name","李四");
        map.put("age","30");
        data.add(map);
        /*Map<String,String> geta=new HashMap();
        geta.put("name","李四");
        geta.put("age","30");
        data.add(geta);*/
    };
    /**
     * BaseAdapter用法可以显示图片加文字
     */

     /*  class MyAdapter extends BaseAdapter{
           *//**
            *
            * 项的个数
            *//*

           @Override
           public int getCount() {
               return dataScources.size();
           }
           *//*
           * 返回项
            *//*

           @Override
           public Object getItem(int position) {
               return position;
           }
           *//*
           * 返回项ID
            *//*

           @Override
           public long getItemId(int position) {
               return position;
           }
           *//*
           * 返回项的View
            *//*
           @Override
           public View getView(int position, View convertView, ViewGroup parent) {
               *//*TextView textView=new TextView(Unit5_BaseAdapter.this);*//*
               //下面二种建立 布局填充器的方法
              *//* LayoutInflater  inflater1=LayoutInflater.from(Unit5_BaseAdapter.this);*//*
               LayoutInflater inflater=getLayoutInflater();
               View Row=inflater.inflate(R.drawerlayout1.unit5_listview_testview,parent,false);
               TextView textView= (TextView)Row.findViewById(R.id.Item_list);
               textView.setText(dataScources.get(position));
               return Row;
           }
       }*/
}
