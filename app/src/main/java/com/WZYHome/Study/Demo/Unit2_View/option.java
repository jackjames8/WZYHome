package com.WZYHome.Study.Demo.Unit2_View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.WZYHome.Study.Demo.R;

/**
 * Created by Administrator on 2017/5/31.
 */

public class option extends AppCompatActivity {
    Button Button_ok;
    RadioGroup RadioGroup_music,RadioGroup_sound,RadioGroup_Plane;
    TextView tvtest;
    String bgMusic="开";
    String bgSound="开";
    String bgPlane="机型一";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.option);
        tvtest= (TextView) findViewById(R.id.tvtest);
        RadioGroup_music= (RadioGroup) findViewById(R.id.RadioGroup_music);
        RadioGroup_sound= (RadioGroup) findViewById(R.id.RadioGroup_sound);
        RadioGroup_Plane= (RadioGroup) findViewById(R.id.RadioGroup_Plane);
        tvtest= (TextView) findViewById(R.id.tvtest);
        Button_ok= (Button) findViewById(R.id.Button_ok);
        Button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*StringBuilder str=new StringBuilder();
                str.append("音乐背景:"+bgMusic+"音乐音效:"+bgSound+"机型："+bgPlane);
                tvtest.setText(str+"");*/
                Intent intent=getIntent();
                intent.putExtra("bgMusic",bgMusic);
                intent.putExtra("bgSound",bgSound);
                intent.putExtra("bgPlane",bgPlane);
                setResult(progressbarGameStart.RESULT_CODE,intent);
                finish();
            }
        });

        //局部内部类
        class CheckChangeListener implements RadioGroup.OnCheckedChangeListener{

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (group.getId()){
                    case R.id.RadioGroup_music:
                        if(checkedId==R.id.radioButton_musicOpen){
                            bgMusic="开";
                        } else{
                            bgMusic="关";
                        }
                        break;
                    case R.id.RadioGroup_sound:
                        if(checkedId==R.id.RadioGroup_sound){
                            bgSound="开";
                        }else{
                            bgSound="关";
                        }
                        break;
                    case R.id.RadioGroup_Plane:
                        switch (checkedId){
                            case R.id.radioButtonPlane_1:
                                bgPlane="机型一";
                                break;
                            case R.id.radioButtonPlane_2:
                                bgPlane="机型二";
                                break;
                            case R.id.radioButtonPlane_3:
                                bgPlane="机型三";
                                break;

                        }
                        break;

                }


            }
        }

        CheckChangeListener listener1= new CheckChangeListener();

        RadioGroup_music.setOnCheckedChangeListener(listener1);
        RadioGroup_sound.setOnCheckedChangeListener(listener1);
        RadioGroup_Plane.setOnCheckedChangeListener(listener1);

    }
}
