package com.imooc.io;

import java.io.File;
import java.io.IOException;

import org.omg.IOP.IOR;

/**
 * �г�File��һЩ���ò��� ������� ������
 * @author wang
 *
 */
public class FileUtils {

	/**
	 * �г�ָ��Ŀ¼�£�������Ŀ¼���������ļ�
	 * @param dir
	 * @throws IOException
	 */
	public static void listDirectory(File dir) throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Ŀ¼"+dir+"������");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException("����Ŀ¼");
		}
		
		String[] names = dir.list();//���ص����ַ������� ֱ�������� ��������Ŀ¼�µ�����
		for (String string : names) {
			System.out.println(dir+string);
		}
		//���Ҫ������Ŀ¼�µ����� ��Ҫ����file���󲢵ݹ����
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
