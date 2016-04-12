package com.imooc.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String s = "幕课ABC";
		byte[] bytes = s.getBytes();//转换成字节序列 用的是项目默认的编码
		for (byte b : bytes) {
			//把字节（转换成了int）以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println(" ");
		
		byte[] bytes2 = s.getBytes("gbk");
		//GBK编码 中文占用两个字节  英文占用一个字节
		for (byte b : bytes2) {
			//把字节（转换成了int）以16进制的方式显示
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println(" ");
		
		byte[] bytes3 = s.getBytes("utf-8");
		//UTF-8编码 中文占用3个字节  英文占用1个字节
		for ( byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff)+" ");
		}
		System.out.println(" ");
		
		/**
		 * Java是双字节编码 就是一个字符占用两个字节  UTF-16BE编码
		 */
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff)+ " ");
		}
		System.out.println("");
		/**
		 * 当你的字节序列是某种编码时，若想把字节序列转化为字符串 要用相同的编码
		 */
		String str1 = new String(bytes4);
		System.out.println(str1);
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		
		/**
		 * 文本文件就是字节序列 
		 * 可以使任意序列的字节序列
		 * 如果在中文机器上直接创建文本文件 那么该文本文件只认识ASNI编码
		 */
	}
	

}
