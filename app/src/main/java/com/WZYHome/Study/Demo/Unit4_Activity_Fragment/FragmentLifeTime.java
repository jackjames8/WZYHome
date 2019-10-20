package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/8/22.
 */

public class FragmentLifeTime extends Fragment {
    //Fragment的生命周期
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e("FragmentonAttach()","onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("FragmentonCreate()","onCreate()");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.e("FragmentononCreateView","onCreateView");
        return inflater.inflate(R.layout.unt5_listview,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e("FragmentonViewCreated","onViewCreated");
        String[] data={"AAA","BBB","CCC"};
       ListView listView= (ListView) view.findViewById(R.id.ListView);
        listView.setAdapter(new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1,data));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("FragmentonActivityCreat","onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("FragmentonStart()","onStart()");
    }

    @Override
    public void onResume() {
        Log.e("FragmentonResume()","onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.e("FragmentonPause()","onPause()");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.e("FragmentonStop()","onStop()");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.e("FragmentonDestroyView()","onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.e("FragmentonDestroy()","onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.e("FragmentonDetach()","onDetach()");
        super.onDetach();
    }

}
