package com.WZYHome.Study.Demo.Unit1;

import android.graphics.Color;
import android.os.Build;
import android.os.CountDownTimer;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

/**
 * 获取验证码倒计时，只要传四个参数给构造函数就行了
 */

public class TimeCountUtil extends CountDownTimer {

    private AppCompatActivity mActivity;
    private Button btn;//按钮
    // 在这个构造方法里需要传入四个参数，一个是Activity，一个是总的时间millisInFuture，
    // 一个是countDownInterval,时间间隔后显示，然后就是你在哪个按钮上做这个是，就把这个按钮传过来就可以了
    public TimeCountUtil(AppCompatActivity mActivity,long millisInFuture, long countDownInterval, Button btn) {
        super(millisInFuture, countDownInterval);
        this.mActivity = mActivity;
        this.btn = btn;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onTick(long millisUntilFinished) {
        btn.setClickable(false);//设置不能点击
        btn.setText(millisUntilFinished / 1000 + "秒");//设置倒计时时间

//设置按钮为灰色，这时是不能点击的
        btn.setBackgroundColor(mActivity.getResources().getColor(R.color.daojishi));
        btn.setClickable(false);
        Spannable span = new SpannableString(btn.getText().toString());//获取按钮的文字
        span.setSpan(new ForegroundColorSpan(Color.RED), 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//讲倒计时时间显示为红色
        btn.setText(span);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onFinish() {
        btn.setText("获取验证码");
        btn.setClickable(true);//重新获得点击
        btn.setBackgroundColor(mActivity.getResources().getColor(R.color.orange));//还原背景色
    }
}
