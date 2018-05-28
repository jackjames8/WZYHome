package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 *    <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.Custom_Dialogue">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Custom_Dialogue extends Activity {
    Button btn_showDialogue;
    MyDialogue dlg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit8_custom_dialogue);
        btn_showDialogue= (Button) findViewById(R.id.btn_showDialogue);

        btn_showDialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg=new MyDialogue(Custom_Dialogue.this,R.style.MyDialog);
                dlg.setTitle("Test");
                dlg.show();

            }
        });
    }
    class MyDialogue extends Dialog{

        public MyDialogue(Context context) {
            super(context);
        }

        protected MyDialogue(Context context, boolean cancelable, OnCancelListener cancelListener) {
            super(context, cancelable, cancelListener);
        }

        public MyDialogue(Context context, int themeResId) {
            super(context, themeResId);
        }
         //自定义对话框
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.unit8_dialogue);
            //点击ok弹出对话框
            findViewById(R.id.btn_ok2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyDialogue.this.dismiss();
                    Toast.makeText(Custom_Dialogue.this,"ok",Toast.LENGTH_LONG).show();

                }
            });
            //点击cancel弹出对话框
            findViewById(R.id.button16).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyDialogue.this.dismiss();
                    Toast.makeText(getApplicationContext(),"cancel",Toast.LENGTH_LONG).show();

                }
            });
        }
    }

}
