package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.Adapter.GridViewAdapter;
import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/7/11.
 */

public class GridViewTest2 extends AppCompatActivity {
    private List<Integer> mDatas;
    private GridView mGridView;
    private GridViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view_test2);
        mGridView=(GridView) findViewById(R.id.gv_test);

        initDatas();
        adapter=new GridViewAdapter(GridViewTest2.this,mDatas);
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if(position==parent.getChildCount()-1){
                    mDatas.add(R.drawable.feiji_1);
                    Toast.makeText(GridViewTest2.this, "您点击了添加", Toast.LENGTH_SHORT).show();
                    adapter=new GridViewAdapter(GridViewTest2.this, mDatas);
                    mGridView.setAdapter(adapter);//更新适配器
                    adapter.notifyDataSetChanged();//更新适配器*/
                }

            }
        });

    }
    private void initDatas() {
        mDatas=new ArrayList<>();
        mDatas.add(R.drawable.feiji_1);
        mDatas.add(R.drawable.feiji_1);
        mDatas.add(R.drawable.feiji_1);
        mDatas.add(R.drawable.feiji_1);
        mDatas.add(R.drawable.feiji_1);

    }


}
