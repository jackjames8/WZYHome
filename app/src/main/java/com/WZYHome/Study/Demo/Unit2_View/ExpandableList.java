package com.WZYHome.Study.Demo.Unit2_View;
        import android.app.Activity;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AbsListView;
        import android.widget.BaseExpandableListAdapter;
        import android.widget.Button;
        import android.widget.ExpandableListAdapter;
        import android.widget.ExpandableListView;
        import android.widget.ExpandableListView.OnChildClickListener;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.WZYHome.Study.Demo.R;

        import static android.widget.LinearLayout.HORIZONTAL;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.ExpandableList">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ExpandableList extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.expandlistview);

        final ExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            //设置组视图的图片
            int[] logos = new int[] { R.drawable.a, R.drawable.b,R.drawable.c};
            //设置组视图的显示文字
            private String[] generalsTypes = new String[] { "收起" };
            //子视图显示文字
            private String[][] generals = new String[][] {
                    { "全拆座" },
            };
            //子视图图片
            public int[][] generallogos = new int[][] {
                    { R.drawable.feiji_1},
                 };

            //自己定义一个获得文字信息的方法
            TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.FILL_PARENT, 64);
                TextView textView = new TextView(
                        ExpandableList.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                textView.setTextColor(Color.BLACK);
                return textView;
            }


            //重写ExpandableListAdapter中的各个方法
            @Override
            public int getGroupCount() {
                // TODO Auto-generated method stub
                return generalsTypes.length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                // TODO Auto-generated method stub
                return generalsTypes[groupPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                // TODO Auto-generated method stub
                return groupPosition;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                // TODO Auto-generated method stub
                return generals[groupPosition].length;
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                // TODO Auto-generated method stub
                return generals[groupPosition][childPosition];
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                // TODO Auto-generated method stub
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                // TODO Auto-generated method stub
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded,
                                     View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                LinearLayout ll = new LinearLayout(
                        ExpandableList.this);
                ll.setOrientation(HORIZONTAL );
               /* ImageView logo = new ImageView(ExpandableList.this);
                logo.setImageResource(logos[groupPosition]);
                logo.setPadding(50, 0, 0, 0);
                ll.addView(logo);*/
                TextView textView = getTextView();
                textView.setTextColor(getResources().getColor(R.color.orange));
                textView.setPadding(50,5,0,0);
                textView.setTextSize(15);
                textView.setText(getGroup(groupPosition).toString());
                ll.addView(textView);
                return ll;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent) {
                // TODO Auto-generated method stub
                LinearLayout ll = new LinearLayout(
                        ExpandableList.this);
                ll.setOrientation(HORIZONTAL );
                //在子项加一个Button
                Button SpecialSpecItems=new Button(ExpandableList.this);
                SpecialSpecItems.setText(getChild(groupPosition, childPosition)
                        .toString());
                ll.addView(SpecialSpecItems);

               /* ImageView generallogo = new ImageView(
                        ExpandableList.this);
                generallogo
                        .setImageResource(generallogos[groupPosition][childPosition]);
                ll.addView(generallogo);*/
               /* TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition)
                        .toString());
                ll.addView(textView);*/
                return ll;
            }

            @Override
            public boolean isChildSelectable(int groupPosition,
                                             int childPosition) {
                // TODO Auto-generated method stub
                return true;
            }

        };

        ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.list);
        expandableListView.setAdapter(adapter);


        //设置item点击的监听器
        expandableListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                Toast.makeText(
                        ExpandableList.this,
                        "你点击了" + adapter.getChild(groupPosition, childPosition),
                        Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }
}
