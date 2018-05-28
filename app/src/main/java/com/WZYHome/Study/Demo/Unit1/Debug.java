package com.WZYHome.Study.Demo.Unit1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Debug extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

    }

    public static void f2(){
        for(char c=0;c<128;c++)
            if(Character.isLowerCase(c))
                System.out.println("value:"+(int)c+"character:"+c);

    }
    public  static void f1() {
        System.out.println("one");
        System.out.println("two");
        System.out.println("three");
    }
    public static void main(String[] args){
        f1();
        f2();
    }


}
