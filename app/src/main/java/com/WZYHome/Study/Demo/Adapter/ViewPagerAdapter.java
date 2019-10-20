package com.WZYHome.Study.Demo.Adapter;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Util.ViewFactory;
import com.WZYHome.Study.Demo.interfaces.CallBack;

import java.util.List;

/**
 * Created by Administrator on 2018/7/25.
 */

public class ViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private  List<String>  mNewsArrayList;
    private CallBack callBack;

    public ViewPagerAdapter(Context context, List<String> newsArrayList , CallBack callBack1) {
       this.mContext=context;
       this.mNewsArrayList=newsArrayList;
        callBack=callBack1;
    }

    @Override
    public int getCount() {
        return mNewsArrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View view = View.inflate(mContext, R.layout.my_pager_adapter_item, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.tv_title);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);//全屏幕展示
        ViewFactory.getInstance().getHttpImageView(imageView, mNewsArrayList.get(position));
        textView.setText("点击我");
           view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callBack.callBack(position);
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View) object);
    }
}
