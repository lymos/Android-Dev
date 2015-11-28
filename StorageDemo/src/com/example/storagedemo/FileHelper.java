package com.example.storagedemo;

import java.io.*;

import android.content.Context;

public class FileHelper{
	
	private Context mcontext;
	public FileHelper(Context mcontext){
		this.mcontext = mcontext;
	}
	
	public void save(String file_name, String content) throws Exception{
		// openFileOUtput 向内存中写入数据  如果写到SD卡 请用: FileOutputStream output = new FileOutputStream(filename);
		FileOutputStream output = mcontext.openFileOutput(file_name, Context.MODE_PRIVATE); // 以私有方式打开文件输出流
		output.write(content.getBytes()); // 以字节方式写入
		output.close();
	}
	
	public String read(String file_name) throws Exception{
		FileInputStream input = mcontext.openFileInput(file_name);
		int len = 0;
		byte[] temp = new byte[1024];
		StringBuilder sb = new StringBuilder("");	// 声明字符串容器
		while((len = input.read(temp)) > 0){
			sb.append(new String(temp, 0, len));	// 添加到结尾
		}
		input.close();
		return sb.toString(); 	// 转换成字符串
	}
	
}