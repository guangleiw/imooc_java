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
		
		//判断是否是一个目录
		System.out.println(file.isDirectory());
		//判断是否是一个文件
		System.out.println(file.isFile());
		
		//常用的API
		System.out.println(file); //file.toString();
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getName());//文件或者文件夹的名字
		System.out.println(file.getParentFile());
	}

}
