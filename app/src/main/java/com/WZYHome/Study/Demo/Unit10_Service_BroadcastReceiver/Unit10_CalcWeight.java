package com.WZYHome.Study.Demo.Unit10_Service_BroadcastReceiver;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit10_Service_BroadcastReceiver.Unit10_CalcWeight">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 <service android:name=".Unit10_Service_BroadcastReceiver.Unit10_CalcWeight_Service"></service>
 </application>
 */

public class Unit10_CalcWeight extends Activity {
    Button button19;
    EditText edtHeight;
    RadioButton radB_M,radB_F;
    Unit10_CalcWeight_Service.calBind bind;
    TextView textView37;
    ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i(Unit10_CalcWeight_Service.TAG,"onServiceConnected");
            bind=(Unit10_CalcWeight_Service.calBind)iBinder;
            Double Result=bind.getdata();
            textView37.setText("你的标准体重是:"+Result);
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit11_calweight);
        button19= (Button) findViewById(R.id.button19);
        edtHeight= (EditText) findViewById(R.id.edtHeight);
        radB_F= (RadioButton) findViewById(R.id.radB_F);
        radB_M= (RadioButton) findViewById(R.id.radB_M);
        textView37= (TextView) findViewById(R.id.textView37);
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sex=0;
                if(radB_M.isChecked()){
                    sex=0;
                }else {
                    sex=1;
                }
                //身高
                double height=0;
                try {
                    height=Double.parseDouble(edtHeight.getText()+"");
                }catch (Exception ex){
                    edtHeight.setText("");
                    edtHeight.requestFocus();
                    return;
                }
                //交给Service去计算
                Intent service=new Intent(Unit10_CalcWeight.this,Unit10_CalcWeight_Service.class);
                service.putExtra("sex",sex);
                service.putExtra("height",height);
                bindService(service,conn,BIND_AUTO_CREATE);
            }
        });
    }
}
