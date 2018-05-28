package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Unit4_FragmentDemo2 extends Fragment {
    private final static String TAG="DetailFragment";
    private TextView textView;
    private Button backButton;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.unit4_fragmentdemo2,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
      textView = (TextView) view.findViewById(R.id.textView42);
        backButton=(Button) view.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
                supportFragmentManager.popBackStack();//移出回退栽顶元素
             /*   supportFragmentManager.popBackStackImmediate();*///移出回退栽顶元素,用在popstackfragementTest中。

            }
        });

    }
    public  void setName(String name){
        textView.setText(name);
    }
}
