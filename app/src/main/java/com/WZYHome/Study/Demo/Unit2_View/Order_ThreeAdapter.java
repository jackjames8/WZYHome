package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.User;

import java.util.ArrayList;
import java.util.List;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Order_ThreeAdapter">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Order_ThreeAdapter extends Activity {
   List<User>  userList=new ArrayList<User>();
  /*  List<Map<String,String>> data=new ArrayList<Map<String,String>>();*/
    ListView ListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        ListView= (ListView) findViewById(R.id.ListView);
        userList.add(new User("AAA",1000));
        userList.add(new User("KKK",2000));
        userList.add(new User("CCC",5000));
     /*   fill();*/
        //第一种方法
      /*  SimpleAdapter adapter=new SimpleAdapter(this,
                data,R.drawerlayout1.unit5_listview_testview,
                new String[]{"userName","userScore"},
                new int[]{R.id.Item_list,R.id.textView_age});
        ListView.setAdapter(adapter);*/

        //第二种方法
       /* ListView.setAdapter(new MyAdapter());*/
        //第三种方法

        ListView.setAdapter(new ArrayAdapterDemo(this,0,0,userList));

    }
    class ArrayAdapterDemo extends ArrayAdapter<User>{
        public ArrayAdapterDemo(Context context, int resource, int textViewResourceId, List<User> objects) {
            super(context, 0, 0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Wrapper Wrapper=null;
            View Row=convertView;
            if(Row==null) {
                //*LayoutInflater inflater = LayoutInflater.from(Unit5_BaseAdapter_Object.this);*//*
                Row = getLayoutInflater().inflate(R.layout.unit5_listview_testview, parent, false);
                //将布局文件解析成View的过程，需要资源(CPJ,内存)
                Wrapper=new Wrapper(Row);
                Row.setTag(Wrapper);

            }else {
                Wrapper= (Wrapper) Row.getTag();
            }

            TextView tvAuthor= (TextView)Wrapper.getTvAuthor();
            TextView tvBookName= (TextView)Wrapper.getTvBookName();
            tvBookName.setText(userList.get(position).getUserName()+" ");
            tvAuthor.setText(userList.get(position).getUserScore()+" ");
            return Row;
        }
    }
   /* class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return userList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
           Wrapper Wrapper=null;
            View Row=convertView;
            if(Row==null) {
                *//*LayoutInflater inflater = LayoutInflater.from(Unit5_BaseAdapter_Object.this);*//*
                Row = getLayoutInflater().inflate(R.drawerlayout1.unit5_listview_testview, parent, false);
                //将布局文件解析成View的过程，需要资源(CPJ,内存)
                Wrapper=new Wrapper(Row);
                Row.setTag(Wrapper);

            }else {
                Wrapper= (Wrapper) Row.getTag();
            }
            TextView tvAuthor= (TextView)Wrapper.getTvAuthor();
            TextView tvBookName= (TextView)Wrapper.getTvBookName();
            tvBookName.setText(userList.get(position).getUserName()+" ");
            tvAuthor.setText(userList.get(position).getUserScore()+" ");
            return Row;
        }

    }*/
    class Wrapper{
        TextView tvAuthor;
        TextView tvBookName;

        View Row;
        public Wrapper(View Row){
            this.Row=Row;
        }
        public TextView getTvBookName(){
            if(tvBookName==null){
                tvBookName= (TextView) Row.findViewById(R.id.Item_list);
            }
            return  tvBookName;
        }
        public TextView getTvAuthor(){
            if(tvAuthor==null){
                tvAuthor= (TextView)Row.findViewById(R.id.textView_age);
            }
            return  tvAuthor;
        }

    }
/*    void fill(){
        for(User user:userList){
            Map<String,String> map=new HashMap<String,String>();
            map.put("userName",user.getUserName());
            map.put("userScore",user.getUserScore()+"");
            data.add(map);
        }

    }*/

}
