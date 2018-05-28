package com.WZYHome.Study.Demo.Unit1.mvpdemo.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit1.mvpdemo.presenter.LoginPresenter;

/**
 *     <uses-permission android:name="android.permission.INTERNET"/>
 <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"></uses-permission>
 <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name="com.WZYHome.Study.Demo.Unit1.mvpdemo.view.LoginActivity">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 *
 *
 */

public class LoginActivity extends AppCompatActivity implements ILoginView {

    Button btnLogin;
    EditText editUserCount;
    EditText editPassword;
    private ProgressDialog mProgressDialog;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvp_activity);
        initView();
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle("登录中..");
        mProgressDialog.setMessage("请稍等");
        loginPresenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.doLogin();
            }
        });
    }

    private void initView() {
        btnLogin= (Button) findViewById(R.id.btnLogin);
        editUserCount= (EditText) findViewById(R.id.editUserCount);
        editPassword= (EditText) findViewById(R.id.editPassword);
    }

    @Override
    public String getUserCount() {
        String userAcount = editUserCount.getText().toString();
        if (TextUtils.isEmpty(userAcount)) {
            Toast.makeText(this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
        }
        return userAcount;
    }

    @Override
    public String getUserPassword() {
        String userPassword = editPassword.getText().toString();
        if (TextUtils.isEmpty(userPassword)) {
            Toast.makeText(this, "密码不能为空！", Toast.LENGTH_SHORT).show();
        }
        return userPassword;
    }

    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.cancel();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(this, "去下个界面", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail() {
        Toast.makeText(this, "提示用户失败", Toast.LENGTH_SHORT).show();
    }


}
