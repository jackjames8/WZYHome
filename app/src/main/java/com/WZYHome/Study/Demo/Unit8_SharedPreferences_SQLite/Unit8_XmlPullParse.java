package com.WZYHome.Study.Demo.Unit8_SharedPreferences_SQLite;

import android.app.Activity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.WZYHome.Study.Demo.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * <application
 android:allowBackup="true"
 android:icon="@drawable/feiji_1"
 android:label="@string/app_name"
 android:theme="@style/AppTheme">
 <activity
 android:name=".Unit8_SharedPreferences_SQLite.Unit8_XmlPullParse">
 <intent-filter>
 <action android:name="android.intent.action.MAIN" />

 <category android:name="android.intent.category.LAUNCHER" />
 </intent-filter>
 </activity>
 </application>
 */

public class Unit8_XmlPullParse extends Activity {
    static final String TAG="xmlDemo";
    Button parse_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit13_xmlpullparse);
        parse_btn= (Button) findViewById(R.id.parse_btn);
        parse_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logPullParse();
            }
        });


    }

    private void logPullParse() {
        XmlPullParser parser=getResources().getXml(R.xml.demo);
        try {
            int eventType=parser.getEventType();
            while (eventType!=XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_DOCUMENT:
                        Log.i(TAG,"get start document");
                        break;
                    case XmlPullParser.START_TAG:
                        Log.i(TAG,"get start tag:  "+parser.getName());
                        int count=parser.getAttributeCount();
                        for(int i=0;i<count;i++){
                            Log.i(TAG," getAttributeName :  "+parser.getAttributeName(i));
                            Log.i(TAG," getAttributeValue :  "+parser.getAttributeValue(i));
                        }
                        break;
                    case XmlPullParser.TEXT:
                        Log.i(TAG,"get TEXT:  "+parser.getText());
                        break;
                    case XmlPullParser.END_TAG:
                        Log.i(TAG,"get start end tag:  "+parser.getName());
                        break;
                    default:
                        break;
                }
                eventType=parser.next();
            }
            Log.i(TAG,"get end document");

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
