package com.WZYHome.Study.Demo.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/7/23.
 */

public class pulldownBaseAdapter extends BaseAdapter {
    private List<String> mList;
    private Context mContext;

    public pulldownBaseAdapter(List<String> mList1,Context mContext1) {
        this.mList=mList1;
        this.mContext=mContext1;
    }

    @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(mContext);
            textView.setText(mList.get(position));
            textView.setTextColor(mContext.getResources()
                    .getColor(android.R.color.black));
            textView.setBackgroundColor(mContext.getResources()
                    .getColor(android.R.color.white));
            textView.setTextSize(25);
            return textView;
        }
    }

