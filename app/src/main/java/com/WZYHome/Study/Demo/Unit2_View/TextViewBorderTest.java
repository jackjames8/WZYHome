package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.WZYHome.Study.Demo.R;
import com.WZYHome.Study.Demo.Unit2_View.Custom.TextViewBorder;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.TextViewBorderTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class TextViewBorderTest extends AppCompatActivity {

    private TextViewBorder state1;
    private TextViewBorder state2;
    private TextViewBorder state3;
    private TextViewBorder state4;
    private CheckBox checkboxStyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_border_test);
        state1 = (TextViewBorder) findViewById(R.id.state1);
        state2 = (TextViewBorder) findViewById(R.id.state2);
        state3 = (TextViewBorder) findViewById(R.id.state3);
        state4 = (TextViewBorder) findViewById(R.id.state4);
        checkboxStyle= (CheckBox) findViewById(R.id.checkboxStyle);
/**
 * 监听checkbox是否被选中,如果选中了则设置背景是橙色,如果没有选中则白色
 */
        checkboxStyle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    checkboxStyle.setBackgroundResource(R.drawable.border_orange);

                }else {
                    checkboxStyle.setBackgroundResource(R.drawable.border_white);
                }
            }
        });
        state1.setBorderColor(getResources().getColor(R.color.red));
        //边框颜色
        state2.setBorderColor(getResources().getColor(R.color.app_red_delete_color));
        //字体颜色
        state2.setTextColor(getResources().getColor(R.color.app_red_delete_color));

        state3.setBorderColor(getResources().getColor(R.color.app_blue_color));
        state3.setTextColor(getResources().getColor(R.color.progress_color));

        state4.setBorderColor(getResources().getColor(R.color.app_red_delete_color));
        state4.setTextColor(getResources().getColor(R.color.app_blue_color));
    }
}
