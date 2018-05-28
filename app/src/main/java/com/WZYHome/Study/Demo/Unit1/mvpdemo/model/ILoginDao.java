package com.WZYHome.Study.Demo.Unit1.mvpdemo.model;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface ILoginDao {
    public void checkUser(String userAcount,String userPassword,OncheckUserCallback oncheckUserCallback);
    public interface OncheckUserCallback{
        public void onSucess(LoginEntity t);
        public void onFail(Throwable e);
    }

}
