package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.WZYHome.Study.Demo.R;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.TabHostTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class TabHostTest extends Activity {
    Button AddPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit6_tabhost);
        final TabHost tHost= (TabHost) findViewById(R.id.tabhost);
        AddPage= (Button) findViewById(R.id.AddPage);
        tHost.setup();
        AddPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tHost.addTab(tHost.newTabSpec("Test3")
                        .setIndicator("test")
                        .setContent(new TabHost.TabContentFactory() {
                            @Override
                            public View createTabContent(String tag) {
                                View view=LayoutInflater.from(getApplicationContext()).inflate(R.layout.over,null);
                                return view;
                            }
                        }));


            }
        });
        //tHost.newTabSpec("")通过这个，返回对页而的操作
        TabHost.TabSpec LinearLayout=tHost.newTabSpec("");
        LinearLayout.setIndicator("WHAT'S NEW");
        LinearLayout.setContent(R.id.tab1);
        tHost.addTab(LinearLayout);

        tHost.addTab(tHost.newTabSpec("Test2")
                .setIndicator("",getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(R.id.tab2)
        );
/*        tHost.addTab(tHost.newTabSpec("Test3")
                .setIndicator("LabelC")
                .setContent(R.id.tab3)
        );*/

    }
}
