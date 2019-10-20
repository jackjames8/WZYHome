package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

import java.util.List;

/**
 * Created by Administrator on 2017/10/31.
 */

public class RecyclerViewAdapter1 extends RecyclerView.Adapter<RecyclerViewAdapter1.MyViewHolder> {
    private  Context context;
    private List<String> datas;



    public RecyclerViewAdapter1(Context context, List<String> datas) {
        this.context=context;
        this.datas=datas;
    }

    /**
     * 相当于getView方法中创建view和viewHolder
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView=View.inflate(context, R.layout.my_recycler_view_adapter,null);
        return new MyViewHolder(itemView);
    }

    /**
     * 数据和View绑定
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.TvDestination.setText(datas.get(position));
    }

    /**
     * 得到总条数
     * @return
     */
    @Override
    public int getItemCount() {
        return datas.size();
    }

    public void addData(int position, String data) {
        datas.add(position,data);
        //刷新适配器
        notifyItemInserted(position);
    }

    public void removeData(String content) {
        int position=datas.indexOf(content);
        datas.remove(position);
        //刷新适配器
        notifyItemRemoved(position);
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView TvDestination;
        ImageView imagCancel,imagAdd;
        public MyViewHolder(View itemView) {
            super(itemView);
            TvDestination= (TextView) itemView.findViewById(R.id.TvDestination);
            imagCancel= (ImageView) itemView.findViewById(R.id.imagCancel);
            imagAdd= (ImageView) itemView.findViewById(R.id.imagAdd);

            //单击添加事件
            imagAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addData(getPosition(),"请按此输入目的地");
                }
            });

            //单击删除事件
            imagCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    removeData(datas.get(getLayoutPosition()));
                }
            });


            //点击整个布局View的点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (myonItemClickListener!=null){
                        myonItemClickListener.onItemClick(v,datas.get(getLayoutPosition()));
                    }
                }
            });


        }
    }
   public interface onItemClickListener{
       public void onItemClick(View View, String data);
    }
    onItemClickListener myonItemClickListener;
    public void setOnItemClickListener(onItemClickListener myonItemClickListener){
        this.myonItemClickListener=myonItemClickListener;
    }


}
