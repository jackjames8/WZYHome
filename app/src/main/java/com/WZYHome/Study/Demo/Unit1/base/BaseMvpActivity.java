package com.WZYHome.Study.Demo.Unit1.base;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit1.base.presenter.MvpBasePresenter;
import com.WZYHome.Study.Demo.Unit1.base.view.MvpBaseView;
import com.WZYHome.Study.Demo.Util.SkipActivity;
import com.WZYHome.Study.Demo.Util.ViewFactory;

import java.text.DecimalFormat;

/**
 * V层定义
 *
 * @author Unique
 */
public abstract class BaseMvpActivity<V extends MvpBaseView, P extends MvpBasePresenter<V>> extends AppCompatActivity implements View.OnClickListener {

    protected P presenter;
    protected V view;
    private InputMethodManager imm;
    private String StatisticsValue = "";

    public P getPresenter() {
        return presenter;
    }

    public V getView() {
        return view;
    }

    protected DecimalFormat df = null;
    RelativeLayout rootLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.base_mvp_activity);
        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
        if (this.presenter != null && this.view != null) {
            this.presenter.attachView(view);
        }
        int layout = initLayout();
        if (layout != 0) {
            setContentView(layout);
        }
        if (df == null) {
            df = new DecimalFormat("#0.00");
        }
        init(savedInstanceState);
        initData();

    }

    @Override
    public void setContentView(int layoutId) {
        setContentView(View.inflate(this, layoutId, null));
    }

    @Override
    public void setContentView(View view) {
        rootLayout = (RelativeLayout) findViewById(R.id.rootLayout);
        if (rootLayout == null) {
            return;
        }
        if (view == null) {
            return;
        }
        rootLayout.addView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    public void setBackground() {
        rootLayout.setBackgroundResource(0);
    }

    /**
     * @return 初始化布局
     */
    protected abstract int initLayout();

    /**
     * 绑定P层
     *
     * @return
     */
    public abstract P createPresenter();

    /**
     * 创建View层
     */
    public abstract V createView();

    /**
     * 初始化控件以及点击事件
     */
    protected abstract void init(Bundle savedInstanceState);

    /**
     * 与用户交互的逻辑
     */
    protected abstract void initData();

    /**
     * 初始化控件
     *
     * @param id 控件id
     * @return
     */
    protected void setViewGone(int id) {
        byId(id).setVisibility(View.GONE);
    }

    protected void setViewVisible(int id) {
        byId(id).setVisibility(View.VISIBLE);
    }

    /**
     * 初始化控件
     *
     * @param id 控件id
     * @return
     */
    protected View byId(int id) {
        return setClick(id, false);
    }

    /**
     * 初始化带点击事件的控件
     *
     * @param id 控件id
     * @return
     */
    protected View setClick(int id) {
        return setClick(id, true);
    }

    /**
     * 初始化带点击事件的控件
     *
     * @param id      控件id
     * @param isClick 是否带点击事件
     * @return
     */
    protected View setClick(int id, boolean isClick) {
        View view = findViewById(id);
        if (isClick)
            view.setOnClickListener(this);
        return view;
    }

    /**
     * 初始化带点击事件的控件
     *
     * @param id      控件id
     * @param isClick 接口
     * @return
     */
    protected View setClick(int id, View.OnClickListener isClick) {
        View view = findViewById(id);
        view.setOnClickListener(isClick);
        return view;
    }

    /**
     * 统计标识
     */
    public String getStatisticsValue() {
        return StatisticsValue;
    }

    /**
     * 统计标识
     */
    public void setStatisticsValue(String statisticsValue) {
        StatisticsValue = statisticsValue;
    }





    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (this.presenter != null) {
            this.presenter.dettachView();
            this.presenter = null;
        }
    }

    public void onFinish(View v) {
        int vId = v.getId();
        if (R.id.exitImageButton == vId) {
            close();
        }
    }

    public void close() {
        finish();
    }

    /**
     * 加载网络图片
     *
     * @param imageView 图片控件
     * @param httpUrl   图片路径
     */
    protected void loadHttpImageView(ImageView imageView, String httpUrl) {
        if (!httpUrl.isEmpty()) {
            ViewFactory.getInstance().getHttpImageView(imageView, httpUrl);
        }
    }

    protected void isKeyboard(View view) {
        if (imm == null) {
            imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void startActivity(Class clazz) {
        SkipActivity.getInstance().startActivity(this, clazz);
    }

    public void startActivity(Class clazz, int code) {
        Intent intent = new Intent(this, clazz);
        startActivityForResult(intent, code);
    }

    /**
     * 动态注册广播监听
     *
     * @param receiver 广播
     */
    protected void setFilter(BroadcastReceiver receiver, String key) {
        setFilter(receiver, key, "");
    }

    protected void setFilter(BroadcastReceiver receiver, String key1, String key2) {
        IntentFilter filter = new IntentFilter();
        //监听时间改变Intent.ACTION_TIME_CHANGED
        filter.addAction(key1);
        if (!key2.isEmpty())
            filter.addAction(key2);
        registerReceiver(receiver, filter);
    }

    protected void skipPhone(String phone) {
        if (phone.isEmpty()) {
            return;
        }
        this.startActivity(SkipActivity.getInstance().skipPhone(phone));
    }

    protected void skipSMS(String phone) {
        if (phone.isEmpty()) {
            return;
        }
        this.startActivity(SkipActivity.getInstance().skipSMS(phone));
    }

    protected void setScreenLuminance() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.screenBrightness = 0.6f;
        getWindow().setAttributes(lp);
    }

    protected String format(String info) {
        return df.format(Double.valueOf(info));
    }

    protected String format(double info) {
        return df.format(info);
    }
/*
 @Override
 public boolean onKeyDown(int keyCode, KeyEvent event) {
 if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
 return true;
 } else {
 return super.onKeyDown(keyCode, event);
 }
 }
 */




}

