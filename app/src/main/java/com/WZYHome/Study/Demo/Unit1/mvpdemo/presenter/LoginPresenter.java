package com.WZYHome.Study.Demo.Unit1.mvpdemo.presenter;

import android.text.TextUtils;

import com.WZYHome.Study.Demo.Unit1.mvpdemo.model.ILoginDao;
import com.WZYHome.Study.Demo.Unit1.mvpdemo.model.ILoginDaoFactory;
import com.WZYHome.Study.Demo.Unit1.mvpdemo.model.LoginEntity;
import com.WZYHome.Study.Demo.Unit1.mvpdemo.view.ILoginView;

/**
 * Created by Administrator on 2017/12/13.
 */

public class LoginPresenter implements ILoginPresenter {
    ILoginDao iLoginDao;
    ILoginView iLoginView;

    public LoginPresenter(ILoginView LoginView) {
        iLoginView=LoginView;
        iLoginDao= ILoginDaoFactory.getInstance();

    }

    @Override
    public void doLogin() {
        String userCount = iLoginView.getUserCount();
        if(TextUtils.isEmpty(userCount)){
            return;
        }

        String userPassword = iLoginView.getUserPassword();
        if(TextUtils.isEmpty(userPassword)){
            return;
        }
        iLoginView.showLoading();
        iLoginDao.checkUser(userCount, userPassword, new ILoginDao.OncheckUserCallback() {
            @Override
            public void onSucess(LoginEntity t) {
                iLoginView.onSuccess();
                iLoginView.hideLoading();
            }

            @Override
            public void onFail(Throwable e) {
                iLoginView.onFail();
                iLoginView.hideLoading();

            }
        });


    }

    @Override
    public void cancelLogin() {

    }
}
