package com.WZYHome.Study.Demo.Unit2_View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.WZYHome.Study.Demo.R;

/**
 *        <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.image_button_test">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */


public class ImageButtonTest extends AppCompatActivity {
    ImageView imageView_android;
    Button btn_pre,btn_next;
    int[] resid={R.drawable.timg1,
                 R.drawable.timg2,
                 R.drawable.timg3,
                 R.drawable.timg4};
       int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_button_test);
        //xml中的控件与代码相关联；
        imageView_android= (ImageView) findViewById(R.id.imageView_android);
        btn_pre=(Button)findViewById(R.id.btn_pre);
        btn_next= (Button) findViewById(R.id.btn_next);
        btn_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Drawable drawable=getResources().getDrawable(R.drawable.gamebackground);*/
                index--;
                if(index<=0){
                    index=0;
                }
                imageView_android.setImageResource(resid[index]);


               /* image.setImageDrawable(drawable);*/



            }
        });
        btn_next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               /* Drawable drawable=getResources().getDrawable(R.drawable.gamebackground);*/
                index++;
                if(index>=resid.length-1){
                    index=resid.length-1;
                }
                imageView_android.setImageResource(resid[index]);
               /* image.setImageDrawable(drawable);*/

            }
        });


    }




}
