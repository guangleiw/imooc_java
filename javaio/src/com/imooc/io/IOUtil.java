package com.imooc.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	/*
	 * 读取指定文件内容 按照Hex 输出到控制台
	 * 并且每输出10个byte 换行
	 */
	public static void printHex(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);//把文件作为字节流 进行读操作
		int b;
		int i = 1;
		while((b = in.read())!= -1){
			if(b <= 0xf){
				//单位数 前面补0
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+"  ");
			if(i++%10 == 0){
				System.out.println();
			}
		}
		in.close();
	}
	
	public static void printHexByByteArray(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20*1024];
		//从in中批量读取字节 放入到buf这个字节数组中 从第0个位置开始放 最多放buf.length 
		//返回的是字节的个数
		int bytes = in.read(buf,0,buf.length);//一次性读完 说明字节数组足够大
		int j = 1;
		for(int i = 0;i < bytes;i++){
			if(buf[i] <= 0xf){
				System.out.println("0");
			}
			System.out.println();
		}
	}
	/**
	 * 进行文件copy 利用带缓冲字节流
	 * @param srcFile
	 * @param destFile
	 */
	public static void copyFileByBuffer(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件"+srcFile+"不存在");
		}
		
		if(!destFile.exists()){
			throw new IllegalArgumentException("文件"+destFile+"不存在");
		}
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));
		int c;
		while((c = bis.read())!= -1){
			bos.write(c);
			bos.flush();
		}
		bis.close();
		bos.close();
	}
}
