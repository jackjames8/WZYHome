package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/6/15.
 */

public class GridView_Spinner extends Activity {
    GridView GridView1;
    Spinner spinner;
    String[] date={"AAA","BBB","CCC","DDD","EEE","FFF"};
    int[]  resIds={R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
       };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unt5_listview);
        GridView1= (GridView) findViewById(R.id.GridView1);
        spinner= (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String num=" ";
                TextView tv= (TextView) view.findViewById(android.R.id.text1);
                num=(String) tv.getText()+" ";
               GridView1.setNumColumns(Integer.parseInt(num));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner.setSelection(2);
        GridView1.setAdapter(new MyAdapter());
    }
    class MyAdapter extends ArrayAdapter<String>{

        public MyAdapter() {
            super(GridView_Spinner.this, 0);
        }
        public int getCount() {
            return resIds.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View Row=convertView;
            Wrapper wrapper=null;
            if(Row==null) {
                LayoutInflater inflater = getLayoutInflater();
                Row= inflater.inflate(R.layout.unit5_listview_testview, parent, false);
                wrapper=new Wrapper(Row);
                Row.setTag(wrapper);
            }else{
                wrapper=(Wrapper) Row.getTag();
            }
            ImageView imageView= wrapper.getImageView();
            TextView  textView= wrapper.getTextView();
            imageView.setImageResource(resIds[position]);
            textView.setText(date[position]);

            return Row;
        }

    }
    class Wrapper{
        ImageView imageView;
        TextView textView;
        View Row;
        public Wrapper(View Row){
            this.Row=Row;
        }

        public TextView getTextView() {
            if(textView==null){
                textView= (TextView) Row.findViewById(R.id.Item_list);
            }
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public ImageView getImageView() {
            if(imageView==null){
                imageView= (ImageView) Row.findViewById(R.id.imageView2);
            }
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }
    }

}
