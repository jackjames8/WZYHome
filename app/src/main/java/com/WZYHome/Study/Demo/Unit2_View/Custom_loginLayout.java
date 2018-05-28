package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/6/18.
 */

public class Custom_loginLayout extends LinearLayout {
    private EditText edUseName,edPassWord;
    Button btnLogin;
    TextView UseName,Password;

    public Custom_loginLayout(Context context) {
        super(context);
        init(context);
    }

    public Custom_loginLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public Custom_loginLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    //将XML布局实例化，并且查找内部的子控件
    void init(Context context){
        View view= LayoutInflater.from(context).inflate(R.layout.login,this,true);
        UseName= (TextView) view.findViewById(R.id.UseName);
        Password= (TextView) view.findViewById(R.id.password);
        edUseName= (EditText) view.findViewById(R.id.editText4);
        edPassWord= (EditText) view.findViewById(R.id.editText5);
        btnLogin= (Button) view.findViewById(R.id.button5);
    }

    public String GetedUseName(){
        return edUseName.getText()+"";
    }
    public String GetedPassWord(){
        return  edPassWord.getText()+"";
    }
   public void setOnClickListener(View.OnClickListener listener){
       btnLogin.setOnClickListener(listener);
    }
    public void SetUseName(String name){
        UseName.setText(name);
    }
    public void SetPassword(String password){
        Password.setText(password);
    }
}
