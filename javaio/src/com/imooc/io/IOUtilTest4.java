package com.imooc.io;

import java.io.File;
import java.io.IOException;

public class IOUtilTest4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		IOUtil.copyFileByBuffer(new File("E:\\test\\data1.txt"), new File("e:\\test\\data2.txt"));
	}

}
