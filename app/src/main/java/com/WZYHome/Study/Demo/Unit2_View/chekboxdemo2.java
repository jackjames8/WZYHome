package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.WZYHome.Study.Demo.R;
/*
 <application
        android:allowBackup="true"
        android:icon="@drawable/feiji_1"
        android:label="@string/app_name"
        android:theme="@style/AppTheme">
        <activity
            android:name=".Unit2_View.chekboxdemo2">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>
 */

public class chekboxdemo2 extends Activity {
    CheckBox chkI,chkB;
    EditText etContent;
    int style=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkboxdemo2);
        chkI= (CheckBox) findViewById(R.id.chkI);
        chkB= (CheckBox) findViewById(R.id.chkB);
        etContent= (EditText) findViewById(R.id.etContent);
        checkedchange listten=new checkedchange();
        chkI.setOnCheckedChangeListener(listten);
        chkB.setOnCheckedChangeListener(listten);
    }
    class checkedchange implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()){
                case R.id.chkI:
                    if(isChecked){
                        style+=Typeface.ITALIC;
                    }else{
                        style-=Typeface.ITALIC;
                    }
                    break;
                case R.id.chkB:
                    if(isChecked){
                        style+=Typeface.BOLD;
                    }else {
                        style-=Typeface.BOLD;
                    }
                    break;
            }

            etContent.setTypeface(Typeface.DEFAULT,style);


        }
    }
}
