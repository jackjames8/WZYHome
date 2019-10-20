package com.WZYHome.Study.Demo.Unit2_View;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;


import com.WZYHome.Study.Demo.R;

/**
 *      <application
 android:allowBackup="true"
 android:icon="@drawable/ic_launcher"
 android:label="@string/app_name"
 android:theme="@style/AppBaseTheme" >
 <activity
 android:name=".Unit2_View.ToolBar"
 android:label="@string/app_name" >
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ToolBar extends  AppCompatActivity {
Button closeWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // App Logo
        toolbar.setLogo(R.mipmap.hz_idxlogo_720x1280);
        // Title
        toolbar.setTitle("");
        // Sub Title
        toolbar.setSubtitle("");
        // Navigation Icon 要设定在 setSupoortActionBar 才有作用
        // 否則會出現 back bottom
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.hz_address_contacts_720x1280);


        // Menu recycler_view_adapter click 的监听事件一样要设定在 setSupportActionBar 才有作用
        toolbar.setOnMenuItemClickListener(onMenuItemClick);


    }

    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.action_edit:
                   finish();
                    break;
                case R.id.action_share:
                    msg += "Click share";
                    break;
                case R.id.action_settings:
                    msg += "Click setting";
                    break;
            }

            if(!msg.equals("")) {
                Toast.makeText(ToolBar.this, msg, Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    };

    /**
     *
     * @param menu // 为了让 Toolbar 的 Menu 有作用，这边的程式不可以拿掉
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 为了让 Toolbar 的 Menu 有作用，这边的程式不可以拿掉
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
