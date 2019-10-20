package com.WZYHome.Study.Demo.Unit2_View;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2017/11/2.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>  {
    List<String> datas = new ArrayList();
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public RecyclerViewAdapter(List<String> datas ) {
        this.datas = datas;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_adapter,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    /**
     *  定义一个监听接口
     */
    public  interface OnRecyclerViewItemClickListener {
        /**
         *
         * @param view 点击item的视图
         * @param data 点击得到的数据
         */
        void onItemClick(View view , String data);
    }
    /**
     * 定义接口的方法
     */
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
    if(position==0){
        viewHolder.imageViewImageView.setImageResource(R.drawable.destination_start);
        viewHolder.viewLineUp.setVisibility(View.GONE);
        viewHolder.imageCancel.setVisibility(View.GONE);
        viewHolder.image_add.setVisibility(View.GONE);
    }else if (position==1){
        viewHolder.imageCancel.setVisibility(View.GONE);
        viewHolder.image_add.setVisibility(View.VISIBLE);
        if(datas.size()==2){
            viewHolder.imageViewImageView.setImageResource(R.drawable.destination_end);
            viewHolder.viewLineDown.setVisibility(View.GONE);

        }else{
            viewHolder.imageViewImageView.setImageResource(R.drawable.destination_centra);
            viewHolder.viewLineDown.setVisibility(View.VISIBLE);


        }

    }else if(position==datas.size()-1){
        viewHolder.imageViewImageView.setImageResource(R.drawable.destination_end);
        viewHolder.viewLineUp.setVisibility(View.VISIBLE);
        viewHolder.viewLineDown.setVisibility(View.GONE);
        viewHolder.imageCancel.setVisibility(View.VISIBLE);
        viewHolder.image_add.setVisibility(View.GONE);

    }else {
        viewHolder.imageViewImageView.setImageResource(R.drawable.destination_centra);
        viewHolder.viewLineUp.setVisibility(View.VISIBLE);
        viewHolder.viewLineDown.setVisibility(View.VISIBLE);
        viewHolder.image_add.setVisibility(View.GONE);
        viewHolder.imageCancel.setVisibility(View.VISIBLE);
    }
        viewHolder.mTextView.setText(datas.get(position));

    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addItem(String content, int position) {
        datas.add(position,content);
        notifyItemInserted(position); //Attention!
    }
    public void removeItem(int position) {
        datas.remove(position);
        notifyItemRemoved(position);//Attention!
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public View viewLineDown ,viewLineUp;
       public ImageView imageCancel,image_add,imageViewImageView;
        public ViewHolder(View view){
            super(view);
            mTextView = (TextView) view.findViewById(R.id.item_time_line_txt);
            imageCancel= (ImageView) view.findViewById(R.id.imageCancel);
            image_add= (ImageView) view.findViewById(R.id.imageAdd);
            imageViewImageView= (ImageView) view.findViewById(R.id.imageViewImageView);
            viewLineDown=view.findViewById(R.id.viewLineDown);
            viewLineUp=view.findViewById(R.id.viewLineUp);



            image_add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addItem("按此输入目的地",datas.size());
                    notifyDataSetChanged();
                }
            });
            imageCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        removeItem(getLayoutPosition());
                        notifyDataSetChanged();
                }
            });

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener != null) {
                        //注意这里使用getTag方法获取数据
                        mOnItemClickListener.onItemClick(v,datas.get(getLayoutPosition()));


                    }
                }
            });
        }
    }

}