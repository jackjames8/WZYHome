package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.widget.EditText;

import com.WZYHome.Study.Demo.Adapter.BaseAdapterEditTextView;
import com.WZYHome.Study.Demo.Entity.Book;
import com.WZYHome.Study.Demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 *  <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.ListView_EditTextView">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ListView_EditTextView extends AppCompatActivity {
    ListView ListView;

    List<Book> list=new ArrayList<Book>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_adapter_object);
        ListView= (android.widget.ListView) findViewById(R.id.ListView);
        fill();
        ListView.setAdapter(new BaseAdapterEditTextView(list,this));

    }
    void fill(){
        for(int i=0;i<50;i++)
            list.add(new Book("书名"+i,i+"作者"));
    };

}
