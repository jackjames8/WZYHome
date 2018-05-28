package com.WZYHome.Study.Demo.Unit13_NetWork;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/4.
 */

public class Unit13_MyJavaScriptInterface {
    private Context context;
    public Unit13_MyJavaScriptInterface(Context context) {
        this.context=context;
    }
    //在android代码中实现对应的接口给JavaScript调用
    @JavascriptInterface
    public  void myShowToast(String toast){
        Toast.makeText(context,toast,Toast.LENGTH_LONG).show();

    }

}
