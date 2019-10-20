package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.List;

import static android.widget.LinearLayout.*;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/CustomTheme">
 <activity
 android:name=".Unit2_View.RecyclerViewActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class RecyclerViewActivity extends AppCompatActivity implements OnClickListener{
    Button btn_list,btn_grid,btn_flow;
    RecyclerView recyclerView;
    private List<String> datas=new ArrayList<>();
    private RecyclerViewAdapter1 adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_activity);
        initView();
        //设置点击事件
        btn_grid.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_flow.setOnClickListener(this);
        //准备数据集合
        initData();

        //设置RecyclerView的适配器
        adapter=new RecyclerViewAdapter1(RecyclerViewActivity.this,datas);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewAdapter1.onItemClickListener() {
            @Override
            public void onItemClick(View View, String data) {
                   Toast.makeText(RecyclerViewActivity.this,"data="+data,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        for(int i=0;i<2;i++){
            datas.add("content"+i);
        }
    }

    private void initView() {
        btn_list= (Button) findViewById(R.id.btn_list);
        btn_grid= (Button) findViewById(R.id.btn_grid);
        btn_flow= (Button) findViewById(R.id.btn_flow);
        recyclerView= (RecyclerView) findViewById(R.id.recyclerView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_flow:
                StaggeredGridLayoutManager layoutManager3=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(layoutManager3);
                break;
            case R.id.btn_grid:
                GridLayoutManager layoutManager2=new GridLayoutManager(RecyclerViewActivity.this,3,GridLayoutManager.VERTICAL,true);
                recyclerView.setLayoutManager(layoutManager2);
                break;
            case R.id.btn_list:
                LinearLayoutManager layoutManager1=new LinearLayoutManager(RecyclerViewActivity.this,LinearLayoutManager.VERTICAL,true);
                recyclerView.setLayoutManager(layoutManager1);
                //定位到最后一条
                recyclerView.scrollToPosition(datas.size()-1);
                break;
        }

    }
}
