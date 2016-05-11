package com.imooc.io;

import java.io.IOException;

public class IOUtilTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			IOUtil.printHex("E:\\test\\data1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
