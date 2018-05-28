package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Unit2_RadioButton">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class RadioButtonTest extends Activity {
    RadioGroup rg;
    RadioButton radioButton6,radioButton7,radioButton8;
    TextView tv;
    Button submit_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radiobuttondemo);
        rg= (RadioGroup) findViewById(R.id.RadioGroup);
        radioButton6= (RadioButton) findViewById(R.id.radioButton6);
        radioButton7= (RadioButton) findViewById(R.id.radioButton7);
        radioButton8= (RadioButton) findViewById(R.id.radioButton8);
        tv= (TextView) findViewById(R.id.textView4);
        submit_1= (Button) findViewById(R.id.submit_1);
        submit_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int money=0;
                int id=rg.getCheckedRadioButtonId();
                switch(id){
                    case R.id.radioButton6:
                        money=50;
                        break;
                    case R.id.radioButton7:
                        money=100;
                        break;
                    case R.id.radioButton8:
                        money=200;
                        break;
                }
                tv.setText("充值金额"+money);
            }
        });

     /*   rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int money=0;
                switch(checkedId){
                    case R.id.radioButton6:
                        money=50;
                        break;
                    case R.id.radioButton7:
                        money=100;
                        break;
                    case R.id.radioButton8:
                        money=200;
                        break;
                }
                tv.setText("充值金额"+money);
            }
        });*/

    }
}
