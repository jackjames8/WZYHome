package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * Created by Administrator on 2017/7/11.
 */

public class Unit10_CalcWeight_Service extends Service {
    double result=0;
    static  final String TAG="CalBind";
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public IBinder onBind(Intent intent) {
        int sex=intent.getIntExtra("sex",0);
        Double height=intent.getDoubleExtra("height",0);
        cal(sex,height);
        return new calBind();
    }
     private void cal(int sex,Double height){
         if(sex==0){
             result=(height-80)*0.7;

         }else {
             result=(height-70)*0.6;
         }
     }
    class calBind extends Binder{
        public double getdata(){
            return result;

        }

    }


}
