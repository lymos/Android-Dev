package com.example.storagedemo;

import java.io.*;

import android.content.Context;

public class FileHelper{
	
	private Context mcontext;
	public FileHelper(Context mcontext){
		this.mcontext = mcontext;
	}
	
	public void save(String file_name, String content) throws Exception{
		// openFileOUtput ���ڴ���д������  ���д��SD�� ����: FileOutputStream output = new FileOutputStream(filename);
		FileOutputStream output = mcontext.openFileOutput(file_name, Context.MODE_PRIVATE); // ��˽�з�ʽ���ļ������
		output.write(content.getBytes()); // ���ֽڷ�ʽд��
		output.close();
	}
	
	public String read(String file_name) throws Exception{
		FileInputStream input = mcontext.openFileInput(file_name);
		int len = 0;
		byte[] temp = new byte[1024];
		StringBuilder sb = new StringBuilder("");	// �����ַ�������
		while((len = input.read(temp)) > 0){
			sb.append(new String(temp, 0, len));	// ��ӵ���β
		}
		input.close();
		return sb.toString(); 	// ת�����ַ���
	}
	
}