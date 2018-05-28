package com.WZYHome.Study.Demo.Unit2_View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 *   <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit2_View.ProgressBarTest">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class ProgressBarTest extends AppCompatActivity {
    ProgressBar pBr;
    Button btn;
    int progress=0;
    TextView textView22,textView21;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit6_progressbar);
        pBr= (ProgressBar) findViewById(R.id.progressBar7);
        btn= (Button) findViewById(R.id.button10);
        textView22= (TextView) findViewById(R.id.textView22);
        textView21= (TextView) findViewById(R.id.textView21);
        seekBar= (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int in=seekBar.getProgress();
                textView21.setText(in+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress+=10;
                pBr.setProgress(progress);
                int in=seekBar.getProgress();
                textView21.setText(in+"");
            }
        });

    }
}
