package com.WZYHome.Study.Demo.Util;

import android.util.Log;

/**
 * Created by Administrator on 2018/1/19.
 * fuction:统一管理打印日志
 */

public class LogUtil {
    public static boolean IsDebug=true;
    public static void LogI(String Tag,String Mes){
        if(IsDebug){
            Log.i(Tag,Mes);
        }
    }
}
