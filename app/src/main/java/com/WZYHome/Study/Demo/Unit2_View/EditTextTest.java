package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.Custom.IEditTextChangeListener;
import com.WZYHome.Study.Demo.Unit2_View.Custom.WorksSizeCheckUtil;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Custom.EditTextTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 *
 *
 */

//监听多个edittext内容  当editText有内容时，改变Button按钮颜色实现登入
public class EditTextTest extends AppCompatActivity {

    private Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text_test);

        EditText editText1 = (EditText) findViewById(R.id.edit_mobile);
        EditText editText2 = (EditText) findViewById(R.id.edit_yanzhengma);

        btn1 = (Button) findViewById(R.id.btn_nextStep);
        btn1.setEnabled(false);
        btn1.setBackgroundColor(EditTextTest.this.getResources().getColor(R.color.daojishi));
        //1.创建工具类对象 把要改变颜色的tv先传过去
        WorksSizeCheckUtil.textChangeListener textChangeListener = new WorksSizeCheckUtil.textChangeListener(btn1);

        //2.把所有要监听的edittext都添加进去
        textChangeListener.addAllEditText(editText1,editText2);

        //3.接口回调 在这里拿到boolean变量 根据isHasContent的值决定 tv 应该设置什么颜色
        WorksSizeCheckUtil.setChangeListener(new IEditTextChangeListener() {
            @Override
            public void textChange(boolean isHasContent) {
                if(isHasContent){
                    btn1.setBackgroundColor(EditTextTest.this.getResources().getColor(R.color.orange));//还原背景色
                }else{
                    btn1.setBackgroundColor(EditTextTest.this.getResources().getColor(R.color.daojishi));
                }
            }
        });
    }
}
