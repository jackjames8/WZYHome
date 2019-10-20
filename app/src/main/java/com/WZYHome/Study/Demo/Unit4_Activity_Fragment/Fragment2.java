package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/11/17.
 */

public class Fragment2 extends Fragment {

    private TextView textView ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        final View view = inflater.inflate(R.layout.fragment2, null);
        textView = (TextView) view.findViewById(R.id.text_detail2);
        Bundle bundle = getArguments();
        String str = bundle.getString( "msg");
        textView.setText(str);
        return view;
    }

}