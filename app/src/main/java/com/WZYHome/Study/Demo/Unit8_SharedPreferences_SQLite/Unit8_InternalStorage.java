package com.WZYHome.Study.Demo.Unit8_SharedPreferences_SQLite;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.WZYHome.Study.Demo.R;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit8_SharedPreferences_SQLite.Unit8_InternalStorage">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit8_InternalStorage extends Activity {
    Button save_button,load_button;
    TextView textView34;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_internalstorage);
        save_button= (Button) findViewById(R.id.save_button);
        load_button= (Button) findViewById(R.id.load_button);
        textView34= (TextView) findViewById(R.id.textView34);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSave();
                Toast.makeText(getApplicationContext(),"WriteSuccessful",Toast.LENGTH_LONG).show();

            }

         
        });
        load_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoad();

            }
        });

    }

    private void showLoad() {
        try {
            InputStream is=openFileInput("fileDemo");
            StringBuffer sb=new StringBuffer();
            int c=0;
            while ((c=is.read()) !=-1){
                sb.append((char)c);

            }
            textView34.setText(sb);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    private void showSave() {
        try {
            OutputStream os=openFileOutput("fileDemo",0);
            String buffer="hello ,wushuiyan";
            os.write(buffer.getBytes());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
