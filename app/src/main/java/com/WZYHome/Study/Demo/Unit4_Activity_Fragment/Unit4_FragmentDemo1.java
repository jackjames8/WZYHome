package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Unit4_FragmentDemo1 extends Fragment {
    public OnListenerA mlListener;

    View Myview;
    Button button20;

    Unit4_FragmentDemo2 fragment2=new Unit4_FragmentDemo2();

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.unit4_fragmentdemo1,container,false);
    }
     interface OnListenerA{
        public  void  onNameSelected(String name);
         public  void  getView(View view);
    }

    public void setOnNameSelectedListener(OnListenerA listener) {
        mlListener = listener;
    }


     //直接实例化对象;
/*    OnListenerA  a=new OnListenerA() {
        @Override
        public void onNameSelected(String name) {

        }
    };*/
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       Myview=view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final String[] data={"java","android","c++","c","php"};
        ListView listView= (ListView) Myview.findViewById(R.id.listview1);
        button20=(Button) Myview.findViewById(R.id.button20);
        //点击Unit4_FragmentDemo1中的button键,把fragment2中进来来
        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm=getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft=fm.beginTransaction();
                ft.add(R.id.containerFrameLayout, fragment2,"hehe");
                ft.commit();
            }
        });


        listView.setAdapter(new ArrayAdapter<>(Myview.getContext(),android.R.layout.simple_list_item_1,data));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name=data[position];
                if(mlListener!=null){
                    mlListener.onNameSelected(name);
                }
            }
        });

        if(mlListener!=null){
            mlListener.getView(Myview);
        }
    }
}
