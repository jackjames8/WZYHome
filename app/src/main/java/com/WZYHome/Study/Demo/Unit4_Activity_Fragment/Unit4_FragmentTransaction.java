package com.WZYHome.Study.Demo.Unit4_Activity_Fragment;

import android.os.Bundle;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name">
 <activity
 android:name=".Unit4_Activity_Fragment.Unit4_FragmentTransaction"
 android:theme="@style/CustomTheme">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

/**
 *这demo主要是为了体现fragment之间通过回调接口传递参数
 */

public class Unit4_FragmentTransaction extends AppCompatActivity {
    private Unit4_FragmentDemo1 lm;
    private Unit4_FragmentDemo2 dm;
    private final static String DETAIL_FM_TAG="DetailFrament";
    Button buttonClick;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit4_fragmenttransaction);
         final FragmentManager fm=getSupportFragmentManager();
        lm=(Unit4_FragmentDemo1)fm.findFragmentById(R.id.KListFragment);
         lm.setOnNameSelectedListener(new Unit4_FragmentDemo1.OnListenerA() {
             @Override
             public void onNameSelected(String name) {
                 //如果dm为空
                 if(dm==null){
                     //创建dm对象，把它添加到Framelayout中，并传name的值传给dm对象
                     dm=new Unit4_FragmentDemo2();
               /*      Bundle args=new Bundle();
                     args.putString("name",name);
                     dm.setArguments(args);*/
                     FragmentTransaction ft=fm.beginTransaction();
                     ft.add(R.id.detail_container, dm);
                     ft.commitAllowingStateLoss();
                 }else {
                     dm.setName(name);
                 }

             }

             @Override
             public void getView(View view) {
                 buttonClick = view.findViewById(R.id.button20);
                 buttonClick.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Toast.makeText(getApplicationContext(),"成功了",Toast.LENGTH_SHORT).show();
                     }
                 });
             }
         });


    }
}
