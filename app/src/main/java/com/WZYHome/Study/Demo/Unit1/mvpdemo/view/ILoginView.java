package com.WZYHome.Study.Demo.Unit1.mvpdemo.view;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface ILoginView {
    public String getUserCount();
    public String getUserPassword();
    public void showLoading();
    public void hideLoading();
    public void onSuccess();
    public void onFail();

}
