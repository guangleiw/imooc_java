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
	 * ��ȡָ���ļ����� ����Hex ���������̨
	 * ����ÿ���10��byte ����
	 */
	public static void printHex(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);//���ļ���Ϊ�ֽ��� ���ж�����
		int b;
		int i = 1;
		while((b = in.read())!= -1){
			if(b <= 0xf){
				//��λ�� ǰ�油0
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
		//��in��������ȡ�ֽ� ���뵽buf����ֽ������� �ӵ�0��λ�ÿ�ʼ�� ����buf.length 
		//���ص����ֽڵĸ���
		int bytes = in.read(buf,0,buf.length);//һ���Զ��� ˵���ֽ������㹻��
		int j = 1;
		for(int i = 0;i < bytes;i++){
			if(buf[i] <= 0xf){
				System.out.println("0");
			}
			System.out.println();
		}
	}
	/**
	 * �����ļ�copy ���ô������ֽ���
	 * @param srcFile
	 * @param destFile
	 */
	public static void copyFileByBuffer(File srcFile,File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ�"+srcFile+"������");
		}
		
		if(!destFile.exists()){
			throw new IllegalArgumentException("�ļ�"+destFile+"������");
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
