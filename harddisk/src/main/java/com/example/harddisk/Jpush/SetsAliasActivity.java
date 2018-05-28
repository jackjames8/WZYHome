package com.example.harddisk.Jpush;


import android.app.Activity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.harddisk.R;

import cn.jpush.android.api.JPushInterface;


public class SetsAliasActivity extends Activity {
	Button SetsAliasButton;
	EditText AliasEditText;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sets_alias_activity);
		AliasEditText=(EditText) findViewById(R.id.AliasEditText);
		SetsAliasButton=(Button) findViewById(R.id.SetsAliasButton);

	}
	public void SetsAlias(View view){
		String trim = AliasEditText.getText().toString().trim();
		JPushInterface.setAlias(this,trim,null);//设置别名
		Toast.makeText(this,"设置成功",Toast.LENGTH_SHORT).show();
	}
	



}