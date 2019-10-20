package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.jsonBean;
import com.WZYHome.Study.Demo.Unit13_NetWork.Bean.myMenu;
import com.WZYHome.Study.Demo.Util.GogleGsonUtil;
import com.WZYHome.Study.Demo.until;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/12/13.
 *     <uses-permission android:name="android.permission.CALL_PHONE" />
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
 <uses-permission android:name="android.permission.WRITE_CONTACTS" />
 <uses-permission android:name="android.permission.CAMERA" />

 <!-- To auto-complete the email text field in the login form with the user's emails -->
 <uses-permission android:name="android.permission.GET_ACCOUNTS" />
 <uses-permission android:name="android.permission.READ_PROFILE" />
 <uses-permission android:name="android.permission.READ_CONTACTS" />

 <uses-permission android:name="android.permission.INTERNET"/>
 <!-- 授予该程序读取外部存储器的权限 -->
 <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>

 <uses-permission android:name="android.permission.INTERNET"/>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit2_View.ExpandableListViewTest"
 android:theme="@style/AppTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ExpandableListViewTest extends Activity {

    //View
    private ExpandableListView expandableListView;

    //Model：定义的数据
    private List<String> groups = new ArrayList<>();
    //注意，字符数组不要写成{{"A1,A2,A3,A4"}, {"B1,B2,B3,B4，B5"}, {"C1,C2,C3,C4"}}*/
    private List<List<myMenu>> childs=new ArrayList<>();


    List arrayList = new ArrayList();

    jsonBean jsonBean;
    JSONObject jsonObject = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.expandable_list_view_test);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);





        String json = until.myMenu;

         jsonBean=(jsonBean) GogleGsonUtil.JsonToObject(json, jsonBean.class);
        List<com.WZYHome.Study.Demo.Unit13_NetWork.Bean.jsonBean.个人信息Bean> 个人信息 = jsonBean.get个人信息();





            JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        //通过迭代器获取这段json当中所有的key值
        Iterator keys = jsonObject.keys();
       
        //然后通过一个循环取出所有的key值
        while (keys.hasNext()){
            String key = String.valueOf(keys.next());
            try {
                JSONArray jsonArray = jsonObject.getJSONArray(key);
                List<myMenu> child=new ArrayList<>();
                for(int i=0;i<jsonArray.length();i++){
                    myMenu myMenu = (com.WZYHome.Study.Demo.Unit13_NetWork.Bean.myMenu) GogleGsonUtil.JsonToObject(jsonArray.opt(i).toString(), myMenu.class);

                    child.add(myMenu);


                }

                childs.add(child);

                /*String s = jsonArray.toString();*/
            } catch (JSONException e) {
                e.printStackTrace();
            }

         
     /*       ob value = null;
            try {
                value = jsonObject.get(key);

                arrayList.add(value);
            } catch (JSONException e) {
                e.printStackTrace();
            }*/

            groups.add(key);


        }



        //最后就可以通过刚刚得到的key值去解析后面的json了

        childs.toString();
      expandableListView.setAdapter(new MyExpandableListView());

    }


    //为ExpandableListView自定义适配器
    class MyExpandableListView extends BaseExpandableListAdapter {

        //返回一级列表的个数
        @Override
        public int getGroupCount() {
            return groups.size();
        }

        //返回每个二级列表的个数
        @Override
        public int getChildrenCount(int groupPosition) { //参数groupPosition表示第几个一级列表
            Log.d("smyhvae", "-->" + groupPosition);
            return childs.get(groupPosition).size();
        }

        //返回一级列表的单个item（返回的是对象）
        @Override
        public Object getGroup(int groupPosition) {
            return groups.get(groupPosition);
        }

        //返回二级列表中的单个item（返回的是对象）
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childs.get(groupPosition).get(childPosition);  //不要误写成groups[groupPosition][childPosition]
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //每个item的id是否是固定？一般为true
        @Override
        public boolean hasStableIds() {
            return true;
        }

        //【重要】填充一级列表
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_group, null);
            }
            TextView tv_group = (TextView) convertView.findViewById(R.id.tv_group);
            tv_group.setText(groups.get(groupPosition));
            return convertView;
        }

        //【重要】填充二级列表
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_child, null);
            }

            ImageView iv_child = (ImageView) convertView.findViewById(R.id.iv_child);
            TextView tv_child = (TextView) convertView.findViewById(R.id.tv_child);

            //iv_child.setImageResource(resId);
            tv_child.setText(childs.get(groupPosition).get(childPosition).getMenuname());

            return convertView;
        }

        //二级列表中的item是否能够被选中？可以改为true
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }


}