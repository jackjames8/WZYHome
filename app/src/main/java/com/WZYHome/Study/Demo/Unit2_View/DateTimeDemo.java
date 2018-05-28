package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.WZYHome.Study.Demo.R;

/**
 *    <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Unit2_DateTimeDemo">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class DateTimeDemo extends Activity {
    Button btnDate,btnTime,btn_progress;
    TextView tvDateTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit8_datetimedemo);
        btnDate= (Button) findViewById(R.id.btnDate);
        tvDateTime= (TextView) findViewById(R.id.tvDateTime);
        btnTime= (Button) findViewById(R.id.btnTime);
        btn_progress= (Button) findViewById(R.id.btn_progress);
        //设置进度对话框
        btn_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog pgd=new ProgressDialog(DateTimeDemo.this);
                pgd.setMessage("进度显示");
                pgd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);//设置为水平进度条
                pgd.show();
            }
        });
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出日期对话框
                DatePickerDialog dlg=new DatePickerDialog(DateTimeDemo.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                tvDateTime.setText(year+"-"+(month+1)+"-"+dayOfMonth);

                            }
                        },2000,1,1);
                dlg.show();
            }
        });
        //时间弹出对话框
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog tlg=new TimePickerDialog(DateTimeDemo.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                tvDateTime.setText(hourOfDay+":"+minute);

                            }
                        },11,20,true);
                tlg.show();
            }
        });

    }
}
