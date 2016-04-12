package com.imooc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TestPageContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://www.baidu.com");
			InputStream in = url.openStream();
			InputStreamReader isr = new InputStreamReader(in,"utf-8");
			BufferedReader bf = new BufferedReader(isr);
			String data = bf.readLine();
			while(data!=null){
				System.out.println(data);
				data= bf.readLine();
			}
			bf.close();isr.close();in.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
