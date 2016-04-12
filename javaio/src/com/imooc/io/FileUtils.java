package com.imooc.io;

import java.io.File;
import java.io.IOException;

import org.omg.IOP.IOR;

/**
 * 列出File的一些常用操作 比如过滤 遍历等
 * @author wang
 *
 */
public class FileUtils {

	/**
	 * 列出指定目录下（包括子目录）的所有文件
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("目录"+dir+"不存在");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException("不是目录");
		}
		
		String[] names = dir.list();//返回的是字符串数组 直接子名称 不包含子目录下的内容
		for (String string : names) {
			System.out.println(dir+string);
		}
		//如果要遍历子目录下的内容 需要构造file对象并递归操作
		File[] files = dir.listFiles();
//		for (File file : files) {
//			System.out.println(file);
//		}
		if(files!=null &&files.length  >0){
			for (File file : files) {
				if(file.isDirectory()){
					listDirectory(file);
				}else {
					System.out.println(file);
				}
			}
		}
	}
	
}
