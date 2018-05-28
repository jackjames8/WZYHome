package com.WZYHome.Study.Demo.Unit1.mvpdemo.model;

/**
 * Created by Administrator on 2017/12/13.
 */

public class ILoginDaoFactory {
    public static ILoginDao getInstance(){
        return new ILoginDao1();
    }
}
