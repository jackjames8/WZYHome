package com.WZYHome.Study.Demo.Unit2_View;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.WZYHome.Study.Demo.R;

/*import static com.example.administrator.myapplication.R.id.item1;*/

/**
 *     <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/ActionBarStyle">
 <activity
 android:name=".Unit2_View.Menu1">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Menu1 extends Activity {
    EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit7_menu);
        editText3= (EditText) findViewById(R.id.editText3);
        registerForContextMenu(editText3);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i("TEST","OnCreatMenu");
        //(int groupiId,int itemId,int order,charSequence title)
        menu.add(Menu.NONE,0X001,1,"AAA");
        menu.add(Menu.NONE,0X002,3,"BBB");
        //第二种方法解析
        MenuInflater inflater=new MenuInflater(this);
        inflater.inflate(R.menu.menu1,menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu1,menu);//解析方法解析布局菜单
     /*   menu.add(1,1,1,"AAA");
        menu.add(1,1,2,"BBB");
        menu.add(1,1,2,"CCC");
        menu.add(2,1,2,"DDD");
        menu.add(2,1,2,"EEE");
        menu.add(2,1,2,"FFF");
        menu.setGroupEnabled(2,false);//设置该组不能用
        menu.setGroupVisible(1,false);//设置该组不可见*/
/*        SubMenu subMenu=menu.addSubMenu(Menu.NONE,1,1,"AAA");//添加子菜单的方法
        subMenu.add(Menu.NONE,1,1,"AAA1");//添加子菜单的方法
        subMenu.add(Menu.NONE,2,2,"AAA2");//添加子菜单的方法*/
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item2a:
                if(item.isChecked()==false)
                    item.setChecked(true);
                else {
                    item.setChecked(false);
                }
                break;
            case R.id.item2b:
                if(item.isChecked()){
                item.setChecked(false);
                }else {
                    item.setChecked(true);
                }
                break;
        }
        return super.onContextItemSelected(item);
    }
}
