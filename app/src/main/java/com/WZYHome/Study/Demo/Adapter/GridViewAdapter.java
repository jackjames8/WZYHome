package com.WZYHome.Study.Demo.Adapter;

/**
 * Created by Administrator on 2018/7/11.
 */

import java.util.List;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.Order_ThreeAdapter;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Integer> list;
    LayoutInflater layoutInflater;
    private ImageView mImageView;

    public GridViewAdapter(Context context, List<Integer> list) {

        this.context = context;
        this.list = list;

        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size()+1;//注意此处
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Wrapper Wrapper=null;
        View view=convertView;
        if(view==null) {
            view= layoutInflater.inflate(R.layout.grid_item, parent, false);
            //将布局文件解析成View的过程，需要资源(CPJ,内存)
            Wrapper=new Wrapper(view);
            view.setTag(Wrapper);

        }else {
            Wrapper= (Wrapper) view.getTag();
        }

        if (position < list.size()) {
            System.out.println("position"+position);
            Wrapper.getLogo().setBackgroundResource(list.get(position));
        }else{
            System.out.println("elseposition"+position);
            Wrapper.getLogo().setBackgroundResource(R.drawable.add);//最后一个显示加号图片
        }
        return view;
    }

    class Wrapper{
        private ImageView mImageView;
        View view;
        public Wrapper(View Row){
            this.view=Row;
        }
        public ImageView getLogo(){
            if(mImageView==null){
                mImageView= (ImageView) view.findViewById(R.id.ImageViewItem);
            }
            return  mImageView;
        }


    }

}
