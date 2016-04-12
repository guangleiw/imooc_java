package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s = "Ļ��ABC";
		byte[] bytes = s.getBytes();//ת�����ֽ����� �õ�����ĿĬ�ϵı���
		for (byte b : bytes) {
			//���ֽڣ�ת������int����16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println(" ");
		
		byte[] bytes2 = s.getBytes("gbk");
		//GBK���� ����ռ�������ֽ�  Ӣ��ռ��һ���ֽ�
		for (byte b : bytes2) {
			//���ֽڣ�ת������int����16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println(" ");
		
		byte[] bytes3 = s.getBytes("utf-8");
		//UTF-8���� ����ռ��3���ֽ�  Ӣ��ռ��1���ֽ�
		for ( byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println(" ");
		
		/**
		 * Java��˫�ֽڱ��� ����һ���ַ�ռ�������ֽ�  UTF-16BE����
		 */
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff)+ " ");
		}
		System.out.println("");
		/**
		 * ������ֽ�������ĳ�ֱ���ʱ��������ֽ�����ת��Ϊ�ַ��� Ҫ����ͬ�ı���
		 */
		String str1 = new String(bytes4);
		System.out.println(str1);
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		
		/**
		 * �ı��ļ������ֽ����� 
		 * ����ʹ�������е��ֽ�����
		 * ��������Ļ�����ֱ�Ӵ����ı��ļ� ��ô���ı��ļ�ֻ��ʶASNI����
		 */
	}
	

}
