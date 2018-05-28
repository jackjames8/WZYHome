package com.WZYHome.Study.Demo.Unit1.mvpdemo.model;


import android.os.Handler;
import android.os.Message;

/**
 * Created by Administrator on 2017/12/13.
 */

public class ILoginDao1 implements ILoginDao {
    public static int num=0;
  private Handler handler=new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          switch (msg.what){
              case 0:
                  oncheckUserCallback.onSucess((LoginEntity) msg.obj);
                  break;
              case 1:
                  oncheckUserCallback.onFail(null);
                  break;
              default:
                  break;
          }
      }
  };
  private OncheckUserCallback oncheckUserCallback;
    @Override
    public void checkUser(String userAcount, String userPassword, OncheckUserCallback oncheckUserCallback1) {
        oncheckUserCallback=oncheckUserCallback1;
      new Thread(){
          @Override
          public void run() {
              super.run();

                  handler.sendEmptyMessageDelayed(num++%2,3000);


          }
      }.start();
    }
}
