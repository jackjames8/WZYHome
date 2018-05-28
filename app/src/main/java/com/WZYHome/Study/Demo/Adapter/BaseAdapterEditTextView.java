package com.WZYHome.Study.Demo.Adapter;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.Entity.Book;
import com.WZYHome.Study.Demo.R;

import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/9.
 */

public class BaseAdapterEditTextView extends BaseAdapter implements View.OnClickListener {
    List<Book> mUers;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public BaseAdapterEditTextView(List<Book> list ,Context context) {
        this.mUers = list;
        mContext=context;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
        public int getCount() {
            return mUers.size();
        }

        @Override
        public Book getItem(int position) {
            return mUers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         *
         * @param position
         * @param convertView 我们的条目每次切换 展现--->不展现--->又展现，都会重复getView方法，导致我们条目数据丢失
         * @param parent　　2.浪费对象,浪费内存
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder=null;
           /* View Row=convertView;*///重复利用了view资源
            if(convertView==null) {

                convertView = mLayoutInflater.inflate(R.layout.unit_base_adapter_object, parent, false);
                System.out.println("MyAdapter.getView--->"+position+"内存地址"+convertView.hashCode());
                TextView userTextView=convertView.findViewById(R.id.userTextView);
                Button userButton=convertView.findViewById(R.id.usrButton);
                EditText mEditText=convertView.findViewById(R.id.inputEditText);
                //将布局文件解析成View的过程，需要资源(CPJ,内存)
                viewHolder=new ViewHolder();
                viewHolder.userTextView=userTextView;
                viewHolder.usrButton=userButton;
                viewHolder.inputEditText=mEditText;
                convertView.setTag(viewHolder);

            }else {
                viewHolder=(ViewHolder)convertView.getTag();
                //加载的时候移除监听器
                viewHolder.inputEditText.removeTextChangedListener((TextWatcher) viewHolder.inputEditText.getTag());
            }

            TextWatcher watcher = (TextWatcher) viewHolder.inputEditText.getTag();
             //显示的内容的时候
            final Book book= (Book) getItem(position);
            viewHolder.userTextView.setText(book.getTvBookName()+" ");
            viewHolder.usrButton.setText(book.getTvAuthor()+" ");
            viewHolder.usrButton.setOnClickListener(this);//设置监听器
            viewHolder.usrButton.setTag(book);//保存当前对象;
            viewHolder.inputEditText.setText(book.getContent());

            if(watcher==null){
                watcher=new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        book.setContent(s.toString());//保存每天个对象的值
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                };
                viewHolder.inputEditText.setTag(watcher);//保留监听器
            }
            //作监听
            viewHolder.inputEditText.addTextChangedListener(watcher);//设置监听


            return convertView;
        }

    /**
     *
     * @param v　事件源5554
     */
    @Override
    public void onClick(View v) {
        Book book = (Book) v.getTag();
        Toast.makeText(mContext,book.getTvAuthor(),Toast.LENGTH_SHORT).show();
    }
}
    class ViewHolder{
        TextView userTextView;
        Button usrButton;
       EditText inputEditText;

    }


