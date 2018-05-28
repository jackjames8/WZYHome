package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */

public class RecyclerViewTest extends AppCompatActivity implements View.OnClickListener {
    RecyclerView mRecyclerView;
    Button btnVertical, btnHorizontal, grid, flow;
    List<String> dummyDatas = new ArrayList();
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_test);
        //绑定控件
        initView();
        btnVertical.setOnClickListener(this);
        btnHorizontal.setOnClickListener(this);
        grid.setOnClickListener(this);
        flow.setOnClickListener(this);
        //创建默认的线性LayoutManager

    }

    /**
     * RecyclerView初始化数据
     */
    private void recyclerIniData() {


        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        mRecyclerView.setHasFixedSize(true);
//创建并设置Adapter
        recyclerViewAdapter = new RecyclerViewAdapter(getDummyDatas());
        mRecyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                Toast.makeText(getApplicationContext(), "data=" + data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        flow = (Button) findViewById(R.id.flow);
        btnVertical = (Button) findViewById(R.id.btnVertical);
        btnHorizontal = (Button) findViewById(R.id.btnHorizontal);
        grid = (Button) findViewById(R.id.grid);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

    }


    //初始化数据
    public List<String> getDummyDatas() {
        dummyDatas.add("南岗洲");
        dummyDatas.add("南岗洲");
        return dummyDatas;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnVertical:
                //创建默认的线性LayoutManager为垂直
                LinearLayoutManager mLayoutManager1 = new LinearLayoutManager(this);
                mLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager1);
                recyclerIniData();
                break;
            case R.id.btnHorizontal:
                LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(this);
                mLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mLayoutManager2);
                recyclerIniData();
                break;
            case R.id.grid:
                GridLayoutManager mLayoutManager3 = new GridLayoutManager(this, 3);
                mRecyclerView.setLayoutManager(mLayoutManager3);
                recyclerIniData();
                break;
            case R.id.flow:
                StaggeredGridLayoutManager mLayoutManager4 = new StaggeredGridLayoutManager(3, LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mLayoutManager4);
                recyclerIniData();
                break;
        }

    }
}
