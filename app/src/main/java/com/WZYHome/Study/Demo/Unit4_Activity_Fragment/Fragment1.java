package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/11/17.
 */

public class Fragment1 extends Fragment {

    private MyInter  myInter ;

    public interface MyInter{
        public void passValue(String info);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getActivity() instanceof MyInter) {//如果宿主Activity实现了该接口
            myInter = (MyInter) getActivity(); //就将mylistener 指向该Activity
        }
    }
    private TextView textView ;
    private Button btn ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment1, null );
        textView = (TextView) view.findViewById(R.id.text1_detail);
        btn = (Button) view.findViewById(R.id.btnId);
        btn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myInter.passValue( "我是fragment1中的信息" );
            }

        });
        textView.setText( "我是属于一个fragment");
        return view;
    }
}