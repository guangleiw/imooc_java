package com.imooc.io;

import java.io.File;

public class FileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("E:\\test\\fuck");
		System.out.println("cunzai ?"+file.exists());
		if(!file.exists()){
			file.mkdirs();
			//file.createNewFile();
		}else{
			file.delete();
		}
		
		//�ж��Ƿ���һ��Ŀ¼
		System.out.println(file.isDirectory());
		//�ж��Ƿ���һ���ļ�
		System.out.println(file.isFile());
		
		//���õ�API
		System.out.println(file); //file.toString();
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());//�ļ������ļ��е�����
		System.out.println(file.getParentFile());
	}

}
