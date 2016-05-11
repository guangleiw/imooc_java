package com.imooc;

import java.net.MalformedURLException;
import java.net.URL;

public class TestURL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL immoc = new URL("http://www.imooc.com");
			URL url = new URL(immoc,"/index.html?username=tom#test");
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
