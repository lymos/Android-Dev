package com.example.storagedemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.widget.Toast;
//import android.view.Menu;
//import android.view.MenuItem;

public class MainActivity extends Activity implements View.OnClickListener{
	
	private Button btn_write;
	private Button btn_clean;
	private Button btn_read;
	private EditText file_name;
	private EditText file_content;
	private Context mcontext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mcontext = getApplicationContext();
		bindViews();
	}
	
	/**
	 * 绑定事件
	 */
	private void bindViews(){
		file_name = (EditText) findViewById(R.id.file_name);
		file_content = (EditText) findViewById(R.id.file_content);
		btn_write = (Button) findViewById(R.id.btn_write);
		btn_clean = (Button) findViewById(R.id.btn_clean);
		btn_read = (Button) findViewById(R.id.btn_read);
		
		btn_write.setOnClickListener(this);
		btn_clean.setOnClickListener(this);
		btn_read.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v){
		switch(v.getId()){
			case R.id.btn_write:
				FileHelper fhelper = new FileHelper(mcontext);
				String name = file_name.getText().toString();
				String cont = file_content.getText().toString();
				try{
					fhelper.save(name, cont);
					Toast.makeText(mcontext, "数据写入成功！", Toast.LENGTH_SHORT).show();
				}catch(Exception e){
					e.printStackTrace();
					Toast.makeText(mcontext, "数据写入失败！", Toast.LENGTH_SHORT).show();
				}
				break;
			case R.id.btn_clean:
				file_name.setText("");
				file_content.setText("");
				break;
			case R.id.btn_read:
				FileHelper fhelper2 = new FileHelper(mcontext);
				String fname = file_name.getText().toString();	// 读取输入框的内容
				try{
					String cont2 = fhelper2.read(fname);
					Toast.makeText(mcontext, cont2, Toast.LENGTH_LONG).show();	// 弹出提示
				}catch(Exception e){
					e.printStackTrace();
				}
				break;
			default:
				break;
		}
	}
}
