package com.WZYHome.Study.Demo.Unit1.base.model;


import androidx.fragment.app.FragmentActivity;

/**
 * @author: Unique
 * CreatedTime 2017/11/2on 14:11
 * function:
 */
public abstract class MvpBaseModel implements MvpModel{
    protected FragmentActivity mActivity;

    public MvpBaseModel() {
    }

    public MvpBaseModel(FragmentActivity activity) {
        this.mActivity = activity;
    }
}
