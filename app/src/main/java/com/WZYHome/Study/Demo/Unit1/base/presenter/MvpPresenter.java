package com.WZYHome.Study.Demo.Unit1.base.presenter;


import com.WZYHome.Study.Demo.Unit1.base.view.MvpBaseView;

/**
 * 抽象为接口
 * 
 * @author Unique
 *
 */
public interface MvpPresenter<V extends MvpBaseView> {

	/**
	 * 绑定视图
	 * 
	 * @param view
	 */
	  void attachView(V view);

	/**
	 * 解除绑定
	 */
	  void dettachView();
	
}
