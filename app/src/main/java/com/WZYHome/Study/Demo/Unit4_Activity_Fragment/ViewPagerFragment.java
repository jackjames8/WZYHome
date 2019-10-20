package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/8/26.
 */

public class ViewPagerFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.unit4_fragmentdemo1,container,false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final String[] data={"java","android","c++","c","php"};
        ListView listView= (ListView) view.findViewById(R.id.listview1);
        listView.setAdapter(new ArrayAdapter<>(view.getContext(),android.R.layout.simple_list_item_1,data));
    }

}
