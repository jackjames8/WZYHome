package com.WZYHome.Study.Demo.Unit1.base;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit1.base.presenter.MvpBasePresenter;
import com.WZYHome.Study.Demo.Unit1.base.view.MvpBaseView;
import com.WZYHome.Study.Demo.Util.SkipActivity;

import java.text.DecimalFormat;


/**
 * V层定义
 *
 * @author Unique
 */
public abstract class BaseMvpFragment<V extends MvpBaseView, P extends MvpBasePresenter<V>>
        extends Fragment {

    private P presenter;
    private V view;
    View mRootView;
    public DecimalFormat df = null;
    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.presenter == null) {
            this.presenter = createPresenter();
        }
        if (this.view == null) {
            this.view = createView();
        }
        if (this.presenter != null && this.view != null) {
            this.presenter.attachView(view);
        }
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.base_mvp_fragment, container, false);
            int layout = setContentView();
            if (layout != 0) {
                setContentView(layout);
            }
            init();
            initData();
        } else {
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            if (parent != null) {
                parent.removeView(mRootView);
            }
        }
        if (df == null) {
            df = new DecimalFormat("#0.00");
        }
        return mRootView;
    }

    private void setContentView(int layoutId) {
        View inflate = View.inflate(getActivity().getApplicationContext(), layoutId, null);
        RelativeLayout rootLayout = (RelativeLayout) mRootView.findViewById(R.id.RootLayout);
        rootLayout.addView(inflate);
    }

    /**
     * @return 初始化布局
     */
    protected abstract int setContentView();

    /**
     * 绑定P层
     *
     * @return
     */
    public abstract P createPresenter();

    /**
     * 创建View层
     *
     * @return
     */
    public abstract V createView();

    /**
     * 初始化控件以及点击事件
     */
    protected abstract void init();

    /**
     * 与用户交互的逻辑
     */
    protected abstract void initData();

    /**
     * 点击事件
     *
     * @param v
     */
    protected abstract void baseClick(View v);

    /**
     * 初始化控件
     *
     * @param id 控件id
     * @return
     */
    protected View byId(int id) {
        return setClick(id, false);
    }

    View hintView;

    View HintOrderNoDataTextView;
    protected String format(String info) {
        return df.format(Double.valueOf(info));
    }

    protected String format(double info) {
        return df.format(info);
    }
    protected void initHint(String hintType, boolean showHint) {
        if (showHint) {
            return;
        }
        if (hintView == null)
            hintView = byId(R.id.HintLayout);
        if (hintView.getVisibility() == View.VISIBLE)
            hintView.setVisibility(View.GONE);
        if (HintOrderNoDataTextView == null)
            HintOrderNoDataTextView = byId(R.id.HintOrderNoDataTextView);
        if (HintOrderNoDataTextView.getVisibility() == View.VISIBLE)
            HintOrderNoDataTextView.setVisibility(View.GONE);

        switch (hintType) {
            case "HintOrderNoData":
                hintView.setVisibility(View.VISIBLE);
                HintOrderNoDataTextView.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }

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
        View view = mRootView.findViewById(id);
        if (isClick)
            view.setOnClickListener(baseListener);
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
        View view = mRootView.findViewById(id);
        view.setOnClickListener(isClick);
        return view;
    }



    public void startActivity(Class clazz) {
        SkipActivity.getInstance().startActivity((AppCompatActivity) getActivity(), clazz);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.presenter != null) {
            this.presenter.dettachView();
            this.presenter = null;
        }
    }

    public View.OnClickListener baseListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            baseClick(v);
        }
    };
}
